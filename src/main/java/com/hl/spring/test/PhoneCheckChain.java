package com.hl.spring.test;

import com.hl.spring.CheckChain;
import com.hl.spring.From;
import com.hl.spring.Result;

import java.util.Map;

/**
 * @Author: hl
 * @Description: TODO
 * @DateTime: 2024/3/21  0:59
 **/
@From(from = "memberCheckChain")
public class PhoneCheckChain implements CheckChain {
    @Override
    public String getName() {
        return "phoneCheckChain";
    }

    @Override
    public boolean isNecessary(Map<String, Object> condition) {
        return true;
    }

    @Override
    public Result check(Map<String, Object> condition) {
        System.out.println("我需要memberChainCheck先执行才能执行 ------ " + getName());
        return new Result(true, null);
    }
}
