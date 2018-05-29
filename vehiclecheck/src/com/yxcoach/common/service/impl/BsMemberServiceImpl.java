package com.yxcoach.common.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import com.yxcoach.common.base.util.DateUtil;
import com.yxcoach.common.base.util.PageOption;
import com.yxcoach.common.base.util.PageUtil;
import com.yxcoach.common.base.util.Util;
import com.yxcoach.common.base.util.excel.ExcelWrite;
import com.yxcoach.common.base.util.excel.ReadData;
import com.yxcoach.common.dao.BsCouponDAO;
import com.yxcoach.common.dao.BsMemberDAO;
import com.yxcoach.common.entity.BsCar;
import com.yxcoach.common.entity.BsCoupon;
import com.yxcoach.common.entity.BsMember;
import com.yxcoach.common.service.BsMemberService;
import com.yxcoach.common.request.BsMemberQueryRequest;

/**
 * @ClassName: BsMemberServiceImpl
 * @Description: 会员表 serviceImpl
 * @author liwei
 * @date 2018-05-09
 */
@Transactional(readOnly = true)
@Service("bsMemberService")
public class BsMemberServiceImpl implements BsMemberService {
	private static final Log log = LogFactory.getLog(BsMemberServiceImpl.class);

	@Resource(name = "bsMemberDAO")
	private BsMemberDAO bsMemberDAO;

	@Resource(name = "bsCouponDAO")
	private BsCouponDAO bsCouponDAO;

	/**
	 * 查询所有的会员联系电话
	 */
	@Override
	public List<BsMember> selectByTelphone(Map<String, Object> map) throws Exception {
		return this.bsMemberDAO.selectByTelphone(map);
	}

	/**
	 * 分页查询
	 */
	public PageInfo selectPage(BsMemberQueryRequest bsMemberQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption = bsMemberQueryRequest.getPageOption();
		if (bsMemberQueryRequest.getPageOption().getRows() == null)
			bsMemberQueryRequest.getPageOption().setRows(20);
		if (bsMemberQueryRequest.getPageOption().getPage() == null)
			bsMemberQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsMemberQueryRequest.getPageOption().getRows());
		map.put("BEGIN",
				(bsMemberQueryRequest.getPageOption().getPage() - 1) * bsMemberQueryRequest.getPageOption().getRows());

		if (Util.isNotNull(bsMemberQueryRequest.getTypex())) //
			map.put("typex", bsMemberQueryRequest.getTypex());
		if (Util.isNotNull(bsMemberQueryRequest.getTelphone()))//
			map.put("telphone", bsMemberQueryRequest.getTelphone());
		if (Util.isNotNull(bsMemberQueryRequest.getReal_name())) //
			map.put("real_name", bsMemberQueryRequest.getReal_name());
		if (Util.isNotNull(bsMemberQueryRequest.getNickname())) //
			map.put("nickname", bsMemberQueryRequest.getNickname());
		if (Util.isNotNull(bsMemberQueryRequest.getStatus())) //
			map.put("status", bsMemberQueryRequest.getStatus());
		if (Util.isNotNull(bsMemberQueryRequest.getAudit_user())) //
			map.put("audit_user", bsMemberQueryRequest.getAudit_user());
		if (Util.isNotNull(bsMemberQueryRequest.getSource())) //
			map.put("source", bsMemberQueryRequest.getSource());

		PageUtil.orderParam(pageOption, map);
		// 自定义其他条件
		Integer count = this.bsMemberDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(bsMemberQueryRequest.getPageOption().getRows(),
					bsMemberQueryRequest.getPageOption().getPage(), count, new ArrayList<BsMember>());
		}
		List<BsMember> list = this.bsMemberDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(bsMemberQueryRequest.getPageOption().getRows(),
				bsMemberQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 查询一条记录
	 */
	public BsMember get(Long id) throws Exception {
		return bsMemberDAO.getById(id);
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(BsMember bsMember) throws Exception {
		Integer result = bsMemberDAO.add(bsMember);
		return result > 0 ? true : false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(BsMember bsMember) throws Exception {
		Integer result = 0;
		bsMemberDAO.update(bsMember);
		if (Util.isNotNull(bsMember.getCoupon_type_id())) {
			// 查询当前Coupon_type_id 未领取的优惠券
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("coupon_type_id", bsMember.getCoupon_type_id());
			List<BsCoupon> bc = bsCouponDAO.selectCouponStatusUnreceived(map);
			if (bc != null && bc.size() > 0) {
				// 更新一条优惠券状态为未使用 发给当前车主
				BsCoupon bsCoupon = new BsCoupon();
				bsCoupon.setId(bc.get(0).getId());
				bsCoupon.setStatus(5L);// 未使用
				bsCoupon.setReceive_date(Timestamp.valueOf(DateUtil.getCurDateyyyMMddHHmmss()));// 领取时间
				bsCoupon.setMember_id(bsMember.getId());
				result = bsCouponDAO.updateStatus(bsCoupon);
			}
		}
		return result > 0 ? true : false;
	}

	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) throws Exception {
		Integer result = bsMemberDAO.deleteById(id);
		return result > 0 ? true : false;
	}

	/**
	 * 经纪人审核
	 */
	@Override
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean updateExamine(BsMember bsMember) throws Exception {
		Integer result = bsMemberDAO.updateExamine(bsMember);
		return result > 0 ? true : false;
	}

	/**
	 * 我的VIP
	 * 
	 * @param wechat_id
	 * @return
	 */
	@Override
	public PageInfo selectMeVip(BsMemberQueryRequest bsMemberQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption = bsMemberQueryRequest.getPageOption();
		if (bsMemberQueryRequest.getPageOption().getRows() == null)
			bsMemberQueryRequest.getPageOption().setRows(20);
		if (bsMemberQueryRequest.getPageOption().getPage() == null)
			bsMemberQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsMemberQueryRequest.getPageOption().getRows());
		map.put("BEGIN",
				(bsMemberQueryRequest.getPageOption().getPage() - 1) * bsMemberQueryRequest.getPageOption().getRows());
		map.put("wechat_id", bsMemberQueryRequest.getWechat_id());
		PageUtil.orderParam(pageOption, map);
		// 自定义其他条件
		Integer count = this.bsMemberDAO.selectMeVipCount(map);
		if (count == 0) {
			return new PageInfo(bsMemberQueryRequest.getPageOption().getRows(),
					bsMemberQueryRequest.getPageOption().getPage(), count, new ArrayList<BsCar>());
		}
		List<BsMember> list = this.bsMemberDAO.selectMeVip(map);
		PageInfo pageInfo = new PageInfo(bsMemberQueryRequest.getPageOption().getRows(),
				bsMemberQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	@Override
	public List<Map<String, Object>> export(BsMember bsMember) {
		return bsMemberDAO.getMembersByCon(bsMember);
	}

	/**
	 * 导出
	 * 
	 * @return
	 */
	public String exportDataAgent(BsMember bsMember, String path) {
		List<Map<String, Object>> list = bsMemberDAO.getMembersByCon(bsMember);
		Iterator<Map<String, Object>> iterator = list.iterator();
		List<String> headers = new ArrayList<String>();
		headers.add("用户名");
		headers.add("真实姓名");
		headers.add("身份证号");
		headers.add("审核状态");
		headers.add("认证时间");
		headers.add("审核人");
		ExcelWrite write = new ExcelWrite("经纪人导出", path, headers);
		ReadData data = new ReadData();
		while (iterator.hasNext()) {
			BsMember bs = (BsMember) iterator.next();
			Map<String, String> ss = new HashMap<String, String>();

			ss.put("用户名", bs.getNickname() != null ? bs.getNickname() : "");
			ss.put("真实姓名", bs.getReal_name() != null ? bs.getReal_name() : "");
			ss.put("身份证号",
					bs.getPin() != null ? bs.getPin().replaceAll("(\\w{2})(\\w+)(\\w{2})", "$1************$3") : "");
			String status = (String) (bs.getStatus() != null ? bs.getStatus().toString() : "");
			String sType = "未知状态";
			if (status != null) {
				if ("1".equals(status)) { // 1：
					sType = "待审核";
				} else if ("2".equals(status)) { // 3：
					sType = "认证通过";
				} else if ("3".equals(status)) { // 3：
					sType = "认证失败";
				}
			}
			ss.put("审核状态", sType);
			ss.put("认证时间", bs.getIdentify_date() != null
					? bs.getIdentify_date().toString().substring(0, bs.getIdentify_date().toString().length() - 2)
					: "");
			ss.put("审核人", bs.getUser_name() != null ? bs.getUser_name().toString() : "");
			data.setData(ss);
			write.writeRow(data);
		}
		write.close();
		return path;
	}

	@Override
	public String exportDataMember(BsMember bsMember, String path) {
		List<Map<String, Object>> list = bsMemberDAO.getMembersByCon(bsMember);
		Iterator<Map<String, Object>> iterator = list.iterator();
		List<String> headers = new ArrayList<String>();
		headers.add("用户名");
		headers.add("联系电话");
		headers.add("用户类型");
		headers.add("二维码");
		headers.add("邀请人数");
		headers.add("来源");
		headers.add("注册时间");

		ExcelWrite write = new ExcelWrite("车主导出", path, headers);
		ReadData data = new ReadData();
		while (iterator.hasNext()) {
			BsMember bs = (BsMember) iterator.next();
			Map<String, String> ss = new HashMap<String, String>();

			ss.put("用户名", bs.getNickname() != null ? bs.getNickname() : "");
			ss.put("联系电话", bs.getTelphone() != null ? bs.getTelphone() : "");
			String type = (String) (bs.getType() != null ? bs.getType().toString() : "");
			String sType = "未知用户类型";
			if ("1".equals(type)) { // 1：车主
				sType = "车主";
			} else if ("3".equals(type)) { // 3：经纪人
				sType = "经纪人";
			}
			ss.put("用户类型", sType);

			ss.put("二维码", bs.getQrcode_url() != null ? bs.getQrcode_url() : "");
			ss.put("邀请人数", bs.getInvite_num() != null ? bs.getInvite_num().toString() : "0");
			// 注册来源 1：平台 2：经纪人 3：上门客户
			String source = bs.getSource() != null ? bs.getSource().toString() : "";
			if ("1".equals(source)) { // 1：车主
				sType = "平台";
			} else if ("2".equals(source)) { // 2：经纪人
				sType = "经纪人";
			} else if ("3".equals(source)) { // 3：上门客户
				sType = "上门客户";
			}
			ss.put("来源", sType);
			ss.put("注册时间",  bs.getGmt_create() != null
					? bs.getGmt_create().toString().substring(0, bs.getGmt_create().toString().length() - 2)
					: "");
			data.setData(ss);
			write.writeRow(data);
		}
		write.close();
		return path;
	}
}
