package com.lxn.api.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> extends Response {
    private static final long serialVersionUID = 1;
    private T data;
}
