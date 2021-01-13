package com.lxn.api.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response implements Serializable {
    private static final long serialVersionUID = 1;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    int code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String msg;

}
