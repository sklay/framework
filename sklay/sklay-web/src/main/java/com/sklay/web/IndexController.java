package com.sklay.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sklay.model.AccountLog;
import com.sklay.service.AccountService;
import com.sklay.widgets.model.User;

@Controller
public class IndexController {

	@Autowired
	private AccountService accountService;

	@ModelAttribute
	public void populateModel(Model model) {
		model.addAttribute("nav", "index");
	}

	@RequestMapping("/")
	public String index(ModelMap model) {
		// 最新公开的
		List<AccountLog> accountLogs = accountService.findRecentSharedLogs(0,
				10);
		model.put("recentLogs", accountLogs);

		// 公开的、且记账数多的记账之星
		List<User> stars = accountService.findMostActiveUsers(0, 10);
		model.put("stars", stars);

		// 最新讨论
		model.put("latestTopics", null);

		return "index.index";
	}
}
