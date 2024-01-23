package com.winter.app.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value = "/account/*")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("add")
	public String setadd() throws Exception {
		return "account/add";
	}

	@PostMapping("add")
	public String setadd(AccountDTO accountDTO, HttpSession session) throws Exception {
		int result = accountService.setAdd(accountDTO);
		return "redirect:./list";
	}

}
