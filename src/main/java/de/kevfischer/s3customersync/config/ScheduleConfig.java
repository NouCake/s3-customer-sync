package de.kevfischer.s3customersync.config;

import de.kevfischer.s3customersync.service.CustomerCSVService;
import de.kevfischer.s3customersync.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@EnableScheduling
public class ScheduleConfig {

    private final static long SCHEDULE_INTERVAL = 3 * 60 * 60 * 1000; //3 Hours in millis

    @Autowired private CustomerCSVService customerService;
    @Autowired private StorageService storageService;

    @Scheduled(fixedDelay = SCHEDULE_INTERVAL)
    public void testTask() {
        String csv = customerService.allCustomerAsCsvString();
        String key = "" + new SimpleDateFormat("'germany_'yyyy-MM-dd_HH-mm-ss").format(new Date());
        System.out.println("Storing Object: " + key);
        storageService.storeObject(key, csv);
    }

}
