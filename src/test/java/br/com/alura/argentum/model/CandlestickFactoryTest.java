package br.com.alura.argentum.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

	@Test
	public void deveGerarTresCandlesticksDiferentesComBaseEmNegociacoesDeTresDiasDiferentes() {
		LocalDateTime hoje = LocalDateTime.now();
		LocalDateTime amanha = hoje.plusDays(1);
		LocalDateTime depoisDeAmanha = hoje.plusDays(2);

		Negociacao negociacao1 = new Negociacao(50.0, 20, hoje);
		Negociacao negociacao2 = new Negociacao(100.0, 20, hoje);
		Negociacao negociacao3 = new Negociacao(150.0, 20, hoje);

		Negociacao negociacao4 = new Negociacao(50.0, 100, amanha);
		Negociacao negociacao5 = new Negociacao(10.0, 20, amanha);

		Negociacao negociacao6 = new Negociacao(35.0, 20, depoisDeAmanha);
		Negociacao negociacao7 = new Negociacao(35.0, 20, depoisDeAmanha);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4, negociacao5,negociacao6, negociacao7);
		
		CandlestickFactory factory = new CandlestickFactory();
		
		List<Candlestick> candlesticks = factory.gerarCandlestick(negociacoes);
		
		assertEquals(3, candlesticks.size());
		
		assertTrue(negociacoes.get(0).isMesmoDia(candlesticks.get(0).getData()));
		assertTrue(negociacoes.get(3).isMesmoDia(candlesticks.get(1).getData()));
		assertTrue(negociacoes.get(5).isMesmoDia(candlesticks.get(2).getData()));
		
		assertEquals(6000.0, candlesticks.get(0).getVolume(), 0.0000001);
		assertEquals(50.0, candlesticks.get(0).getMinimo(), 0.0000001);
		assertEquals(150.0, candlesticks.get(0).getMaximo(), 0.0000001);
		assertEquals(50.0, candlesticks.get(0).getAbertura(), 0.0000001);
		assertEquals(150.0, candlesticks.get(0).getFechamento(), 0.0000001);
	}
}
