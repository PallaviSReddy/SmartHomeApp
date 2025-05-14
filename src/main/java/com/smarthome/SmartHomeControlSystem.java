package com.smarthome;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class SmartHomeControlSystem{

    private List<HomeAppliance> homeAppliances;

    public SmartHomeControlSystem(){

        homeAppliances = new ArrayList<>();
    }

    public void addHomeAppliance(HomeAppliance appliance){
        homeAppliances.add(appliance);
    }

    public void yearlyUpdate() {
        LocalDate toDay = LocalDate.now();
        if (toDay.getMonthValue() == 1 && toDay.getDayOfMonth() == 1) {
            System.out.println("Yearly Maintenance Update for all Home Devices");
            for (HomeAppliance app : homeAppliances) {
                app.turningOff();
            }
        }else{
                System.out.println("Yearly Maintenance is only ran on Jan 1st ");
            }
        }


        public static void main(String[] args){
            SmartHomeControlSystem smartHomeApp = new SmartHomeControlSystem();
            smartHomeApp.addHomeAppliance(new LightDevice());
            smartHomeApp.addHomeAppliance(new FanDevice());
            smartHomeApp.addHomeAppliance(new AirConditioningDevice());
            smartHomeApp.yearlyUpdate();

        }
    }