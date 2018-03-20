package com.zx.share.platform.wechat.api.config;

import com.zx.share.platform.common.bean.SessionConfig;
import com.zx.share.platform.common.bean.SmsConfig;
import com.zx.share.platform.wechat.api.interceptor.CrossDomainFilter;
import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.auth.AuthDescriptor;
import net.spy.memcached.auth.PlainCallbackHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.Resource;
import java.io.IOException;

/**
 *
 * @author fenggang
 */
@Configuration
@PropertySource(value = {"classpath:/application.properties"}, ignoreResourceNotFound = true, encoding = "utf-8")
public class AppBeanFactary {

    Logger logger = LoggerFactory.getLogger(AppBeanFactary.class);

    @Value("${aliyun.sms.product}")
    public String smsProduct;
    @Value("${aliyun.sms.domain}")
    public String smsDomain;
    @Value("${aliyun.sms.access-key-id}")
    public String smsAccessKeyId;
    @Value("${aliyun.sms.access-key-secret}")
    public String smsAccessKeySecret;

    @Resource
    private MemcachedConfig memcachedConfig;
    @Resource
    private UrlInterceptorConfig urlInterceptorConfig;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    SmsConfig smsConfig(){
        SmsConfig smsConfig = new SmsConfig();
        smsConfig.setSmsAccessKeyId(smsAccessKeyId);
        smsConfig.setSmsAccessKeySecret(smsAccessKeySecret);
        smsConfig.setSmsDomain(smsDomain);
        smsConfig.setSmsProduct(smsProduct);
        return smsConfig;
    }

    @Bean
    SessionConfig sessionConfig(){
        SessionConfig sessionConfig = new SessionConfig();
        sessionConfig.setExpiration(urlInterceptorConfig.getExpiration());
        sessionConfig.setValidationUrls(urlInterceptorConfig.getValidationUrls());
        return sessionConfig;
    }

    @Bean
    MemcachedClient memcachedClient() throws IOException {
        MemcachedClient memcachedClient = null;
        if (memcachedConfig.isNeedAuth()) {
            AuthDescriptor ad =
                    new AuthDescriptor(new String[] {"PLAIN"}, new PlainCallbackHandler(memcachedConfig.getUsername(), memcachedConfig.getPassword()));
            memcachedClient =
                    new MemcachedClient(new ConnectionFactoryBuilder().setProtocol(ConnectionFactoryBuilder.Protocol.BINARY).setAuthDescriptor(ad).build(),
                            AddrUtil.getAddresses(memcachedConfig.getServers()));
        } else {
            memcachedClient =
                    new MemcachedClient(new ConnectionFactoryBuilder().setProtocol(ConnectionFactoryBuilder.Protocol.BINARY).build(), AddrUtil.getAddresses(memcachedConfig
                            .getServers()));
        }

        return memcachedClient;
    }

    /**
     * 注册跨域支持过滤器
     */
    @Bean
    public FilterRegistrationBean registerCrossDomainFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CrossDomainFilter crossDomainFilter = new CrossDomainFilter();
        // 设置是否允许跨域访问
        crossDomainFilter.setAllowCrossDomain(true);
        registrationBean.setFilter(crossDomainFilter);
        registrationBean.setOrder(1);
        return registrationBean;
    }

    public String getSmsProduct() {
        return smsProduct;
    }

    public void setSmsProduct(String smsProduct) {
        this.smsProduct = smsProduct;
    }

    public String getSmsDomain() {
        return smsDomain;
    }

    public void setSmsDomain(String smsDomain) {
        this.smsDomain = smsDomain;
    }

    public String getSmsAccessKeyId() {
        return smsAccessKeyId;
    }

    public void setSmsAccessKeyId(String smsAccessKeyId) {
        this.smsAccessKeyId = smsAccessKeyId;
    }

    public String getSmsAccessKeySecret() {
        return smsAccessKeySecret;
    }

    public void setSmsAccessKeySecret(String smsAccessKeySecret) {
        this.smsAccessKeySecret = smsAccessKeySecret;
    }
}
