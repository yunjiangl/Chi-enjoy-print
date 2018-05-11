package com.zx.share.platform.vo.wechat.request;

import com.zx.share.platform.common.bean.PageRequestBean;
import com.zx.share.platform.util.StringUtil;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by fenggang on 18/3/19.
 *
 * @author fenggang
 * @date 18/3/19
 */
public class PrinterQueryBean extends PageRequestBean {
    private static final long serialVersionUID = 7636921007615846343L;

    @ApiModelProperty(value = "经度")
    private Double longitude;
    @ApiModelProperty(value = "纬度")
    private Double latitude;
    @ApiModelProperty(value = "用户id")
    private Long userId;
    @ApiModelProperty(value = "用户code")
    private String userCode;
    @ApiModelProperty(value = "打印机code")
    private String printerCode;

    private String province;
    private String city;
    private String area;
    private String query;


    @ApiModelProperty(value = "开始经度")
    private Double startLongitude;
    @ApiModelProperty(value = "开始纬度")
    private Double startLatitude;

    @ApiModelProperty(value = "结束经度")
    private Double endLongitude;
    @ApiModelProperty(value = "结束纬度")
    private Double endLatitude;

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPrinterCode() {
        return printerCode;
    }

    public void setPrinterCode(String printerCode) {
        this.printerCode = printerCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Double getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(Double startLongitude) {
        this.startLongitude = startLongitude;
    }

    public Double getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(Double startLatitude) {
        this.startLatitude = startLatitude;
    }

    public Double getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(Double endLongitude) {
        this.endLongitude = endLongitude;
    }

    public Double getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(Double endLatitude) {
        this.endLatitude = endLatitude;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void calculate(){
        if(StringUtil.isNotBlank(latitude)){
            setStartLatitude(latitude-0.003);
            setEndLatitude(latitude+0.003);
        }
        if(StringUtil.isNotBlank(longitude)){
            setStartLongitude(longitude-0.003);
            setEndLongitude(longitude+0.003);
        }

    }
}
