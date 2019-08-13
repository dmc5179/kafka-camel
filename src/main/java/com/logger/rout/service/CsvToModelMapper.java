package com.logger.rout.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.logger.rout.CSVRecord;
import com.logger.rout.service.db.mysql.MysqlDatabaseRecord;


@Component
public class CsvToModelMapper {

	private static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-mm-dd hh:mm:ss.SSS";
	DateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS_SSS);

	public MysqlDatabaseRecord convertToMysqlModel(CSVRecord csv) {
		MysqlDatabaseRecord databaseRec = new MysqlDatabaseRecord();
    databaseRec.setLongitude(csv.getLongitude());
databaseRec.setLatitude(csv.getLatitude());
databaseRec.setunused_z(csv.getunused_z());
databaseRec.setSOG(csv.getSOG());
databaseRec.setCOG(csv.getCOG());
databaseRec.setHeading(csv.getHeading());
databaseRec.setROT(csv.getROT());
databaseRec.setBaseDateTime(csv.getBaseDateTime());
databaseRec.setStatus(csv.getStatus());
databaseRec.setVoyageID(csv.getVoyageID());
databaseRec.setMMSI(csv.getMMSI());
databaseRec.setReceiverType(csv.getReceiverType());
databaseRec.setReceiverID(csv.getReceiverID());
databaseRec.setDestination(csv.getDestination());
databaseRec.setCargo(csv.getCargo());
databaseRec.setDraught(csv.getDraught());
databaseRec.setETA(csv.getETA());
databaseRec.setStartTime(csv.getStartTime());
databaseRec.setEndTime(csv.getEndTime());
databaseRec.setunused_IMO(csv.getunused_IMO());
databaseRec.setunused_CallSign(csv.getunused_CallSign());
databaseRec.setunused_Name(csv.getunused_Name());
databaseRec.setVesselType(csv.getVesselType());
databaseRec.setVesselLength(csv.getVesselLength());
databaseRec.setVesselWidth(csv.getVesselWidth());
databaseRec.setDimensionComponents(csv.getDimensionComponents());
		return databaseRec;
	}
	
	
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
}
