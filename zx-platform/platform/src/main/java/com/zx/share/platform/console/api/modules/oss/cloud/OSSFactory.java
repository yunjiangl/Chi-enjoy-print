package com.zx.share.platform.console.api.modules.oss.cloud;

import com.zx.share.platform.console.api.common.utils.ConfigConstant;
import com.zx.share.platform.console.api.common.utils.Constant;
import com.zx.share.platform.console.api.common.utils.SpringContextUtils;
import com.zx.share.platform.console.api.modules.sys.service.SysConfigService;

/**
 * 文件上传Factory
 * @author czx
 * @email object_czx@163.com
 * @date 2017-03-26 10:18
 */
public final class OSSFactory {
    private static SysConfigService sysConfigService;

    static {
        OSSFactory.sysConfigService = (SysConfigService) SpringContextUtils.getBean("sysConfigService");
    }

    public static CloudStorageService build(){
        //获取云存储配置信息
        CloudStorageConfig config = sysConfigService.getConfigObject(ConfigConstant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);

        if(config.getType() == Constant.CloudService.QINIU.getValue()){
            return new QiniuCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
            return new AliyunCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
            return new QcloudCloudStorageService(config);
        }

        return null;
    }

}
