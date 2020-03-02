package com.example.loginproject;

public class Date {

    private String checkin, checkout;

    public Date(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Date() {
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
