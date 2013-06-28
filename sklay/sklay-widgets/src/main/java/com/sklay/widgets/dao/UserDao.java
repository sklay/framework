/*
 * Project:  sklay
 * Module:   sklay-web
 * File:     UserDao.java
 * Modifier: fuyu
 * Modified: 2012-12-7 下午8:53:06 
 *
 * Copyright (c) 2012 Sanyuan Ltd. All Rights Reserved.
 *
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent or the
 * registration of a utility model, design or code.
 */
package com.sklay.widgets.dao;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.sklay.widgets.model.User;

/**
 * 
 * @author <a href="mailto:1988fuyu@163.com">fuyu</a>
 *
 * @version  v1.0 2013-6-26
 */
public interface UserDao extends JpaRepository<User, Long> {

	/**
	 * @param email
	 * @return
	 */
	@QueryHints({@QueryHint(name=org.hibernate.annotations.QueryHints.CACHEABLE,value="true")}) 
	@Query("select u from User u where u.name=?1 or phone = ?1")
	User findByName(String name);

	@Query("select count(u) from User u where u.name=?1")
	long countByName(String name);

	@Query("select u from User u")
	List<User> listUsers(Pageable pageable);

}
