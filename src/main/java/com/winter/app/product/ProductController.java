package com.winter.app.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.util.Pager;

@Controller
@RequestMapping (value = "/product/*")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;


	//list
	@GetMapping("list")
	public String getList(Pager pager, Model model)throws Exception{
		List<ProductDTO> ar = productService.getList(pager);
		model.addAttribute("list", ar);
		return "product/list";
	}
	
	//detail
	@GetMapping("detail")
	public String getDetail(ProductDTO productDTO, Model model)throws Exception{
		productDTO = productService.getDetail(productDTO);
		model.addAttribute("productDTO", productDTO);
		return "product/detail";
	}
	
	//add
	@GetMapping("add")
	public String setAdd()throws Exception{
		return "product/add";
	}
	//add
	@PostMapping("add")
	public String setAdd(ProductDTO productDTO, MultipartFile [] attachs) throws Exception {
		int result = productService.setAdd(productDTO, attachs);
		return "redirect:./list";
	}
	
	//update
	@GetMapping("update")
	public String setUpdate(ProductDTO productDTO, Model model)throws Exception{
		productDTO = productService.getDetail(productDTO);
		model.addAttribute("productDTO", productDTO);
		return "product/update";
	}
	//update
	@PostMapping("update")
	public String setUpdate(ProductDTO productDTO, MultipartFile [] attachs)throws Exception{
		int result = productService.setUpdate(productDTO, attachs);
		return "redirect:./list";
		
	}
	
	//delete
	@PostMapping("delete")
	public String setDelete(ProductDTO productDTO)throws Exception{
	int result = productService.setDelete(productDTO);
	return "redirect:./list";
	}
	
}