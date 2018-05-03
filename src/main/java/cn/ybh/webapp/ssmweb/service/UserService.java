package cn.ybh.webapp.ssmweb.service;

import cn.ybh.webapp.ssmweb.entity.User;

public interface UserService {
	public User getUserById(int userId);  
    public int addUser(User user);  
}
