package br.com.clickfood.clickfoodapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clickfood.clickfoodapi.dto.ListaIngredientesComSelecao;
import br.com.clickfood.clickfoodapi.model.Ingrediente;
import br.com.clickfood.clickfoodapi.model.IngredienteReceita;
import br.com.clickfood.clickfoodapi.model.Receita;
import br.com.clickfood.clickfoodapi.repository.IngredienteReceitaRepository;
import br.com.clickfood.clickfoodapi.repository.IngredienteRepository;

@Service
public class ReceitaService {

	@Autowired
	private IngredienteRepository ingredientes;

	@Autowired
	private IngredienteReceitaRepository ingredientesReceitas;

	@Autowired
	private IngredienteService ingredienteService;

	public List<Receita> filtraReceitas(ListaIngredientesComSelecao listaIngredientesComSelecao) {
		List<Long> ids = ingredienteService.filtraSelecionados(listaIngredientesComSelecao.getIngredienteList());
		List<IngredienteReceita> listaIngredientesReceitas = ingredientesReceitas.findByIngrediente(ids);
		List<Ingrediente> listaIngredientes = ingredientes.findByIds(ids);
		List<Receita> receitas = new ArrayList<Receita>();
		for (IngredienteReceita ir : listaIngredientesReceitas) {
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

		return receitas;
	}

}
