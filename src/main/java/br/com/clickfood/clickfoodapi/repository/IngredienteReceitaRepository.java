package br.com.clickfood.clickfoodapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clickfood.clickfoodapi.model.IngredienteReceita;

@Repository
public class IngredienteReceitaRepository extends SimpleJpaRepository<IngredienteReceita, Long> {

	public IngredienteReceitaRepository(EntityManager em) {
		super(IngredienteReceita.class, em);
	}

	public List<IngredienteReceita> findByIngrediente(List<Long> ingredientes) {
		return findAll((Root<IngredienteReceita> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			In<Long> in = cb.in(root.get("ingrediente").get("id"));
			ingredientes.forEach(id -> in.value(id));
			return cb.and(in);
		});
	}

}
