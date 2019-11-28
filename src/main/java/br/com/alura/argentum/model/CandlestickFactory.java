package br.com.alura.argentum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CandlestickFactory {

	public Candlestick gerarCandlestickParaData(List<Negociacao> negociacoes, LocalDateTime data) {
		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(negociacoes.size() - 1).getPreco();
				
		double minimo = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double maximo = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		
		double volume = 0;
		
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

	public List<Candlestick> gerarCandlestick(List<Negociacao> negociacoes) {
		List<Candlestick> candlesticks = new ArrayList<>();
		
		List<Negociacao> negociacoesDoDia = new ArrayList<>();
		
		LocalDateTime data = negociacoes.get(0).getData();
		
		for (Negociacao negociacao : negociacoes) {
			if (negociacao.isMesmoDia(data)) {
				negociacoesDoDia.add(negociacao);
			} else {
				Candlestick candlestick = this.gerarCandlestickParaData(negociacoesDoDia, data);
				candlesticks.add(candlestick);
				negociacoesDoDia = new ArrayList<>();
				data = negociacao.getData();
			}
		}
		
		Candlestick candlestick = this.gerarCandlestickParaData(negociacoesDoDia, data);
		candlesticks.add(candlestick);
		
		return candlesticks;
	}
}