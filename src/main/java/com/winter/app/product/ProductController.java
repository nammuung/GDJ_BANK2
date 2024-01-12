package com.winter.app.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//annotation
@Controller
@RequestMapping("/product/*")
public class ProductController {
	@RequestMapping(value="add", method = RequestMethod.GET)
	public void setAdd()throws Exception{}
	
	@RequestMapping(value ="list", method = RequestMethod.GET)
	public void getList()throws Exception{
		
	}

}
