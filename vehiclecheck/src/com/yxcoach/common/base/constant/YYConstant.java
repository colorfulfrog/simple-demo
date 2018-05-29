package com.yxcoach.common.base.constant;


/**
 * Created by fengruxiao on 16/1/6.
 */
public interface YYConstant {
    String YYSP_ID = "YYSP_ID";
    String YYSP_PWD = "YYSP_PWD";
    String xmlHead = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    String header = "<Header><ID>" + YXContants.getConfigValue(YYConstant.YYSP_ID) + "</ID><PWD>" + YXContants.getConfigValue(YYConstant.YYSP_PWD) + "</PWD><SIGN /></Header>";
    String sMessage = "<Message>";
    String eMessage = "</Message>";

    /**
     * 车票的类型,如果是流水班,则 hot 字段值为"热线",否则为"普通"
     */
    String SCHEDULE_HOTTYPE_HOT = "热线";
    String SCHEDULT_HOTTYPE_COMMON  = "普通";
}
