package com.smarthome;

class AirConditioningDevice extends HomeAppliance{

private Integer thermostatMode = 24;

 @Override
    public void turningOff(){
        thermostatMode =null;
        System.out.println("Toggle for Air conditioning turned off  with mode as null ");
     }
}