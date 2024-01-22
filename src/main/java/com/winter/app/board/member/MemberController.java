package com.winter.app.board.member;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDTO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	//mypage
	@GetMapping("mypage")
	public void getMypage(HttpSession session, Model model)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO = memberService.getDetail(memberDTO);
		model.addAttribute("member",memberDTO);
	}
	
	
	// 입력 폼
	@GetMapping("join")
	public void setJoin()throws Exception{
		
	}
	
	//update
	@GetMapping("update")
	public void setUpdate(HttpSession session, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO = memberService.getDetail(memberDTO);
		model.addAttribute("member", memberDTO);
	}
	//update
	@PostMapping("update")
	public String setUpdate(MemberDTO memberDTO, HttpSession session)throws Exception{
		//DB Update 후 Mypage로 이동
		MemberDTO m = (MemberDTO)session.getAttribute("member");
		
		memberDTO.setUserName(m.getUserName());

		int result = memberService.setUpdate(memberDTO);
		
		return "redirect:./mypage";
	}
	
	
	//약관동의
	@GetMapping("ok")
	public void ok()throws Exception{
		
	}
	
	
	@GetMapping("agreement")
	public void setAgreement()throws Exception{
		
	}

	
	
	// 데이터 전달
	@PostMapping("join")
	public String setJoin(MemberDTO memberDTO, MultipartFile avatar, Model model)throws Exception{
		int result = memberService.setJoin(memberDTO, avatar);
		
		String msg ="회원 가입 실패 했음";
		String path ="./join";
		if(result>0) {
			msg="회원 가입 성공 했음";
			path="../";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("path", path);
		
		return "commons/result";
	}
	//로그인
	@GetMapping("login")
	public void getLogin()throws Exception{
		
	}
	
	//로그인
	//request객체를 사용할때 로그인을 하게되면 페이지 이동시 request가 끊겨서
	//상위 내장객체인 session을 사용함 session의 경우 인터넷 접속창을 끄거나 다른 페이지로 이동할때 세션이 끊김
	//최상위 객체인 Applicaion은 server(tomcat)이 종료되었을때 끊김
	@PostMapping("login")
	public String getLogin(MemberDTO memberDTO, HttpSession session, Model model)throws Exception{
		// memberservice에서 가공한 데이터를 DTO에 담아서 보내줌
		memberDTO = memberService.getLogin(memberDTO);
		
		// 로그인이 되어있지 않으면 로그인 페이지로 이동
		// 메시지를 보내기 위해서 model 사용
		if(memberDTO == null) {
			model.addAttribute("msg", "ID 또는 PW 확인");
			return "member/login";
		}
		
		//request.getSession() 이렇게 꺼내는게 정상적인 방법인데 spring에서 자동으로 session에서 꺼낼수있게 해줌
		// request보다 상위 객체인 session사용 
		session.setAttribute("member", memberDTO);
		// session에 key:value 보내줌 String:object
		return "redirect:/";
		
	}
	@GetMapping("logout")
	public String getLogout(HttpSession session)throws Exception{
		// 첫번째 방법 null을 넣어서 끊기게 함 
		//session.setAttribute("member", null);
		
		//key value 삭제
		//session.removeAttribute("member");
		
		// value 값만 삭제
		//session.removeValue("member");
		
		// 시간 조정
		session.invalidate();
		return "redirect:/";
	}
	
	
}