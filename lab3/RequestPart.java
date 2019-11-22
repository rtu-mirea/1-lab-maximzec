package com.company;

public class RequestPart {
    private Instrument instrument;
    private int time;
    private int startTime = 0;

    RequestPart(Instrument instrument , int time){
        this.instrument = instrument;
        this.time = time;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public int getTime() {
        return time;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
}
