package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exqoo.Launch;
import com.exqoo.service.SysDeviceService;

/**
 * 
 * @ClassName: SysDeviceServiceTest
 * @Description: 设备业务测试类
 * @author 芸江
 * @date 2018年1月16日 下午3:15:42
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes = Launch.class)
public class SysDeviceServiceTest {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SysDeviceService sysDeviceService;

	@Before
	public void setupMockMvc() throws Exception {
		logger.info("开始测试");
	}

	@Test
	public void test() {
		Map<String,Object> map = new HashMap<String,Object>();
		
		List list = sysDeviceService.list(map);
		logger.info("测试结束");
	}

}
