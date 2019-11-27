package br.com.alura.argentum.model;

import java.time.LocalDateTime;
import java.util.List;

public class CandlestickFactory {

	public Candlestick gerarCandlestickParaData(List<Negociacao> negociacoes, LocalDateTime data) {
		double abertura = negociacoes.get(0).getPreco();
		double fechamento = negociacoes.get(negociacoes.size() - 1).getPreco();
		
		double volume = 0;
		
		double minimo = negociacoes.get(0).getPreco();
		double maximo = negociacoes.get(0).getPreco();
		
		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();
			
			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			} else if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}
		}
		
		return new Candlestick(abertura, fechamento, maximo, minimo, volume, data);
	}
}
