package com.zx.share.platform.wechat.api.interceptor;

import com.zx.share.platform.common.bean.SessionConfig;
import com.zx.share.platform.common.bean.UrlPatternConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * spring mvc的辅助配置
 */
@Configuration
public class DefaultWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    SessionConfig sessionConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        UrlPatternConfig validationUtils = sessionConfig.getValidationUrls();

        LoginValidationInterceptor loginValidationInterceptor = applicationContext.getBean(LoginValidationInterceptor.class);

        List<String> includePatterns = validationUtils.getIncludePatterns();
        List<String> excludePatterns = validationUtils.getExcludePatterns();
        InterceptorRegistration registration = null;
        if ((null != includePatterns) && (includePatterns.size() > 0)) {
            registration = registry.addInterceptor(loginValidationInterceptor);
            registration.addPathPatterns(includePatterns.toArray(new String[]{}));
            if ((null != excludePatterns) && (excludePatterns.size() > 0)) {
                registration.excludePathPatterns(excludePatterns.toArray(new String[]{}));
            }
        }

    }

}
