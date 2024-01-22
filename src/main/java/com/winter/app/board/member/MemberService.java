package com.winter.app.board.member;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.FileManager;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private ServletContext servletContext;
	
	
	//mypage
	public MemberDTO getDetail(MemberDTO memberDTO)throws Exception{
		return memberDAO.getDetail(memberDTO);
	}
	
	//로그인
	public MemberDTO getLogin(MemberDTO memberDTO)throws Exception{
		// 비밀번호 비교하기위해서 새로 선언함 ( 비밀번호를 꺼내오는 용도 )
		MemberDTO m = memberDAO.getDetail(memberDTO);
		// null으로 오면 아이디를 입력하지 않은거임
		if(m != null) {
			if(m.getPassword().equals(memberDTO.getPassword())) {
				return memberDTO;
			}else {
				// 비밀번호가 null일떄 null리턴
				return m=null;
			}
		}
		// 아이디가 null로 왔을때 null리턴
		return m;
		
	}
	
	
	public int setJoin (MemberDTO memberDTO, MultipartFile avatar)throws Exception{
		int result=0;
		result = memberDAO.setJoin(memberDTO);

		if(avatar.isEmpty()) {
			return result;
		}
		String path = servletContext.getRealPath("/resources/upload/member");
		
		String fileName = fileManager.fileSave(path, avatar);
		
		AvatarDTO avatarDTO = new AvatarDTO();
		avatarDTO.setFileName(fileName);
		avatarDTO.setOriName(avatar.getOriginalFilename());
		avatarDTO.setUserName(memberDTO.getUserName());
		
		result = memberDAO.setAvatarAdd(avatarDTO);
		
		
		
		return result;
	}
	
	
	public String mypage(MemberDTO memberDTO) throws Exception {
		
		return memberDAO.mypage(memberDTO);
	}
	
	public int setUpdate (MemberDTO memberDTO)throws Exception{
		return memberDAO.setUpdate(memberDTO);
	}

	
	

}