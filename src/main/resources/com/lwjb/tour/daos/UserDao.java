package com.lwjb.tour.daos;

import org.apache.ibatis.annotations.Param;

import com.lwjb.tour.models.User;

public interface UserDao {
	
	public long save(User user);
	
	public long addRole(@Param("userId") int userId, @Param("roleId") int roleId);
	
	public User findByUsername(@Param("username") String username);
	
}
