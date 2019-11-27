package br.com.alura.argentum.model;

public class IdentidadeBuilder {

	private int numero;
	private String nome;
	private String nomeDaMae;
	private String nomeDoPai;
	private String estadoOndeNasceu;

	public IdentidadeBuilder setNumero(int numero) {
		this.numero = numero;
		return this;
	}

	public IdentidadeBuilder setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public IdentidadeBuilder setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
		return this;
	}

	public IdentidadeBuilder setNomeDoPai(String nomeDoPai) {
		this.nomeDoPai = nomeDoPai;
		return this;
	}

	public IdentidadeBuilder setEstadoOndeNasceu(String estadoOndeNasceu) {
		this.estadoOndeNasceu = estadoOndeNasceu;
		return this;
	}

	public Identidade build() {
		return new Identidade(numero, nome, nomeDaMae, nomeDoPai, estadoOndeNasceu);
	}
}
