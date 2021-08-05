package br.com.clickfood.clickfoodapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ingrediente", schema = "clickfoodapi")
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ingrediente")
	private Long id;

	@Column(name = "nome_ingrediente")
	private String nome;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "ingrediente_receita", joinColumns = @JoinColumn(name = "id_ingrediente"), inverseJoinColumns = @JoinColumn(name = "id_receita"))
	private List<Receita> receitas = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

}
