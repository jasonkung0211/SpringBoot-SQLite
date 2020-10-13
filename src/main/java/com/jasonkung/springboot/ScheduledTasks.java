package com.jasonkung.springboot;


import com.jasonkung.springboot.model.Parking;
import com.jasonkung.springboot.model.ParkingMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private final ParkingMapper parkingMapper;

    public ScheduledTasks(ParkingMapper mapper) {
        this.parkingMapper = mapper;
    }

    @Scheduled(fixedDelay = 10000)
    public void syncData() {
        String resp = ParkingProvider.get("https://www.tsa.gov.tw/tsa/get_parkjason.aspx");
        String jsonString = resp.replace("[", "");
        jsonString = jsonString.replace("]", "");
        String[] jsonlist = jsonString.split("},");

        for (int i = 0; i < jsonlist.length; i++) {
            Parking temp = new Parking();
            temp.setName(jsonlist[i].subSequence(jsonlist[i].indexOf("\"停車場\":")+7, jsonlist[i].indexOf("\",")).toString());
            temp.setSpace(Integer.valueOf(jsonlist[i].replaceAll("\\D+","")));
            this.parkingMapper.insert(temp);
        }
    }

}
