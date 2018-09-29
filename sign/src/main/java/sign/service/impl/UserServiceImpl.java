package sign.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import sign.dao.UserDao;
import sign.entity.User;
import sign.service.UserService;

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
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void addUser(User user,String password2) {
		if (StringUtils.isEmpty(user.getNo())) {
			throw new RuntimeException("用户账号为空");
		}
		if (null != userDao.findUserByNo(user.getNo())) {
			throw new RuntimeException("用户账号已存在，请重新输入");
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			throw new RuntimeException("用户密码为空");
		}
		if (!user.getPassword().equals(password2)) {
			throw new RuntimeException("两次输入密码不一致");
		}
		if (StringUtils.isEmpty(user.getUsername())) {
			throw new RuntimeException("用户姓名为空");
		}
		
		try {
			userDao.addUser(user);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public User findUserByNoAndUsername(String no, String username) {
		if (StringUtils.isEmpty(no)) {
			throw new RuntimeException("用户账号为空");
		}
		if (StringUtils.isEmpty(username)) {
			throw new RuntimeException("用户名字为空");
		}
		User user = null;
		
		try {
			user = userDao.findUserByNoAndUsername(no, username);
		} catch (Exception e) {
			throw new RuntimeException("查询错误");
		}
		if (null == user) {
			throw new RuntimeException("账号或者用户名错误，请输入正确的账号用户名");
		}
		return user;
	}

	@Override
	public void updateUserByNo(User user) {
		Subject subject = SecurityUtils.getSubject();
		String no = (String) subject.getPrincipal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("password", user.getPassword());
		map.put("username", user.getUsername());
		
		try {
			userDao.updateUserByNo(map);
			
		} catch (Exception e) {
			throw e;
		}
		
	}

	
	
	
	
}

