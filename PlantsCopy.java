package com.company;

import java.util.Stack;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class PlantsCopy {

    public static void main(String[] args){
        System.out.println("Minimum radius : " + happyPlants());
    }

    static int happyPlants(){
        int [] plantSlots = {15,16};
        int [] showerSlots = {6,10,11};

        int minRadius = 0;
//        System.out.println("Minimum radius : " + getMinRadiusBtwnShowers(showerSlots));
//        System.out.println("Minimum radius : " + getMinRadiusShowerToFlower(plantSlots,showerSlots));
//        if (getMinRadiusBtwnShowers(showerSlots) > getMinRadiusShowerToFlower(plantSlots,showerSlots))
//            minRadius = getMinRadiusBtwnShowers(showerSlots);
//        else
        System.out.println(getMinRadiusShowerToFlower(plantSlots, showerSlots));
        minRadius = getMinRadiusShowerToFlower(plantSlots,showerSlots);
        return minRadius;
    }


    public static int getMinRadiusShowerToFlower(int [] plantSlots, int [] showerSlots) {
        int minRadius = 0, radius = 0;
        radius = abs(showerSlots[0]-plantSlots[0]);
        if (radius > minRadius)
            minRadius = radius;
        for (int i = 0; i < showerSlots.length-1; i++) {
            System.out.println("i : " + i);
            for (int j = 0; j < plantSlots.length; j++) {
                System.out.println("j : " + j);
                if (plantSlots[j] >= showerSlots[i] && plantSlots[j] <= showerSlots[i+1] ) {
                    if (plantSlots[j] - showerSlots[i] <= showerSlots[i+1] - plantSlots[j] ) {
                        radius = plantSlots[j] - showerSlots[i];
//                        System.out.println("Radius between showers : " + radius);
                    }
                }
                System.out.println("Radius : " + radius);
            }
        }
        if (abs(showerSlots[showerSlots.length-1]-plantSlots[plantSlots.length-1]) > radius) {
            radius = abs(showerSlots[showerSlots.length-1]-plantSlots[plantSlots.length-1]);
        }
        if (radius > minRadius)
            minRadius = radius;
        return minRadius;
    }


    private static int getMinRadiusBtwnShowers(int [] showerSlots) {
        int minRadius = 0;
        int radius = 0;
        for (int i = 0; i < showerSlots.length-1; i++) {
            radius = (int) Math.floor(abs((showerSlots[i]-showerSlots[i+1]))/2);
            if (radius > minRadius)
                minRadius = radius;
//            System.out.println(radius);
        }
        return minRadius;
    }
}