package com.jasonkung.springboot;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jasonkung.springboot.model.Parking;
import com.jasonkung.springboot.model.ParkingMapper;
import okhttp3.ResponseBody;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduledTasks {

    private final ParkingMapper parkingMapper;

    public ScheduledTasks(ParkingMapper mapper) {
        this.parkingMapper = mapper;
    }

    @Scheduled(fixedDelay = 1000)
    public void syncData() {
        String resp = ParkingProvider.get("https://www.tsa.gov.tw/tsa/get_parkjason.aspx");
        Type listType = new TypeToken<ArrayList<Parking>>(){}.getType();
        List<Parking> entity = new Gson().fromJson(resp, listType);
        for (Parking parking : entity) {
            //System.out.println(parking.toString());
            this.parkingMapper.insert(parking);
        }
    }

}
