package com.logger.rout;

//import java.sql.TimeStamp;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord( separator = "," )
public class CSVRecord {

  @DataField(pos = 1)
  private String Longitude;
  @DataField(pos = 2)
  private String Latitude;
  @DataField(pos = 3)
  private String unused_z;
  @DataField(pos = 4)
  private String SOG;
  @DataField(pos = 5)
  private String COG;
  @DataField(pos = 6)
  private String Heading;
  @DataField(pos = 7)
  private String ROT;
  //private TimeStamp BaseDateTime;
  @DataField(pos = 8)
  private String BaseDateTime;
  @DataField(pos = 9)
  private String Status;
  @DataField(pos = 10)
  private String VoyageID;
  @DataField(pos = 11)
  private String MMSI;
  @DataField(pos = 12)
  private String ReceiverType;
  @DataField(pos = 13)
  private String ReceiverID;
  @DataField(pos = 14)
  private String Destination;
  @DataField(pos = 15)
  private String Cargo;
  @DataField(pos = 16)
  private String Draught;
  //private TimeStamp ETA;
  @DataField(pos = 17)
  private String ETA;
  //private TimeStamp StartTime;
  @DataField(pos = 18)
  private String StartTime;
  //private TimeStamp EndTime;
  @DataField(pos = 19)
  private String EndTime;
  @DataField(pos = 20)
  private String unused_IMO;
  @DataField(pos = 21)
  private String unused_CallSign;
  @DataField(pos = 22)
  private String unused_Name;
  @DataField(pos = 23)
  private String VesselType;
  @DataField(pos = 24)
  private String VesselLength;
  @DataField(pos = 25)
  private String VesselWidth;
  @DataField(pos = 26)
  private String DimensionComponents;


  @Override
  public String toString() {
    return "CSVRecord [lat=" + Latitude + ", lon=" + Longitude + ", sog=" + SOG + ", cog=" + COG + ", heading=" + Heading + ", rot=" + ROT + ", bdt=" + BaseDateTime + ", status=" + Status 
        + ", voyageId=" + VoyageID + ", mmsi=" + MMSI + ", receiverType=" + ReceiverType + ", receiverId=" + ReceiverID + ", dest=" + Destination + ", cargo=" + Cargo 
        + ", draught=" + Draught + ", eta=" + ETA + ", startTime=" + StartTime + ", endTime=" + EndTime + ", vesselType=" + VesselType + ", vesselLength=" + VesselLength 
        + ", vesselWidth=" + VesselWidth + ", dimComp=" + DimensionComponents + "]";
  }

  public String getLongitude() {
    return Longitude;
  }

  public void setLongitude(String Longitude) {
    this.Longitude = Longitude;
  }

  public String getLatitude() {
    return Latitude;
  }

  public void setLatitude(String Latitude) {
    this.Latitude = Latitude;
  }

  public String getunused_z() {
    return unused_z;
  }

  public void setunused_z(String unused_z) {
    this.unused_z = unused_z;
  }

  public String getSOG() {
    return SOG;
  }

  public void setSOG(String SOG) {
    this.SOG = SOG;
  }

  public String getCOG() {
    return COG;
  }

  public void setCOG(String COG) {
    this.COG = COG;
  }

  public String getHeading() {
    return Heading;
  }

  public void setHeading(String Heading) {
    this.Heading = Heading;
  }

  public String getROT() {
    return ROT;
  }

  public void setROT(String ROT) {
    this.ROT = ROT;
  }

  public String getBaseDateTime() {
    return BaseDateTime;
  }

  public void setBaseDateTime(String BaseDateTime) {
    this.BaseDateTime = BaseDateTime;
  }

  public String getStatus() {
    return Status;
  }

  public void setStatus(String Status) {
    this.Status = Status;
  }

  public String getVoyageID() {
    return VoyageID;
  }

  public void setVoyageID(String VoyageID) {
    this.VoyageID = VoyageID;
  }

  public String getMMSI() {
    return MMSI;
  }

  public void setMMSI(String MMSI) {
    this.MMSI = MMSI;
  }

  public String getReceiverType() {
    return ReceiverType;
  }

  public void setReceiverType(String ReceiverType) {
    this.ReceiverType = ReceiverType;
  }

  public String getReceiverID() {
    return ReceiverID;
  }

  public void setReceiverID(String ReceiverID) {
    this.ReceiverID = ReceiverID;
  }

  public String getDestination() {
    return Destination;
  }

  public void setDestination(String Destination) {
    this.Destination = Destination;
  }

  public String getCargo() {
    return Cargo;
  }

  public void setCargo(String Cargo) {
    this.Cargo = Cargo;
  }

  public String getDraught() {
    return Draught;
  }

  public void setDraught(String Draught) {
    this.Draught = Draught;
  }

  public String getETA() {
    return ETA;
  }

  public void setETA(String ETA) {
    this.ETA = ETA;
  }

  public String getStartTime() {
    return StartTime;
  }

  public void setStartTime(String StartTime) {
    this.StartTime = StartTime;
  }

  public String getEndTime() {
    return EndTime;
  }

  public void setEndTime(String EndTime) {
    this.EndTime = EndTime;
  }

  public String getunused_IMO() {
    return unused_IMO;
  }

  public void setunused_IMO(String unused_IMO) {
    this.unused_IMO = unused_IMO;
  }

  public String getunused_CallSign() {
    return unused_CallSign;
  }

  public void setunused_CallSign(String unused_CallSign) {
    this.unused_CallSign = unused_CallSign;
  }

  public String getunused_Name() {
    return unused_Name;
  }

  public void setunused_Name(String unused_Name) {
    this.unused_Name = unused_Name;
  }

  public String getVesselType() {
    return VesselType;
  }

  public void setVesselType(String VesselType) {
    this.VesselType = VesselType;
  }

  public String getVesselLength() {
    return VesselLength;
  }

  public void setVesselLength(String VesselLength) {
    this.VesselLength = VesselLength;
  }

  public String getVesselWidth() {
    return VesselWidth;
  }

  public void setVesselWidth(String VesselWidth) {
    this.VesselWidth = VesselWidth;
  }

  public String getDimensionComponents() {
    return DimensionComponents;
  }

  public void setDimensionComponents(String DimensionComponents) {
    this.DimensionComponents = DimensionComponents;
  }


}
