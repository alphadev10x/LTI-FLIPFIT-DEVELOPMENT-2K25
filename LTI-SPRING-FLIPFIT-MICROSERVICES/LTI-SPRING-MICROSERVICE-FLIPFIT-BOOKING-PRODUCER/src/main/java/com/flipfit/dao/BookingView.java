/**
 * 
 */
package com.flipfit.dao;

import java.time.LocalDate;

/**
 * 
 */


public class BookingView {
 private Long centerId;
 private String slotName;
 private String firstName;
 private String lastName;
 private String bookDate;
 private Boolean bookingStatus;
 
 

 public BookingView() {
	super();
}



 /**
 * @return the centerId
 */
public Long getCenterId() {
	return centerId;
}



 /**
 * @param centerId the centerId to set
 */
 public void setCenterId(Long centerId) {
	this.centerId = centerId;
 }



 /**
 * @return the slotName
 */
 public String getSlotName() {
	return slotName;
 }



 /**
 * @param slotName the slotName to set
 */
 public void setSlotName(String slotName) {
	this.slotName = slotName;
 }



 /**
 * @return the firstName
 */
 public String getFirstName() {
	return firstName;
 }



 /**
 * @param firstName the firstName to set
 */
 public void setFirstName(String firstName) {
	this.firstName = firstName;
 }



 /**
 * @return the lastName
 */
 public String getLastName() {
	return lastName;
 }



 /**
 * @param lastName the lastName to set
 */
 public void setLastName(String lastName) {
	this.lastName = lastName;
 }



 /**
 * @return the bookDate
 */
 public String getBookDate() {
	return bookDate;
 }



 /**
 * @param bookDate the bookDate to set
 */
 public void setBookDate(String bookDate) {
	this.bookDate = bookDate;
 }



 /**
 * @return the bookingStatus
 */
 public Boolean getBookingStatus() {
	return bookingStatus;
 }



 /**
 * @param bookingStatus the bookingStatus to set
 */
 public void setBookingStatus(Boolean bookingStatus) {
	this.bookingStatus = bookingStatus;
 }



 public BookingView(Long centerId, String slotName, String firstName, String lastName,
                    String bookDate, Boolean bookingStatus) {
     this.centerId = centerId;
     this.slotName = slotName;
     this.firstName = firstName;
     this.lastName = lastName;
     this.bookDate = bookDate;
     this.bookingStatus = bookingStatus;
 }
}

 // getters

