package com.company;

public class Instrument {
    private String name;
    private int count;

    Instrument(String name , int count){
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }
}
