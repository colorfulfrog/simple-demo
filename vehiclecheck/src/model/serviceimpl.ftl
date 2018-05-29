package ${serviceImplPackage};

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
import ${daoPackage}.${daoName};
import ${entityPackage}.${entityName};
import ${servicePackage}.${serviceName};
import ${requestManagerPackage}.${entityName}QueryRequest;
/**
 * @ClassName: ${serviceNameImpl}
 * @Description: ${tableComment} serviceImpl
 * @author ${auth}
 * @date ${date}
 */
@Transactional(readOnly = true)
@Service("${serviceReName}")
public class ${serviceNameImpl} implements ${serviceName}{
	private static final Log log = LogFactory.getLog(${serviceNameImpl}.class);
	
	@Resource(name = "${daoReName}")
	private ${daoName} ${daoReName};
		
	/**
	 * 分页查询
	 */
	public PageInfo selectPage(${entityName}QueryRequest ${entityReName}QueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=${entityReName}QueryRequest.getPageOption();
		if(${entityReName}QueryRequest.getPageOption().getRows()==null) ${entityReName}QueryRequest.getPageOption().setRows(20);
		if(${entityReName}QueryRequest.getPageOption().getPage()==null) ${entityReName}QueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", ${entityReName}QueryRequest.getPageOption().getRows());
		map.put("BEGIN", (${entityReName}QueryRequest.getPageOption().getPage() - 1) * ${entityReName}QueryRequest.getPageOption().getRows());
		
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.${daoReName}.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(${entityReName}QueryRequest.getPageOption().getRows(), ${entityReName}QueryRequest.getPageOption().getPage(), count, new ArrayList<${entityName}>());
		}
		List<${entityName}> list = this.${daoReName}.selectPage(map);
		PageInfo pageInfo = new PageInfo(${entityReName}QueryRequest.getPageOption().getRows(), ${entityReName}QueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 查询一条记录
	 */
	public ${entityName} get(Long id) throws Exception {
		return ${daoReName}.getById(id);
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(${entityName} ${entityReName}) throws Exception {
		Integer result = ${daoReName}.add(${entityReName});
		return result>0?true:false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(${entityName} ${entityReName}) throws Exception {
		Integer result = ${daoReName}.update(${entityReName});
		return result>0?true:false;
	}
	
	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) throws Exception {
		Integer result = ${daoReName}.deleteById(id);
		return result>0?true:false;
	}
}
