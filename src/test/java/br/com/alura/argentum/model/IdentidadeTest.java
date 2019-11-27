package br.com.alura.argentum.model;

import org.junit.Test;

public class IdentidadeTest {

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarIdentidadeComNumeroInvalido() {
		new Identidade(0, "Willian", "Maria", "João", "RS");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarIdentidadeComNomeInvalido() {
		new Identidade(0, null, "Maria", "João", "RS");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarIdentidadeComNomeMaeInvalido() {
		new Identidade(0, "Willian", null, "João", "RS");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarIdentidadeComNomePaiInvalido() {
		new Identidade(0, "Willian", "Maria", null, "RS");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarIdentidadeComEstadoDenascimentoInvalido() {
		new Identidade(0, "Willian", "Maria", "João", null);
	}
}
