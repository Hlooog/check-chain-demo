package com.hl.spring;

import java.util.Map;

/**
 * @Author: hl
 * @Description: TODO
 * @DateTime: 2024/3/20  22:46
 **/
public interface CheckChain {

    /**
     * 返回类名
     * @return
     */
    String getName();

    /**
     * 通过条件来判断这个类返回的校验结果是不是必须要的
     * 如果不是必须要的 就算check返回false 也是可以继续执行的
     * @param condition 条件
     * @return true表示是必须的  false 表示不是必须的
     */
    boolean isNecessary(Map<String, Object> condition);

    /**
     * 返回校验结果
     * @param condition 校验条件
     * @return 校验结果 如果不通过 可以把异常结果放进这里面
     */
    Result check(Map<String, Object> condition);

}
