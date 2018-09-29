package sign.dao;

import java.util.Map;

import sign.entity.User;

public interface UserDao {
    /**
     * 登录
     * @param no
     * @return
     */
	public User findUserByNo (String no);
    /**
     * 注册
     * @param user
     */
	public void addUser (User user);
	/**
	 * 根据账号，真实姓名找回密码；
	 * @param no 
	 * @param username
	 * @return
	 */
	public User findUserByNoAndUsername(String no,String username);
	
	/**
	 * 修改个人信息
	 * @param no
	 */
	public void updateUserByNo(Map<String, Object> map);
	
	
}