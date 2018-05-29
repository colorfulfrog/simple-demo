package com.yxcoach.common.base.enums;



/**
 * @Description 班次状态   枚举
 * Created by yangzhipeng on 2017年7月18日
 */
public enum BusFreStatusEnum {
	//1等待组客  2正在组客 3已经发班 4班次完成 5班次取消6班次异常
	/** 等待组客  */
	PASSG_WAIT(1, "等待组客"),
	
	/**  正在组客   */
	PASSG_START(2, "正在组客"),
	
	/**  已经发班    */
	FRE_START(3, "已经发班"),
	
	/** 班次完成  */
	FRE_END(4, "班次完成 "),
	
    /** 班次取消  */
	FRE_CANCEL(5, "班次取消"),
	
	/** 班次异常  */
	FRE_EXO(6, "班次异常 ");
	
	
  
    private Integer status;

    private String desc;

    BusFreStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static boolean isIn(Integer status) {
        for (BusFreStatusEnum t : BusFreStatusEnum.values()) {
            if (t.getStatus()==status) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断type是否在指定的typeEnum范围中
     *
     * @param status
     * @param idTypeEnums
     * @return
     */
    public static boolean isIn(Integer status, BusFreStatusEnum... idTypeEnums) {
        for (BusFreStatusEnum typeEnum : idTypeEnums) {
            if (typeEnum.getStatus()==status) {
                return true;
            }
        }
        return false;
    }

    public static BusFreStatusEnum getEnum(Integer status) {
        for (BusFreStatusEnum f : BusFreStatusEnum.values()) {
            if (f.getStatus()==status) {
                return f;
            }
        }
        return null;
    }

    public Integer getStatus() {
        return status;
    }

    public boolean equals(Integer status) {
        return status==this.status;
    }

}
