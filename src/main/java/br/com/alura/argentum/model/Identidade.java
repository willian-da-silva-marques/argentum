package br.com.alura.argentum.model;

import java.io.Serializable;

public class Identidade implements Serializable {

	private static final long serialVersionUID = 8244680981123001701L;

	private int numero;
	private String nome;
	private String nomeDaMae;
	private String nomeDoPai;
	private String estadoOndeNasceu;

	public Identidade(int numero, String nome, String nomeDaMae, String nomeDoPai, String estadoOndeNasceu) {
		if (numero <= 0) {
			throw new IllegalArgumentException("Número deve ser maior que 0.");
		}

		if (nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException("Nome é obrigatório");
		}

		if (nomeDaMae == null || nomeDaMae.isEmpty()) {
			throw new IllegalArgumentException("Nome da mãe é obrigatório");
		}

		if (nomeDoPai == null || nomeDoPai.isEmpty()) {
			throw new IllegalArgumentException("Nome do pai é obrigatório");
		}

		if (estadoOndeNasceu == null || estadoOndeNasceu.isEmpty()) {
			throw new IllegalArgumentException("Estado de nascimento é obrigatório");
		}

		this.numero = numero;
		this.nome = nome;
		this.nomeDaMae = nomeDaMae;
		this.nomeDoPai = nomeDoPai;
		this.estadoOndeNasceu = estadoOndeNasceu;
	}

	public int getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public String getNomeDaMae() {
		return nomeDaMae;
	}

	public String getNomeDoPai() {
		return nomeDoPai;
	}

	public String getEstadoOndeNasceu() {
		return estadoOndeNasceu;
	}

}