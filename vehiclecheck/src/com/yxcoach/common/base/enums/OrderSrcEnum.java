package com.yxcoach.common.base.enums;



/**
 * @Description 订单类型
 * Created by yangzhipeng on 2017年7月18日
 */
public enum OrderSrcEnum {
	//订单来源1、电呼 2、控收 3、售票 4、中途上车5、站内乘客
    CALL(1, "电呼"),
    DISPATCH(2, "控收"),
    SALE(3, "售票"),
    MD_RIDE(4, "中途上车 "),
    ST_PSSAGE(5, "站内乘客");
    

    private Integer type;

    private String desc;

    OrderSrcEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static boolean isIn(Integer type) {
        for (OrderSrcEnum t : OrderSrcEnum.values()) {
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
    public static boolean isIn(Integer type, OrderSrcEnum... idTypeEnums) {
        for (OrderSrcEnum typeEnum : idTypeEnums) {
            if (typeEnum.getType()==type) {
                return true;
            }
        }
        return false;
    }

    public static OrderSrcEnum getEnum(Integer type) {
        for (OrderSrcEnum f : OrderSrcEnum.values()) {
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
