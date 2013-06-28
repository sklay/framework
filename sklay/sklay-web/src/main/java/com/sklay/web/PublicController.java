/*
 * Project:  any
 * Module:   sklay-web
 * File:     LoginoutController.java
 * Modifier: zhouning
 * Modified: 2012-12-14 下午2:17:48 
 *
 * Copyright (c) 2012 Sanyuan Ltd. All Rights Reserved.
 *
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent or the
 * registration of a utility model, design or code.
 */
package com.sklay.web;

import javax.validation.Valid;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sklay.widgets.model.User;
import com.sklay.widgets.service.UserService;
import com.sklay.widgets.util.LoginUserHelper;

/**
 * 
 * @author <a href="mailto:1988fuyu@163.com">fuyu</a>
 *
 * @version  v1.0 2013-6-27
 */
@Controller
@RequestMapping("/public")
public class PublicController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/doRegist")
	@ResponseBody
	public int doRegist(@Valid User user,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return 3;
		}
		if(userService.exist(user.getName())){
			return 2;
		}
		else{
			userService.regist(user);
			return 0;
		}
	}
	
	@RequestMapping("/doLogin")
	@ResponseBody
	public int doLogin(User user,boolean rememberMe){
		try{
			LoginUserHelper.login(user.getName(), user.getPassword(), rememberMe);
			return 0;
		} catch (UnknownAccountException uae) {
			return 1;
		} catch (IncorrectCredentialsException ice){
			return 1;
		}
	}
	
	
	@RequestMapping("/logout")
	public String logout(User user,boolean rememberMe){
		LoginUserHelper.logout();
		return "redirect:/";
	}
	
}
