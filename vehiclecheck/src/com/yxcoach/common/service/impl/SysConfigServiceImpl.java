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
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.dao.SysConfigDAO;
import com.yxcoach.common.entity.SysConfig;
import com.yxcoach.common.service.SysConfigService;
import com.yxcoach.common.request.SysConfigQueryRequest;
/**
 * @ClassName: SysConfigServiceImpl
 * @Description: 参数配置表 serviceImpl
 * @author liwei
 * @date 2018-05-09
 */
@Transactional(readOnly = true)
@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService{
	private static final Log log = LogFactory.getLog(SysConfigServiceImpl.class);
	
	@Resource(name = "sysConfigDAO")
	private SysConfigDAO sysConfigDAO;
		
	/**
	 * 分页查询
	 */
	public PageInfo selectPage(SysConfigQueryRequest sysConfigQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=sysConfigQueryRequest.getPageOption();
		if(sysConfigQueryRequest.getPageOption().getRows()==null) sysConfigQueryRequest.getPageOption().setRows(20);
		if(sysConfigQueryRequest.getPageOption().getPage()==null) sysConfigQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", sysConfigQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (sysConfigQueryRequest.getPageOption().getPage() - 1) * sysConfigQueryRequest.getPageOption().getRows());
		
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.sysConfigDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(sysConfigQueryRequest.getPageOption().getRows(), sysConfigQueryRequest.getPageOption().getPage(), count, new ArrayList<SysConfig>());
		}
		List<SysConfig> list = this.sysConfigDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(sysConfigQueryRequest.getPageOption().getRows(), sysConfigQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 统计总条数
	 * @return
	 * @throws Exception
	 */
	public int countSum() throws Exception{
		return this.sysConfigDAO.selectPageCount(null);
	}
	/**
	 * 查询一条记录
	 */
	public SysConfig get(Long id) throws Exception {
		return sysConfigDAO.getById(id);
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(SysConfig sysConfig) throws Exception {
		Integer result = sysConfigDAO.add(sysConfig);
		return result>0?true:false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(SysConfig sysConfig) throws Exception {
		Integer result = sysConfigDAO.update(sysConfig);
		return result>0?true:false;
	}
	
	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) throws Exception {
		Integer result = sysConfigDAO.deleteById(id);
		return result>0?true:false;
	}
}
