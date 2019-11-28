package br.com.alura.argentum.reader;

import java.io.InputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.alura.argentum.converters.LocalDateTimeConverter;
import br.com.alura.argentum.model.Negociacao;

@SuppressWarnings("unchecked")
public class LeitorXml {

	public List<Negociacao> carregarNegociacoes(InputStream inputStream) {
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("negociacao", Negociacao.class);
		xStream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		return (List<Negociacao>) xStream.fromXML(inputStream);
	}
}