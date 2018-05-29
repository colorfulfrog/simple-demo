package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;
import com.yxcoach.common.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.yxcoach.common.entity.BsMember;

/**
 *	
 *  bs_memberDao
 *  注释:会员表
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@MyBatisDao
@Component("bsMemberDAO")
public interface BsMemberDAO{
	
	/**
	 * 获取会员表信息
	 */
	public List<BsMember> selectByTelphone(Map<String, Object> map);
	/**
	 * 获取会员表分页数据
	 */
	public List<BsMember> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取会员表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询会员表
	 */
	public BsMember getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改会员表
	 */
	public Integer update(BsMember bsMember) throws Exception;
	/**
	 * 添加会员表
	 */
	public Integer add(BsMember bsMember)throws Exception;
	/**
	 * 根据ID删除会员表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	/**
	 * 根据条件查询会员表
	 */
	public BsMember getByCon(BsMember bsMember) throws Exception;
	/**
	 * 经纪人审核
	 */
	public Integer updateExamine(BsMember bsMember);
	/**
	 * 我的VIP
	 * @param map
	 * @return
	 */
	public List<BsMember> selectMeVip(Map<String, Object> map);
	public Integer selectMeVipCount(Map<String,Object> map) throws Exception;
	
	/**
	 * 车辆导出
	 * @param bsMember
	 * @return
	 */
	public List<Map<String, Object>> getMembersByCon(BsMember bsMember);

}