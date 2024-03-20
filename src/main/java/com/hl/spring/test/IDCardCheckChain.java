package com.hl.spring.test;

import com.hl.spring.CheckChain;
import com.hl.spring.From;
import com.hl.spring.Result;

import java.util.Map;

/**
 * @Author: hl
 * @Description: TODO
 * @DateTime: 2024/3/21  1:00
 **/
@From(from = "tokenCheckChain")
public class IDCardCheckChain implements CheckChain {
    @Override
    public String getName() {
        return "IDCardCheckChain";
    }

    @Override
    public boolean isNecessary(Map<String, Object> condition) {
        return false;
    }

    @Override
    public Result check(Map<String, Object> condition) {
        System.out.println("我需要tokenCheckChain先执行才能执行 ------ " + getName());
        return new Result(false,  new RuntimeException("身份证验证失败"));
    }
}
