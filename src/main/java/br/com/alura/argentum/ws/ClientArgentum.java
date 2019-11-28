package br.com.alura.argentum.ws;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import br.com.alura.argentum.model.Negociacao;
import br.com.alura.argentum.reader.LeitorXml;

public class ClientArgentum {
	
	public static final String URL_WS_ARGENTUM_NEGOCIACOES = "http://argentumws.caelum.com.br/negociacoes";

	public List<Negociacao> getNegociacoes() {
		HttpURLConnection httpURLConnection = null;
		try {
			URL url = new URL(URL_WS_ARGENTUM_NEGOCIACOES);
			httpURLConnection = (HttpURLConnection) url.openConnection();
			InputStream inputStream = httpURLConnection.getInputStream();
			return new LeitorXml().carregarNegociacoes(inputStream);
		} catch (IOException ex) {
			throw new RuntimeException(ex.getMessage());
		}
		finally {
			httpURLConnection.disconnect();
		}
	}
	
	public static void main(String[] args) {
		ClientArgentum clientArgentum = new ClientArgentum();
		List<Negociacao> negociacoes = clientArgentum.getNegociacoes();
		negociacoes.stream().forEach(System.out::println);
	}
}