package br.com.clickfood.clickfoodapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "receita", schema = "clickfoodapi")
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_receita")
	private Long id;

	@Column(name = "nome_receita")
	private String nome;

	@Column(name = "tempo_preparo_receita")
	private Integer tempo;

	@Column(name = "serve_receita")
	private Integer serve;

	@Column(name = "kcal_receita")
	private Integer kcal;

	@Column(name = "modo_preparo_receita")
	private String preparo;

	@Column(name = "url_receita")
	private String url;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	@ManyToMany(mappedBy = "receitas")
	private List<Ingrediente> ingredientes = new ArrayList<>();

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

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public Integer getServe() {
		return serve;
	}

	public void setServe(Integer serve) {
		this.serve = serve;
	}

	public Integer getKcal() {
		return kcal;
	}

	public void setKcal(Integer kcal) {
		this.kcal = kcal;
	}

	public String getPreparo() {
		return preparo;
	}

	public void setPreparo(String preparo) {
		this.preparo = preparo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

}
