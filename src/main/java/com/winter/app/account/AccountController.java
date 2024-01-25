package com.winter.app.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.app.board.member.MemberDTO;
import com.winter.app.product.ProductDTO;
import com.winter.app.util.Pager;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@GetMapping("add")
	public void add(ProductDTO productDTO, Model model) throws Exception {
		Long productNum = productDTO.getProductNum();
		
		model.addAttribute("dto", productNum);
		
	}
	@PostMapping("add")
	public String add(AccountDTO accountDTO,HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		Long nowTime = System.currentTimeMillis();
		
		accountDTO.setUserName(memberDTO.getUserName());
		accountDTO.setAccountNum(nowTime);
		
		int result = accountService.add(accountDTO);
		
		String msg ="계좌 개설 실패 했음";
		String path ="../";
		if(result>0) {
			msg="계좌 개설 성공 했음";
			path="../";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("path", path);
		
		return "commons/result";
	}
	
	@GetMapping("list")
	public void getList(ProductDTO productDTO, Pager pager, HttpSession session, Model model) throws Exception {
		MemberDTO ac = (MemberDTO)session.getAttribute("member");
		pager.setSearch(ac.getUserName());
		List<ProductDTO> ar = accountService.getList(pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
	}
}