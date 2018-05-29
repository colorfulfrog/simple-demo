package ${entityPackage};

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:${tableName}
 *  注释:${tableComment}
 *  创建人: ${auth}
 *  创建日期:${date}
 */
@ApiModel(value = "${entityName}", description = "${tableComment}")
public class ${entityName} implements Serializable{
    private static final long serialVersionUID = 1L;
    
<#if fields ?exists >
	<#list fields as tem>
	<#if tem[0] =="java.lang.String">
	<#if tem[3] !="">
	@ApiModelProperty(value = "${tem[2]} 长度(${tem[4]}) 必填")
	</#if>
	<#if tem[3] =="">
	@ApiModelProperty(value = "${tem[2]} 长度(${tem[4]})")
	</#if>
	</#if>
	<#if tem[0] !="java.lang.String">
	@ApiModelProperty(value = "${tem[2]} ")
	</#if>
	private ${tem[0]} ${tem[1]};
	
	</#list>
</#if>
	
<#if fields ?exists >
	<#list fields as tem>
	public void set${tem[1]?cap_first}(${tem[0]} ${tem[1]}){
		this.${tem[1]}=${tem[1]};
	}
	public ${tem[0]} get${tem[1]?cap_first}(){
		return this.${tem[1]};
	}
	</#list>
</#if>
}
