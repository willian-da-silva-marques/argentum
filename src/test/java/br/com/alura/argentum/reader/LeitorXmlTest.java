package br.com.alura.argentum.reader;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.junit.Test;

import br.com.alura.argentum.model.Negociacao;

public class LeitorXmlTest {

	@Test
	public void deveCarregarXmlComApenasUmaNegociacao() {
		String xml =
				  "<list>\n"
				+ "   <negociacao>\n"
				+ "    <preco>10.0</preco>\n"
				+ "    <quantidade>4</quantidade>\n"
				+ "    <data>\n"
				+ "      <time>1569813960000</time>\n"
				+ "      <timezone>America/Sao_Paulo</timezone>\n"
				+ "    </data>\n"
				+ "  </negociacao>\n"
				+ "</list>";
		
		LeitorXml leitorXml = new LeitorXml();
		
		InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
		
		List<Negociacao> negociacoes = leitorXml.carregarNegociacoes(inputStream);
		
		Negociacao negociacaoExpected = new Negociacao(10.0, 4, LocalDateTime.of(2019, Month.SEPTEMBER, 30, 0, 26));
		
		assertEquals(1, negociacoes.size());
		
		assertEquals(negociacaoExpected, negociacoes.get(0));
	}
}