package com.hl.spring.test;

import com.hl.spring.CheckChain;
import com.hl.spring.From;
import com.hl.spring.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: hl
 * @Description: TODO
 * @DateTime: 2024/3/20  23:09
 **/
@From(from = "authCheckChain")
//@Component
public class TokenCheckChain implements CheckChain {
    @Override
    public String getName() {
        return "tokenCheckChain";
    }

    @Override
    public boolean isNecessary(Map<String, Object> condition) {
        return true;
    }

    @Override
    public Result check(Map<String, Object> condition) {
        System.out.println("我需要authCheckChain先执行才能执行 ------ " + getName());
        return new Result(true, null);
    }
}
