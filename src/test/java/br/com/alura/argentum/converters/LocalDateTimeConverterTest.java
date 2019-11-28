package br.com.alura.argentum.converters;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.alura.argentum.model.Negociacao;

public class LocalDateTimeConverterTest {

	@Test
	public void deveConverterNegociacaoEmXmlComDataEmMilissegundos() {
		LocalDateTime data = LocalDateTime.of(2019, Month.SEPTEMBER, 30, 0, 26);
		Negociacao negociacao = new Negociacao(10.0, 4, data);
		
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("negociacao", Negociacao.class);
		xStream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		
		String negociacaoXML = xStream.toXML(negociacao);
		
		String xmlExpected =
				"<negociacao>\n"
				+ "  <preco>10.0</preco>\n"
				+ "  <quantidade>4</quantidade>\n"
				+ "  <data>\n"
				+ "    <time>1569813960000</time>\n"
				+ "    <timezone>America/Sao_Paulo</timezone>\n"
				+ "  </data>\n"
				+ "</negociacao>";
		
		assertEquals(xmlExpected, negociacaoXML);
	}
	
	@Test
	public void deveConverterXmlEmNegociacaoComADataLocalDateTime() {
		LocalDateTime data = LocalDateTime.of(2019, Month.SEPTEMBER, 30, 0, 26);
		String xml =
				"<negociacao>\n"
				+ "  <preco>10.0</preco>\n"
				+ "  <quantidade>4</quantidade>\n"
				+ "  <data>\n"
				+ "    <time>1569813960000</time>\n"
				+ "    <timezone>America/Sao_Paulo</timezone>\n"
				+ "  </data>\n"
				+ "</negociacao>";
		
		Negociacao negociacaoExpected = new Negociacao(10.0, 4, data);
		
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("negociacao", Negociacao.class);
		xStream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		
		Negociacao negociacao = (Negociacao) xStream.fromXML(xml);
		
		assertEquals(negociacaoExpected, negociacao);
	}
}