package com.winter.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.files.FileDTO;
import com.winter.app.util.Pager;


@Repository
public class ProductDAO {
	
	
	@Autowired
	private SqlSession sqlSession;
	private final String namespace="com.winter.app.product.ProductDAO.";
	
	
	public List<ProductDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(namespace+"getList", pager);
	}
	
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception{
		return sqlSession.selectOne(namespace+"getDetail",productDTO);
	}

	public int setAdd(ProductDTO productDTO) throws Exception{
		return sqlSession.insert(namespace+"setAdd",productDTO);
	}
	public int setFileAdd(ProductFileDTO productFileDTO)throws Exception{
		return sqlSession.insert(namespace+"setFileAdd",productFileDTO);
	}
	

	public int setUpdate(ProductDTO productDTO) throws Exception{
		return sqlSession.update(namespace+"setUpdate", productDTO);
	}
	public int setDelete(ProductDTO productDTO) throws Exception{
		return sqlSession.delete(namespace+"setDelete", productDTO);
	}
	
	public Long getTotal(Pager pager)throws Exception{
		return sqlSession.selectOne(namespace+"getTotal",pager);
	}
	public List<ProductFileDTO> getListFiles(ProductDTO productDTO)throws Exception{
		return sqlSession.selectList(namespace+"getListFiles", productDTO);
	}
	
	
}
