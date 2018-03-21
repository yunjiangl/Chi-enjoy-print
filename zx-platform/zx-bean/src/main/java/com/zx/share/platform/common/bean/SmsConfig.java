package com.zx.share.platform.common.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by fenggang on 18/3/7.
 *
 * @author fenggang
 * @date 18/3/7
 */
public class SmsConfig implements Serializable {

    public String smsProduct;
    public String smsDomain;
    public String smsAccessKeyId;
    public String smsAccessKeySecret;

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
