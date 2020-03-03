package com.example.loginproject;

public class BookingDate {

    private String checkindate;
    private String checkoutdate;

    public BookingDate() {
    }

    public BookingDate(String checkindate, String checkoutdate) {
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
    }

    public String getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(String checkindate) {
        this.checkindate = checkindate;
    }

    public String getCheckoutdate() {
        return checkoutdate;
    }

    public void setCheckoutdate(String checkoutdate) {
        this.checkoutdate = checkoutdate;
    }
}
