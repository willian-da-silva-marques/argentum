package br.com.alura.argentum.converters;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.alura.argentum.model.Negociacao;

public class LocalDateTimeConverterTest {

	@Test
	public void deveConverterNegociacaoEmXmlComDataEmMilissegundos() {
		LocalDateTime hoje = LocalDateTime.now();
		Negociacao negociacao = new Negociacao(10.0, 4, hoje);
		
		XStream xStream = new XStream(new DomDriver());
		xStream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		
		String negociacaoXML = xStream.toXML(negociacao);
		
		String xmlExpected =
				"<negociacao>"
				+ " <preco>10.0</preco>"
				+ " <quantidade>4</quantidade>"
				+ " <data>"
				+ "   <time>1569542400000</time>"
				+ "   <timezone>Etc/UTC</timezone>"
				+ " </data>"
				+ "</negociacao>";
		
		assertEquals(xmlExpected, negociacaoXML);
	}
}