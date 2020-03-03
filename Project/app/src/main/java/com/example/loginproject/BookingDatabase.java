package com.example.loginproject;

public class BookingDatabase {

    private String checkindate;
    private String checkoutdate;
    private Integer quantity1, quantity2, quantity3, quantity4;

    public BookingDatabase() {
    }

    public BookingDatabase(String checkindate, String checkoutdate) {
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

    public Integer getQuantity1() {
        return quantity1;
    }

    public void setQuantity1(Integer quantity1) {
        this.quantity1 = quantity1;
    }

    public Integer getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(Integer quantity2) {
        this.quantity2 = quantity2;
    }

    public Integer getQuantity3() {
        return quantity3;
    }

    public void setQuantity3(Integer quantity3) {
        this.quantity3 = quantity3;
    }

    public Integer getQuantity4() {
        return quantity4;
    }

    public void setQuantity4(Integer quantity4) {
        this.quantity4 = quantity4;
    }
}
