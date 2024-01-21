package com.winter.app.product;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;



import com.winter.app.util.FileManager;
import com.winter.app.util.Pager;


@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private ServletContext servletContext;

	
	// Delte
	public int setDelete(ProductDTO productDTO) throws Exception{
		List<ProductFileDTO> ar= productDAO.getListFiles(productDTO);
		String path = servletContext.getRealPath("/resources/upload/product/");
		for(ProductFileDTO p : ar) {
			fileManager.fileDelete(path, p.getFileName());
		}
		int result = productDAO.setDelete(productDTO);
		return result;
	}
	
	// update
	public int setUpdate(ProductDTO productDTO, MultipartFile [] attachs)throws Exception{
		return productDAO.setUpdate(productDTO);
	}
	
	public int setAdd(ProductDTO productDTO, MultipartFile [] attachs) throws Exception{
		// 글 등록
		int result = productDAO.setAdd(productDTO);
		
		//저장, 경로
		String path = servletContext.getRealPath("/resources/upload/product/");
		
		// HDD저장 파일명 받기
		for(MultipartFile f : attachs) {
			if(f.isEmpty()) {
				continue;
			}
		
		String fileName = fileManager.fileSave(path, f);
		//DB저장
		ProductFileDTO productFileDTO = new ProductFileDTO();
		productFileDTO.setFileName(fileName);
		productFileDTO.setOriName(f.getOriginalFilename());
		productFileDTO.setProductNum(productDTO.getProductNum());
		result = productDAO.setFileAdd(productFileDTO);
		}
		return result;
	}
	
	public List<ProductDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		Long totalCount = productDAO.getTotal(pager);
		System.out.println(totalCount);
		pager.makeNum(totalCount);
		List<ProductDTO> ar = this.productDAO.getList(pager);
		return ar;

	}
	
	public ProductDTO getDetail(ProductDTO productDTO)throws Exception{
		return productDAO.getDetail(productDTO);
	}

	
	
	

}