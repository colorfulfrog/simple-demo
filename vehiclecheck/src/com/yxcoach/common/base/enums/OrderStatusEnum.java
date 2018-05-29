package com.yxcoach.common.base.enums;



/**
 * @Description 订单状态类 枚举
 * Created by yangzhipeng on 2017年7月18日
 */
public enum OrderStatusEnum {
	//1等待组客  2正在组客 3已经发班 4班次完成 5班次取消6班次异常
 /*   WAIT(1, "等待组客"),
    GET_BUS(2, "正在组客"),
    ALREADYBUS(3, "已经发班"),
    FR_FINLISH(4, "班次完成 "),
    FR_CANCEL(5, "班次取消"),*/
    /*FR_EXCEPTION(6,"班次异常")*/
    A_EXCEPTION(6,"班次异常");
    

    private Integer type;

    private String desc;

    OrderStatusEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static boolean isIn(Integer type) {
        for (OrderStatusEnum t : OrderStatusEnum.values()) {
            if (t.getType()==type) {
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
    public static boolean isIn(Integer type, OrderStatusEnum... idTypeEnums) {
        for (OrderStatusEnum typeEnum : idTypeEnums) {
            if (typeEnum.getType()==type) {
                return true;
            }
        }
        return false;
    }

    public static OrderStatusEnum getEnum(Integer type) {
        for (OrderStatusEnum f : OrderStatusEnum.values()) {
            if (f.getType()==type) {
                return f;
            }
        }
        return null;
    }

    public Integer getType() {
        return type;
    }

    public boolean equals(Integer type) {
        return type==this.type;
    }

}
