package com.fh.code;

public enum ResponseEnum {

    SUCCESS(200,"操作成功"),
    ERROR(500,"操作失败"),
    CODE_ERROR(1001,"验证码错误"),
    PHONE_NUMBER_IS_NULL(505,"手机号为空"),
    MEMBER_INFO_IS_NULL(506,"会员信息为空"),
    MEMBER_USERNAME_IS_NULL(507,"会员用户名为空"),
    MEMBER_PASSWORD_IS_NULL(508,"会员密码为空"),
    MEMBER_PHONE_NUMBER_IS_NULL(509,"会员手机号为空"),
    MEMBER_PHONE_NUMBER_IS_ILLEGAL(510,"会员手机号不合法"),
    VERIFY_CODE_IS_NULL(511,"验证码为空"),
    VERIFY_CODE_IS_EXPIRED(512,"验证码无效"),
    MEMBER_USERNAME_IS_EXISTED(514,"用户名已存在"),
    MEMBER_PHONE_NUMBER_IS_USED(515,"密码不正确"),

    MEMBER_PWD_IS_NULL(515,"手机号已注册"),
    TOKEN_IS_NULL(516,"没有头信息"),
    TOKEN_IS_SHORT_OF(517,"头信息不完整"),
    TOKEN_VERIFY_ERROR(518,"验证token失败"),
    TOKEN_IS_EXPIRED(522,"登录信息已过期"),
    PRODUCT_ID_IS_NULL(523,"商品id为空"),
    PRODUCT_IS_SOLD_OUT(524,"商品下架"),
    CART_IS_NOT_EXISTED(524,"购物车不存在"),
    CART_PRODUCT_IS_NOT_EXISTED(524,"购物车不存在此商品"),
    CART_ALL_CHECKED_PRODUCT_UNDER_STOCK(525,"所选商品库存都不足"),
    TOKEN_IS_CHANGED(526,"token已经被篡改"),
    REPETITIVE_OPERATION(527,"重复操作"),
    PAY_LOG_IS_NULL(528,"当前会员没有待支付订单"),
    OUT_TRADE_NO_INVALID(529,"无效的订单号！"),
    PWD_ERROR(403,"密码");

    private int code;
    private String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
