<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd"> 
<mapper namespace="${mybatisNameSpace}">

	<!-- 实体和表的映射关系 -->
	<resultMap type="${entityName}" id="responseMap">
		<#if fields ?exists >
			<#list fields as tem>
				<result property="${tem[1]}" column="${tem[1]}"/>
			</#list>
		</#if>
	</resultMap>
	<!-- 获取分页数据 -->
	<select id="selectPage" parameterType="java.util.Map" resultMap="responseMap">
		SELECT * FROM ${tableName} 
		 <where> 
		 	<!--添加查询 -->
		 </where>
		LIMIT
		<if test="PSIZE==null">10</if><if test="PSIZE!=null">#${"{"}PSIZE${"}"}</if>
		offset
		<if test="BEGIN==null">0</if><if test="BEGIN!=null">#${"{"}BEGIN${"}"}</if>
	</select>
	<!-- 获取分页数据总条数 -->
	<select id="selectPageCount" resultType="int" parameterType="java.util.Map">
		SELECT COUNT(1) FROM ${tableName}
		<where> 
		 	<!--添加查询 -->
		 </where>
	</select>
	<!-- 添加单条记录 -->
	<insert id="add" parameterType="${entityName}" <#if priField ?exists >useGeneratedKeys="true" keyProperty="${priField}"</#if>>
		<#assign p1="" />
		<#assign p2="" />
		<#if fields ?exists >
		<#list fields as tem>
			<#if priField !=tem[1] >
				<#assign p1=p1+tem[1]+"," />
				<#assign p2=p2+"#{"+tem[1]+"}"+"," />
			</#if>
		</#list>
		<#assign p1=p1?substring(0,p1?length-1) />
		<#assign p2=p2?substring(0,p2?length-1) />
		</#if>
		insert into ${tableName}(${p1}) values(${p2})
	</insert>
	<!-- 获取单条记录 -->
	<select id="getById" parameterType="${priFieldParameterType}" resultMap="responseMap">
		SELECT * FROM ${tableName} WHERE 
		<#if priField ?exists >
		${priField}=#${"{"}${priField}${"}"} 
		</#if>
	</select>
	<!-- 更新单条记录 -->
	<update id="update" parameterType="${entityName}">
		update ${tableName}
		<set>
			<#if fields ?exists >
				<#list fields as tem>
				<#assign p3=false />
				<#if priField ?exists >
					<#if priField==tem[1]><#assign p3=true /></#if>
				</#if>
				<#if !p3>
				<if test="${tem[1]}!=null">
					${tem[1]}=#${"{"}${tem[1]}${"}"}<#if (tem_index+1) lt fields?size>,</#if>
				</if>
				</#if>
				</#list>
			</#if>
		</set>
		where  
		<#if priField ?exists >
		${priField}=#${"{"}${priField}${"}"} 
		</#if>
	</update>
	<!-- 删除单条记录 -->
	<delete id="deleteById" parameterType="${priFieldParameterType}">
		delete from ${tableName} where 
		<#if priField ?exists >
		${priField}=#${"{"}${priField}${"}"} 
		</#if>
	</delete>
</mapper>
