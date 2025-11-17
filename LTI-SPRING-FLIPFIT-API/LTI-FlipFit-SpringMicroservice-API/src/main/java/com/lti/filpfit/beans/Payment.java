package com.lti.filpfit.beans;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"Payment Details"
 */
public class Payment {
	
	private String paymentId;
    private String bookingId;
    private Boolean amountPaid;
    
    public Payment() {
        // Public no-argument constructor
    }
 
    public String getPaymentId() {
        return paymentId;
    }
 
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
 
    public String getBookingId() {
        return bookingId;
    }
 
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
 
    public Boolean getAmountPaid() {
        return amountPaid;
    }
 
    public void setAmountPaid(Boolean amountPaid) {
        this.amountPaid = amountPaid;
    }

}
