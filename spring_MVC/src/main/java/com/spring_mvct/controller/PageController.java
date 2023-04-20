package com.spring_mvct.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@GetMapping("/homepage")
	// http://localhost:8080/homepage
	public @ResponseBody String getHomePage() {
		return "PRIMA PAGINA SPRING WEB MVC!!!";
	}

	@GetMapping("/homepage/param")
	// http://localhost:8080/homepage/param?test=ciao
	public @ResponseBody String getHomePageQueryString(@RequestParam String test) {
		return "PRIMA PAGINA SPRING WEB MVC!!!" + test;
	}

	@GetMapping("/homepage/param/{test}")
	// http://localhost:8080/homepage/param/test
	public @ResponseBody String getHomePagePathParam(@PathVariable String test) {
		return "PRIMA PAGINA SPRING WEB MVC!!!" + test;
	}

	@GetMapping("/homepage/thymeleaf/page1/{test}")
	public String getHomePageThymeleaf(Map<String, Object> model, @PathVariable String test) {
		model.put("testParam1", test);
		return "pageTest";
	}

	@GetMapping("/homepage/thymeleaf/page2/{test}")
	public String getHomePageThymeleaf(ModelMap model, @PathVariable String test) {
		model.addAttribute("testParam2", test);
		return "pageTest";
	}

	@GetMapping("/homepage/thymeleaf/page3/{test}")
	public String getHomePageThymeleaf(Model model, @PathVariable String test) {
		model.addAttribute("testParams3", test);
		return "pageTest";
	}

	@GetMapping("/homepage/thymeleaf/page4/{test}")
	public ModelAndView getHomePageThymeleaf(@PathVariable String test) {
		ModelAndView model = new ModelAndView("pageTest");
		model.addObject("testParams4", test);
		return model;
	}

}
