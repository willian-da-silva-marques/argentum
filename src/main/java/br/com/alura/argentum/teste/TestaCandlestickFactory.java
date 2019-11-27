package br.com.alura.argentum.teste;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import br.com.alura.argentum.model.Candlestick;
import br.com.alura.argentum.model.CandlestickFactory;
import br.com.alura.argentum.model.Negociacao;

public class TestaCandlestickFactory {

	public static void main(String[] args) {
	
		LocalDateTime hoje = LocalDateTime.now();
		
		Negociacao negociacao1 = new Negociacao(40.0, 100, hoje );
		Negociacao negociacao2 = new Negociacao(35.0, 100, hoje );
		Negociacao negociacao3 = new Negociacao(45.0, 100, hoje );
		Negociacao negociacao4 = new Negociacao(20.0, 100, hoje );
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);
		
		CandlestickFactory factory = new CandlestickFactory();
		
		Candlestick candle = factory.gerarCandlestickParaData(negociacoes, hoje);
		
		System.out.println(candle);
	}
}
