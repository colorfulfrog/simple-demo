package com.yxcoach.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.base.util.PageOption;
import com.yxcoach.common.base.util.PageUtil;
import com.yxcoach.common.base.util.Util;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.dao.SysRoleDAO;
import com.yxcoach.common.entity.SysRole;
import com.yxcoach.common.service.SysRoleService;
import com.yxcoach.common.request.SysRoleRequest;
import com.yxcoach.common.request.SysRoleQueryRequest;
/**
 * @ClassName: SysRoleServiceImpl
 * @Description: 角色表 serviceImpl
 * @author yangzhipeng
 * @date 2018-03-24
 */
@Transactional(readOnly = true)
@Service("SysRoleServiceImpl")
public class SysRoleServiceImpl implements SysRoleService{

	@Resource(name = "SysRoleDAO")
	private SysRoleDAO sysRoleDAO;
		
	
	
	/**
	 * 分页查询
	 */
	public PageInfo selectPage(SysRoleQueryRequest sysRoleQueryRequest) throws Exception {
		 Map<String, Object> map = new HashMap<String, Object>();
	        PageOption pageOption=sysRoleQueryRequest.getPageOption();
	        map.put("PSIZE", pageOption.getRows());
	        map.put("BEGIN", (pageOption.getPage() - 1) * pageOption.getRows());
	        
	        if(Util.isNotNull(sysRoleQueryRequest.getRoleName())){
	        	map.put("roleName", sysRoleQueryRequest.getRoleName());
	        }
	        if(Util.isNotNull(sysRoleQueryRequest.getRoleType()))
	        {
	        	map.put("roleType", sysRoleQueryRequest.getRoleType());
	        }
	        PageUtil.orderParam(pageOption, map);
	        Integer count = this.sysRoleDAO.selectPageCount2(map);
	        ArrayList<SysRole> role=new ArrayList<>();
	        role.add(new SysRole());
	        if (count == 0) {
	            return new PageInfo(pageOption.getRows(), pageOption.getPage(), count, role);
	        }
	        List<SysRole> list = this.sysRoleDAO.selectPage2(map);
	        PageInfo pageInfo = new PageInfo(pageOption.getRows(), pageOption.getPage(), count, list);
	        return pageInfo;
	}
	
	
	

	/**
	 * 查询一条记录
	 */
	public SysRole get(BaseViewRequest baseViewRequest) throws Exception {
		return sysRoleDAO.getById(baseViewRequest.getId());
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(SysRoleRequest sysRoleRequest) throws Exception {
	    SysRole sysRole= sysRoleRequest.getSysRole();
	    
		Integer result = sysRoleDAO.add(sysRole);
		return result>0?true:false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(SysRoleRequest sysRoleRequest) throws Exception {
	    SysRole sysRole= sysRoleRequest.getSysRole();	    
	    
		Integer result = sysRoleDAO.update(sysRole);
		return result>0?true:false;
	}
	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(BaseDeleteRequest baseDeleteRequest) throws Exception {
		Integer result = sysRoleDAO.deleteById(baseDeleteRequest.getId());
		return result>0?true:false;
	}




	@Override
	public List<SysRole> selectAll() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("is_show", 1);
		return sysRoleDAO.selectAll();
	}




	@Override
	public List<Map<String, Integer>> selecPersion(Map<String, String> map)
			throws Exception {
		return sysRoleDAO.selecPersion(map);
	}


}
