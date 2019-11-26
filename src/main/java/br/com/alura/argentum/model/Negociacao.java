package br.com.alura.argentum.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public final class Negociacao implements Serializable {

	private static final long serialVersionUID = 9009706465419029862L;
	
	private final double preco;
	private final int quantidade;
	private final LocalDateTime data;

	public Negociacao(double preco, int quantidade, LocalDateTime data) {
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public LocalDateTime getData() {
		return data;
	}
}