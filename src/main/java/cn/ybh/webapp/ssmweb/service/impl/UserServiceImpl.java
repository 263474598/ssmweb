package cn.ybh.webapp.ssmweb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ybh.webapp.ssmweb.dao.UserMapper;
import cn.ybh.webapp.ssmweb.entity.User;
import cn.ybh.webapp.ssmweb.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userDao;
	
	public User getUserById(int userId) {
		return userDao.selectByPrimaryKey(userId);  
	}

	public int addUser(User user) {
		 return userDao.insertSelective(user);  
	}

}
