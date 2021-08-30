package br.com.clickfood.clickfoodapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingrediente_receita", schema = "heroku_a130e8c74333e84")
public class IngredienteReceita {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ingrediente_receita")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "id_ingrediente")
	private Ingrediente ingrediente;
	
	@ManyToOne
    @JoinColumn(name = "id_receita")
	private Receita receita;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

}
