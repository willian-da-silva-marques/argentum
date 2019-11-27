package br.com.alura.argentum.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public final class Negociacao implements Serializable {

	private static final long serialVersionUID = 9009706465419029862L;

	private final double preco;
	private final int quantidade;
	private final LocalDateTime data;

	public Negociacao(double preco, int quantidade, LocalDateTime data) {

		if (preco < 0) {
			throw new IllegalArgumentException("Preço deve ser maior ou igual a 0.");
		}

		if (quantidade < 1) {
			throw new IllegalArgumentException("Quantidade deve ser maior que 0.");
		}

		if (data == null) {
			throw new IllegalArgumentException("Data deve ser informada.");
		}

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

	public double getVolume() {
		return this.preco * this.quantidade;
	}
}