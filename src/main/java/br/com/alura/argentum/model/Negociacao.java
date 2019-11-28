package br.com.alura.argentum.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantidade;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Negociacao other = (Negociacao) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (quantidade != other.quantidade)
			return false;
		return true;
	}

	public boolean isMesmoDia(LocalDateTime data) {
		return this.data.getDayOfMonth() == data.getDayOfMonth() 
		&& this.data.getMonth() == data.getMonth()
		&& this.data.getYear() == data.getYear();
	}

	@Override
	public String toString() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
		return "{ \n"
					+ "\tpreco: " + numberFormat.format(preco) 
					+ "\n\tquantidade: " + quantidade 
					+ "\n\tdata: " + dateTimeFormatter.format(data) 
		  + " \n},";
	}
	
	
}