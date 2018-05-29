package com.yxcoach.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.base.util.PageOption;
import com.yxcoach.common.base.util.PageUtil;
import com.yxcoach.common.dao.SysMenuDAO;
import com.yxcoach.common.dao.SysPersionDAO;
import com.yxcoach.common.entity.SysMenu;
import com.yxcoach.common.entity.SysRole;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.SysMenuQueryRequest;
import com.yxcoach.common.request.SysMenuRequest;
import com.yxcoach.common.service.SysMenuService;
import com.yxcoach.common.service.SysRoleService;
/**
 * @ClassName: SysMenuServiceImpl
 * @Description: 菜单表 serviceImpl
 * @author yangzhipeng
 * @date 2018-03-24
 */
@Transactional(readOnly = true)
@Service("SysMenuServiceImpl")
public class SysMenuServiceImpl implements SysMenuService{

	@Resource(name = "SysMenuDAO")
	private SysMenuDAO sysMenuDAO;
		
	@Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;
	
	@Resource(name = "SysRoleServiceImpl")
    private SysRoleService sysRoleService;
	
	@Resource(name = "SysPersionDAO")
    private SysPersionDAO sysPersionDAO;
	
	/**
	 * 分页查询
	 */
	public PageInfo selectPage(SysMenuQueryRequest sysMenuQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=sysMenuQueryRequest.getPageOption();
		if(sysMenuQueryRequest.getPageOption().getRows()==null) sysMenuQueryRequest.getPageOption().setRows(20);
		if(sysMenuQueryRequest.getPageOption().getPage()==null) sysMenuQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", sysMenuQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (sysMenuQueryRequest.getPageOption().getPage() - 1) * sysMenuQueryRequest.getPageOption().getRows());
		
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.sysMenuDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(sysMenuQueryRequest.getPageOption().getRows(), sysMenuQueryRequest.getPageOption().getPage(), count, new ArrayList<SysMenu>());
		}
		List<SysMenu> list = this.sysMenuDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(sysMenuQueryRequest.getPageOption().getRows(), sysMenuQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}
	
	
	

	/**
	 * 查询一条记录
	 */
	public SysMenu get(BaseViewRequest baseViewRequest) throws Exception {
		return sysMenuDAO.getById(baseViewRequest.getId());
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(SysMenuRequest sysMenuRequest) throws Exception {
		//根据传过来的type来判断新增的是1级菜单 还是二级菜单 0 为1级
    	Integer result=0;

    	if(sysMenuRequest.getType()==0){
    		sysMenuRequest.getSysMenu().setPid(0l);
    		result = sysMenuDAO.add(sysMenuRequest.getSysMenu());
    	}else{
    		result = sysMenuDAO.add(sysMenuRequest.getSysMenu());
    	}
        return result > 0 ? true : false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(SysMenuRequest sysMenuRequest) throws Exception {
	    SysMenu sysMenu= sysMenuRequest.getSysMenu();	    
	    
		Integer result = sysMenuDAO.update(sysMenu);
		return result>0?true:false;
	}
	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(BaseDeleteRequest baseDeleteRequest) throws Exception {
		//删除时先判断是一级菜单还是二级菜单
				Integer result = 0;
				SysMenu sysmn = sysMenuDAO.getById(baseDeleteRequest.getId());
				if (sysmn.getPid() == 0) {
					// 删除一级菜单时 需要删除一级菜单所对应的所有二级菜单 以及所有二级菜单中所对应的权限
					// 查询一级菜单的二级菜单
					List<SysMenu> list = sysMenuDAO.selectMemuAll2(baseDeleteRequest.getId());
					for (SysMenu sysMenu : list) {
						// 根据菜单编号删除权限
						sysPersionDAO.deleteByMId(sysMenu.getId());
					}
					// 根据pid删除二级菜单
					sysMenuDAO.deleteByPid(baseDeleteRequest.getId());
					// 删除一级菜单
					result = sysMenuDAO.deleteById(baseDeleteRequest.getId());
				} else {
					// 如果是二级菜单则删除二级菜单所对应的权限
					sysPersionDAO.deleteByMId(baseDeleteRequest.getId());
					result = sysMenuDAO.deleteById(baseDeleteRequest.getId());
				}
		        return result > 0 ? true : false;
	}




	public void resetRoleMenu() throws Exception {
		List roles = sysRoleService.selectAll();
		Map<String,Object> map = new HashMap();
		map.put("type", 1);
		for (int i = 0; i < roles.size(); i++) {
			SysRole role = (SysRole) roles.get(i);
			map.put("rid", role.getId());
			List<SysMenu> sysMenuList = sysMenuDAO.selectRoleMemu(map);
			// redisTemplate.opsForList().leftPush(Constants.ROLE_MENU_KEY+role.getId(), sysMenuList);
			redisTemplate.opsForValue().set(Constants.ROLE_MENU_KEY +":"+ role.getId(), sysMenuList);
		}

		// 2.角色-权限：key,value都为角色id_权限url
		Map persionMap = new HashMap();
		for (int i = 0; i < roles.size(); i++) {
			SysRole role = (SysRole) roles.get(i);
			persionMap.put("rid", "" + role.getId());
			List<Map<String, Integer>> list = sysRoleService
					.selecPersion(persionMap);
			
//			String keys = Constants.ROLE_PERSION_KEY +":"+ role.getId();
//			redisTemplate.opsForValue().set(keys, list);
			for (int j = 0; j < list.size(); j++) {
				Map pmap = list.get(j);
				String key = Constants.ROLE_PERSION_KEY +":"+ role.getId()
						+":"+ pmap.get("persion");
				redisTemplate.opsForValue().set(key, key);
			}
		}
	}




	@Override
	public List<SysMenu> selectAll(SysMenuQueryRequest queryRequest)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SysMenu> list = null;
		List<SysMenu> newList = new ArrayList<SysMenu>();
		if (!"".equals(queryRequest.getName()) && queryRequest.getName()!=null ) {
			map.put("name", queryRequest.getName());
			list = sysMenuDAO.selectAll(map);
			List<SysMenu> list1=new ArrayList<SysMenu>();
			Set<SysMenu> setData = new HashSet<SysMenu>();
			if (list.size() > 0) {
				for (SysMenu sysMenu : list) {
					if (sysMenu.getPid() != 0) {
						//查出是二级菜单时 对应的去查一级菜单
						SysMenu sysmn = sysMenuDAO.getById(sysMenu.getPid());
						list1.add(sysmn);
					} else {
						//根据一级去查二级
						List<SysMenu> sm= sysMenuDAO.selectMemuAll2(sysMenu.getId());
						for (SysMenu sysMenu2 : sm) {
							list1.add(sysMenu2);
						}
					}
				}
			}
			for (SysMenu sysMenu : list1) {
				list.add(sysMenu);
			}
			//去除重复的元素
	        setData.addAll(list); 
	        for (SysMenu sysMenu : setData) {
	        	newList.add(sysMenu);
			}
		} else {
			list = sysMenuDAO.selectAll(map);
		}
		return (!"".equals(queryRequest.getName()) && queryRequest.getName()!=null)==true?newList:list;
	}


}
