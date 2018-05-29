package com.yxcoach.common.base.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by alan on 15/9/5.
 * 客户端类型枚举
 */
public enum ClientTypeEnum {
    USER("USER", "user", "用户端"),
    DRIVER("DRIVER", "driver", "司机端"),
    WEIXIN("WEIXIN", "weiXin", "微信端"),
    ALIPAY("ALIPAY", "alipay", "支付宝")
    ;

    private String type;

    private String typeInLowerCase;

    private String desc;

    ClientTypeEnum(String type, String typeInLowerCase, String desc) {
        this.type = type;
        this.typeInLowerCase = typeInLowerCase;
        this.desc = desc;
    }

    public static boolean isIn(String type) {
        for (ClientTypeEnum t : ClientTypeEnum.values()) {
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
    public static boolean isIn(String type, ClientTypeEnum... idTypeEnums) {
        for (ClientTypeEnum typeEnum : idTypeEnums) {
            if (StringUtils.equalsIgnoreCase(type, typeEnum.getType())) {
                return true;
            }
        }
        return false;
    }

    public static ClientTypeEnum getEnum(String type) {
        for (ClientTypeEnum f : ClientTypeEnum.values()) {
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

    public ClientTypeEnum setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public ClientTypeEnum setType(String type) {
        this.type = type;
        return this;
    }

    public String getTypeInLowerCase() {
        return typeInLowerCase;
    }

    public ClientTypeEnum setTypeInLowerCase(String typeInLowerCase) {
        this.typeInLowerCase = typeInLowerCase;
        return this;
    }

    public boolean equals(String type) {
        return StringUtils.equalsIgnoreCase(this.type, type);
    }

}
