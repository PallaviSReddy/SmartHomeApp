package com.smarthome;

class FanDevice extends HomeAppliance{
    private int fanSpeed = 1;

 @Override
    public void turningOff(){
        fanSpeed=0;
        System.out.println("Toggle for Fan switch turned off  with speed set as 0 ");
     }

}