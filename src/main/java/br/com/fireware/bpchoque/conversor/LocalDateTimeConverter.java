package br.com.fireware.bpchoque.conversor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
		
		return Timestamp.valueOf(attribute);
	}

	public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
		
		return dbData.toLocalDateTime();
	}

}
