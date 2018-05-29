package ${servicePackage};

import com.yxcoach.common.base.entity.PageInfo;
import ${entityPackage}.${entityName};
import ${requestManagerPackage}.${entityName}QueryRequest;
/**
 *  ${serviceName}
 *  注释:${tableComment}Service
 *  创建人: ${auth}
 *  创建日期:${date}
 */
public interface ${serviceName} {
	
	/***
	 * ${tableComment}列表分页
	 * @param ${requestManagerEntityReName} 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(${entityName}QueryRequest ${entityReName}QueryRequest) throws Exception;
	
	/***
	 * 查询${tableComment}
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public ${entityName} get(Long id) throws Exception;
    
    /***
     * ${tableComment}添加
     * @param ${entityReName}
     * @return
     * @throws Exception
     */
    public boolean add(${entityName} ${entityReName}) throws Exception;
    
    /***
     * ${tableComment}修改
     * @param ${entityReName}
     * @return
     * @throws Exception
     */
    public boolean update(${entityName} ${entityReName}) throws Exception;
	/***
	 * 删除${tableComment}
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public boolean delete(Long id) throws Exception;

}
