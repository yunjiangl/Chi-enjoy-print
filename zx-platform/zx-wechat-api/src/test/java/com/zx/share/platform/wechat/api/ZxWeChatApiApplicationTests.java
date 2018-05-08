package com.zx.share.platform.wechat.api;

import com.zx.share.platform.bean.sys.SysDictionary;
import com.zx.share.platform.util.email.MailBean;
import com.zx.share.platform.util.email.SendMail;
import com.zx.share.platform.wechat.api.pay.service.WeCharPayService;
import com.zx.share.platform.wechat.api.pay.service.impl.WeCharPayServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZxWeChatApiApplicationTests {

	@Autowired
	private WeCharPayService weCharPayService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void payTest(){
		//111.85.159.16
		Map<String,Object> map = weCharPayService.payUnifiedorder("合意之家-测试支付","测试支付",1,"111.85.159.16","fg201805070000001","oCdck0Y35dqWOzGfI36fmbUkXLKE","JSAPI");
		System.out.println(map);
	}

	@Test
	public void emaiTest(){
		MailBean mb = new MailBean();
		mb.setHost("smtp.163.com"); // 设置SMTP主机(163)，若用126，则设为：smtp.126.com
		mb.setUsername("fglovezzr@163.com"); // 设置发件人邮箱的用户名
		mb.setPassword("fg201314zzr"); // 设置发件人邮箱的密码，需将*号改成正确的密码
		mb.setFrom("fglovezzr@163.com"); // 设置发件人的邮箱
		mb.setTo("exqooo@print.epsonconnect.com"); // 设置收件人的邮箱
		mb.setSubject(UUID.randomUUID().toString()); // 设置邮件的主题
		mb.setContent(""); // 设置邮件的正文

		mb.attachFile("/Users/fenggang/Documents/1524209545257.jpg"); // 往邮件中添加附件

		SendMail sm = new SendMail();
		System.out.println("正在发送邮件...");
		// 发送邮件
		if (sm.sendMail(mb)){
			System.out.println("发送成功!");
		}else{
			System.out.println("发送失败!");
		}
	}

}
