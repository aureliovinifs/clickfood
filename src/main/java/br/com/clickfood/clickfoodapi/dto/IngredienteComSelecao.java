package br.com.clickfood.clickfoodapi.dto;

public class IngredienteComSelecao {

	private Boolean selecionado;
	private Long id;
	private String nome;

	public IngredienteComSelecao() {

	}

	public IngredienteComSelecao(Boolean selecionado, Long id, String nome) {
		super();
		this.selecionado = selecionado;
		this.id = id;
		this.nome = nome;
	}

	public Boolean getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Boolean selecionado) {
		this.selecionado = selecionado;
	}

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

}
