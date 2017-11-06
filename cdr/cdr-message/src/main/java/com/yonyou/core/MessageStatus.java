package com.yonyou.core;

public enum MessageStatus {

    NEW("0", "新接入消息，正在解析。"),
    OK("1", "消息处理成功。"),
    NULL_DTO("2", "关键业务对象为空，检查xml格式。"),
    DEPEND_NOT_EXIST("3", "消息依赖不存在。"),
    NULL_FIELD("4", "非空字段为空。"),
    NOT_SUPPORT_ACTION("5","不支持的交互类"),
    EXCEPTION("9", "系统异常。");


    private String value;

    private String desc;

    MessageStatus(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
