package org.mycompany;

//import java.sql.TimeStamp;

public class AIS {

  private String empId;
  private String empName;

  private float Longitude;
  private float Latitude;
  private float unused_z;
  private float SOG;
  private float COG;
  private short Heading;
  private short ROT;
  //private TimeStamp BaseDateTime;
  private short Status;
  private String VoyageID;
  private String MMSI;
  private String ReceiverType;
  private String ReceiverID;
  private String Destination;
  private short Cargo;
  private short Draught;
  //private TimeStamp ETA;
  //private TimeStamp StartTime;
  //private TimeStamp EndTime;
  private String unused_IMO;
  private String unused_CallSign;
  private String unused_Name;
  private String VesselType;
  private short VesselLength;
  private short VesselWidth;
  private String DimensionComponents;


  @Override
  public String toString() {
    return "Employee [lat=" + Latitude + ", lon=" + Longitude + "]";
  }

}
