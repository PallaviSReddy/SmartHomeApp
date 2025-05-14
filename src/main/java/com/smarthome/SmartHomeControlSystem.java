package com.smarthome;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SmartHomeControlSystem{

    private List<HomeAppliance> homeAppliances;
    private boolean updateDone = false;

    public SmartHomeControlSystem(){

        homeAppliances = new ArrayList<>();
    }

    public void addHomeAppliance(HomeAppliance appliance){
        homeAppliances.add(appliance);
    }

    public void yearlyUpdate(LocalDateTime atm) {

        if(atm.getMonth() == Month.JANUARY &&
                atm.getDayOfMonth() == 1 &&
                atm.getHour() == 1 &&
                atm.getMinute() == 0 &&
                !updateDone){
           System.out.println("Yearly Maintenance Update for all Home Devices");
            for (HomeAppliance app : homeAppliances) {
                app.turningOff();
                updateDone = true;
            }
        }else{
                System.out.println(" Month is " + atm.getMonth() + " Yearly Maintenance is only ran on Jan 1st ");
                updateDone = false;
            }
        }


        public static void main(String[] args){
            SmartHomeControlSystem smartHomeApp = new SmartHomeControlSystem();
            smartHomeApp.addHomeAppliance(new LightDevice());
            smartHomeApp.addHomeAppliance(new FanDevice());
            smartHomeApp.addHomeAppliance(new AirConditioningDevice());

            // scheduling
            ScheduledExecutorService scheduleJob = Executors.newSingleThreadScheduledExecutor();
            Runnable runTask = () ->{
                LocalDateTime atm = LocalDateTime.now();
                smartHomeApp.yearlyUpdate(atm);
            };
            //LocalDateTime atm = LocalDateTime.of(2025, 1, 1, 1, 0);
            System.out.println("Calling Schedule job  " );
            scheduleJob.scheduleAtFixedRate(runTask, 0,60, TimeUnit.SECONDS);
            System.out.println("Schedule job is running " );


        }
    }