package br.com.clickfood.clickfoodapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.clickfood.clickfoodapi.dto.IngredienteComSelecao;
import br.com.clickfood.clickfoodapi.model.Ingrediente;

@Service
public class IngredienteService {

	public List<Long> filtraSelecionados(ArrayList<IngredienteComSelecao> ingredientesComSelecao) {
		List<Long> ids = new ArrayList<Long>();
		for (IngredienteComSelecao is : ingredientesComSelecao) {
			if (is.getSelecionado())
				ids.add(is.getId());
		}
		return ids;
	}

	public ArrayList<IngredienteComSelecao> paraIngredientesComSelecao(List<Ingrediente> ingredientes) {
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
