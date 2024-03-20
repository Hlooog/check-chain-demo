package com.hl.spring.test;

import com.hl.spring.CheckChain;
import com.hl.spring.From;
import com.hl.spring.Result;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: hl
 * @Description: TODO
 * @DateTime: 2024/3/20  22:52
 **/
@From
//@Component
public class AuthCheckChain implements CheckChain {
    @Override
    public String getName() {
        return "authCheckChain";
    }

    @Override
    public boolean isNecessary(Map<String, Object> condition) {
        return false;
    }

    @Override
    public Result check(Map<String, Object> condition) {
        System.out.println("我是第一层执行的 ------ " + getName());
        return new Result(false, new RuntimeException("账号验证失败"));
    }
}
