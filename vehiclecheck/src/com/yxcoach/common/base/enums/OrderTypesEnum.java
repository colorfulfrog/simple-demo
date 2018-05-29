package com.yxcoach.common.base.enums;



/**
 * @Description 订单类型   枚举
 * Created by yangzhipeng on 2017年7月18日
 */
public enum OrderTypesEnum {
	//订单类型   1、拼车（调度时，座位说+1）2、包车（整车必须为新班次，不能添加其他乘客）3、快件（不扣除座位数）4、已售车票
	/** 拼车  */
	CARPOOLING(1, "拼车"),
	
	/**  包车 */
	CHARTERED(2, "包车"),
	
	/**  快件 */
	DELIVERY(3, "快件"),
	
	/** 已售车票  */
    TICKET(4, "已售车票 ");
  
    private Integer types;

    private String desc;

    OrderTypesEnum(Integer types, String desc) {
        this.types = types;
        this.desc = desc;
    }

    public static boolean isIn(Integer types) {
        for (OrderTypesEnum t : OrderTypesEnum.values()) {
            if (t.getTypes()==types) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断type是否在指定的typeEnum范围中
     *
     * @param types
     * @param idTypeEnums
     * @return
     */
    public static boolean isIn(Integer types, OrderTypesEnum... idTypeEnums) {
        for (OrderTypesEnum typeEnum : idTypeEnums) {
            if (typeEnum.getTypes()==types) {
                return true;
            }
        }
        return false;
    }

    public static OrderTypesEnum getEnum(Integer types) {
        for (OrderTypesEnum f : OrderTypesEnum.values()) {
            if (f.getTypes()==types) {
                return f;
            }
        }
        return null;
    }

    public Integer getTypes() {
        return types;
    }

    public boolean equals(Integer types) {
        return types==this.types;
    }

}
