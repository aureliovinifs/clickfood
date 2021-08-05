package br.com.clickfood.clickfoodapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clickfood.clickfoodapi.model.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

}
