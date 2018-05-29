package com.yxcoach.common.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.base.exception.YxBizException;
import com.yxcoach.common.base.util.DateUtil;
import com.yxcoach.common.base.util.PageOption;
import com.yxcoach.common.base.util.PageUtil;
import com.yxcoach.common.base.util.RandomUtil;
import com.yxcoach.common.base.util.Util;
import com.yxcoach.common.dao.BsCarDAO;
import com.yxcoach.common.dao.BsCheckStationDAO;
import com.yxcoach.common.dao.BsOrderDAO;
import com.yxcoach.common.dao.SysConfigDAO;
import com.yxcoach.common.dao.SysDiscountDAO;
import com.yxcoach.common.dao.SysPriceDAO;
import com.yxcoach.common.entity.BsCar;
import com.yxcoach.common.entity.BsCheckStation;
import com.yxcoach.common.entity.BsOrder;
import com.yxcoach.common.entity.SysConfig;
import com.yxcoach.common.entity.SysDiscount;
import com.yxcoach.common.entity.SysPrice;
import com.yxcoach.common.request.BsOrderQueryRequest;
import com.yxcoach.common.service.BsOrderService;
/**
 * @ClassName: BsOrderServiceImpl
 * @Description: 订单表 serviceImpl
 * @author liwei
 * @date 2018-05-10
 */
@Transactional(readOnly = true)
@Service("bsOrderService")
public class BsOrderServiceImpl implements BsOrderService{
	private static final Log log = LogFactory.getLog(BsOrderServiceImpl.class);
	
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	
	@Resource(name = "bsOrderDAO")
	private BsOrderDAO bsOrderDAO;
	
	@Resource(name = "bsCarDAO")
	private BsCarDAO bsCarDAO;
	
	@Resource(name = "sysPriceDAO")
	private SysPriceDAO sysPriceDAO;
	
	@Resource(name = "bsCheckStationDAO")
	private BsCheckStationDAO bsCheckStationDAO;
	@Resource(name = "sysDiscountDAO")
	private SysDiscountDAO sysDiscountDAO;
	@Resource(name = "sysConfigDAO")
	private SysConfigDAO sysConfigDAO;
		
	/**
	 *  分页
	 */
	public PageInfo selectPage(BsOrderQueryRequest bsOrderQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=bsOrderQueryRequest.getPageOption();
		if(bsOrderQueryRequest.getPageOption().getRows()==null) bsOrderQueryRequest.getPageOption().setRows(20);
		if(bsOrderQueryRequest.getPageOption().getPage()==null) bsOrderQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsOrderQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (bsOrderQueryRequest.getPageOption().getPage() - 1) * bsOrderQueryRequest.getPageOption().getRows());
		
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.bsOrderDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(bsOrderQueryRequest.getPageOption().getRows(), bsOrderQueryRequest.getPageOption().getPage(), count, new ArrayList<BsOrder>());
		}
		List<BsOrder> list = this.bsOrderDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(bsOrderQueryRequest.getPageOption().getRows(), bsOrderQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}
	
	
	/**
	 *  财务流水 分页
	 */
	@Override
	public PageInfo accountflowPage(BsOrderQueryRequest bsOrderQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=bsOrderQueryRequest.getPageOption();
		if(bsOrderQueryRequest.getPageOption().getRows()==null) bsOrderQueryRequest.getPageOption().setRows(20);
		if(bsOrderQueryRequest.getPageOption().getPage()==null) bsOrderQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsOrderQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (bsOrderQueryRequest.getPageOption().getPage() - 1) * bsOrderQueryRequest.getPageOption().getRows());
		
		if(Util.isNotNull(bsOrderQueryRequest.getOrder_no())){
			map.put("order_no", bsOrderQueryRequest.getOrder_no());
		}
		if(Util.isNotNull(bsOrderQueryRequest.getQuery_status())){
			map.put("query_status", bsOrderQueryRequest.getQuery_status());
		}
		if(Util.isNotNull(bsOrderQueryRequest.getStartDate())){
			map.put("startDate", bsOrderQueryRequest.getStartDate());
		}	
		if(Util.isNotNull(bsOrderQueryRequest.getEndDate())){
			map.put("endDate", bsOrderQueryRequest.getEndDate());
		}
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.bsOrderDAO.selectflowPageCount(map);
		if (count == 0) {
			return new PageInfo(bsOrderQueryRequest.getPageOption().getRows(), bsOrderQueryRequest.getPageOption().getPage(), count, new ArrayList<BsOrder>());
		}
		List<BsOrder> list = this.bsOrderDAO.selectflowPage(map);
		PageInfo pageInfo = new PageInfo(bsOrderQueryRequest.getPageOption().getRows(), bsOrderQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}
	
	
	/**
	 *  退款单 分页
	 */
	@Override
	public PageInfo refundPage(BsOrderQueryRequest bsOrderQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=bsOrderQueryRequest.getPageOption();
		if(bsOrderQueryRequest.getPageOption().getRows()==null) bsOrderQueryRequest.getPageOption().setRows(20);
		if(bsOrderQueryRequest.getPageOption().getPage()==null) bsOrderQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsOrderQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (bsOrderQueryRequest.getPageOption().getPage() - 1) * bsOrderQueryRequest.getPageOption().getRows());
		
		if(Util.isNotNull(bsOrderQueryRequest.getOrder_no())){
			map.put("order_no", bsOrderQueryRequest.getOrder_no());
		}
		if(Util.isNotNull(bsOrderQueryRequest.getRefund_status())){
			map.put("refund_status", bsOrderQueryRequest.getRefund_status());
		}
		if(Util.isNotNull(bsOrderQueryRequest.getRefund_type())){
			map.put("refund_type", bsOrderQueryRequest.getRefund_type());
		}
		if(Util.isNotNull(bsOrderQueryRequest.getGmt_user())){
			map.put("gmt_user", bsOrderQueryRequest.getGmt_user());
		}
		if(Util.isNotNull(bsOrderQueryRequest.getStartDate())){
			map.put("startDate", bsOrderQueryRequest.getStartDate());
		}	
		if(Util.isNotNull(bsOrderQueryRequest.getEndDate())){
			map.put("endDate", bsOrderQueryRequest.getEndDate());
		}
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.bsOrderDAO.selectRefundPageCount(map);
		if (count == 0) {
			return new PageInfo(bsOrderQueryRequest.getPageOption().getRows(), bsOrderQueryRequest.getPageOption().getPage(), count, new ArrayList<BsOrder>());
		}
		List<BsOrder> list = this.bsOrderDAO.selectRefundPage(map);
		
		PageInfo pageInfo = new PageInfo(bsOrderQueryRequest.getPageOption().getRows(), bsOrderQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 查询一条记录
	 */
	public BsOrder get(Long id) throws Exception {
		return bsOrderDAO.getById(id);
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public BsOrder add(BsOrder bsOrder) throws Exception {
		String genOrderSerial = RandomUtil.genOrderSerial(bsOrder.getMember_id());
		bsOrder.setOrder_no(genOrderSerial); //订单编号
		bsOrder.setStatus(1); //1待支付
		bsOrder.setService_type(1); //1车检
		Integer result = bsOrderDAO.add(bsOrder);
		return result>0?bsOrder:null;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(BsOrder bsOrder) throws Exception {
		Integer result = bsOrderDAO.update(bsOrder);
		return result>0?true:false;
	}
	
	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) throws Exception {
		Integer result = bsOrderDAO.deleteById(id);
		return result>0?true:false;
	}

	@Override
	public Map<String,Object> budget(Long car_id,Timestamp order_date,boolean isDiscount) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		Float total_fee = 0f;
		Float after_discount_fee = 0f;
		Float discount_fee = 0f;
		BsCar car = bsCarDAO.getById(car_id);
		Timestamp regist_date = car.getRegist_date();
		Integer seat_num = car.getSeat_num();
		Float weight = car.getWeight();
		Integer car_category = car.getCar_category(); //车辆性质 1载货 2载客
		Integer type = car.getType(); //车型 1小 2中 3大
		
		int car_year = DateUtil.getDiffYear(regist_date) <= 0 ? 1 : DateUtil.getDiffYear(regist_date); //获得车辆年限
		Integer seat_flag = 0; //座位数标识
		if(seat_num != null){
			if(seat_num <= 5){ //小于5座
				seat_flag = 1;
			}else if(seat_num > 5 && seat_num <= 19){ //6-19
				seat_flag = 2;
			}else if(seat_num > 19){ //大于19座
				seat_flag = 3;
			}
		}
		Integer weight_flag = 0;
		if(weight <= 3.5){
			weight_flag = 1;
		}else if(weight > 3.5 && weight <= 6){
			weight_flag = 2;
		}else if(weight > 6){
			weight_flag = 3;
		}
		
		SysPrice sysPrice = new SysPrice();
		sysPrice.setCar_type(type);
		sysPrice.setCar_year(car_year);
		sysPrice.setCar_category(car_category);
		sysPrice.setSeat_num(seat_flag);
		sysPrice.setWeight(weight_flag);
		sysPrice.setIs_need_appraise(car.getIs_need_appraise()); //是否需要等级评定
		SysPrice price = sysPriceDAO.getByCon(sysPrice);
		if(price != null){
			Float level_price = price.getLevel_price(); //等级评定费用
			Float all_round_price = price.getAll_round_price(); //环检费用
			Float check_price = price.getCheck_price(); //安检费用
			total_fee = level_price + all_round_price + check_price;
			if (isDiscount){
				List<SysDiscount> allDiscounts = sysDiscountDAO.getAllDiscounts();
				Float discount = 10f; //默认不打折
				for (SysDiscount sysDiscount : allDiscounts) {
					int diff = DateUtil.differentDaysByMillisecond(new Date(),order_date);
					if(diff >= sysDiscount.getPre_order_days()){
						discount = sysDiscount.getDiscount();
						break;
					}
				}
				after_discount_fee = Util.round(total_fee * (discount / 10), 2); //折后费用
				discount_fee = total_fee - after_discount_fee;
			}
		}else{
			log.error("预算费用失败-获取定价规则为空");
			throw new YxBizException("预算费用失败-获取定价规则为空");
		}
		map.put("total_fee", isDiscount ? after_discount_fee : total_fee); //总费用
		map.put("discount_fee", discount_fee); //折扣金额
		map.put("sys_price", price); //定价规则
		return map;
	}


	@Override
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public JSONObject payOffline(Long order_id) throws Exception {
		BsOrder bsOrder = new BsOrder();
		bsOrder.setId(order_id);
		bsOrder.setPay_type(2); //支付类型 1在线支付 2线下窗口支付
		update(bsOrder);
		
		BsOrder order = get(order_id);
		BsCar bsCar = bsCarDAO.getById(order.getCar_id());
		BsCheckStation bsCheckStation = bsCheckStationDAO.getById(order.getStation_id());
		JSONObject result = new JSONObject();
		result.put("order_id", order.getId());
		result.put("car_number", bsCar.getCar_number());
		result.put("station_name", bsCheckStation.getStation_name());
		result.put("station_address", bsCheckStation.getStation_address());
		result.put("telephone", bsCheckStation.getTelephone());
		return result;
	}


	@Override
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean cancel(Long order_id) throws Exception {
		BsOrder bsOrder = get(order_id);
		Integer status = bsOrder.getStatus();
		if(status == null || status != 1){ // status=1 待支付
			throw new YxBizException("只有预约成功且未支付的订单才能取消.");
		}
		
		BsOrder order = new BsOrder();
		order.setId(order_id);
		order.setStatus(9); // 9 取消
		return update(order);
	}


	@Override
	public JSONObject detail(Long order_id) throws Exception {
		BsOrder order = get(order_id);
		BsCar bsCar = bsCarDAO.getById(order.getCar_id());
		BsCheckStation bsCheckStation = bsCheckStationDAO.getById(order.getStation_id());
		JSONObject result = new JSONObject();
		JSONObject orderObj = new JSONObject();
		orderObj.put("order_id", order.getId());
		orderObj.put("order_status", order.getStatus());
		orderObj.put("order_no", order.getOrder_no());
		orderObj.put("car_number", bsCar.getCar_number());
		orderObj.put("frame_num", bsCar.getFrame_num()); //车架号
		orderObj.put("seat_num", bsCar.getSeat_num());
		orderObj.put("telephone", order.getTelephone());
		orderObj.put("order_date", order.getOrder_date());
		orderObj.put("total_fee", order.getTotal_fee());
		orderObj.put("check_result_img", order.getCheck_result_img());
		orderObj.put("coupon_fee", order.getCoupon_fee()); //优惠金额
		orderObj.put("status", order.getStatus()); //状态
		
		JSONObject stationObj = new JSONObject();
		stationObj.put("station_name", bsCheckStation.getStation_name());
		stationObj.put("station_address", bsCheckStation.getStation_address());
		stationObj.put("telephone", bsCheckStation.getTelephone());
		
		result.put("order", orderObj); //订单信息
		result.put("station", stationObj); //检测站信息
		return result;
	}

	@Override
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean applyRefund(Long order_id, Integer refund_type) throws Exception {
		boolean result = false;
		//只有待检测的订单能退款
		BsOrder bsOrder = get(order_id);
		//订单状态 1待支付2待检测 3检测中 4已完成 5退款待审核 6待退款（退款审核通过）7退款审核不通过 8已退款 9关闭 
		Integer status = bsOrder.getStatus();
		if(status == 1){
			throw new YxBizException("您并未支付该订单款项，无需申请退款");
		}else if(status == 2){
			List<SysConfig> configList = sysConfigDAO.all();
			if(configList != null && configList.size() == 1){
				SysConfig sysConfig = configList.get(0);
				Float refund_fee_percent = sysConfig.getRefund_fee(); //退款手续费率
				Float refund_fee = (bsOrder.getTotal_fee().floatValue() * (100-refund_fee_percent)) / 100;
				BsOrder order = new BsOrder();
				order.setId(order_id);
				order.setStatus(5); //设置为退款待审核
				order.setRefund_type(refund_type);
				order.setRefund_fee(new BigDecimal(Util.round(refund_fee, 2).doubleValue())); //设置退款费用
				result = update(order);
			}else{
				throw new YxBizException("获取配置参数失败");
			}
		}else{
			log.info("applyRefund-订单当前状态：" + status);
			throw new YxBizException("您的车辆已经在检测中或已经检测完成，不能申请退款");
		}
		return result;
	}


	@Override
	public PageInfo selectBackstagePage(BsOrderQueryRequest bsOrderQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=bsOrderQueryRequest.getPageOption();
		if(bsOrderQueryRequest.getPageOption().getRows()==null) bsOrderQueryRequest.getPageOption().setRows(20);
		if(bsOrderQueryRequest.getPageOption().getPage()==null) bsOrderQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsOrderQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (bsOrderQueryRequest.getPageOption().getPage() - 1) * bsOrderQueryRequest.getPageOption().getRows());
		
		
		//分页条件
		//订单编号
		//联系电话
		//车牌号
		//预约时间
		//检测站
		//订单状态
		if (Util.isNotNull(bsOrderQueryRequest.getOrder_no())) //
			map.put("order_no", bsOrderQueryRequest.getOrder_no());
		if (Util.isNotNull(bsOrderQueryRequest.getTelephone())) //
			map.put("telephone", bsOrderQueryRequest.getTelephone());
		if (Util.isNotNull(bsOrderQueryRequest.getCar_number())) //
			map.put("car_number", bsOrderQueryRequest.getCar_number());
		if (Util.isNotNull(bsOrderQueryRequest.getOrder_start_date())) //
			map.put("order_start_date", bsOrderQueryRequest.getOrder_start_date());
		if (Util.isNotNull(bsOrderQueryRequest.getOrder_end_date())) //
			map.put("order_end_date", bsOrderQueryRequest.getOrder_end_date());
		if (Util.isNotNull(bsOrderQueryRequest.getStation_id())) //
			map.put("station_id", bsOrderQueryRequest.getStation_id());
		if (Util.isNotNull(bsOrderQueryRequest.getStation_name())) //
			map.put("station_name", bsOrderQueryRequest.getStation_name());
		if (Util.isNotNull(bsOrderQueryRequest.getStatus())) //
			map.put("status", bsOrderQueryRequest.getStatus());
		
		
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.bsOrderDAO.selectBackstagePageCount(map);
		if (count == 0) {
			return new PageInfo(bsOrderQueryRequest.getPageOption().getRows(), bsOrderQueryRequest.getPageOption().getPage(), count, new ArrayList<BsOrder>());
		}
		List<BsOrder> list = this.bsOrderDAO.selectBackstagePage(map);
		PageInfo pageInfo = new PageInfo(bsOrderQueryRequest.getPageOption().getRows(), bsOrderQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 订单查询后台 修改 /取消 / 上传检测结果  /开始检测 / 确认收款
	 */
	@Override
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean updateOperation(BsOrder bsOrder) throws Exception {
		return  bsOrderDAO.updateOperation(bsOrder)>0?true:false;
	}
}
