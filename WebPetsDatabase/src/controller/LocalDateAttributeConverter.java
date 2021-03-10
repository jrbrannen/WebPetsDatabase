/**
 * 
 */
package controller;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Mar 10, 2021
 */

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date>{

	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		// TODO Auto-generated method stub
		return (attribute == null ? null: Date.valueOf(attribute));
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbDate) {
		// TODO Auto-generated method stub
		return (dbDate == null ? null: dbDate.toLocalDate());
	}

}
