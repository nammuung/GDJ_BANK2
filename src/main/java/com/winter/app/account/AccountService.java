package com.winter.app.account;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParserContext;
import org.springframework.stereotype.Service;

import com.winter.app.board.member.MemberDTO;
import com.winter.app.product.ProductDTO;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	//add
	public int setAdd(AccountDTO accountDTO)throws Exception{
	ProductDTO productDTO =new ProductDTO();
	
		long today = System.currentTimeMillis(); // long 형의 현재시간
		accountDTO.setAccount(today);
	
		accountDTO.setProductNum(productDTO.getProductNum());
		
		
		System.out.println("======================================="+accountDTO.getProductNum());
		System.out.println("======================================="+today);
		//System.out.println("======================================="+accountDTO.getUserName());
		return accountDAO.setAdd(accountDTO);
	}
	
}
