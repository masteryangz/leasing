package com.service;

import com.domain.House;

public class HouseService {
    private House[] houses;
    private int houseNums = 0;
    private int houseId = 0;
    public HouseService(int size){
        houses = new House[size];
    }

    public House findById(int Id) {
        for(int i = 0; i < houseNums; i++){
            if(houses[i].getId() == Id){
                return houses[i];
            }
        }
        return null;
    }

    public boolean del(int delId){
        int index = -1;
        for(int i = 0; i < houseNums; i++){
            if(delId == houses[i].getId()){
                index = i;
            }
        }
        if(index == -1) {
            return false;
        }
        for(int i = index; i < houseNums - 1; i++){
            houses[i] = houses[i+1];
        }
        houses[--houseNums] = null;
        return true;
    }

    public boolean add(House newHouse){
        if(houseNums == houses.length){
            House[] newHouses = new House[2*houses.length];
            for(int i = 0; i < houses.length; i++){
                newHouses[i] = houses[i];
            }
            houses = newHouses;
        }
        houses[houseNums++] = newHouse;
        newHouse.setId(++houseId);
        return true;
    }

    public House[] list(){
        return houses;
    }
    
}
