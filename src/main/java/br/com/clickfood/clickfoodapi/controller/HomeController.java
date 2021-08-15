package br.com.clickfood.clickfoodapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/receitas")
	public String receitas() {
		return "receitas";
	}

	@RequestMapping("/sobre")
	public String sobre() {
		return "sobre";
	}

}
