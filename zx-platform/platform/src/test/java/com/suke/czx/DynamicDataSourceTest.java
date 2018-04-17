package com.suke.czx;


import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.console.api.datasources.DataSourceTestService;
import com.zx.share.platform.console.api.modules.user.entity.UserEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDataSourceTest {
    @Autowired
    private DataSourceTestService dataSourceTestService;

    @Test
    public void test(){
        //数据源1
        ZxUser user = dataSourceTestService.queryObject(1L);
        System.out.println(ToStringBuilder.reflectionToString(user));

        //数据源2
        ZxUser user2 = dataSourceTestService.queryObject2(1L);
        System.out.println(ToStringBuilder.reflectionToString(user2));

        //数据源1
        ZxUser user3 = dataSourceTestService.queryObject(1L);
        System.out.println(ToStringBuilder.reflectionToString(user3));
    }

}
