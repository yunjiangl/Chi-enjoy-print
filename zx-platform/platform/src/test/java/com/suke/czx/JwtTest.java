package com.suke.czx;

import com.zx.share.platform.console.api.common.utils.Word2PdfUtil;
import com.zx.share.platform.console.api.modules.app.utils.JwtUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


//@RunWith(SpringRunner.class)
//@SpringBootTest
public class JwtTest {
//    @Autowired
//    private JwtUtils jwtUtils;

    @Test
    public void test() {
//        String token = jwtUtils.generateToken(1);

//        System.out.println(token);

        Word2PdfUtil.doc2pdf("H:/IT软件开发常用英语词汇经典大全.doc");
        //String inPath="H:/pdf/IT软件开发常用英语词汇经典大全.doc";
        //System.out.println(inPath.substring(0,inPath.lastIndexOf("/")));
    }

}
