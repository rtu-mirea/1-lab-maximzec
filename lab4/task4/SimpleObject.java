package com.company;

import java.io.Serializable;

public class SimpleObject implements Serializable {
    private String name;
    private int count;



    public SimpleObject(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
       return this.name + "=" + this.count;
    }
}
