package com.winter.app.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.board.member.MemberDTO;
import com.winter.app.product.ProductDTO;
import com.winter.app.util.Pager;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO accountDAO;

	public int add(AccountDTO accountDTO) throws Exception {
		
		return accountDAO.add(accountDTO);
	}

	public List<AccountDTO> list(Pager pager, MemberDTO memberDTO) throws Exception {
		pager.makeRow();
		Map<String, Object> map= new HashMap<String, Object>();
		
		map.put(pager, pager);
		map.put(memberDTO, memberDTO);
		
		Long totalCount = accountDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		List<AccountDTO> ar = this.accountDAO.list(pager);
		
		return ar;
	}
}