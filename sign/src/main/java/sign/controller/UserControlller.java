package sign.controller;


import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sign.entity.User;
import sign.service.UserService;
import sign.vo.JsonBean;

/** ......................我佛慈悲......................
 *                       _oo0oo_
 *                      o8888888o
 *                      88" . "88
 *                      (| -_- |)
 *                      0\  =  /0
 *                    ___/`---'\___
 *                  .' \\|     |// '.
 *                 / \\|||  :  |||// \
 *                / _||||| -卍- |||||- \
 *               |   | \\\  -  /// |   |
 *               | \_|  ''\---/''  |_/ |
 *               \  .-\__  '-'  ___/-. /
 *             ___'. .'  /--.--\  `. .'___
 *          ."" '<  `.___\_<|>_/___.' >' "".
 *         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *         \  \ `_.   \_ __\ /__ _/   .-` /  /
 *     =====`-.____`.___ \_____/___.-`___.-'=====
 *                       `=---='
 *                       
 *..................佛祖开光 ,永无BUG...................
 * 
 */
@Controller
public class UserControlller {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	@ResponseBody
	public JsonBean<User> findUserByNo(String no, String password){
		JsonBean<User> bean = new JsonBean<User>();
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(no, password);
		
		try {
			subject.login(token);
			bean.setCode(1);
		}catch(UnknownAccountException e){
			bean.setCode(0);
			bean.setMsgs("用户名错误!");
		}catch(IncorrectCredentialsException e){
			bean.setCode(0);
			bean.setMsgs("密码错误!");
		}catch (AuthenticationException e) {
			bean.setCode(0);
			bean.setMsgs("非法用户!");
			e.printStackTrace();
		}
		return bean;
	}
	
	@RequestMapping(value="/addUser.do", method=RequestMethod.POST)
	@ResponseBody
	public JsonBean<User> addUser(User user, String password2) {
		JsonBean<User> bean = new JsonBean<>();
		
		try {
			userService.addUser(user, password2);
			bean.setCode(0);
		} catch (Exception e) {
			bean.setCode(1111);
			bean.setMsgs(e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping(value="/findPassword.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findUserByNoAndUsername(String no,String username) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			User user = userService.findUserByNoAndUsername(no, username);
			String password = user.getPassword();
			map.put("code", 0);
			map.put("password", password);
			return map;
		} catch (Exception e) {
			map.put("code", 1111);
			map.put("msg", e.getMessage());
			return map;
		}		
	}
	
	@RequestMapping(value="/updateUser.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateUserByNo(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			userService.updateUserByNo(user);
			map.put("code", 0);
			return map;
		} catch (Exception e) {
			map.put("msg", e.getMessage());
			return map;
		}
		
		
		
	}
	
	
	
	
}

