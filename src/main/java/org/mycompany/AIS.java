package org.mycompany;

//import java.sql.TimeStamp;

public class AIS {

  private float Longitude;
  private float Latitude;
  private float unused_z;
  private float SOG;
  private float COG;
  private short Heading;
  private short ROT;
  //private TimeStamp BaseDateTime;
  private String BaseDateTime;
  private short Status;
  private String VoyageID;
  private String MMSI;
  private String ReceiverType;
  private String ReceiverID;
  private String Destination;
  private short Cargo;
  private short Draught;
  //private TimeStamp ETA;
  private String ETA;
  //private TimeStamp StartTime;
  private String StartTime;
  //private TimeStamp EndTime;
  private String EndTime;
  private String unused_IMO;
  private String unused_CallSign;
  private String unused_Name;
  private String VesselType;
  private short VesselLength;
  private short VesselWidth;
  private String DimensionComponents;


  @Override
  public String toString() {
    return "AIS [lat=" + Latitude + ", lon=" + Longitude + ", sog=" + SOG + ", cog=" + COG + ", heading=" + Heading + ", rot=" + ROT + ", bdt=" + BaseDateTime + ", status=" + Status 
        + ", voyageId=" + VoyageID + ", mmsi=" + MMSI + ", receiverType=" + ReceiverType + ", receiverId=" + ReceiverID + ", dest=" + Destination + ", cargo=" + Cargo 
        + ", draught=" + Draught + ", eta=" + ETA + ", startTime=" + StartTime + ", endTime=" + EndTime + ", vesselType=" + VesselType + ", vesselLength=" + VesselLength 
        + ", vesselWidth=" + VesselWidth + ", dimComp=" + DimensionComponents + "]";
  }

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




}
