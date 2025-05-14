package com.smarthome;

class LightDevice extends HomeAppliance{
private boolean switchOn = true;

   @Override
    public void turningOff(){
        switchOn =false;
        System.out.println("Toggle for Light switch");
     }
}