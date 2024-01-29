package com.winter.app.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.winter.app.board.member.MemberDTO;
import com.winter.app.util.Pager;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@PostMapping("add")
	@ResponseBody
	public Map<String, Object> setReply(Pager pager,ReplyDTO replyDTO, HttpSession session, Model model)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		replyDTO.setUserName(memberDTO.getUserName());
		
		int result = replyService.setReply(replyDTO);
		
		List<ReplyDTO> ar = replyService.getList(pager, replyDTO);
		//JSON으로 여러개 보내려고 MAP사용
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("datas", ar);
		map.put("pager", pager);
		return map;
		
	}
	
	//delete
	@PostMapping("delete")
	@ResponseBody
	public Map<String, Object>setDelete(Pager pager, ReplyDTO replyDTO)throws Exception{
		replyService.setDelete(replyDTO);
		List<ReplyDTO> ar = replyService.getList(pager, replyDTO);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("datas", ar);
		map.put("pager", pager);
		return map;
	}
	
	@GetMapping("list")
	@ResponseBody   // JSON으로 보낸다는뜻
	public Map<String, Object> getList(Pager pager, ReplyDTO replyDTO, Model model)throws Exception {
		List<ReplyDTO> ar = replyService.getList(pager, replyDTO);
//		model.addAttribute("list", ar);
//		model.addAttribute("pager", pager);
		
		//list자체를 리턴함
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("datas", ar);
		map.put("pager", pager);
		
		return map;
	}
	
	
}