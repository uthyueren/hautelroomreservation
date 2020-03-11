package com.example.loginproject;

public class ClassBooking {

    private String checkinDate;
    private String checkoutDate;
    private Integer singleRoom, twinRoom, triRoom, quadRoom;

    public ClassBooking() {
    }

    public ClassBooking(String checkindate, String checkoutdate, Integer singleRoom, Integer twinRoom, Integer triRoom, Integer quadRoom) {
        this.checkinDate = checkindate;
        this.checkoutDate = checkoutdate;
        this.singleRoom = singleRoom;
        this.twinRoom = twinRoom;
        this.triRoom = triRoom;
        this.quadRoom = quadRoom;
    }

    public String getCheckindate() {
        return checkinDate;
    }

    public void setCheckindate(String checkindate) {
        this.checkinDate = checkindate;
    }

    public String getCheckoutdate() {
        return checkoutDate;
    }

    public void setCheckoutdate(String checkoutdate) {
        this.checkoutDate = checkoutdate;
    }

    public Integer getSingleRoom() {
        return singleRoom;
    }

    public void setSingleRoom(Integer singleRoom) {
        this.singleRoom = singleRoom;
    }

    public Integer getTwinRoom() {
        return twinRoom;
    }

    public void setTwinRoom(Integer twinRoom) {
        this.twinRoom = twinRoom;
    }

    public Integer getTriRoom() {
        return triRoom;
    }

    public void setTriRoom(Integer triRoom) {
        this.triRoom = triRoom;
    }

    public Integer getQuadRoom() {
        return quadRoom;
    }

    public void setQuadRoom(Integer quadRoom) {
        this.quadRoom = quadRoom;
    }
}
