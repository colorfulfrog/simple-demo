package com.yxcoach.common.base.constant;

/**
 * 所有的常量key值
 * Created by fengruxiao on 15/10/10.
 */
public interface ConstantsKey {

    interface AlipayConfig {

        /**
         * 支付宝消息验证地址
         */
        String HTTPS_VERIFY_URL = "HTTPS_VERIFY_URL";
        /**
         * 合作身份者ID，以2088开头由16位纯数字组成的字符串
         */
        String PARTNER = "PARTNER";
        /**
         * 商户的私钥
         */
        String PRIVATE_KEY = "PRIVATE_KEY";
        /**
         * 支付宝的公钥，无需修改该值
         */
        String ALI_PUBLIC_KEY = "ALI_PUBLIC_KEY";
        /**
         * 调试用，创建TXT日志文件夹路径
         */
        String LOG_PATH = "LOG_PATH";
        /**
         * 字符编码格式 目前支持 gbk 或 utf-8
         */
        String INPUT_CHARSET = "INPUT_CHARSET";
        /**
         * 签名方式 不需修改
         */
        String SIGN_TYPE = "SIGN_TYPE";
        /**
         * 支付宝时间格式
         */
        String ALIPAY_TIME_FORMAT = "ALIPAY_TIME_FORMAT";
        /**
         * 支付宝回调路径
         */
        String ALIPAY_CALLBACK_URL = "ALIPAY_CALLBACK_URL";
        /**
         * 支付宝充值回调
         */
        String ALIPAY_CALLBACK_URL_RECHARGE = "ALIPAY_CALLBACK_URL_RECHARGE";
        /**
         * 支付宝退款地址
         */
        String ALIPAY_REFUND_URL = "ALIPAY_REFUND_URL";
        /**
         * 支付宝应用ID,开放平台退款使用
         */
        String ALI_APP_ID = "ALI_APP_ID";
        /**
         * 安全交易码
         */
        String ALIPAY_SECURE_KEY="ALIPAY_SECURE_KEY";
        /**
         * 支付宝退款后回调路径
         */
        String ALIPAY_REFUND_CALLBACK_URL="ALIPAY_REFUND_CALLBACK_URL";

        String ALIPAY_GATEWAY_URL="ALIPAY_GATEWAY_URL";
        String ALIPAY_FORMAT="ALIPAY_FORMAT";
    }
    /**
     * 阿里开放平台密钥对
     */
    public interface AliOpenPlatform{
        String PUBLIC_KEY="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
        String PRIVATE_KEY="MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANQf1kbdybpzzM9/tLog8mwyf3hORoVsU+4ZtpzoVI1gLCzUB/7C18lHkS7vl0H7MtTOmUmXeLQGOFDwY+X+P5ZMscjumi3ugNF70ILyYZE0iLugdEO5ubThbkf8cqX70m4gt2uSL0if9ITYWNW7VQ5D2d3yRpiu0PFNJuQ3Uh2pAgMBAAECgYEA09VDYBvGg4t3AdSPf7y9Oy2mvFa2+DD5E/LbuZAON+zN0KqhnVmospnks5GSZNLdrUTwMVyxrl3zyWh26sxfY/8Uu8JZs8fIZPqv0aTRESLFCTBsOpstyKDoaDFA7cCsvcXWaZ+EDZfKth9xroDtZ42vpep4ptIpEJUY7Dkvvd0CQQD8xa1loTc/q/FCNuv0IH0nw0j3RpdBYBtLXM6+qUSgUP3+DIu+ZcEBV3NSyrJRwX5Lz4YcE+1ZZBgfmExmkG9zAkEA1tVHwkNrb+/V1egh9+8rnyEolfeTok7MBelSLov1/5P8IsK4qD225zUAbXT0tbshPnSfLuHu+SDgBcZB2MJ/cwJAb5u04T/azjFUWGE5s9Q4jrsKV6yCkqolwxPacZL5qzO3wlm1xj7Vhosfb3nyXGjsI/sggvtFfIfWovSzH0I9AwJBAKVZ3zNsROMRC9rqIkr8cOy3zs8ukRkZ4PqjzLc6zop6UlRG323OolpudvfITxkZAMtbY7Hn/9EMNqD7KW82tHUCQQDGXI/Ib0ll0F8KwqKI1VNcYUjdLF0IIYf8753Wq2OXfQcS42+2qfo8gQH1QYopELM/T0jy/n3E39rVzW7YalCE";
    }

    interface WechatConfig {
        /**
         * 微信支付统一下单 URL
         */
        String WECHAT_UNI_ORDER_URL = "WECHAT_UNI_ORDER_URL";

        /**
         * 微信查询订单 URL
         */
        String WECHAT_QUERY_ORDER_URL = "WECHAT_QUERY_ORDER_URL";

        /**
         * API 安全的 key, md5验签时需要
         */
        String WECHAT_API_SECURE_KEY = "WECHAT_API_SECURE_KEY";

        /**
         * 微信走么 APPID
         */
        String WECHAT_ZOUME_APPID = "WECHAT_ZOUME_APPID";
        /**
         * 微信公众号 APPID
         */
        String WECHAT_YXHL_APPID = "WECHAT_YXHL_APPID";

        /**
         * 微信走么 商户号
         */
        String WECHAT_ZOUME_MERCHANTID = "WECHAT_ZOUME_MERCHANTID";

        /**
         * HTTPS证书的本地路径
         */
        String WECHAT_CERT_LOCAL_PATH = "WECHAT_CERT_LOCAL_PATH";
        /**
         * 微信公众号的HTTPS证书的本地路径
         */
        String WECHAT_GZH_CERT_LOCAL_PATH = "WECHAT_GZH_CERT_LOCAL_PATH";

        /**
         * HTTPS证书密码，默认密码等于商户号MCHID
         */
        String WECHAT_CERT_PASSWORD = "WECHAT_CERT_PASSWORD";
        /**
         * 微信公众号的证书密码
         */
        String WECHAT_GZH_CERT_PASSWORD = "WECHAT_GZH_CERT_PASSWORD";

        /**
         * 微信时间格式
         */
        String WECHAT_TIME_FORMAT = "WECHAT_TIME_FORMAT";

        /**
         * 微信 请求 BODY,也就是商品简述
         */
        String WECHAT_ZOUME_BODY = "WECHAT_ZOUME_BODY";

        /**
         * 微信 请求 Detail, 商品详细信息
         */
        String WECHAT_ZOUME_DETAIL = "WECHAT_ZOUME_DETAIL";

        /**
         * notify_url
         */
        String WECHAT_NOTIFY_URL = "WECHAT_NOTIFY_URL";
        /**
         * notify_url,充值回调url
         */
        String WECHAT_NOTIFY_URL_RECHARGE = "WECHAT_NOTIFY_URL_RECHARGE";

        /**
         * package
         */
        String WECHAT_ZOUME_PACKAGE = "WECHAT_ZOUME_PACKAGE";

        /**
         * 微信退款路径
         */
        String WECHAT_REFUND_URL = "WECHAT_REFUND_URL";

    }

    interface SwitchConfig {
        /**
         * 是否支付宝调试状态,线下环境- true,线上环境- false
         */
        String ALIPAY_IS_DEBUG = "ALIPAY_IS_DEBUG";

        /**
         * 巴士实时下单是否未 mock 数据,如果 true, 进行 mock, 否则查询真实数据
         */
        String BUS_INTIME_MOCK = "BUS_INTIME_MOCK";

        /**
         * 任务被拒绝或超时未接受时,处理模式
         * * 为恢复订单到初始状态 RESUME
         * * 把当前任务传递给下一个司机 TRANSFER
         */
        String REFUSE_TYPE = "REFUSE_TYPE";
    }

    interface YXConstants {
        /**
         * 客户端最新版本标识
         */
        String CLIENT_LASTEST_VERSION = "CLIENT_LASTEST_VERSION";
        /**
         * 客户端需要更新提示标识
         */
        String CLIENT_NEED_UPDATE = "CLIENT_NEED_UPDATE";
        /**
         * 客户端不需要更新标识
         */
        String CLIENT_NO_NEED_UPDATE = "CLIENT_NO_NEED_UPDATE";
        /**
         * 登陆记录类型--用户
         */
        String LOGIN_TYPE_USER = "LOGIN_TYPE_USER";
        /**
         * 登陆记录类型--司机
         */
        String LOGIN_TYPE_DRIVER = "LOGIN_TYPE_DRIVER";
        /**
         * 账户长度分割值
         */
        String ACCOUNT_LENGTH = "ACCOUNT_LENGTH";
        /**
         * false
         */
        String FALSE = "FALSE";
        /**
         * true
         */
        String TRUE = "TRUE";
        /**
         * title 分隔符
         */
        String TITLE_SEP = "TITLE_SEP";
        /**
         * 空字符串
         */
        String EMPTY = "EMPTY";
        /**
         * 子订单TITLE前缀
         */
        String TITLE_DETAIL_PUFFIX = "TITLE_DETAIL_PUFFIX";
        /**
         * 发车班次时间格式
         */
        String DEPART_TIME_FORMAT = "DEPART_TIME_FORMAT";
        /**
         * 订单流水号格式
         */
        String ORDER_SERIAL_TIME_FORMAT = "ORDER_SERIAL_TIME_FORMAT";
        /**
         * 订单失败原因为用户取消
         */
        String USER_CANCEL = "USER_CANCEL";
        /**
         * 司机点击未接上,失败原因
         */
        String DRIVER_CANCEL = "DRIVER_CANCEL";
        /**
         * 失败原因,调度取消任务
         */
        String DISPATCH_CANCEL_TASK = "DISPATCH_CANCEL_TASK";
        /**
         * 失败原因,调度修改订单到关闭
         */
        String DISPATCH_CANCEL = "DISPATCH_CANCEL";

        /**
         * 预约订单的提前时间,默认为2个小时,即2*60*60秒
         */
        String PREORDER_INTERVAL_IN_SECONDS = "PREORDER_INTERVAL_IN_SECONDS";

        /**
         * 当天最早允许预约的开始时间,理论上需要提前两小时调度,那么凌晨6点钟的车需要凌晨4点钟开始调度吗?
         * 肯定不行,所以加入一个最晚预约时间,这里暂定为9,表示九点
         */
        String PREORDER_ALLOW_BEGIN_HOUR_TODAY = "PREORDER_ALLOW_BEGIN_HOUR_TODAY";

        /**
         * 当天最早允许预约的开始时间,理论上需要提前两小时调度,那么凌晨6点钟的车需要凌晨4点钟开始调度吗?
         * 肯定不行,所以加入一个最晚预约时间,这里暂定为30,表示30分
         * 跟PREORDER_ALLOW_BEGIN_HOUR_TODAY合并起来就是 9:30
         * 代表9:30(含)之前的所有车次,都不能当天预约,必须提前一天预约
         */
        String PREORDER_ALLOW_BEGIN_MIN_TODAY = "PREORDER_ALLOW_BEGIN_MIN_TODAY";

        /**
         * 调度员下班时间,也就是调度第二天早上班次的时间
         */
        String END_DOWN_JOB_HOURS = "END_DOWN_JOB_HOURS";

        /**
         * 未付款订单取消时间间隔,分钟为单位,默认为30分钟
         */
        String UNPAID_ORDER_CANCEL_INTERVAL_MINS = "UNPAID_ORDER_CANCEL_INTERVAL_MINS";

        /**
         * 定时调度 关闭订单的原因
         */
        String TIME_TASK_CLOSE_ORDER_REASON = "TIME_TASK_CLOSE_ORDER_REASON";

        /**
         * 定时调度 任务地理位置信息保存天数,默认为3天
         */
        String TASK_LOCATION_SAVE_DAYS = "TASK_LOCATION_SAVE_DAYS";

        /**
         * 拼车业务,订单取消时间
         */
        String SHARE_ORDER_CANCEL_INTERVAL_MINS = "SHARE_ORDER_CANCEL_INTERVAL_MINS";

        /**
         * 拼车业务,订单提醒时间
         */
        String SHARE_ORDER_REMIND_INTERVAL_MINS = "SHARE_ORDER_REMIND_INTERVAL_MINS";

        /**
         * 位置信息类型- order
         */
        String LOCATION_TYPE_ORDER = "LOCATION_TYPE_ORDER";

        /**
         * 位置信息类型- SELF
         */
        String LOCATION_TYPE_SELF = "LOCATION_TYPE_SELF";

        /**
         * 位置信息类型- car
         */
        String LOCATION_TYPE_CAR = "LOCATION_TYPE_CAR";
        /**
         * 位置信息类型- bus
         */
        String LOCATION_TYPE_BUS = "LOCATION_TYPE_BUS";

        /**
         * 实时巴士查询时,开始时间,默认为30分钟,也就是说如果当前为10点,则查询十点半之后的车
         */
        String BUS_INTIME_BEGIN_MINS = "BUS_INTIME_BEGIN_MINS";

        /**
         * 实时巴士查询时,结束时间,默认为120分钟,也就是如果当前为10点,则查询12点之前的车
         */
        String BUS_INTIME_END_MINS = "BUS_INTIME_END_MINS";

        /**
         * 超过5分钟未接受的快车任务,会自动分配给下一个司机
         */
        String UNACCEPT_TASK_TRANSFER_INTERVAL_MINS = "UNACCEPT_TASK_TRANSFER_INTERVAL_MINS";

        /**
         * 任务 transfer 原因
         */
        String TASK_TRANSFER_REASON = "TASK_TRANSFER_REASON";

        /**
         * localIP,当前服务器 IP
         */
        String LOCAL_IP = "LOCAL_IP";

        /**
         * 对应的 IP地址, 类似于 eth0这种,如果需要取多个,则直接拼接,用冒号分割 eth0:en0
         */
        String IP_TYPE_NAME = "IP_TYPE_NAME";

        /**
         * 还剩多少毫秒时,不允许接单了,目前定为5秒,即5000毫秒
         */
        String ABANDON_ACCEPT_TASK_INTERVAL_MILLIS = "ABANDON_ACCEPT_TASK_INTERVAL_MILLIS";

        /**
         * 需要过滤的 URL 数据 key
         */
        String AUTH_FILTER_URL_KEY = "AUTH_FILTER_URL_KEY";
        /**
         * 不允许议价操作
         */
        String REFUSE_BARGAINING_DRIVER = "REFUSE_BARGAINING_DRIVER";
        /**
         * 时间左区间  用于停止定制巴士,预约快车,包车服务
         */
        String STOP_SERVICE_LEFT = "STOP_SERVICE_LEFT";
        /**
         * 时间右区间
         */
        String STOP_SERVICE_RIGHT = "STOP_SERVICE_RIGHT";
        /**
         * 时间格式化 停止服务时间格式化
         */
        String STOP_SERVICE_TIME_FORMAT = "STOP_SERVICE_TIME_FORMAT";
        /**
         * 下载地址页面配置
         */
        String DOWNLOAD_DEAFULT_PAGE = "DOWNLOAD_DEAFULT_PAGE";
        /**
         * 显示所有的车票信息(定制巴士+原有接口查的票)
         */
        String SHOW_ALL_TICKET = "SHOW_ALL_TICKET";

        /**
         * 益阳售票常量
         */
        /**
         * idnumber
         */
        String IDNUMBER = "IU";
        /**
         * id name
         */
        String IDNAME = "IA";
        /**
         * 候车室
         */
        String WAIT_ROOM = "WR";
        /**
         * 流水班标记
         */
        String HOT = "H";
        /**
         * 检票口
         */
        String CHECK_PORT = "CP";
        /**
         * 是否购买保险
         */
        String CHIT_PRICE_FLAG = "CPF";
        /**
         * 保险费
         */
        String CHIT_PRICE = "CHIT_PRICE";
        /**
         * 客户端系统
         */
        String CLIENT_SYSTEM = "CS";
        /**
         * 客户端版本
         */
        String CLIENT_VERSION = "CV";
        /**
         * 获取出发车站
         */
        String GET_STATION_START = "GET_STATION_START";
        /**
         * 获取出发城市
         */
        String GET_STATION_CITY = "GET_STATION_CITY";
        /**
         * 获取目的城市
         */
        String GET_STATION_END = "GET_STATION_END";
        /**
         * 获取订单信息
         */
        String GET_ORDER_INFO = "GET_ORDER_INFO";
        /**
         * 获取车次
         */
        String GET_SCHEDULE_BUS = "GET_SCHEDULE_BUS";
        /**
         * 获取详细车次信息
         */
        String GET_ONE_BUS_INFO = "GET_ONE_BUS_INFO";
        /**
         * 锁票
         */
        String GET_LOCK_TICKET = "GET_LOCK_TICKET";
        /**
         * 出票
         */
        String GET_SALE_TICKET = "GET_SALE_TICKET";
        /**
         * 取消锁票
         */
        String GET_CANCELL_LOCK_TICKET = "GET_CANCELL_LOCK_TICKET";
        /**
         * 取票手机号
         */
        String GET_TICKET_MOBILE = "GTM";
        /**
         * 成功标识
         */
        String RESULT_CODE_SUCC = "0000";
        /**
         * 100分
         */
        String NUMBER = "100";
        /**
         * 存表开关  0,存  其他不存
         */
        String OPEN_INSERT_TABLE = "OPEN";
        /**
         * 年月日 格式化样式
         */
        String DATE_FORMAT = "yyyy-MM-dd";
        /**
         * 时间分钟  格式化样式
         */
        String TIME_FORMAT = "HH:mm";

        /**
         * 推送ios 测试标识
         */
        String PUSH_IOS_TEST = "TEST";
        /**
         * 推送通知 标识 不成功走短信 8888
         */
        String PUSH_FALSE = "8888";
        /**
         * 查询是否可以退票
         */
        String GET_ORDER_BACK_FLAG = "GET_ORDER_BACK_FLAG";
        /**
         * 退票
         */
        String GET_ORDER_BACK_TICKET = "GET_ORDER_BACK_TICKET";
        /**
         * 退票标识
         */
        String GET_ORDER_BACK_TICKET_FLAG = "是";
        /**
         * 存储缓存,到达城市
         */
        String YY_TICKET = "yy_ticket";
        /**
         * 存储缓存,到达城市
         */
        String BUS_TICKET_END_STATION = "BUS_TICKET_END_STATION";

        /**
         * 公共接口 目的站点
         */
        String PUB_TICKET_END_STATION = "PUB_TICKET_END_STATION";
        /**
         * redis 缓存失效时间,1个小时
         */
        Long EXPIRE_HOURS = 1l;
        /**
         * 存储缓存, y_ticket_city
         */
        String PUB_Y_TICKET_CITY = "PUB_Y_TICKET_CITY";
        /**
         * 退款接口路径
         */
        String REFUND_ORDER_URL = "REFUND_ORDER_URL";
        /**
         * 查询益阳售票订单状态接口路径
         */
        String QUERY_ORDER_STATUS_URL = "QUERY_ORDER_STATUS_URL";
        /***
         * 查询机构名称
         * 唐志伟
         */
        String ORG_NAME="ORG_NAME";
    }

    interface Amap {
        /**
         * 悦行服务端-高德 key
         */
        String AMAP_SERVER_WEB_KEY = "AMAP_SERVER_WEB_KEY";

        /**
         * 高德 API 路径
         */
        String AMAP_WEBSERVER_URL = "AMAP_WEBSERVER_URL";

        /**
         * 高德 API 距离相关的 URI
         */
        String AMAP_DISTANCE_URI = "AMAP_DISTANCE_URI";
    }


    interface SendMsg {
        /**
         * 注册时  找回密码短信通知
         */
        String REGISTER_MSG = "REGISTER_MSG";
        /**
         * 支付完成后旅客短信通知_接驳
         */
        String PAY_FINISH_MSG = "PAY_FINISH_MSG";
        /**
         * 支付完成后旅客短信通知_自行上车
         */
        String PAY_FINISH_MSG_SELF = "PAY_FINISH_MSG_SELF";

        /**
         * 固定班次支付完成发送信息
         */
        String FIX_TICKET_PAY_FINISH_MSG = "FIX_TICKET_PAY_FINISH_MSG";
        /**
         * 新地班次支付完成发送信息
         */
        String XD_TICKET_PAY_FINISH_MSG = "XD_TICKET_PAY_FINISH_MSG";
        /**
         * 大巴网班次支付完成发送信息-模板1
         */
        String DABA_TICKET_PAY_FINISH_MSG_1 = "DABA_TICKET_PAY_FINISH_MSG_1";
        /**
         * 大巴网班次支付完成发送信息-模板2
         */
        String DABA_TICKET_PAY_FINISH_MSG_2 = "DABA_TICKET_PAY_FINISH_MSG_2";

        /**
         * 走么充值信息
         */
        String ZOUME_RECHARGE_MSG = "ZOUME_RECHARGE_MSG";

        /**
         * 中控确定派遣大巴后旅客短信通知
         */
        String DISPATCH_BUS_USER_MSG = "DISPATCH_BUS_USER_MSG";
        /**
         *  接驳车派车（乘客接收）
         */
        String ACCEPT_BUS_USER_MSG = "ACCEPT_BUS_USER_MSG";
        /**
         * 接驳任务（司机接收）
         */
        String ACCEPT_BUS_DRIVER_MSG = "ACCEPT_BUS_DRIVER_MSG";
        /**
         * 中控确定派遣大巴后司机短信通知   还有接驳车 快车
         */
        String DISPATCH_BUS_DRIVER_MSG = "DISPATCH_BUS_DRIVER_MSG";
        /**
         * 定制巴士任务（司机接收）
         */
        String DISPATCH_BUS_DRIVER_N_MSG = "DISPATCH_BUS_DRIVER_N_MSG";
        /**
         * 公务车任务（司机接收）
         */
        String DISPATCH_OFFICE_DRIVER_N_MSG = "DISPATCH_OFFICE_DRIVER_N_MSG";
        /**
         * 接驳车接受任务, 旅客短信通知
         */
        String ACCEPT_TASK_CAR_MSG = "ACCEPT_TASK_CAR_MSG";
        /**
         * 巴士任务（司机接收）
         */
        String BUS_TASK_DRIVER_MSG = "BUS_TASK_DRIVER_MSG";
        /**
         * 快车接受任务,旅客短信通知
         */
        String ACCEPT_QUICK_TASK_CAR_MSG = "ACCEPT_QUICK_TASK_CAR_MSG";
        /**
         * 快车接驾中取消,旅客短信通知
         */
        String CANCEL_TASK_MSG = "CANCEL_TASK_MSG";
        /**
         * 司机取消乘客短信内容
         */
        String DRIVER_CANCEL_MSG = "DRIVER_CANCEL_MSG";
        /**
         * 司机发送账单
         */
        String DRIVER_SENDBILL_MSG = "DRIVER_SENDBILL_MSG";
        /**
         * 支付完成,发给司机的短信
         */
        String QUICK_PAY_FINISH_MSG ="QUICK_PAY_FINISH_MSG";
        /**
         * 电呼下单成功发送短信
         */
        String CALL_CENTER_MSG = "CALL_CENTER_MSG";
        /**
         * 加客给司机发短信
         */
        String DRIVER_ADD_MSG = "DRIVER_ADD_MSG";

        /**
         * 软件序列号,通过亿美销售人员获取
         */
        String SN = "SN";
        /**
         * 密码,通过亿美销售人员获取
         */
        String SENDMSG_PASSWORD = "SENDMSG_PASSWORD";
        /**
         * 序列号首次激活时自己设定
         */
        String SENDMSG_KEY = "SENDMSG_KEY";
        /**
         * 发送短信基本路径
         */
        String SENDMSG_BASE_URL = "SENDMSG_BASE_URL";
        /**
         * 发送即时短信
         */
        String SENDMSG_NOW = "SENDMSG_NOW";
        /**
         * 注册序列号
         */
        String REGIST_SN = "REGIST_SN";
        /**
         * 查询余额
         */
        String SENDMSG_BALANCE = "SENDMSG_BALANCE";
        /**
         * 短信签名
         */
        String MSG_SIGNATURE = "MSG_SIGNATURE";
        /**
         * 半小时内最多可以发10条短信,后续事件可以自己定制
         */
        String SMS_MAX_COUNT_IN_HALF_HOUR = "SMS_MAX_COUNT_IN_HALF_HOUR";
        /**
         * 短信验证码超时时间,设置为180秒
         */
        String SMS_EXPIRED_SECONDS = "SMS_EXPIRED_SECONDS";

        /**
         * 短信发送时间间隔
         */
        String SMS_TIME_INTERVAL = "SMS_TIME_INTERVAL";

        /**
         * 短信中的时间格式
         */
        String SMS_TIME_FORMAT = "SMS_TIME_FORMAT";
        /**
         * 快车下单成功通知短信
         */
        String CALL_CENTER_MSG_USER = "CALL_CENTER_MSG_USER";
        String CALL_FOR_OTHER_MSG = "正替您叫车。";
        /**
         * 公务车调度成功短信模板修改
         */
        String XG_DISPATCH_BUS_USER_MSG = "XG_DISPATCH_BUS_USER_MSG";
        /**
         * 公务车预定成功短信模板修改
         */
        String XG_CALL_CENTER_MSG_USER = "XG_CALL_CENTER_MSG_USER";
        /**
         * 巴士退票短信
         */
        String BUS_TICKET_REFUND_MSG = "BUS_TICKET_REFUND_MSG";

    }

    interface AttributeKeyConstants {
        /**
         * 订单上的联系人姓名
         */
        String ORDER_CONTRACT_NAME_KEY = "ORDER_CONTRACT_NAME_KEY";

        /**
         * 是否需要小车接送的标记
         */
        String NEED_FERRY = "NEED_FERRY";

        /**
         * 拼车订单,超过1小时未成行的话,需要打标,用于提示
         */
        String SHARE_ORDER_REMIND_KEY = "SHARE_ORDER_REMIND_KEY";

        /**
         * 出发地经纬度属性
         */
        String LNG_LAT = "LNG_LAT";
        /**
         * 目的地经纬度
         */
        String ELNG_LAT = "ELNG_LAT";
        /**
         * 跳站标识
         */
        String JUMP = "JUMP";

        /**
         * 主订单发车时间
         */
        String MAIN_ORDER_DEPART = "MAIN_ORDER_DEPART";

        /**
         * 任务拒绝原因
         */
        String TASK_REFUSE_REASON = "TASK_REFUSE_REASON";

        /**
         * 新生成 taskId
         */
        String NEW_TASK_ID = "NEW_TASK_ID";


        /**
         * 老 taskId
         */
        String OLD_TASK_ID = "OLD_TASK_ID";

        /**
         * 操作 IP
         */
        String OPERATE_IP = "OPERATE_IP";

        /**
         * 是否已经议价
         */
        String IS_BARGAINING = "IS_BARGAINING";

        /**
         * 售票查询始发站 存数据库 开关
         */
        String OPEN_INSERT_TABLE_YYSALE = "OPEN_INSERT_TABLE_YYSALE";
        /**
         * idnumber
         */
        String IDNUMBER = "IU";
        /**
         * id name
         */
        String IDNAME = "IA";
        /**
         * 候车室
         */
        String WAIT_ROOM = "WR";
        /**
         * 流水班标记
         */
        String HOT = "H";
        /**
         * 检票口
         */
        String CHECK_PORT = "CP";
        /**
         * 是否购买保险
         */
        String CHIT_PRICE_FLAG = "CPF";
        /**
         * 保险费
         */
        String CHIT_PRICE = "CHIT_PRICE";
        /**
         * 客户端系统
         */
        String CLIENT_SYSTEM = "CS";
        /**
         * 客户端版本
         */
        String CLIENT_VERSION = "CV";
        /**
         * 取票手机号
         */
        String GET_TICKET_MOBILE = "GTM";
        /**
         * 用户的类型,用户表中
         */
        String USER_TYPE = "USER_TYPE";


        // 下单需要保存的数据
        // 单程用车
        String CALL_CAR_FOR_OTHER = "IS_CCFO"; //替他人叫车
        String OTHER_MOBILE = "OM"; // 他人手机号
        String SEND_MSG_FLAG = "SMF"; // 他人手机号
        String USER_DEPART_TIME = "UDT"; // 客户选择出发时间
        String VHL_TYPE = "VHLTYP"; //车型
        String RUN_KILOMETER = "RKM"; //约运行公里
        String RUN_TIME = "RT"; //约运行时间
        String RUN_PRICE = "RP"; //运行价格
        // 分时租车
        String RENT_CAR_TIME = "RCT"; //租车时长


        //结束任务时保存
        String RUN_KM = "runKm"; //运行公里
        String RUN_MIN = "runMin"; //运行分钟

        String START_DETAIL_ADDRESS="SDA";//起始详细位置
        String END_DETAIL_ADDRESS="EDA";//终点详细位置

        String VEHICLE_SERIES= "vehicleSeries";//车系

        String PARKING_FEE = "PF";//停车费
        String LUQIAO_FEE = "LF";//路桥费
        String CLEAN_FEE = "CF";//清洁费
        String ARIPORT_FEE ="AF";//机场服务费
        String OTHER_FEE = "OF";//其它费用
        String NIGHT_FEE = "NF";//夜间费
        String LONG_DISTANCE_FEE = "LDF";//远程费
        String TIMES_FEE = "TF";//时长费
        String PEAK_FEE = "PKF";//高峰期费用
        String KM_FEE = "KF";//里程费
        String START_FEE ="SF";//起步费
        String PACKAGE_FEE ="PAGF";//套餐价

        //巴士退票
        String LCMONNEY ="LCM";//退票手续费
        String REFUND_FEE ="RFEE";//退票金额
    }

    interface PushConstants {
        /**
         * 乘客应用key
         */
        String APP_ANDROID_KEY_USER = "APP_ANDROID_KEY_USER";
        /**
         * 乘客应用证书
         */
        String APP_ANDROID_SECRET_USER = "APP_ANDROID_SECRET_USER";
        /**
         * 乘客应用key
         */
        String APP_IOS_KEY_USER = "APP_IOS_KEY_USER";
        /**
         * 乘客应用证书
         */
        String APP_IOS_SECRET_USER = "APP_IOS_SECRET_USER";
        /**
         * 司机应用key
         */
        String APP_ANDROID_KEY_DRIVER = "APP_ANDROID_KEY_DRIVER";
        /**
         * 司机应用证书
         */
        String APP_ANDROID_SECRET_DRIVER = "APP_ANDROID_SECRET_DRIVER";
        /**
         * 司机应用key
         */
        String APP_IOS_KEY_DRIVER = "APP_IOS_KEY_DRIVER";
        /**
         * 司机应用证书
         */
        String APP_IOS_SECRET_DRIVER = "APP_IOS_SECRET_DRIVER";
        /**
         * 客户端系统
         */
        String CLIENT_SYSTEM_IOS = "CLIENT_SYSTEM_IOS";
        /**
         * 客户端系统
         */
        String CLIENT_SYSTEM_ANDROID = "CLIENT_SYSTEM_ANDROID";
        /**
         * 给单用户推送
         */
        String PUSH_UNICAST = "PUSH_UNICAST";
        /**
         * 给多用户推送
         */
        String PUSH_LISTCAST = "PUSH_LISTCAST";
        /**
         * ANDROID user推送版本号
         */
        String PUSH_ANDROID_CLIENT_VERSION = "PUSH_ANDROID_CLIENT_VERSION";
        /**
         * ANDROID driver 推送版本号
         */
        String PUSH_ANDROID_DRIVER_VERSION = "PUSH_ANDROID_DRIVER_VERSION";
        /**
         * IOS user
         */
        String PUSH_IOS_CLIENT_VERSION = "PUSH_IOS_CLIENT_VERSION";
        /**
         * IOS driver
         */
        String PUSH_IOS_DRIVER_VERSION = "PUSH_IOS_DRIVER_VERSION";
        /**
         * 安卓推送 通知栏提示文字
         */
        String PUSH_ANDROID_TICKER = "PUSH_ANDROID_TICKER";
        /**
         * 安卓推送 通知标题
         */
        String PUSH_ANDROID_TITLE = "PUSH_ANDROID_TITLE";
        /**
         * 安卓推送 状态栏图标ID
         */
        String PUSH_ANDROID_ICON = "PUSH_ANDROID_ICON";
        /**
         * 安卓推送 通知栏拉开后左侧图标ID
         */
        String PUSH_ANDROID_LARGEICON = "PUSH_ANDROID_LARGEICON";
        /**
         * ios推送 通知栏提示角标
         */
        String PUSH_IOS_BADGE = "PUSH_IOS_BADGE";
        /**
         * ios推送 铃声
         */
        String PUSH_IOS_SOUND = "PUSH_IOS_SOUND";
        /**
         * ios推送 通知栏提示文字
         */
        String PUSH_IOS_TEST = "PUSH_IOS_TEST";
        /**
         * 推送后续动作  detail
         */
        String PUSH_AFTER_OPEN_DETAIL = "PUSH_AFTER_OPEN_DETAIL";
        /**
         * 推送后续操作  list
         */
        String PUSH_AFTER_OPEN_LIST = "PUSH_AFTER_OPEN_LIST";
        /**
         * 推送后续操作  open
         */
        String PUSH_AFTER_OPEN = "PUSH_AFTER_OPEN";
        /**
         * 推送自定义参数 id  推送订单,任务id
         */
        String PUSH_PARAM_ID = "PUSH_PARAM_ID";
        /**
         * 推送自定义参数  action 推送动作
         */
        String PUSH_PARAM_ACTION = "PUSH_PARAM_ACTION";
        /**
         * 推送ios 参数 rideStatus
         */
        String PUSH_PARAM_RIDESTATUS = "PUSH_PARAM_RIDESTATUS";
        /**
         * 推送后续操作 打开地图详情
         */
        String PUSH_AFTER_OPEN_MAP = "PUSH_AFTER_OPEN_MAP";
        /**
         * 参数字典 param
         */
        String PUSH_PARAM = "PUSH_PARAM";
        /**
         *
         */
        String PUSH_PARAM_BIZTYPE = "PUSH_PARAM_BIZTYPE";
    }

    interface diyBus {
        /**
         * 上车位置和站点距离范围值
         */
        String COMPARE_DISTANCE = "COMPARE_DISTANCE";
        /**
         * 超过多远算过站
         */
        String PASS_STATION_DISTANCE = "PASS_STATION_DISTANCE";
        /**
         * 接驳车价格
         */
        String FERRY_PRICE = "FERRY_PRICE";
        /**
         * 定点bus自动调度时间
         */
        String FIX_BUS_DISPATCH_TIME = "FIX_BUS_DISPATCH_TIME";
        // 方法切换
        String DRIVER_FUNCTION_CHANGE = "DRIVER_FUNCTION_CHANGE";
        //用户端详情地图未派车显示的字
        String USER_MAP_SHOW = "USER_MAP_SHOW";
        //多少公里范围内可派单
        String ACCEPT_DISTANCE="ACCEPT_DISTANCE";
        //查询班次使用的常量
        String startStationCode = "startStationCode";
        String startStationName = "startStationName";
        String endStationCode = "endStationCode";
        String endStationName = "endStationName";
        String scheduleName = "scheduleName";
        String distance = "distance";
        String runtime = "runtime";
        String ticketPrice = "ticketPrice";
        //班次查询接口
        String scheduleNo = "scheduleNo";
        String gmtDepartDate = "gmtDepartDate";
        String gmtDepartTime = "gmtDepartTime";
        String endCityName = "endCityName";
        String freeSeat = "freeSeat";
        String type = "type";
        String vehicleType = "vehicleType";

    }
    interface ftBus {
        /**
         * 查询班次限制,不能卖票的秒数
         */
        String NOT_SELL_TICKET_SEC = "NOT_SELL_TICKET_SEC";
        /**
         * 窗口售票默认联系人电话
         */
        String MOBILE_WINDOW_SALE = "MOBILE_WINDOW_SALE";
        /**
         * 窗口售票默认联系人在数据库中的ID
         */
        String MOBILE_USER_ID_WINDOW_SALE = "MOBILE_USER_ID_WINDOW_SALE";
    }
    interface BizTicket {
        String NOT_SALE_CHL_TYPE = "NOT_SALE_CHL_TYPE"; // 哪个渠道不卖票
        String NO_PASS_GET_TICKET_MSG = "NO_PASS_GET_TICKET_MSG"; // 没有校验码提示信息
    }
    interface Mpv{//公务车 专车
        String MPV_MODEL="MPV_MODEL";
        String RENTAL_TIMES="RENTAL_TIMES";
        String AUTH_ADDRESS="AUTH_ADDRESS";//权限url
        String PLATFORM_ADDRESS="PLATFORM_ADDRESS";//platform的项目地址,用于拼接图片url
        String PLATFORM_PHOTO_ADDRESS = "PLATFORM_PHOTO_ADDRESS";//platform,司机图片url
        String MANAGEMENT_ADDRESS="MANAGEMENT_ADDRESS";//management的项目地址,用于拼接图片url
        /**
         * nginx静态资源根路径
         */
        String NGINX_STATIC_RES_LOCATION="NGINX_STATIC_RES_LOCATION";

        String WAIT_DISPATCH_TIME = "WAIT_DISPATCH_TIME";//专车自动调度订单
    }

    /**
     * 实名认证
     */
    interface Authentication{

        /**
         *  实名认证地址
         */
        String AUTH_URL="AUTH_URL";
        /**
         * 公司账号 100366
         */
        String AUTH_USER_ID="AUTH_USER_ID";

        /**
         * ase密钥 sy37159w1193gbRN
         */
        String AUTH_ASE_KEY="AUTH_ASE_KEY";

        /**
         * md5密钥 73z93h5L5ia5xFNbX9eJ1A13155m5P59
         */
        String AUTH_MD5_KEY="AUTH_MD5_KEY";
    }

    interface ZMPAY{

        String PUBLIC_KEY="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDklIQj5pGDEDQD/Wb+annY5v2s\n" +
                "jLGwKEK3aLrFMGRP5f0M8y+rZCzTsL4G3rCVHcfb0JClQJI9gcPyen63fa3gsBmI\n" +
                "WEJjB0x+3mIlM2weuzNORkdo+Te8f/DOaD1XuJRvuQnZ40uSP7w0sH2tFMhAVGPF\n" +
                "2L4rLOiJ1F6zo4GqrQIDAQAB";

        String PRIVATE_KEY="" +
                "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOSUhCPmkYMQNAP9\n" +
                "Zv5qedjm/ayMsbAoQrdousUwZE/l/QzzL6tkLNOwvgbesJUdx9vQkKVAkj2Bw/J6\n" +
                "frd9reCwGYhYQmMHTH7eYiUzbB67M05GR2j5N7x/8M5oPVe4lG+5CdnjS5I/vDSw\n" +
                "fa0UyEBUY8XYviss6InUXrOjgaqtAgMBAAECgYEAw6fAh/5XNYmMDJI+M62uSJRI\n" +
                "NQdlHTUJDnctz5YBd0aU2R3cAufHWxghQD4jhjAsn6Ih/eGMi+tkb0yc5LFGP7wy\n" +
                "7m//7kSCyrUDzHCeF+j3aIHY6DCEYKg4pgKgcWdCXX13amRfYWCNXa/vVuXiGAyJ\n" +
                "N9zK6M8S9om2nVcWi70CQQD1VDS+dfBgtpWPBTWC99mM33IJqoXXqCOOcFjMjqFY\n" +
                "ZgAmKZBwtCBytjY+b7cDfNsBE6Pm7gUjwjmn+L739Zo3AkEA7oXO/C6UpZ9Wr1O6\n" +
                "xfgAyYNo+YSdGhVSUx06pWoWA8xobZMFxFf1Ow0X+0w+tEM2tfKjSwWaWwCHapba\n" +
                "iUHgOwJAFPC9F8zFWdv75BtTt/wj66xe9YhCqGfHsS7RxZQfHYaHWLqPg688Xc5D\n" +
                "zwyGGJwdrXfZs6p5cdXwSfAnjM6//QJBALv1fdKD8mdBVNH8rSXr9NLXVxWpRxOS\n" +
                "0bjlQ52uJ4L+xRvzy4uZtInAG7HPt2ndvXNLrRolZClqFUwNbFDVNJkCQAYshOVB\n" +
                "8hCKBB/AU9HUZIsp31uxeb7VhyBYmIo1kKra6d02va29RUWt2vS+C0vG9+Qc+pHh\n" +
                "V2NulQRuObIfGLg=\n" +
                "";
    }

    interface SPECIALCAR{
        /**
         *  专车业务是否开通,true--开通;false--未开通
         */
        String SPECIALCAR_OPEN="SPECIALCAR_OPEN";
    }

}
