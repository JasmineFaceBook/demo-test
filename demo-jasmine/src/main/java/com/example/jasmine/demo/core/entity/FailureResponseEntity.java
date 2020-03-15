package com.example.jasmine.demo.core.entity;

/**
 * Created by wuwei on 2017/7/4.
 * 返回失败实体，非错误。
 */
public class FailureResponseEntity extends ResponseEntity {
    public FailureResponseEntity(String msg) {
        super(-1, msg);
    }

    public FailureResponseEntity(Object data) {
        super(-1, "操作失败", data);
    }

    public FailureResponseEntity() {
        super(-1, "操作失败");
    }
    public FailureResponseEntity(String msg,Object data) {
        super(-1, msg, data);
    }
}
