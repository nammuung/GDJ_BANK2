package com.winter.app.board.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.winter.app.board.member.MemberDAO.";
	
	
	public int setJoin(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setJoin", memberDTO);
	}
	
	public int setAvatarAdd(AvatarDTO avatarDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAvatarAdd", avatarDTO);
	}
	
	public MemberDTO getDetail(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", memberDTO);
	}
	
	public String mypage(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"mypage", memberDTO);
	}
	
		
}