package com.yxcoach.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.base.util.PageOption;
import com.yxcoach.common.base.util.PageUtil;
import com.yxcoach.common.base.util.Util;
import com.yxcoach.common.dao.BsCarDAO;
import com.yxcoach.common.entity.BsCar;
import com.yxcoach.common.request.BsCarQueryRequest;
import com.yxcoach.common.service.BsCarService;
/**
 * @ClassName: BsCarServiceImpl
 * @Description: 车辆表 serviceImpl
 * @author liwei
 * @date 2018-05-09
 */
@Transactional(readOnly = true)
@Service("bsCarService")
public class BsCarServiceImpl implements BsCarService{
	private static final Log log = LogFactory.getLog(BsCarServiceImpl.class);
	
	@Resource(name = "bsCarDAO")
	private BsCarDAO bsCarDAO;
		
	/**
	 * 分页查询
	 */
	public PageInfo selectPage(BsCarQueryRequest bsCarQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=bsCarQueryRequest.getPageOption();
		if(bsCarQueryRequest.getPageOption().getRows()==null) bsCarQueryRequest.getPageOption().setRows(20);
		if(bsCarQueryRequest.getPageOption().getPage()==null) bsCarQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsCarQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (bsCarQueryRequest.getPageOption().getPage() - 1) * bsCarQueryRequest.getPageOption().getRows());
		if (Util.isNotNull(bsCarQueryRequest.getCar_number())) {
			map.put("car_number", bsCarQueryRequest.getCar_number());
		}
		if (Util.isNotNull(bsCarQueryRequest.getCar_type())) {
			map.put("type", bsCarQueryRequest.getCar_type());
		}
		if (Util.isNotNull(bsCarQueryRequest.getOwner_name())) {
			map.put("owner_name", bsCarQueryRequest.getOwner_name());
		}
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.bsCarDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(bsCarQueryRequest.getPageOption().getRows(), bsCarQueryRequest.getPageOption().getPage(), count, new ArrayList<BsCar>());
		}
		List<BsCar> list = this.bsCarDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(bsCarQueryRequest.getPageOption().getRows(), bsCarQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 查询一条记录
	 */
	public BsCar get(Long id) throws Exception {
		return bsCarDAO.getById(id);
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(BsCar bsCar) throws Exception {
		Integer car_category = bsCar.getCar_category();
		Integer type = 0;
		if(car_category == 1){ //1载货
			Float weight = bsCar.getWeight();
			if(weight <= 3.5){
				type = 1;
			}else if(weight > 3.5 && weight <= 6){
				type = 2;
			}else if(weight > 6){
				type = 3;
			}
		}else if(car_category == 2){ //2载客
			Integer seat_num = bsCar.getSeat_num();
			if(seat_num != null){
				if(seat_num <= 5){ //小型车：小于5座
					type = 1;
				}else if(seat_num > 5 && seat_num <= 19){ //中型车：6-19
					type = 2;
				}else if(seat_num > 19){ //大型车：小于19座
					type = 3;
				}
			}
		}
		bsCar.setType(type);
		Integer result = bsCarDAO.add(bsCar);
		return result>0?true:false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(BsCar bsCar) throws Exception {
		Integer car_category = bsCar.getCar_category();
		Integer type = 0;
		if(car_category == 1){ //1载货
			Float weight = bsCar.getWeight();
			if(weight <= 3.5){
				type = 1;
			}else if(weight > 3.5 && weight <= 6){
				type = 2;
			}else if(weight > 6){
				type = 3;
			}
		}else if(car_category == 2){ //2载客
			Integer seat_num = bsCar.getSeat_num();
			if(seat_num != null){
				if(seat_num <= 5){ //小型车：小于5座
					type = 1;
				}else if(seat_num > 5 && seat_num <= 19){ //中型车：6-19
					type = 2;
				}else if(seat_num > 19){ //大型车：小于19座
					type = 3;
				}
			}
		}
		bsCar.setType(type);
		Integer result = bsCarDAO.update(bsCar);
		return result>0?true:false;
	}
	
	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) throws Exception {
		Integer result = bsCarDAO.deleteById(id);
		return result>0?true:false;
	}

	@Override
	public List<BsCar> getAllCarsByOwner(Long memberID) throws Exception {
		BsCar bsCar = new BsCar();
		bsCar.setOwner(memberID);
		return bsCarDAO.getCarsByCon(bsCar);
	}

	/**
	 * 查询当天+ days 要发短信的车辆(需要通知检测的会员用户车辆)
	 */
	@Override
	public List<BsCar> selectBsCarCheckDate(Map<String, Object>map) {
		return bsCarDAO.selectBsCarCheckDate(map);
	}

	/**
	 * 我的车辆
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@Override
	public PageInfo selectMeCar(BsCarQueryRequest bsCarQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=bsCarQueryRequest.getPageOption();
		if(bsCarQueryRequest.getPageOption().getRows()==null) bsCarQueryRequest.getPageOption().setRows(20);
		if(bsCarQueryRequest.getPageOption().getPage()==null) bsCarQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsCarQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (bsCarQueryRequest.getPageOption().getPage() - 1) * bsCarQueryRequest.getPageOption().getRows());
		map.put("id", bsCarQueryRequest.getId());
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.bsCarDAO.selectMeCarCount(map);
		if (count == 0) {
			return new PageInfo(bsCarQueryRequest.getPageOption().getRows(), bsCarQueryRequest.getPageOption().getPage(), count, new ArrayList<BsCar>());
		}
		List<BsCar> list = this.bsCarDAO.selectMeCar(map);
		PageInfo pageInfo = new PageInfo(bsCarQueryRequest.getPageOption().getRows(), bsCarQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	@Override
	public List<BsCar> export(BsCar bsCar) throws Exception {
		return bsCarDAO.getCarsByCon(bsCar);
	}
}