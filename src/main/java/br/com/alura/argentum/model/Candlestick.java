package br.com.alura.argentum.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public final class Candlestick implements Serializable {

	private static final long serialVersionUID = -256521810064610274L;

	private final double abertura;
	private final double fechamento;
	private final double maximo;
	private final double minimo;
	private final double volume;
	private final LocalDateTime data;
	
	public Candlestick(double abertura, double fechamento, double maximo, double minimo, double volume,	LocalDateTime data) {
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.maximo = maximo;
		this.minimo = minimo;
		this.volume = volume;
		this.data = data;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getVolume() {
		return volume;
	}

	public LocalDateTime getData() {
		return data;
	}
	
	public boolean isAlta() {
		return this.fechamento > this.abertura;
	}
	
	public boolean isBaixa() {
		return this.fechamento < this.abertura;
	}

	@Override
	public String toString() {
		return  "abertura: " + abertura 
					+ "\nfechamento: " + fechamento 
					+ "\nmaximo: " + maximo 
					+ "\nminimo:"	+ minimo 
					+ "\nvolume: " + volume 
					+ "\ndata: " + data;
	}
}