package br.com.alura.argentum.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CandlestickFactoryTest {

	@Test
	public void deveGerarCandlestickParaSequenciaDeNegociacoesSimples() {
		LocalDateTime hoje = LocalDateTime.now();
		Negociacao negociacao1 = new Negociacao(40.0, 100, hoje);
		Negociacao negociacao2 = new Negociacao(35.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao4 = new Negociacao(20.0, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);

		CandlestickFactory factory = new CandlestickFactory();

		Candlestick candle = factory.gerarCandlestickParaData(negociacoes, hoje);

		assertEquals(20.0, candle.getMinimo(), 0.0000001);
		assertEquals(45.0, candle.getMaximo(), 0.0000001);
		assertEquals(40.0, candle.getAbertura(), 0.0000001);
		assertEquals(20.0, candle.getFechamento(), 0.0000001);
		assertEquals(14000.0, candle.getVolume(), 0.0000001);
	}
	
	@Test
	public void deveGerarCandlestickComApenasUmaNegociacao() {
		
		LocalDateTime data = LocalDateTime.now();
		
		Negociacao negociacao = new Negociacao(40.0, 100, data);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao);
		
		CandlestickFactory factory = new CandlestickFactory();
		
		Candlestick candle = factory.gerarCandlestickParaData(negociacoes, data);
		
		assertEquals(40.0, candle.getMinimo(), 0.0000001);
		assertEquals(40.0, candle.getMaximo(), 0.0000001);
		assertEquals(40.0, candle.getAbertura(), 0.0000001);
		assertEquals(40.0, candle.getFechamento(), 0.0000001);
		assertEquals(4000.0, candle.getVolume(), 0.0000001);
	}
	
	@Test
	public void deveGerarCandlestickComValoresZeradosQuandoNaoHouverNenhumaNegociacao() {
		
		LocalDateTime data = LocalDateTime.now();
		
		List<Negociacao> negociacoes = new ArrayList<>();
		
		CandlestickFactory factory = new CandlestickFactory();
		
		Candlestick candle = factory.gerarCandlestickParaData(negociacoes, data);
		
		assertEquals(0.0, candle.getMinimo(), 0.0000001);
		assertEquals(0.0, candle.getMaximo(), 0.0000001);
		assertEquals(0.0, candle.getAbertura(), 0.0000001);
		assertEquals(0.0, candle.getFechamento(), 0.0000001);
		assertEquals(0.0, candle.getVolume(), 0.0000001);
	}
}
