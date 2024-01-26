package com.winter.app.wishlist;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.winter.app.account.AccountDTO;
import com.winter.app.board.member.MemberDTO;
import com.winter.app.product.ProductDTO;

@Controller
@RequestMapping("/wishlist/")
public class WishlistController {
	
	@Autowired
	private WishlistService wishlistService;


	@GetMapping("list")
	public void getList(HttpSession session, Model model)throws Exception{
		MemberDTO memberDTO =(MemberDTO)session.getAttribute("member");
		List<ProductDTO> ar = wishlistService.getList(memberDTO);
		model.addAttribute("list", ar);
		
	}
	
	@GetMapping("add")
	public String setAdd(HttpSession session, AccountDTO accountDTO, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		accountDTO.setUserName(memberDTO.getUserName());
		int result = wishlistService.setAdd(accountDTO);
		
		model.addAttribute("result",result);
		
		return "commons/ajaxResult";
	}
	
	
	@PostMapping("delete")
	//파라미터 이름이 같은건 배열로 받는다 (여러개의 데이터가 넘어올떄)
	public String setDelete(Long [] productNum, HttpSession session, Model model) throws Exception{
		MemberDTO memberDTO =(MemberDTO)session.getAttribute("member");
//		for(Long l: productNum) {
//			System.out.println(l);
//		}
		int result = wishlistService.setDelete(productNum, memberDTO);
		
		//다시 조회
		List<ProductDTO> ar = wishlistService.getList(memberDTO);
		
		//model.addAttribute("result",result);
		model.addAttribute("list", ar);
		return "wishlist/ajxList";
		//return "commons/ajaxResult";
	}
			
	
	
	
}
