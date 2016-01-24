package com.lwjb.tour.daos;

import org.apache.ibatis.annotations.Param;

import com.lwjb.tour.models.User;

public interface UserDao {
	
	public int save(User user);
	
	public int addRole(@Param("userId") int userId, @Param("roleId") int roleId);
	
	public User findyByName(@Param("useranme") String username);
	
}
