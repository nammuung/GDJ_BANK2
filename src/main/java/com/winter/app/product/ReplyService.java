package com.winter.app.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.board.member.MemberDTO;
import com.winter.app.util.Pager;

@Service
public class ReplyService {
	@Autowired
	private ReplyDAO replyDAO;
	
	public int setReply(ReplyDTO replyDTO)throws Exception{
		return replyDAO.setReply(replyDTO);
	}
	
	public List<ReplyDTO> getList(Pager pager ,ReplyDTO replyDTO)throws Exception{
		pager.setPage(5L);
		pager.makeRow();
		
		// 스타트 넘 라스트 넘 만들어짐
		pager.makeNum(replyDAO.getTotalCount(replyDTO));
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("pager", pager);
		map.put("replyDTO", replyDTO);
		return replyDAO.getList(map);
	}

}