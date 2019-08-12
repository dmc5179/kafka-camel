package org.mycompany;

import org.springframework.stereotype.Component;


@Component
public class CsvToModelMapper {

//	private static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-mm-dd hh:mm:ss.SSS";
//	DateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS_SSS);

	public AISDatabaseRecord convertToPostgisModel(AISCSVRecord csv) {
          AISDatabaseRecord aisRec = new AISDatabaseRecord();
          aisRec.setLongitude(0);
          return aisRec;
	}
	
/*	
	private Date fromString(String dateString) {
		Date date = null;
		if (!StringUtils.isEmpty(dateString)) {
			try {
				date = dateFormat.parse(dateString);
			} catch (ParseException e) {
				date = null;
			}
		}
		return date;
	}
*/
}
