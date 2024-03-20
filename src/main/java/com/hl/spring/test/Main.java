package com.hl.spring.test;

import com.hl.spring.Result;
import com.hl.spring.SpringConfig;
import com.hl.spring.VerifyChain;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

import java.awt.image.RescaleOp;
import java.lang.reflect.Member;

/**
 * @Author: hl
 * @Description: TODO
 * @DateTime: 2024/3/20  23:17
 **/
public class Main {

    public static void main(String[] args) throws Throwable {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        MemberCheckChain bean = context.getBean(MemberCheckChain.class);
//        System.out.println(bean);
        VerifyChain verifyChain = context.getBean(VerifyChain.class);
        Result verify = verifyChain.verify(null);
        if (!verify.pass()) {
            throw verify.getError();
        }
    }

}
