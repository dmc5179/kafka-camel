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
    databaseRec.setLongitude(floatFromString(csv.getLongitude()));
    databaseRec.setLatitude(floatFromString(csv.getLatitude()));
    databaseRec.setunused_z(floatFromString(csv.getunused_z()));
    databaseRec.setSOG(floatFromString(csv.getSOG()));
    databaseRec.setCOG(floatFromString(csv.getCOG()));
    databaseRec.setHeading(shortFromString(csv.getHeading()));
    databaseRec.setROT(shortFromString(csv.getROT()));
    databaseRec.setBaseDateTime(dateFromString(csv.getBaseDateTime()));
    databaseRec.setStatus(shortFromString(csv.getStatus()));
    databaseRec.setVoyageID(csv.getVoyageID());
    databaseRec.setMMSI(csv.getMMSI());
    databaseRec.setReceiverType(csv.getReceiverType());
    databaseRec.setReceiverID(csv.getReceiverID());
    databaseRec.setDestination(csv.getDestination());
    databaseRec.setCargo(shortFromString(csv.getCargo()));
    databaseRec.setDraught(shortFromString(csv.getDraught()));
    databaseRec.setETA(dateFromString(csv.getETA()));
    databaseRec.setStartTime(dateFromString(csv.getStartTime()));
    databaseRec.setEndTime(dateFromString(csv.getEndTime()));
    databaseRec.setunused_IMO(csv.getunused_IMO());
    databaseRec.setunused_CallSign(csv.getunused_CallSign());
    databaseRec.setunused_Name(csv.getunused_Name());
    databaseRec.setVesselType(csv.getVesselType());
    databaseRec.setVesselLength(shortFromString(csv.getVesselLength()));
    databaseRec.setVesselWidth(shortFromString(csv.getVesselWidth()));
    databaseRec.setDimensionComponents(csv.getDimensionComponents());
    return databaseRec;
  }
	
	
  private Date dateFromString(String dateString) {
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

  private String floatFromString(String floatString) {
    String s = "NULL";
    if (!StringUtils.isEmpty(floatString)) {
      try {
        s = new Float(floatString).toString();
      } catch (NumberFormatException e) {
          s = "NULL";
      }
    }
    return s;
  }

  private String integerFromString(String intString) {
    String i = "NULL";
    if (!StringUtils.isEmpty(intString)) {
      try {
        i = Integer.decode(intString).toString();
      } catch (NumberFormatException e) {
          i = "NULL";
      }
    }
    return i;
  }

  private String shortFromString(String shortString) {
    String s = "NULL";
    if (!StringUtils.isEmpty(shortString)) {
      try {
        s = Short.decode(shortString).toString();
      } catch (NumberFormatException e) {
          s = "NULL";
      }
    }
    return s;
  }

}
