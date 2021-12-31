package com.company;

class RideRequest{
    private boolean start,end;
    private String date;
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public boolean getStart() {
        return start;
    }

    public boolean getEnd() {
        return end;
    }
}