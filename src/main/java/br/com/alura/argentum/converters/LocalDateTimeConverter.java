package br.com.alura.argentum.converters;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class LocalDateTimeConverter implements Converter {

	@Override
	public boolean canConvert(Class clazz) {
		return clazz.isAssignableFrom(LocalDateTime.class);
	}

	@Override
	public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
		LocalDateTime data = (LocalDateTime) object;
		ZonedDateTime zonedDateTime = data.atZone(ZoneOffset.systemDefault());
		long milissegundos = zonedDateTime.toInstant().toEpochMilli();

		writer.startNode("time");
		writer.setValue(String.valueOf(milissegundos));
		writer.endNode();

		writer.startNode("timezone");
		writer.setValue(zonedDateTime.getZone().toString());
		writer.endNode();
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		reader.moveDown();
		String milissegundos = reader.getValue();
		reader.moveUp();

		reader.moveDown();
		String timeZone = reader.getValue();
		reader.moveUp();

		long dataMilissegundos = Long.parseLong(milissegundos);
		Instant instant = Instant.ofEpochMilli(dataMilissegundos);

		ZoneId zoneId = ZoneId.of(timeZone);
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneId);

		LocalDateTime data = zonedDateTime.toLocalDateTime();
		return data;
	}
}
