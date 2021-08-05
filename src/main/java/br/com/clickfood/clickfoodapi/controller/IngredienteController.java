package br.com.clickfood.clickfoodapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.clickfood.clickfoodapi.repository.IngredienteRepository;

@RestController
@RequestMapping("/")
public class IngredienteController {

	@Autowired
	private IngredienteRepository repositorio;
	

	@GetMapping
	public ModelAndView listar(Model model) {
		/* LISTAR INGREDIENTES CADASTRADAS */
		model.addAttribute("listaingredientes", repositorio.findAll());

		/* RETORNA A VIEW */
		return new ModelAndView("index");
	}

	@PostMapping(value = "/pesquisar", params = "lista-ingredientes")
	public String pesquisar(@ModelAttribute ArrayList<Long> ingredienteIds) {
		

		return "lista-ingredientes";
	}
}
