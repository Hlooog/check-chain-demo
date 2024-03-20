package com.hl.spring;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: hl
 * @Description:    注解 标在校验类上面 from如果是”“ 表示是第一层来执行， 有值的话表明需要在这个类后面这姓
 * @DateTime: 2024/3/20  22:43
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface From {
    String from() default "";

}
