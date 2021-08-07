package br.com.clickfood.clickfoodapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.clickfood.clickfoodapi.model.Ingrediente;
import br.com.clickfood.clickfoodapi.repository.IngredienteRepository;

@RestController
@RequestMapping("/")
public class IngredienteController {

	@Autowired
	private IngredienteRepository repositorio;

	@GetMapping
	public ModelAndView listar(Model model) {
		ListaIngredientesComSelecao wrapper = new ListaIngredientesComSelecao();
		wrapper.setIngredienteList(paraIngredientesComSelecao(repositorio.findAll()));
		model.addAttribute("wrapper", wrapper);
		return new ModelAndView("index");
	}

	@PostMapping(value = "/pesquisar")
	public String pesquisar(@ModelAttribute ListaIngredientesComSelecao wrapper, Model model) {
		System.out.println(wrapper.getIngredienteList() != null ? wrapper.getIngredienteList().size() : "null list");
		System.out.println("--");
		model.addAttribute("wrapper", wrapper);
		return "index";
	}

	private ArrayList<IngredienteComSelecao> paraIngredientesComSelecao(List<Ingrediente> ingredientes) {
		ArrayList<IngredienteComSelecao> todosIngredientesComSelecao = new ArrayList<IngredienteComSelecao>();
		for (Ingrediente i : ingredientes) {
			IngredienteComSelecao is = new IngredienteComSelecao();
			is.setId(i.getId());
			is.setNome(i.getNome());
			is.setSelecionado(false);
			todosIngredientesComSelecao.add(is);
		}
		return todosIngredientesComSelecao;
	}
}
