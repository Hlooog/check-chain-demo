package com.hl.spring;

import java.util.Map;

/**
 * @Author: hl
 * @Description: TODO
 * @DateTime: 2024/3/20  22:46
 **/
public interface CheckChain {

    String getName();

    boolean isNecessary(Map<String, Object> condition);

    Result check(Map<String, Object> condition);

}
