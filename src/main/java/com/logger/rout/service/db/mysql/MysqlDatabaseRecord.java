package com.logger.rout.service.db.mysql;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.logger.rout.service.db.DatabaseRecord;

@Entity
@Table(name = "ships_ais", schema = "testuser")
public class MysqlDatabaseRecord implements Serializable, DatabaseRecord {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5204942194717950587L;

	public MysqlDatabaseRecord() {
	}

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String Longitude;
  private String Latitude;
  private String unused_z;
  private String SOG;
  private String COG;
  private String Heading;
  private String ROT;
  private Date BaseDateTime;
  private String Status;
  private String VoyageID;
  private String MMSI;
  private String ReceiverType;
  private String ReceiverID;
  private String Destination;
  private String Cargo;
  private String Draught;
  private Date ETA;
  private Date StartTime;
  private Date EndTime;
  private String unused_IMO;
  private String unused_CallSign;
  private String unused_Name;
  private String VesselType;
  private String VesselLength;
  private String VesselWidth;
  private String DimensionComponents;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public Date getBaseDateTime() {
    return BaseDateTime;
  }

  public void setBaseDateTime(Date BaseDateTime) {
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

  public Date getETA() {
    return ETA;
  }

  public void setETA(Date ETA) {
    this.ETA = ETA;
  }

  public Date getStartTime() {
    return StartTime;
  }

  public void setStartTime(Date StartTime) {
    this.StartTime = StartTime;
  }

  public Date getEndTime() {
    return EndTime;
  }

  public void setEndTime(Date EndTime) {
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

  @Override
  public String toString() {
    return "AISRecord [lat=" + Latitude + ", lon=" + Longitude + ", sog=" + SOG + ", cog=" + COG + ", heading=" + Heading + ", rot=" + ROT + ", bdt=" + BaseDateTime + ", status=" + Status 
        + ", voyageId=" + VoyageID + ", mmsi=" + MMSI + ", receiverType=" + ReceiverType + ", receiverId=" + ReceiverID + ", dest=" + Destination + ", cargo=" + Cargo 
        + ", draught=" + Draught + ", eta=" + ETA + ", startTime=" + StartTime + ", endTime=" + EndTime + ", vesselType=" + VesselType + ", vesselLength=" + VesselLength 
        + ", vesselWidth=" + VesselWidth + ", dimComp=" + DimensionComponents + "]";
  }


}
