package ${daoPackage};

import java.util.List;
import java.util.Map;
import com.yxcoach.common.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import ${entityPackage}.${entityName};

/**
 *	
 *  ${tableName}Dao
 *  注释:${tableComment}
 *  创建人: ${auth}
 *  创建日期:${date}
 */
@MyBatisDao
@Component("${daoReName}")
public interface ${daoName}{
	/**
	 * 获取${tableComment}分页数据
	 */
	public List<${entityName}> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取${tableComment}分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询${tableComment}
	 */
	public ${entityName} getById(${priFieldType} ${priField}) throws Exception;
	/**
	 * 根据ID修改${tableComment}
	 */
	public Integer update(${entityName} ${entityReName}) throws Exception;
	/**
	 * 添加${tableComment}
	 */
	public Integer add(${entityName} ${entityReName})throws Exception;
	/**
	 * 根据ID删除${tableComment}
	 */
	public Integer deleteById(${priFieldType} ${priField}) throws Exception;
	
}