package br.com.clickfood.clickfoodapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categoria", schema = "heroku_a130e8c74333e84")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_categoria")
	private Long id;

	@Column(name = "nome_categoria")
	private String nome;

	@JsonIgnore
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
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
