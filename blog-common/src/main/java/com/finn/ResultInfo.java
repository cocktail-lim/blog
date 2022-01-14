package com.finn;

public enum ResultInfo {
    /*
    * 枚举类的对象
    * */
    GLOBAL_ERROR("101", "全局异常，系统繁忙"),
    NOT_FOUND("404", "Sorry, 页面没有找到！"),
    SUCCESS("200", "操作成功！");
    /*
    * 申明枚举类的对象属性
    * */
    private String code;
    private String message;

    /*
    * 创建构造类
    * */
    ResultInfo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /*
    * 获取对象的code
    * */
    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
