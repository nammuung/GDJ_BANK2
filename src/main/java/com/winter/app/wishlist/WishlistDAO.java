package com.winter.app.wishlist;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.account.AccountDTO;
import com.winter.app.board.member.MemberDTO;
import com.winter.app.product.ProductDTO;

@Repository
public class WishlistDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.winter.app.wishlist.WishlistDAO.";
	
	public List<ProductDTO> getList(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", memberDTO);
	}
	
	public int setAdd(AccountDTO accountDTO)throws Exception {
		return sqlSession.insert(NAMESPACE+"setAdd",accountDTO);
	}

	public int setDelete(Map<String, Object> map)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", map);
	}
	
}
