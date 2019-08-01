package org.mycompany;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AISMapper {

    public Map<String, Object> getMap(AIS ais) {
        Map<String, Object> answer = new HashMap<String, Object>();
        //answer.put("EmpId", ais.getEmpId());
        //answer.put("EmpName", ais.getEmpName());
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
