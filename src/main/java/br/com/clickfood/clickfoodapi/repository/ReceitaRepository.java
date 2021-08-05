package br.com.clickfood.clickfoodapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clickfood.clickfoodapi.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

}
