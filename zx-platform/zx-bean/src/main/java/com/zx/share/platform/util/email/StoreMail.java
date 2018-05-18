package com.zx.share.platform.util.email;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.*;

/**
 * Created by fenggang on 18/5/8.
 *
 * @author fenggang
 * @date 18/5/8
 */
public class StoreMail {

    final static String USER = "fengg@exqoo.com"; // 用户名
    final static String PASSWORD = "A123456b"; // 密码
    public final static String MAIL_SERVER_HOST = "pop3.exqoo.com"; // 邮箱服务器

    public static List<Map<String,Object>> emailInbox() throws Exception {
        List<Map<String,Object>> result = new ArrayList<>();
        // 创建一个有具体连接信息的Properties对象
        Properties prop = new Properties();
        prop.setProperty("mail.debug", "true");
        prop.setProperty("mail.store.protocol", "pop3");
        prop.setProperty("mail.pop3.host", MAIL_SERVER_HOST);
        // 1、创建session
        Session session = Session.getInstance(prop);
        // 2、通过session得到Store对象
        Store store = session.getStore();
        // 3、连上邮件服务器
        store.connect(MAIL_SERVER_HOST, USER, PASSWORD);
        // 4、获得邮箱内的邮件夹
        Folder folder = store.getFolder("inbox");
        folder.open(Folder.READ_ONLY);
        // 获得邮件夹Folder内的所有邮件Message对象
        Message[] messages = folder.getMessages();
        for (int i = messages.length-1; i >=0; i--) {
//            Message m = messages[i];
            Map<String,Object> map = new HashMap<>();
            String subject = messages[i].getSubject();
            map.put("subject",subject);
            String from = (messages[i].getFrom()[0]).toString();
            map.put("from",from);
            String content = messages[i].getContent().toString();
            map.put("content",content);
            System.out.println("第 " + (i + 1) + "封邮件的主题：" + subject);
            System.out.println("第 " + (i + 1) + "封邮件的发件人地址：" + from);
            System.out.println("第 " + (i + 1) + "封邮件的发件内容：" + content);
            result.add(map);
            if(i+11 == messages.length){
                break;
            }
        }
        // 5、关闭
        folder.close(false);
        store.close();

        return result;
    }
}
