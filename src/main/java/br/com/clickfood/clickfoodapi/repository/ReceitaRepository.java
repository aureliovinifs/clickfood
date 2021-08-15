package br.com.clickfood.clickfoodapi.repository;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clickfood.clickfoodapi.model.Receita;

@Repository
public class ReceitaRepository extends SimpleJpaRepository<Receita, Long> {

	public ReceitaRepository(EntityManager em) {
		super(Receita.class, em);
	}

}
