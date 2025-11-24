package com.lti.filpfit.beans;

import java.time.LocalTime;
/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"Slot Details"
 */
public class Slot {
	
	
    private String slotId;
    private String centerId;
    private LocalTime time; // Note: Diagram used DateTime, Date is used here for simplicity
	public String getSlotId() {
		return slotId;
	}
	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public Slot() {
		super();
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
 

}
