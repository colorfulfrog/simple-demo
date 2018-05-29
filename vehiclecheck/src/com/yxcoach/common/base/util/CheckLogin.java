package com.yxcoach.common.base.util;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.exception.CredentialsException;
import com.yxcoach.common.base.exception.ExpiredCredentialsException;
import com.yxcoach.common.dao.BsMemberDAO;
import com.yxcoach.common.entity.BsMember;
import com.yxcoach.common.entity.SysUser;

@Service("CheckLogin")
public class CheckLogin {

	@Resource(name = "redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	@Value("${redis.token.key}")
	private String SYS_USER_TOKEN;
	@Value("${ignored.persion}")
	private String ignoredPersion;
	
	@Resource(name = "bsMemberDAO")
	private BsMemberDAO bsMemberDAO;

	// @Value("${redis.token.dispatchkey}")
	// private String SYS_DISPATCH_TOKEN;
	// @Value("${redis.token.bsdriverkey}")
	// private String SYS_BSDRIVER_TOKEN;

	public boolean check(String token, HttpServletRequest request) {

		SysUser user = login(token, request);

		/** 权限控制 */
		String servletPath = request.getServletPath();
		String[] persions = ignoredPersion.split(",");
		/** 忽略掉不需要权限就能访问的url */
		for (String p : persions) {
			if (servletPath.indexOf(p) != -1) {
				return true;
			}
		}
		String persionStr = Constants.ROLE_PERSION_KEY + ":" + user.getRid()
				+ ":" + servletPath;
		Object persion = redisTemplate.opsForValue().get(persionStr);
		if (persion == null) {
			return false;
		}
		return true;

	}

	public SysUser login(String token, HttpServletRequest request) {

		if (Util.isNull(token)) {
			throw new CredentialsException("未登录，请登录");
		}

		/** 登录控制 */

		Object object = redisTemplate.opsForValue().get(
				SYS_USER_TOKEN + ":" + token);
		if (object == null) {
			throw new ExpiredCredentialsException("登录过期");
		}
		SysUser user = (SysUser) object;
		return user;
	}

	public boolean APPLogin(String token, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if (Util.isNull(token)) {
			writeJson(response, 3, "token为空，请验证参数");
			return false;
		}

		BsMember bsMember = new BsMember();
		bsMember.setOpen_id(token);
		BsMember member = bsMemberDAO.getByCon(bsMember);
		if (member == null) {
			writeJson(response, 3, "token验证失败，请确认token是否正确");
			return false;
		}
		response.reset();
		return true;
	}

	/*
	 * public void check(String token,HttpServletRequest request){
	 * 
	 * if(Util.isNull(token)){ throw new CredentialsException("错误的请求"); }
	 *//** 登录控制 */
	/*
	 * SysUser user = (SysUser)
	 * redisTemplate.opsForValue().get(SYS_USER_TOKEN+":"+token);
	 * if(user==null){ throw new ExpiredCredentialsException("登录过期"); }
	 *//** 权限控制 */
	/*
	 * String servletPath=request.getServletPath(); String[] persions =
	 * ignoredPersion.split(",");
	 *//** 忽略掉不需要权限就能访问的url */
	/*
	 * for(String p:persions){ if(servletPath.indexOf(p)!=-1){ return; } }
	 * String
	 * persionStr=Constants.ROLE_PERSION_KEY+":"+user.getRid()+":"+servletPath;
	 * Object persion = redisTemplate.opsForValue().get(persionStr);
	 * if(persion==null){ throw new UnauthenticatedException("无访问权限"); }
	 * 
	 * }
	 */

	public void writeJson(HttpServletResponse response, int code, String msg) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			JSONObject res = new JSONObject();
			res.put("code", code);
			res.put("msg", msg);
			out = response.getWriter();
			out.append(res.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
