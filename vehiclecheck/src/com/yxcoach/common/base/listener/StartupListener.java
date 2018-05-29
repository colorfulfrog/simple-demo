package com.yxcoach.common.base.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.yxcoach.common.base.util.SpringContextUtil;
import com.yxcoach.common.service.SysMenuService;

/**
 * @ClassName: StartupListener
 * @Description: 系统启动完加载
 * @author yangzhipeng
 */
public class StartupListener implements ApplicationListener<ContextRefreshedEvent>{
	private static final Log LOG = LogFactory.getLog(StartupListener.class);
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){
			LOG.info("系统初始化开始.........");
			SysMenuService sys_menu_service = (SysMenuService) SpringContextUtil.getBean("SysMenuServiceImpl");
//			sysDictTxtService sysDictTxtService = (SysDictTxtService) SpringContextUtil.getBean("SysDictTxtServiceImpl");
		    try{
		    	LOG.info("系统加载初始化菜单数据开始...");
		    	sys_menu_service.resetRoleMenu();
				LOG.info("系统加载初始化菜单数据完成。");
			} catch (Exception e) {
				LOG.error("...",e);
			}
		}  
	}
	
}
