package com.winter.app.wishlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.account.AccountDTO;
import com.winter.app.board.member.MemberDTO;
import com.winter.app.product.ProductDTO;

@Service
public class WishlistService {

	@Autowired
	private WishlistDAO wishlistDAO;
	
	public List<ProductDTO> getList(MemberDTO memberDTO)throws Exception{
		return wishlistDAO.getList(memberDTO);
	}
	
	public int setAdd(AccountDTO accountDTO)throws Exception{
		return wishlistDAO.setAdd(accountDTO);
	}

	public int setDelete(Long [] productNum, MemberDTO memberDTO)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nums", productNum);
		map.put("member", memberDTO);
		return wishlistDAO.setDelete(map);
		
	}
	
}
