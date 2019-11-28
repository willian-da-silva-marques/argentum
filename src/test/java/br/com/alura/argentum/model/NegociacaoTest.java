package br.com.alura.argentum.model;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class NegociacaoTest {

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComPrecoNegativo() {
		new Negociacao(-20.0, 3, LocalDateTime.now());
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComDataNula() {
		new Negociacao(10.0, 2, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComQuantidadeInferiorAUm() {
		new Negociacao(10.0, 0, LocalDateTime.now());
	}
	
	@Test
	public void deveVerificarSeDuasNegociacoesDiferentesQueOcorreramNoMesmoSegundoPertencemAoMesmoDia() {
		LocalDateTime data = LocalDateTime.now();
		LocalDateTime agora = data;
		Negociacao negociacao = new Negociacao(100.0, 20, data);
		assertTrue(negociacao.isMesmoDia(agora));
	}
	
	@Test
	public void deveVerificarSeDuasNegociacoesDiferentesQueOcorreramEmHorariosDiferentesPertencemAoMesmoDia() {
		LocalDateTime data = LocalDateTime.of(2019,Month.NOVEMBER,28,8,00);
		LocalDateTime agora = LocalDateTime.of(2019,Month.NOVEMBER,28,9,00);;
		Negociacao negociacao = new Negociacao(100.0, 20, data);
		assertTrue(negociacao.isMesmoDia(agora));
	}
	
	@Test
	public void deveVerificarSeDuasNegociacoesDiferentesQueOcorreramEmMesesDiferentesNaoPertencemAoMesmoDia() {
		LocalDateTime data = LocalDateTime.of(2019,Month.NOVEMBER,28,8,00);
		LocalDateTime agora = LocalDateTime.of(2019,Month.DECEMBER,28,9,00);;
		Negociacao negociacao = new Negociacao(100.0, 20, data);
		assertFalse(negociacao.isMesmoDia(agora));
	}
	
	@Test
	public void deveVerificarSeDuasNegociacoesDiferentesQueOcorreramEmAnosDiferentesNaoPertencemAoMesmoDia() {
		LocalDateTime data = LocalDateTime.of(2019,Month.NOVEMBER,28,9,30);
		LocalDateTime agora = LocalDateTime.of(2020,Month.NOVEMBER,28,9,30);;
		Negociacao negociacao = new Negociacao(100.0, 20, data);
		assertFalse(negociacao.isMesmoDia(agora));
	}
}