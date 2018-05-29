package com.yxcoach.common.base.constant;

/**
 * Created by alan on 16/1/16.
 * 不需要配置的常量都放在这边
 */
public interface NonConfigYxConstants {
    /**
     * 车票查询返回结果编码/名称
     */
    String OK_RET_CODE = "0000";
    String OK_RET_CODE_7 = "0000000";
    String OK_RET_MSG = "Success";
    String SYSTEM = "SYSTEM";
    /**
     * 日期格式化格式
     */
    String SDF_YMDHMS = "yyyy-MM-dd HH:mm:ss";
    String SDF_YMD = "yyyy-MM-dd";
    String DATE_START = " 00:00:00";
    String DATE_END = " 23:59:59";
    String DATE_START_HM = "00:00";
    String DATE_END_HM = "23:59";
    String DATE_MD = "M月d日";
    String DATE_NO_SS = "yyyy-MM-dd HH:mm";
    String DATE_HM = "HH:mm";
    /**
     * 订单和任务操作类型
     */
    String PAY = "pay"; //支付
    String DRIVER_CANCEL = "driver_cancel";//司机取消
    String SYS_CANCEL = "sys_cancel";//系统取消
    String USER_CANCEL = "user_cancel";//用户取消
    String DISPATCH = "dispatch";//派车
    String REFUNDING = "refunding";
    String REFUNDED = "refunded";//退款
    String ACCEPT = "accept";//接任务
    String DISPATCH_CANCEL = "dispatch_cancel";//调度取消
    String FINISH = "finish";//任务完成
    String DRIVER_RIDE = "driver_ride";//司机接上车
    String DRIVER_SENDBILL = "driver_sendbill";//司机发送账单
    String BARGAINING = "bargaining";//议价发车

    // session前缀
    String SESSION_PREFIX_CONST = "ShiroSession_";

    String BASE64_STR="ZMPay--走么钱包,安全方便.";

    /**
     * 真
     */
    String TRUE = "true";
    /**
     * 假
     */
    String FALSE = "false";
    /**
     * 逗号分隔符
     */
    String SEP_COMMA = ",";
    /**
     * 箭头分隔符
     */
    String SEP_ARROW = "-->";
    /**
     * 冒号分隔符
     */
    String SEP_COLON = ":";

    /**
     * 空字符串
     */
    String EMPTY_STR = "";
    /**
     * 分号
     */
    String SEP_SEMICOLON = ";";
    /**
     * 横线分割符
     */
    String SEP_BAR = "-";

    /**
     * 连接符
     */
    String SEP_AND = "&";

    /**
     * 异步消息来源,支付宝
     */
    String NOTIFY_SRC_ALIPAY = "alipay";

    /**
     * 异步消息来源,微信支付
     */
    String NOTIFY_SRC_WECHAT = "wechat";
    /**
     * 快车,现金支付
     */
    String NOTIFY_SRC_CASH = "cash";
    /**
     * 快车,现金支付
     */
    String NOTIFY_SRC_ZMPAY = "zmpay";
    /**
     * 返回给支付宝的结果
     */
    String ALI_RESULT_SUC = "success";
    String ALI_RESULT_FAIL = "fail";

    /**
     * 返回给微信支付的结果
     */
    String WECHAT_RESULT_SUC = "SUCCESS";
    String WECHAT_RESULT_FAIL = "FAIL";

    /**
     * 任务被拒绝或超时未接受时,处理模式
     * * 为恢复订单到初始状态 RESUME
     * * 把当前任务传递给下一个司机 TRANSFER
     */
    String REFUSE_TYPE_RESUME = "RESUME";

    /**
     * 任务被拒绝或者超时未接受时,处理模式为把当前任务传递给下一个司机
     */
    String REFUSE_TYPE_TRANSFER = "TRANSFER";
    /**
     * 存入缓存的key值,配置信息
     */
    String Y_CONFIG = "y_config";
    /**
     * 编码表
     */
    String Y_REAL_CODE = "y_real_code";
    /**
     * 存入缓存的key值,城市
     */
    String Y_CITY = "y_city";
    /**
     * 版本表
     */
    String Y_VERSION = "y_version";
    /**
     * netty通道表
     */
    String Y_CHANNEL = "y_channel";
    /**
     * 存入缓存key值,站点
     */
    String Y_STATION = "y_station";

    /**
     * 存入根据ID存入的Station信息
     */
    String Y_ID_STATION = "y_id_station";

    /**
     * 存入缓存key,登录校验用
     */
    String Y_LOGIN_RECORD = "y_login_record";
    /**
     * 推送设备
     */
    String Y_PUSH_DEVICE = "y_push_device";
    /**
     * 司机上传的经纬度
     */
    String Y_TASK_LOCATION = "y_task_location";
    String Y_DRIVER_LOCATION = "y_driver_location";
    /**
     * 司机上传的行驶里程
     */
    String Y_TASK_DISTANCE = "y_task_distance";
    /**
     * 放当前站的序号前缀
     */
    String CURRENT_SEQUENCE = "current_sequence";
    /**
     * 存入缓存list,key,班次城市信息
     */
    String QUERY_DISTINCT_SCHEDULE = "queryDistinctSchedule";
    /**
     * 存入缓存list
     */
    String QUERY_BY_AREACODE = "queryByAreacode";
    String QUERY_PREFECTURE_CITYBYNAME = "queryPrefectureCityByName";
    String QUERY_COUNTY_BY_STARTSTATION = "queryCountyByStartStation";
    String QUERY_STATION_BY_ID = "queryAllStationByID";

    /**
     * redis 缓存失效时间,默认3天
     */
    Long EXPIRE = 3l;
    /**
     * 1天失效
     */
    Long EXPIRE1 = 1l;
    /**
     * 公众号的唯一标识
     */
    String GZH_APPID = "wx0b88f5062208216e";/**
     * 小程序的唯一标识
     */
    String SMALL_APPID = "wx0ee577b8a78c5821";
    /**
     * 公众号的商户号
     */
    String GZH_MCHID = "1304784501";
    /**
     * 公众号的appsecret
     */
    String SECRET = "bbe34f911722e389bdb9ab9ec1c9435e"; /**
     * 公众号的appsecret
     */
    String SMALL_SECRET = "5f3bd11c1bc10e3fa11d444d341bd020";
    /**
     * 填写为authorization_code
     */
    String GRANT_TYPE = "authorization_code";
    /**
     * 用户类型,用户表中的
     */
    String WX_APP = "wx_app";
    /**
     * app的appId
     */
    String APP_APPID = "wx36f2dcd837967386";
    /**
     * app的商户号
     */
    String APP_MCHID = "1502557121";
    /**
     *  判断本周下周
     */
    String CONDITIONS_WEEK = "conditions";
    /**
     * bus类型判断
     */
    String BUS_TYPE = "busType";
    /**
     * DAY
     */
    String DAY = "day";
    /**
     * 现在
     */
    String NOW = "now";
    /**
     * 上次
     */
    String LAST = "last";
    /**
     * 下次
     */
    String NEXT = "NEXT";

    interface AttributeKeyConstants {
        String idNumber = "idNumber"; //身份证号
        String contractType = "contractType"; //联系人类型(成人/儿童)
        String idType = "idType"; //证件类似
        String gender = "gender"; //性别
        String mobile = "mobile"; //联系人电话
        String realname = "realname"; //联系人姓名
        String ferry = "ferry";//接驳车标识
        String byhand = "byhand";//手工操作纪录

        // 定制巴士attribute属性添加
        String startStationCode = "startStationCode"; //起点编码
        String endStationCode = "endStationCode"; //终点编码
        String getOnStation = "getOnStation"; //定制巴士-需要接驳车-乘车站点
        String resumeOrderFlag = "ROF"; //订单恢复标志
    }

    interface OrgConstant {
        String XD_ORG = "XINDI";
        String DABA_ORG = "DABAWANG";
        String DEFAULT_ORG = "default_org";
    }
    /**
     * 权限类型 即资源编号类型 菜单类型
     */
    String PERMISSION_TYPE_URL="1";
    /**
     * 权限类型 即资源编号类型 按钮类型
     */
    String PERMISSION_TYPE_BUTTION="2";
    /**
     * management在权限系统中的资源根编号
     */
    String PERMISSION_MANAGEMENT="110001";

    interface LineExtKey {
        /**
         * 途经站始发站序号
         */
        Integer START_STATION_SEQ = 1;
        /**
         * 途经站终点站序号
         */
        Integer END_STATION_SEQ = 999;
        /**
         * 途经站初始化值为0
         */
        Long LINE_EXT_ZERO = 0l;
        /**
         * 途经站燃油基数
         */
        String FUEL_OIL_BASE = "fuelOilBase";
        /**
         * 途经站运行时间
         */
        String RUN_TIME = "runTime";
        /**
         * 途经站里程
         */
        String DISTANCE = "distance";
    }

    interface ScheduleBusKey {
        /**
         * 班次判断值0
         */
        String STRING_ZERO = "0";
        /**
         * 班次判断值1
         */
        String STRING_ONE = "1";
        /**
         * 班次判断值0
         */
        Integer INT_ZERO = 0;
        /**
         * 班次判断值1
         */
        Integer INT_ONE = 1;
        /**
         * 班次判断值1
         */
        Integer INT_TWO = 2;
        /**
         * 一周起始周一
         */
        Integer WEEK_ZERO = 0;
        /**
         * 一周末尾周天
         */
        Integer WEEK_SIX = 6;
        /**
         * 一周七天
         */
        String DAY1 = "day1";
        String DAY2 = "day2";
        String DAY3 = "day3";
        String DAY4 = "day4";
        String DAY5 = "day5";
        String DAY6 = "day6";
        String DAY7 = "day7";
    }

    String WALLET_RECHARGE_INFO = "钱包充值:{0}元";
    /**
     * 是否判断
     */
    String ISABLE = "isAble";
    /**
     * 窗口售票类型
     */
    String TICKET_TYPE = "TC";
    /**
     * 窗口售票存入发票号到属性中
     */
    String WINDOW_SALE_TICKET_NUMBER = "WSTN";
    /**
     * 线下订单验票说明
     */
    String WINDOW_CHECK_DESC = "线下订单";
    /**
     * 横线省略
     */
    String WINDOW_LINES = "--------";
    /**
     * 登录路径
     * */
    String LOGIN_URL="/admin/login";

    String AUTO_DISPATCH_TIP = "系统自动派单";
    String AUTO_DISPATCH_CANCEL_TIP = "订单已取消,任务自动取消";


}
