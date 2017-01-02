package br.com.fireware.bpchoque.conversor;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

	public Date convertToDatabaseColumn(LocalDate attribute) {
		System.out.println("Valor de Atribute");
		return Date.valueOf(attribute);
	}

	public LocalDate convertToEntityAttribute(Date dbData) {
		
		return dbData.toLocalDate();
	}

}
