package com.yxcoach.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.yxcoach.common.dao.SysUnionDAO;
import com.yxcoach.common.entity.SysMenu;
import com.yxcoach.common.entity.SysPersion;
import com.yxcoach.common.entity.SysUnion;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.SysMenuPersionRequest;
import com.yxcoach.common.request.SysPersionQueryRequest;
import com.yxcoach.common.request.SysPersionRequest;
import com.yxcoach.common.response.SysChildren_resp;
import com.yxcoach.common.response.SysPersionList_Resp;
import com.yxcoach.common.response.SysPersionParent_resp;
import com.yxcoach.common.response.SysPersion_Resp;
import com.yxcoach.common.service.SysPersionService;
import com.yxcoach.common.service.SysRoleService;
/**
 * @ClassName: SysPersionServiceImpl
 * @Description: 权限表 serviceImpl
 * @author yangzhipeng
 * @date 2018-03-24
 */
@Transactional(readOnly = true)
@Service("SysPersionService")
public class SysPersionServiceImpl implements SysPersionService{

	@Resource(name = "SysPersionDAO")
	private SysPersionDAO sysPersionDAO;
	
	@Resource(name = "SysMenuDAO")
    private SysMenuDAO sysMenuDAO;
		
	@Resource(name = "sysUnionDAO")
    private SysUnionDAO sysUnionDAO;
	
	@Resource(name = "SysRoleServiceImpl")
    private SysRoleService sysRoleService;
	
	@Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;
	
	/**
	 * 分页查询
	 */
	public PageInfo selectPage(SysPersionQueryRequest sysPersionQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=sysPersionQueryRequest.getPageOption();
		if(sysPersionQueryRequest.getPageOption().getRows()==null) sysPersionQueryRequest.getPageOption().setRows(20);
		if(sysPersionQueryRequest.getPageOption().getPage()==null) sysPersionQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", sysPersionQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (sysPersionQueryRequest.getPageOption().getPage() - 1) * sysPersionQueryRequest.getPageOption().getRows());
		
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.sysPersionDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(sysPersionQueryRequest.getPageOption().getRows(), sysPersionQueryRequest.getPageOption().getPage(), count, new ArrayList<SysPersion>());
		}
		List<SysPersion> list = this.sysPersionDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(sysPersionQueryRequest.getPageOption().getRows(), sysPersionQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}
	
	
	

	/**
	 * 查询一条记录
	 */
	public SysPersion get(BaseViewRequest baseViewRequest) throws Exception {
		return sysPersionDAO.getById(baseViewRequest.getId());
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(SysPersionRequest sysPersionRequest) throws Exception {
	    SysPersion sysPersion= sysPersionRequest.getSysPersion();
	    
		Integer result = sysPersionDAO.add(sysPersion);
		return result>0?true:false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(SysPersionRequest sysPersionRequest) throws Exception {
	    SysPersion sysPersion= sysPersionRequest.getSysPersion();	    
	    
		Integer result = sysPersionDAO.update(sysPersion);
		return result>0?true:false;
	}
	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(BaseDeleteRequest baseDeleteRequest) throws Exception {
		Integer result = sysPersionDAO.deleteById(baseDeleteRequest.getId());
		return result>0?true:false;
	}




	@Override
	public List<SysPersionParent_resp> selectmenuAll(Long rid) throws Exception {
		//一级菜单
				List<SysMenu> list= sysMenuDAO.selectMemuAll();	
				Map<String, Object> map= new HashMap<String, Object>();
				map.put("type", 2);
				map.put("rid", rid);
				List<SysUnion> sysunion= sysUnionDAO.selectByRid(map);
				
				Map<String, Object> map1= new HashMap<String, Object>();
				map1.put("type", 1);
				map1.put("rid", rid);
				List<SysUnion> sysunion1= sysUnionDAO.selectByRid(map1);
				//1ji
				List<SysPersionParent_resp> persionlist = new ArrayList<SysPersionParent_resp>();
				for (SysMenu sysMenu : list) {
					//循环获取一级菜单包含的二级子菜单
					List<SysChildren_resp> childrenlist= new ArrayList<SysChildren_resp>();
					List<SysMenu> list2= sysMenuDAO.selectMemuAll2(sysMenu.getId());
					//1jicaidan 
					SysPersionParent_resp e=new SysPersionParent_resp();
					e.setId(sysMenu.getId());
					e.setMenuName(sysMenu.getMenuName());
					boolean flag1=false;
					for (SysUnion sysUnion2 : sysunion1) {
						if(sysMenu.getId().toString().equals(sysUnion2.getOid().toString())){
							flag1=true;
						}
						e.setChecked(flag1);
					}
//					if(flag1){
//						e.setChecked(true);
//					}else{
//						e.setChecked(false);
//					}

					//2ji
					for (SysMenu sysMenu2 : list2) {
						List<SysPersion_Resp> quanxian= sysPersionDAO.SysPersionselectPage(sysMenu2.getId());
						SysChildren_resp children= new SysChildren_resp();
						children.setSecondid(sysMenu2.getId());
						children.setSecondMenuName(sysMenu2.getMenuName());	
						//二级菜单
						boolean flag2=false;
						for (SysUnion sysUnion2 : sysunion1) {
							if(sysMenu2.getId().toString().equals(sysUnion2.getOid().toString())){
								flag2=true;
							}
							children.setChecked(flag2);
						}
//						if(flag2){
//							children.setChecked(true);
//						}else{
//							children.setChecked(false);
//						}
						childrenlist.add(children);
						e.setChildren(childrenlist);
						List<SysPersionList_Resp> srlist= new ArrayList<SysPersionList_Resp>();
						if(quanxian.size()==0){
							children.setSysPersionList(new ArrayList<SysPersionList_Resp>());
						}
						for (SysPersion_Resp quan : quanxian) {					
							SysPersionList_Resp sr= new SysPersionList_Resp();
							sr.setId(quan.getId());
							sr.setPersionName(quan.getPersionName());
							boolean flag=false;
							for (SysUnion sysUnion2 : sysunion) {
								if(quan.getId().toString().equals(sysUnion2.getOid().toString())){
									flag=true;
								}
								sr.setChecked(flag);
							}
//							if(flag){
//								sr.setChecked(true);
//							}else{
//								sr.setChecked(false);
//							}
							//权限
							srlist.add(sr);
							children.setSysPersionList(srlist);
						}	
						
					}
					persionlist.add(e);
				}		
				return persionlist;
	}




	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean uninoAdd(SysMenuPersionRequest sysMenuPersionRequest)
			throws Exception {
		//角色所拥有的权限

				String[] quanxian = sysMenuPersionRequest.getPid();
				String[] caidan = sysMenuPersionRequest.getMid();

				// 2.角色-权限：key,value都为角色id_权限url
				Map persionMap = new HashMap();
				persionMap.put("rid", "" + sysMenuPersionRequest.getRid());
				List<Map<String, Integer>> list = sysRoleService
						.selecPersion(persionMap);
				for (int k = 0; k < list.size(); k++) {
					Map pmap = list.get(k);
					String key = Constants.ROLE_PERSION_KEY + ":"
							+ sysMenuPersionRequest.getRid() + ":"
							+ pmap.get("persion");
					redisTemplate.delete(key);
				}
				Map<String, Object> map2 = new HashMap();
				map2.put("type", 1);
				map2.put("rid", sysMenuPersionRequest.getRid());
				List<SysMenu> sysMenuList = sysMenuDAO.selectRoleMemu(map2);
				// redisTemplate.opsForList().leftPush(Constants.ROLE_MENU_KEY+role.getId(),
				// sysMenuList);
				redisTemplate.delete(Constants.ROLE_MENU_KEY + ":"
						+ sysMenuPersionRequest.getRid());

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("rid", sysMenuPersionRequest.getRid());
				map.put("type",2);
				sysUnionDAO.deleteByRidType(map);
				int result=0;
				int result1=0;
				for (int i = 0; i < quanxian.length; i++) {
					SysUnion s= new SysUnion();
					s.setRid(sysMenuPersionRequest.getRid());
					s.setType(2);
					s.setOid(Long.valueOf(quanxian[i]));
					result=sysUnionDAO.add(s);
				}
				//角色所拥有的菜单

				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("rid", sysMenuPersionRequest.getRid());
				map1.put("type",1);
				sysUnionDAO.deleteByRidType(map1);
				for (int i = 0; i < caidan.length; i++) {
					SysUnion s= new SysUnion();
					s.setRid(sysMenuPersionRequest.getRid());
					s.setType(1);
					s.setOid(Long.valueOf(caidan[i]));
					result1=sysUnionDAO.add(s);
				}

				return result1>0==true?true:false;
	}




	@Override
	public List<SysPersion> listForMenu(
			SysPersionQueryRequest sysPersionQueryRequest) {
		return sysPersionDAO.selectByMenuId(sysPersionQueryRequest.getMenuId());
	}


}
