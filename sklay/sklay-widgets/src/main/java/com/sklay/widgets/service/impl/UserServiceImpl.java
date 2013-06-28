/*
 * Project:  any
 * Module:   slyak-web
 * File:     UserServiceImpl.java
 * Modifier: zhouning
 * Modified: 2012-12-14 下午3:35:16 
 *
 * Copyright (c) 2012 Sanyuan Ltd. All Rights Reserved.
 *
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent or the
 * registration of a utility model, design or code.
 */
package com.sklay.widgets.service.impl;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sklay.widgets.dao.UserDao;
import com.sklay.widgets.model.User;
import com.sklay.widgets.service.UserService;

/**
 * 
 * @author <a href="mailto:1988fuyu@163.com">fuyu</a>
 *
 * @version  v1.0 2013-6-27
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void regist(User user) {
		cleanBeforeRegist(user);
		//the same as shiro.xml
		Sha256Hash hash = new Sha256Hash(user.getPassword(), null, 1024);
		user.setPassword(hash.toBase64());
		userDao.save(user);
	}
	
	private void cleanBeforeRegist(User user){
		user.setId(null);
		user.setSalt(null);
	}

	@Override
	public boolean exist(String eamil) {
		return userDao.countByName(eamil)>0;
	}

	@Override
	public User getUser(Long userId) {
		return userDao.findOne(userId);
	}

}
