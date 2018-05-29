package com.yxcoach.common.base.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by fengruxiao on 15/9/23.
 */
public enum ResultCodeEnum {
	
    UNKNOWN_ERROR("UNKNOWN_ERROR", "未知错误"),
    VERIFY_ERROR("VERIFY_ERROR", "验证码错误"),
    VERIFY_CODE_EXPIRED("VERIFY_CODE_EXPIRED", "验证码失效"),
    CONFIG_INFO_NOT_EXIST("CONFIG_INFO_NOT_EXIST", "配置信息不存在"),
    /**  调度的附属线路编号不能为空或零    */
    DISPATCH_LIN_EXT_NULL("DISPATCH_LIN_EXT_NULL", "调度的附属线路编号不能为空或零"),
    /**  调度的班次编号不能为空或零    */
    DISPATCH_BUS_FRE_NULL("DISPATCH_BUS_FRE_NULL", "调度的班次编号不能为空或零"),
    /**  调度线路编号不能为空或零    */
    DISPATCH_LIN_ID_NULL("DISPATCH_LIN_ID_NULL", "线路编号不能为空或零"),
    
    WECHAT_PREPAY_ERROR("WECHAT_PREPAY_ERROR", "微信支付失败,请稍后重试"),
    /**  订单编号不能为空    */
    ORDER_ID_NULL("ORDER_ID_NULL", "订单编号不能为空")
    ;
    
    private String type;

    private String desc;

    ResultCodeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static boolean isIn(String type) {
        for (ResultCodeEnum t : ResultCodeEnum.values()) {
            if (StringUtils.equalsIgnoreCase(t.getType(), type)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断type是否在指定的typeEnum范围中
     *
     * @param type
     * @param idTypeEnums
     * @return
     */
    public static boolean isIn(String type, ResultCodeEnum... idTypeEnums) {
        for (ResultCodeEnum typeEnum : idTypeEnums) {
            if (StringUtils.equalsIgnoreCase(type, typeEnum.getType())) {
                return true;
            }
        }
        return false;
    }

    public static ResultCodeEnum getEnum(String type) {
        for (ResultCodeEnum f : ResultCodeEnum.values()) {
            if (StringUtils.equalsIgnoreCase(f.getType(), type)) {
                return f;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public boolean equals(String type) {
        return StringUtils.equalsIgnoreCase(this.type, type);
    }

}
