package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

/**
 * 首頁控制器
 * @author sam
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	RequestMappingInfoHandlerMapping requestMappingInfoHandlerMapping;

	/**
	 * @return
	 */
	@RequestMapping("/")
	public String getHome() {
		return "index2";
	}
	
}
