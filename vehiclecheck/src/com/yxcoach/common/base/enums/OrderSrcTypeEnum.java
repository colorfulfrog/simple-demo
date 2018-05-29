package com.yxcoach.common.base.enums;


import org.apache.commons.lang3.StringUtils;

/**
 *  老走么系统订单状态
 * 订单类 枚举  
 * @Description  TODO
 * Created by yangzhipeng on 2017年7月18日
 */
public enum OrderSrcTypeEnum {
    APP("APP", "线上订单"),
    /** * 电话订单  */
    CALL("CALL", "电呼订单"),
    WEIXIN("WEIXIN","微信端订单"),
    WINDOW("WINDOW","窗口订单");
    

    private String type;

    private String desc;

    OrderSrcTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static boolean isIn(String type) {
        for (OrderSrcTypeEnum t : OrderSrcTypeEnum.values()) {
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
    public static boolean isIn(String type, OrderSrcTypeEnum... idTypeEnums) {
        for (OrderSrcTypeEnum typeEnum : idTypeEnums) {
            if (StringUtils.equalsIgnoreCase(typeEnum.getType(), type)) {
                return true;
            }
        }
        return false;
    }

    public static OrderSrcTypeEnum getEnum(String type) {
        for (OrderSrcTypeEnum f : OrderSrcTypeEnum.values()) {
            if (StringUtils.equalsIgnoreCase(f.getType(), type)) {
                return f;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public boolean equals(String type) {
        return StringUtils.equalsIgnoreCase(type, this.type);
    }

}
