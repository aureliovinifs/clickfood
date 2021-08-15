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

import br.com.clickfood.clickfoodapi.dto.IngredienteComSelecao;
import br.com.clickfood.clickfoodapi.dto.ListaIngredientesComSelecao;
import br.com.clickfood.clickfoodapi.model.Ingrediente;
import br.com.clickfood.clickfoodapi.model.IngredienteReceita;
import br.com.clickfood.clickfoodapi.model.Receita;
import br.com.clickfood.clickfoodapi.repository.IngredienteReceitaRepository;
import br.com.clickfood.clickfoodapi.repository.IngredienteRepository;

@RestController
@RequestMapping("/")
public class IngredienteController {

	@Autowired
	private IngredienteRepository ingredientes;

	@Autowired
	private IngredienteReceitaRepository ingredientesReceitas;

	@GetMapping
	public ModelAndView listar(Model model) {
		ListaIngredientesComSelecao wrapper = new ListaIngredientesComSelecao();
		wrapper.setIngredienteList(paraIngredientesComSelecao(ingredientes.findAll()));
		model.addAttribute("wrapper", wrapper);
		return new ModelAndView("index");
	}

	@PostMapping(value = "/pesquisar")
	public ModelAndView pesquisar(@ModelAttribute ListaIngredientesComSelecao wrapper, Model model) {
		List<Long> ids = filtraSelecionados(wrapper.getIngredienteList());
		List<IngredienteReceita> listaIngredientesReceitas = ingredientesReceitas.findByIngrediente(ids);
		List<Receita> receitas = filtraReceitas(listaIngredientesReceitas, ids);
		model.addAttribute("receitas", receitas);
		return new ModelAndView("receitas");
	}

		private List<Receita> filtraReceitas(List<IngredienteReceita> ingredientesReceitas, List<Long> idsIngrediente) {
			List<Ingrediente> listaIngredientes = ingredientes.findByIds(idsIngrediente);
			List<Receita> receitas = new ArrayList<Receita>();
			for (IngredienteReceita ir : ingredientesReceitas) {
				if (!receitas.contains(ir.getReceita())) {
					receitas.add(ir.getReceita());
					List<Boolean> teste = new ArrayList<Boolean>();
					for (Ingrediente i : ir.getReceita().getIngredientes()) {
						teste.add(listaIngredientes.contains(i));
					}
					if (teste.contains(false)) {
						receitas.remove(ir.getReceita());
					}
				}
			}

		/*
		 * if (!receitas.contains(ir.getReceita()) &&
		 * ir.getReceita().getIngredientes().containsAll(listaIngredientes)) {
		 * receitas.add(ir.getReceita()); }
		 */

		/*
		 * for (Long id : idsIngrediente) { if (ir.getIngrediente().getId().longValue()
		 * == id.longValue()) { receitas.add(ir.getReceita()); } else {
		 * receitas.remove(ir.getReceita()); } }
		 */

		return receitas;
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

	private List<Long> filtraSelecionados(ArrayList<IngredienteComSelecao> ingredientesComSelecao) {
		List<Long> ids = new ArrayList<Long>();
		for (IngredienteComSelecao is : ingredientesComSelecao) {
			if (is.getSelecionado())
				ids.add(is.getId());
		}
		return ids;
	}
}
