/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

/**
 *
 * @author Admin
 */
public class LeaveTypes {
    private int LeaveTypeID;
    private String LeaveTypeName;

    public LeaveTypes() {
    }

    public LeaveTypes(int LeaveTypeID, String LeaveTypeName) {
        this.LeaveTypeID = LeaveTypeID;
        this.LeaveTypeName = LeaveTypeName;
    }

    public int getLeaveTypeID() {
        return LeaveTypeID;
    }

    public void setLeaveTypeID(int LeaveTypeID) {
        this.LeaveTypeID = LeaveTypeID;
    }

    public String getLeaveTypeName() {
        return LeaveTypeName;
    }

    public void setLeaveTypeName(String LeaveTypeName) {
        this.LeaveTypeName = LeaveTypeName;
    }
    
}
