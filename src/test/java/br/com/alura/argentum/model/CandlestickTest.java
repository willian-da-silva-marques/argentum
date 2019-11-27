package br.com.alura.argentum.model;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

public class CandlestickTest {

	@Test(expected = IllegalArgumentException.class)
	public void naoDevePermitirMaximoMenorDoQueMinimo() {
		CandlestickBuilder builder = new CandlestickBuilder();
		LocalDateTime data = LocalDateTime.now();
		Candlestick candlestick = builder
				.comAbertura(10.0)
				.comFechamento(30.00)
				.comMinimo(25.0)
				.comMaximo(15.0)
				.comVolume(200)
				.comData(data)
				.build();
		System.out.println(candlestick);
	}
	
	@Test
	public void deveRetornarEAltaSeFechamentoForIgualAAbertura() {
		CandlestickBuilder builder = new CandlestickBuilder();
		LocalDateTime data = LocalDateTime.now();
		Candlestick candlestick = builder
				.comAbertura(30.0)
				.comFechamento(30.00)
				.comMinimo(10.0)
				.comMaximo(50.0)
				.comVolume(200)
				.comData(data)
				.build();
		
		assertTrue(candlestick.isAlta());
	}
}