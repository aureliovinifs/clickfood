package br.com.clickfood.clickfoodapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.clickfood.clickfoodapi.dto.ListaIngredientesComSelecao;
import br.com.clickfood.clickfoodapi.model.Receita;
import br.com.clickfood.clickfoodapi.service.ReceitaService;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

	@Autowired
	private ReceitaService receitaService;

	@GetMapping
	public String receitas() {
		return "receitas";
	}

	@PostMapping(value = "/pesquisar")
	public ModelAndView pesquisar(@ModelAttribute ListaIngredientesComSelecao listaIngredientesComSelecao,
			Model model) {
		List<Receita> receitas = receitaService.filtraReceitas(listaIngredientesComSelecao);
		model.addAttribute("receitas", receitas);
		return new ModelAndView("receitas");
	}

}
