/*package com.yxcoach.common.base.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.google.gson.Gson;
import com.yxcoach.common.entity.messagecenter.MessageLog;
import com.yxcoach.common.entity.messagecenter.MessageSetting;
import com.yxcoach.common.entity.messagecenter.SysMessageSetting;
import com.yxcoach.common.entity.system.SysUser;
import com.yxcoach.common.request.messagecenter.MessageRequest;
import com.yxcoach.common.request.messagecenter.MessageSettingRequest;
import com.yxcoach.common.request.messagecenter.SysMessageSettingRequest;
import com.yxcoach.common.service.dispatcher.BsLineService;
import com.yxcoach.common.service.dispatcher.BsOrderService;
import com.yxcoach.common.service.dispatcher.impl.BsLineServiceImpl;
import com.yxcoach.common.service.dispatcher.impl.BsOrderServiceImpl;
import com.yxcoach.common.service.driver.BsMsglogService;
import com.yxcoach.common.service.driver.impl.BsMsglogServiceImpl;
import com.yxcoach.common.service.messagecenter.MessageService;
import com.yxcoach.common.service.messagecenter.MessageSettingService;
import com.yxcoach.common.service.messagecenter.SysMessageSettingService;
import com.yxcoach.common.service.messagecenter.impl.MessageServiceImpl;
import com.yxcoach.common.service.messagecenter.impl.MessageSettingServiceImpl;
import com.yxcoach.common.service.messagecenter.impl.SysMessageSettingServiceImpl;
import com.yxcoach.common.service.system.SysUserService;
import com.yxcoach.common.service.system.impl.SysUserServiceImpl;

public class MsgSetUtil {
	private static final Log log = LogFactory.getLog(MsgSetUtil.class);
	private static String MESSAGE_SETTING="MESSAGE_SETTING";
	private static String GOTO_WORK="GOTO_WORK";
	public static String SYS_MESSAGE_SETTING_KEY="SysMessageSetting";
	public static String MESSAGE_SETTING_KEY="MessageSetting";
	*//**
	 * 
	 * @param type 1：只取全局开关对象，2：取全局开关对象和个人开关对象
	 * @param userid:用户id，没有请传null
	 * @return
	 *//*
	public static Map getMsgSet(Integer type,Long userid){
		Map res=new HashMap();

		try{
			SysMessageSettingService smservice = (SysMessageSettingService) SpringContextUtil.getBean("SysMessageSettingService", SysMessageSettingServiceImpl.class);
			MessageSettingService mservice = (MessageSettingService) SpringContextUtil.getBean("MessageSettingService", MessageSettingServiceImpl.class);
			RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) SpringContextUtil.getBean("redisTemplate", RedisTemplate.class);
			SysMessageSetting syset = (SysMessageSetting) redisTemplate.opsForValue().get(SYS_MESSAGE_SETTING_KEY+":"+1);//从缓存取全局开关对象
			if(syset==null){
				SysMessageSettingRequest req = new SysMessageSettingRequest();
				req.setId(1);
				syset = smservice.get(req);//从数据库取全局开关对象
				if(syset!=null){
					redisTemplate.opsForValue().set(SYS_MESSAGE_SETTING_KEY+":"+1,syset);//全局开关对象保存到缓存	
				}
			}
			res.put(SYS_MESSAGE_SETTING_KEY, syset);

			if(type.equals(2)){
				if(userid!=null&&userid>0){
					MessageSetting mset = (MessageSetting) redisTemplate.opsForValue().get(MESSAGE_SETTING+":"+userid);//根据用户id从缓存取个人开关对象
					if(mset==null){
						MessageSettingRequest msr=new MessageSettingRequest();
						msr.setUid(userid);
						mset = mservice.get(msr);
						if(mset!=null){
							redisTemplate.opsForValue().set(MESSAGE_SETTING+":"+userid,mset);//根据userid将个人开关对象保存到缓存	
						}
					}
					res.put(MESSAGE_SETTING_KEY, mset);
				}
			}

		}catch(Exception e){
			log.error("获取消息开关对象异常"+e);
			e.printStackTrace();
		}

		return res;
	}

	*//**
	 * 修改个人开关
	 * @param req
	 * @return
	 *//*
	public static void updateMsgSet(MessageSettingRequest req){
		try{
			MessageSettingService mservice = (MessageSettingService) SpringContextUtil.getBean("MessageSettingService", MessageSettingServiceImpl.class);
			RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) SpringContextUtil.getBean("redisTemplate", RedisTemplate.class);
			if(req!=null){
				Long uid = req.getMessageSetting().getUid();
				req.setUid(uid);
				MessageSetting mset = (MessageSetting) redisTemplate.opsForValue().get(MESSAGE_SETTING+":"+uid);//根据用户id从缓存取个人开关对象
				MessageSetting msgset = mservice.get(req);  //从数据库取个人开关对象
				if(mset==null){
					redisTemplate.opsForValue().set(MESSAGE_SETTING+":"+uid,msgset);//根据用户id将个人开关对象保存到缓存	
				}else{
					redisTemplate.opsForValue().set(MESSAGE_SETTING+":"+uid,msgset);//根据用户id将个人开关对象保存到缓存
				}
			}
		}catch(Exception e){
			log.error("修改个人开关异常"+e);
			e.printStackTrace();
		}
	}

	*//**
	 * 修改全局开关
	 * @param req
	 *//*
	public static void updateSysMsgSet(SysMessageSettingRequest req){
		try{
			SysMessageSettingService smservice = (SysMessageSettingService) SpringContextUtil.getBean("SysMessageSettingService", SysMessageSettingServiceImpl.class);
			RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) SpringContextUtil.getBean("redisTemplate", RedisTemplate.class);
			if(req!=null){
				long id = req.getId();
				SysMessageSetting sysmset = (SysMessageSetting) redisTemplate.opsForValue().get(SYS_MESSAGE_SETTING_KEY+":"+id);//根据全局开关id从缓存取全局开关对象
				if(req!=null){
					SysMessageSetting smset = smservice.get(req); //从数据库取全局开关对象
					if(sysmset==null){
						redisTemplate.opsForValue().set(SYS_MESSAGE_SETTING_KEY+":"+id,smset);//根据全局开关id将全局开关对象保存到缓存	
					}else{
						redisTemplate.opsForValue().set(SYS_MESSAGE_SETTING_KEY+":"+id,smset);//根据全局开关id将全局开关对象保存到缓存
					}
				}
			}
		}catch(Exception e){
			log.error("修改全局开关异常"+e);
			e.printStackTrace();
		}
	}

	*//**
	 * 根据用户id查询上下班状态
	 * @param userId 用户id
	 * @return status 调度上下班状态 1上班，2下班 默认状态为上班
	 *//*
	public static Integer getGotoWork(Long userId){
		Integer status=1;
		try{
			SysUserService service = (SysUserService) SpringContextUtil.getBean("SysUserServiceImpl", SysUserServiceImpl.class);
			RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) SpringContextUtil.getBean("redisTemplate", RedisTemplate.class);
			SysUser sys = (SysUser) redisTemplate.opsForValue().get(GOTO_WORK+":"+userId);//根据userid从缓存取上下班状态
			if(sys==null || sys.getStatus() == null){
				sys = new SysUser();
				sys.setId(userId);
				sys.setStatus(1);	//调度上下班状态 1上班，2下班 默认状态为上班
				redisTemplate.opsForValue().set(GOTO_WORK+":"+userId,sys);//根据userid将上下班状态保存到缓存	
			}else{
				status=sys.getStatus();
			}
		}catch(Exception e){
			log.error("获取上下班状态异常"+e);
			e.printStackTrace();
		}
		return status;
	}

	*//**
	 * 根据用户id修改上下班状态
	 * @param userId 用户id
	 * @param status 调度上下班状态 1上班，2下班 默认状态为上班
	 * @return 0修改成功，-1修改失败
	 *//*
	public static Integer updateGotoWork(Long userId,Integer status){

		try{
			RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) SpringContextUtil.getBean("redisTemplate", RedisTemplate.class);
			SysUser sys = (SysUser) redisTemplate.opsForValue().get(GOTO_WORK+":"+userId);//根据userid从缓存取上下班状态
			if(sys!=null){
				sys.setStatus(status);
				redisTemplate.opsForValue().set(GOTO_WORK+":"+userId,sys);//根据userid将上下班状态保存到缓存	
			}else{
				sys = new SysUser();
				sys.setId(userId);
				sys.setStatus(1);	//调度上下班状态 1上班，2下班 默认状态为上班
				redisTemplate.opsForValue().set(GOTO_WORK+":"+userId,sys);//根据userid将上下班状态保存到缓存	
			}
			return 0;
		}catch(Exception e){
			log.error("修改上下班状态异常"+e);
			e.printStackTrace();
		}
		return -1;
	}

	*//**
	 * 
	 * @param user:接收消息的用户对象
	 * @param sendType:1、语音消息(  登录了pc端 则pc端语音+弹框提醒  登录过手机端（账号存在token）则推送到手机端  )  2、文字消息  3、短信消息  4、电话提醒
	 * @param content：消息内容
	 * @param types：业务类型   1、订单列表2、订单详情界面 3、配客列表  4、配客详情界面 5、订单取消详情界面  6消息列表
	 * @param mainid：业务id
	 * @param msgtype：消息类型   消息类型   1、待配客提醒（调度） 2、司机报班提醒（调度） 3、司机发班提醒（调度） 4、司机到达提醒（调度）
	 *   5、司机送达提醒（调度） 6、乘客取消订单提醒（调度）7、司机取消订单提醒（调度）8、调度配客提醒（控收）9、司机取消提醒（控收）  
	 *   10、司机新订单提醒（司机） 11、司机待接客提醒（司机）(作废)12、调度取消订单提醒（司机）13、调度审核取消订单提醒（司机）
	 *   14、乘客下单提醒（乘客）(作废)15、乘客配客提醒（乘客）(作废)16、乘客取消提醒（乘客）(作废)17、app或微信取消订单提醒（乘客）(作废)            
	 * @param role_name:用户角色名称：调度、司机、控收、乘客
	 * @param resend:是否重发，1重发（不写数据库不写缓存），2不重发（首次发送，写数据库，写缓存），3重发（写数据库，不写缓存）
	 * @param lineid:线路id
	 * @param mobile:发给乘客的电话号码
	 * @return
	 *//*
	public static void MsgHandle(SysUser user,MessageLog mlog,Long lineid){
		
		Integer sendtype =mlog.getSendtype();
		String content=mlog.getContent();
		Integer types=mlog.getTypes();
		Long mainid=mlog.getMainid();
		Integer msgtype=mlog.getMsgtype();
		String role_name=mlog.getRole_name();
		String mobile=mlog.getMobile();
		Integer resend=mlog.getResend();
		
		
		Gson gson=new Gson();
		MessageRequest res=new MessageRequest();
			if(Util.isNull(code)||code<1||code>4){
			log.error("code传值错误，取值范围：1新订单待配客，2取消订单，3已配客待接客，4通知");
			return null;
		}
		if(Util.isNull(role_name)){
			log.error("传参错误，role_name不能为空");
			return;
		}
		if(role_name.equals("乘客")){
			if(Util.isNull(mobile)||Util.isNull(content)||Util.isNull(role_name)||Util.isNull(msgtype)){
				log.error("传参错误，发给乘客的消息，mobile、content、msgtype 不能为空");
				return;
			}
		}else{
			if(Util.isNull(types)||Util.isNull(content)||Util.isNull(mainid)||Util.isNull(msgtype)||Util.isNull(sendtype)){
				log.error("传参错误，发给调度司机控收的消息，types、content、mainid、msgtype、sendtype不能为空");
				return;
			}
		}
		//单独处理发给调度消息
		if(!role_name.equals("乘客")){

			if(role_name.equals("调度")){
				//获取调度用户上下班状态（只有调度有上下班状态） status 调度上下班状态 1上班，2下班 默认状态为上班
				Integer status = getGotoWork(user.getId());
				if(status.equals(2)){
					BsMsglogService mls = (BsMsglogService) SpringContextUtil.getBean("BsMsglogService", BsMsglogServiceImpl.class);
					BsLineService ls = (BsLineService) SpringContextUtil.getBean("BsLineService", BsLineServiceImpl.class);
					//如果调度为下班状态，统一发送短信
					//发送方式 1、语音消息(  登录了pc端 则pc端语音+弹框提醒  登录过手机端（账号存在token）则推送到手机端  )  2、文字消息  3、短信消息  4、电话提醒
					//订单线路下的所有调度的主调度
					SysUser mainuser=null;
					try {
						mainuser = ls.getSysUserByLid(lineid);
					} catch (Exception e1) {
						log.error("获取主调度异常");
						e1.printStackTrace();
					}
					String telphone =null;
					if(mainuser!=null){
						telphone=mainuser.getTelphone();
					}
					//调度下班状态直接发送短信，只发送一次，不循环监控，直接返回，不走后面的逻辑
					try {
						mls.send(1,telphone , content);
						log.info("给主调度发送短信成功：telphone="+telphone+"；content="+content);
					} catch (Exception e) {
						log.error("给主调度发送短信异常：telphone="+telphone+"；content="+content);
						e.printStackTrace();
					}
					if(mlog.getResend()!=2){
						return;
					}
				}
			}else{
				//获取调度用户上下班状态（只有调度有上下班状态） status 调度上下班状态 1上班，2下班 默认状态为上班
				Integer status = getGotoWork(user.getId());
				if(status.equals(2)){
					BsMsglogService mls = (BsMsglogService) SpringContextUtil.getBean("BsMsglogService", BsMsglogServiceImpl.class);
					BsLineService ls = (BsLineService) SpringContextUtil.getBean("BsLineService", BsLineServiceImpl.class);
					//如果调度为下班状态，统一发送短信
					//发送方式 1、语音消息(  登录了pc端 则pc端语音+弹框提醒  登录过手机端（账号存在token）则推送到手机端  )  2、文字消息  3、短信消息  4、电话提醒
					
					String telphone =user.getTelphone();
					//司机下班状态直接发送短信，只发送一次，不循环监控，直接返回，不走后面的逻辑
					try {
						mls.send(1,telphone , content);
						log.info("给主司机发送短信成功：telphone="+telphone+"；content="+content);
					} catch (Exception e) {
						log.error("给主司机发送短信异常：telphone="+telphone+"；content="+content);
						e.printStackTrace();
					}
					if(mlog.getResend()!=2){
						return;
					}
				}
			}

			mlog.setRec_id(user.getId());
			mlog.setDispose(1);
			mlog.setSendnum(1);
			mlog.setStatus(1);
			mlog.setMobile(user.getTelphone());
		}else{
			//单独处理发给乘客的消息
			//发给乘客的信息统一发短信
			mlog.setSendtype(3);
		}
		res.setAcceptUser(user);
		res.setMessageLog(mlog);
		//调用开关控制器

		MessageService msgservice = (MessageService) SpringContextUtil.getBean("MessageService", MessageServiceImpl.class);
		try {
			msgservice.sendHander(res);
			log.error("消息引擎开关控制器发送消息成功："+gson.toJson(res));
		} catch (Exception e) {
			log.error("消息引擎开关控制器发送消息异常");
			e.printStackTrace();
		}
	}
	*//**
	 * 根据消息id修改消息的下次发送时间
	 * @param id:消息id
	 * @param time:下次发送时间
	 *//*
	public static void updateMsgListNsendTime(Long id,Timestamp nsend_time){

		RedisTemplate<Object, Object> redisTemplate = (RedisTemplate<Object, Object>) SpringContextUtil.getBean("redisTemplate", RedisTemplate.class);
		List<MessageLog> historyMsg= (List<MessageLog>)redisTemplate.opsForValue().get("loopMsg");

		if(historyMsg!=null&&historyMsg.size()>0){
			for(MessageLog ml:historyMsg){
				
				if(ml.getId()!=null&&ml.getId().equals(id)){
					ml.setNsend_time(nsend_time);
				}
			}	
		}
		redisTemplate.opsForValue().set("loopMsg", historyMsg); 
	}
	*//***
	 * 根据订单id 清楚缓存中对应的消息
	 * @param orderid
	 *//*
	public static void updateMsgCache(Long orderid){
		RedisTemplate<Object, Object> redisTemplate = (RedisTemplate<Object, Object>) SpringContextUtil.getBean("redisTemplate", RedisTemplate.class);
		List<MessageLog> mls= (List<MessageLog>)redisTemplate.opsForValue().get("loopMsg");
		Iterator<MessageLog> iterator = mls.iterator();
		while(iterator.hasNext()){
			MessageLog next = iterator.next();
			if(next.getMainid().equals(orderid));
			iterator.remove();
		}
		redisTemplate.opsForValue().set("loopMsg", mls); 
	}
	
	*//***
	 * 修改订单状态  已读
	 * @param orderid
	 *//*
	public static void updateStatusMsgCache(List<Long> msgids){
		RedisTemplate<Object, Object> redisTemplate = (RedisTemplate<Object, Object>) SpringContextUtil.getBean("redisTemplate", RedisTemplate.class);
		List<MessageLog> mls= (List<MessageLog>)redisTemplate.opsForValue().get("loopMsg");
		Iterator<MessageLog> iterator = mls.iterator();
		//临时保存
		List<MessageLog> temp_mls=new ArrayList<MessageLog>();
		while(iterator.hasNext()){
			MessageLog next = iterator.next();
			if(null!=msgids&&msgids.size()>0){
				for(int i=0;i<msgids.size();i++){
					long id= next.getId();
					long msgid=msgids.get(i);
					if(id==msgid){
						next.setStatus(2);
						temp_mls.add(next);
						iterator.remove();
					}
				}
			}
		}
		if(Util.isNotNull(temp_mls)&&temp_mls.size()>0){
			mls.addAll(temp_mls);
		}
		redisTemplate.opsForValue().set("loopMsg", mls); 
	}
	
	*//**新订单消息未读，短信或电呼汇总消息处理*//*
	public static void addMLogs1(List<MessageLog> mlist,MessageLog mlog){
		if(mlist.size()<1){
			mlist.add(mlog);
		}else{
			boolean flag=false;
			int index=0;
			for(int i=0;i<mlist.size();i++){
				MessageLog tmp=mlist.get(i);
				if(tmp.getMobile().equals(mlog.getMobile())&&tmp.getMsgtype().equals(mlog.getMsgtype())&&tmp.getSendtype().equals(mlog.getSendtype())){
					flag=true;
					index=i;
					break;
				}
			}
			if(flag){
				mlist.get(index).setTmpnum(mlist.get(index).getTmpnum()+mlog.getTmpnum());
			}else{
				mlist.add(mlog);
			}
		}
	}
	*//**
	 * 
	 * @param list调度列表
	 * @return 过滤掉下班的调度，保留主调度或上班的调度
	 *//*
	public static List<SysUser> userFilter(List<SysUser> list){
		if(list==null||list.size()==0) return new ArrayList<>();
		List<SysUser> temp=new ArrayList<>();
		int flag=0;
		for(SysUser li:list){
			Integer status = getGotoWork(li.getId());
			if(status==1||li.getIsmain()==1){
				if(li.getIsmain()==1){
					if(flag>0){
						continue;
					}
					flag++;
				}
				temp.add(li);
			}
		}
		if(temp.size()==0){
			temp.add(list.get(0));
		}
		if(temp.size()>1){
			Iterator<SysUser> it = temp.iterator();
			while (it.hasNext()) {
				SysUser suser = it.next();
				Integer status = getGotoWork(suser.getId());
				if(status==2 && suser.getIsmain()==1){
					it.remove();
				}
			}
		}
		return temp;
	}
	public static void main(String[] args) {
		Integer s=2;
		System.out.println(s==2);
	}
}
*/