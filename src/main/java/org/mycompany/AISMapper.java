package org.mycompany;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AISMapper {

    public Map<String, Object> getMap(AIS ais) {
        Map<String, Object> answer = new HashMap<String, Object>();

        answer.put("Longitude", ais.getLongitude());
        answer.put("Latitude", ais.getLatitude());
        answer.put("unused_z", ais.getunused_z());
        answer.put("SOG", ais.getSOG());
        answer.put("COG", ais.getCOG());
        answer.put("Heading", ais.getHeading());
        answer.put("ROT", ais.getROT());
        answer.put("BaseDateTime", ais.getBaseDateTime());
        answer.put("Status", ais.getStatus());
        answer.put("VoyageID", ais.getVoyageID());
        answer.put("MMSI", ais.getMMSI());
        answer.put("ReceiverType", ais.getReceiverType());
        answer.put("ReceiverID", ais.getReceiverID());
        answer.put("Destination", ais.getDestination());
        answer.put("Cargo", ais.getCargo());
        answer.put("Draught", ais.getDraught());
        answer.put("ETA", ais.getETA());
        answer.put("StartTime", ais.getStartTime());
        answer.put("EndTime", ais.getEndTime());
        answer.put("unused_IMO", ais.getunused_IMO());
        answer.put("unused_CallSign", ais.getunused_CallSign());
        answer.put("unused_Name", ais.getunused_Name());
        answer.put("VesselType", ais.getVesselType());
        answer.put("VesselLength", ais.getVesselLength());
        answer.put("VesselWidth", ais.getVesselWidth());
        answer.put("DimensionComponents", ais.getDimensionComponents());

        return answer;
    }

    public List<AIS> readAis(List<Map<String, String>> dataList) {

        System.out.println("data:" + dataList);

        List<AIS> aisList = new ArrayList<AIS>();

        for (Map<String, String> data : dataList) {

            AIS ais = new AIS();

            //ais.setEmpId(data.get("EmpId"));
            //ais.setEmpName(data.get("EmpName"));

            aisList.add(ais);
        }

        return aisList;
    }
}
