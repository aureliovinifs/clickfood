package br.com.clickfood.clickfoodapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.clickfood.clickfoodapi.dto.ListaIngredientesComSelecao;
import br.com.clickfood.clickfoodapi.repository.IngredienteRepository;
import br.com.clickfood.clickfoodapi.service.IngredienteService;

@RestController
@RequestMapping("/")
public class IngredienteController {

	@Autowired
	private IngredienteRepository ingredientes;

	@Autowired
	private IngredienteService ingredienteService;

	@GetMapping
	public ModelAndView listar(Model model) {
		ListaIngredientesComSelecao listaIngredientesComSelecao = new ListaIngredientesComSelecao();
		listaIngredientesComSelecao
				.setIngredienteList(ingredienteService.paraIngredientesComSelecao(ingredientes.findAll()));
		model.addAttribute("listaIngredientesComSelecao", listaIngredientesComSelecao);
		return new ModelAndView("index");
	}

}
