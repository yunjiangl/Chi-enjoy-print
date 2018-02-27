package com.zx.share.platform.wechat.api.pay.model;


public class TemplateMsg {

    private String value;
    private String color = "#173177";


    public TemplateMsg(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public TemplateMsg(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
