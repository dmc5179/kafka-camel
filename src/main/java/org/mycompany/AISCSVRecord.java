package org.mycompany;

//import java.sql.TimeStamp;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord( separator = "," )
public class AISCSVRecord {

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
    return "AISRecord [lat=" + Latitude + ", lon=" + Longitude + ", sog=" + SOG + ", cog=" + COG + ", heading=" + Heading + ", rot=" + ROT + ", bdt=" + BaseDateTime + ", status=" + Status 
        + ", voyageId=" + VoyageID + ", mmsi=" + MMSI + ", receiverType=" + ReceiverType + ", receiverId=" + ReceiverID + ", dest=" + Destination + ", cargo=" + Cargo 
        + ", draught=" + Draught + ", eta=" + ETA + ", startTime=" + StartTime + ", endTime=" + EndTime + ", vesselType=" + VesselType + ", vesselLength=" + VesselLength 
        + ", vesselWidth=" + VesselWidth + ", dimComp=" + DimensionComponents + "]";
  }
/*
  public float getLongitude() {
    return Longitude;
  }

  public float getLatitude() {
    return Latitude;
  }

  public float getunused_z() {
    return unused_z;
  }

  public float getSOG() {
    return SOG;
  }

  public float getCOG() {
    return COG;
  }

  public short getHeading() {
    return Heading;
  }

  public short getROT() {
    return ROT;
  }

  public String getBaseDateTime() {
    return BaseDateTime;
  }

  public short getStatus() {
    return Status;
  }

  public String getVoyageID() {
    return VoyageID;
  }

  public String getMMSI() {
    return MMSI;
  }

  public String getReceiverType() {
    return ReceiverType;
  }

  public String getReceiverID() {
    return ReceiverID;
  }

  public String getDestination() {
    return Destination;
  }

  public short getCargo() {
    return Cargo;
  }

  public short getDraught() {
    return Draught;
  }

  public String getETA() {
    return ETA;
  }

  public String getStartTime() {
    return StartTime;
  }

  public String getEndTime() {
    return EndTime;
  }

  public String getunused_IMO() {
    return unused_IMO;
  }

  public String getunused_CallSign() {
    return unused_CallSign;
  }

  public String getunused_Name() {
    return unused_Name;
  }

  public String getVesselType() {
    return VesselType;
  }

  public short getVesselLength() {
    return VesselLength;
  }

  public short getVesselWidth() {
    return VesselWidth;
  }

  public String getDimensionComponents() {
    return DimensionComponents;
  }
*/
}
