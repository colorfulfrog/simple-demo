package com.yxcoach.common.service;

import java.util.Map;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.entity.BsMember;
import com.yxcoach.common.request.BsMemberQueryRequest;

import antlr.collections.List;

/**
 * BsMemberService 注释:会员表Service 创建人: liwei 创建日期:2018-05-09
 */
public interface BsMemberService {
	/**
	 * 查询所有的会员联系电话
	 * @param bsMemberQueryRequest
	 * @return
	 * @throws Exception
	 */
	public java.util.List<BsMember> selectByTelphone(Map<String,Object> map) throws Exception;

	/***
	 * 会员表列表分页
	 * 
	 * @param bsMemberRequest
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(BsMemberQueryRequest bsMemberQueryRequest) throws Exception;

	/***
	 * 查询会员表
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BsMember get(Long id) throws Exception;

	/***
	 * 会员表添加
	 * 
	 * @param bsMember
	 * @return
	 * @throws Exception
	 */
	public boolean add(BsMember bsMember) throws Exception;

	/***
	 * 会员表修改
	 * 
	 * @param bsMember
	 * @return
	 * @throws Exception
	 */
	public boolean update(BsMember bsMember) throws Exception;

	/***
	 * 删除会员表
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Long id) throws Exception;

	/**
	 * 经纪人审核
	 * @param bsMember
	 * @return
	 */
	public boolean updateExamine(BsMember bsMember)throws Exception ;

	/**
	 * 我的VIP
	 * @param bsMemberQueryRequest
	 * @return
	 * @throws Exception 
	 */
	public PageInfo selectMeVip(BsMemberQueryRequest bsMemberQueryRequest) throws Exception;

	
	/**
	 *	车辆导出
	 * @param param
	 * @return
	 */
	public java.util.List<Map<String, Object>> export(BsMember param);

	
	/**
	 * 导出(经纪人)
	 * @return
	 */
	public String exportDataAgent(BsMember bsMember , String path);
	/**
	 * 导出(车主)
	 * @return
	 */
	public String exportDataMember(BsMember bsMember , String path);
}
