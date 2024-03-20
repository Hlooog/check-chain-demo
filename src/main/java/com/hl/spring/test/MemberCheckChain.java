package com.hl.spring.test;

import com.hl.spring.CheckChain;
import com.hl.spring.From;
import com.hl.spring.Result;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: hl
 * @Description: TODO
 * @DateTime: 2024/3/20  23:14
 **/
@From
public class MemberCheckChain implements CheckChain {

    @Override
    public String getName() {
        return "memberCheckChain";
    }

    @Override
    public boolean isNecessary(Map<String, Object> condition) {
        return true;
    }

    @Override
    public Result check(Map<String, Object> condition) {
        System.out.println("我是第一层执行的 ------ " + getName());
        return new Result(true, null);
    }
}
