package br.com.clickfood.clickfoodapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clickfood.clickfoodapi.model.Ingrediente;

@Repository
public class IngredienteRepository extends SimpleJpaRepository<Ingrediente, Long> {

	public IngredienteRepository(EntityManager em) {
		super(Ingrediente.class, em);
	}

	public List<Ingrediente> findByIds(List<Long> ids) {
		return findAll((Root<Ingrediente> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			In<Long> in = cb.in(root.get("id"));
			ids.forEach(id -> in.value(id));
			return cb.and(in);
		});
	}

}
