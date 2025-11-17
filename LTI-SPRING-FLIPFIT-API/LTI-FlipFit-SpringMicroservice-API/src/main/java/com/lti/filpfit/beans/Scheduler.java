package com.lti.filpfit.beans;


import java.util.Date;
/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"Scheduler Details"
 */
public class Scheduler {
	
	private String scheduleId;
    private String slotId;
    private String centerId;
    private Date time; // Note: Diagram used DateTime, Date is used here for simplicity
    private Date date;
 
    public Scheduler() {
        // Public no-argument constructor
    }
 
    public String getScheduleId() {
        return scheduleId;
    }
 
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }
 
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
 
  
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getDate() {
        return date;
    }
 
    public void setDate(Date date) {
        this.date = date;
    }

}
