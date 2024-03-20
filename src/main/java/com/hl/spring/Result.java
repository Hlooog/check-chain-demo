package com.hl.spring;

/**
 * @Author: hl
 * @Description: 校验结果类的封装 可以把返回的异常包装起来
 * @DateTime: 2024/3/21  1:02
 **/
public class Result {

    private boolean pass;

    private Throwable error;

    public boolean pass() {
        return pass;
    }

    public Throwable getError() {
        return error;
    }

    public Result(boolean pass, Throwable error) {
        this.pass = pass;
        this.error = error;
    }
}
