package br.com.clickfood.clickfoodapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.clickfood.clickfoodapi.repository.ReceitaRepository;

@RestController
@RequestMapping("receitas")
public class ReceitaController {

	@Autowired
	private ReceitaRepository repositorio;

	@GetMapping
	public ModelAndView listar(Model model) {
		/* CONSULTA RECEITAS CADASTRADAS */
		model.addAttribute("listareceitas", repositorio.findAll());

		/* RETORNA A VIEW */
		return new ModelAndView("receitas");
	}

}
