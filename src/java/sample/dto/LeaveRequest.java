/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class LeaveRequest {
    private int RequestID;
    private int UserID;
    private int LeaveTypeID;
    private Date StartDate;
    private Date EndDate;
    private String Reason;
    private String Status;

    public LeaveRequest() {
    }

    public LeaveRequest(int RequestID, int UserID, int LeaveTypeID, Date StartDate, Date EndDate, String Reason, String Status) {
        this.RequestID = RequestID;
        this.UserID = UserID;
        this.LeaveTypeID = LeaveTypeID;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.Reason = Reason;
        this.Status = Status;
    }

    public int getRequestID() {
        return RequestID;
    }

    public void setRequestID(int RequestID) {
        this.RequestID = RequestID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getLeaveTypeID() {
        return LeaveTypeID;
    }

    public void setLeaveTypeID(int LeaveTypeID) {
        this.LeaveTypeID = LeaveTypeID;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
}
