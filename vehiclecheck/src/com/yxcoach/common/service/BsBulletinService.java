package com.yxcoach.common.service;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.entity.BsBulletin;
import com.yxcoach.common.request.BsBulletinQueryRequest;
/**
 *  BsBulletinService
 *  注释:车检动态表Service
 *  创建人: liwei
 *  创建日期:2018-05-11
 */
public interface BsBulletinService {
	
	/***
	 * 车检动态表列表分页
	 * @param bsBulletinRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(BsBulletinQueryRequest bsBulletinQueryRequest) throws Exception;
	
	/***
	 * 查询车检动态表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public BsBulletin get(Long id) throws Exception;
    
    /***
     * 车检动态表添加
     * @param bsBulletin
     * @return
     * @throws Exception
     */
    public boolean add(BsBulletin bsBulletin) throws Exception;
    
    /***
     * 车检动态表修改
     * @param bsBulletin
     * @return
     * @throws Exception
     */
    public boolean update(BsBulletin bsBulletin) throws Exception;
	/***
	 * 删除车检动态表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public boolean delete(Long id) throws Exception;

}
