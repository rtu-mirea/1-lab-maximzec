package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Request {

    private List<RequestPart> parts = new ArrayList<RequestPart>();

    public List getParts(){
        return this.parts;
    }

    public void addPart(Instrument instrument, int time){
        parts.add(new RequestPart(instrument , time));
    }

    public int getAverallTime(){
        int averallTime = 0;
        for(RequestPart requestPart : parts){
            averallTime += requestPart.getTime();
        }
        return averallTime;
    }

    @Override
    public String toString() {
        return "Request{" +
                "parts=" + parts +
                '}';
    }
}
