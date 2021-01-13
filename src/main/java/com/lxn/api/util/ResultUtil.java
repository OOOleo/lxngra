package com.lxn.api.util;

import com.lxn.api.base.Response;
import com.lxn.api.base.Result;


public class ResultUtil {

    public final static int SUCCESS_CODE = 200;

    public final static String MESSAGE = "success";

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(SUCCESS_CODE);
        result.setMsg(MESSAGE);
        return result;
    }

    public static <T> Result<T> result(T t) {
        Result<T> result = new Result<>(t);
        result.setCode(SUCCESS_CODE);
        result.setMsg(MESSAGE);
        return result;
    }
}
