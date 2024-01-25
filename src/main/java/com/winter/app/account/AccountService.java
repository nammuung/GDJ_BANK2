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

	public List<ProductDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		Long totalCount=accountDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		List<ProductDTO> ar = accountDAO.getList(pager);
		return ar;
	}
}