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
public class LeaveBalances {
    private int UserID;
    private int LeaveBalance;

    public LeaveBalances() {
    }

    public LeaveBalances(int UserID, int LeaveBalance) {
        this.UserID = UserID;
        this.LeaveBalance = LeaveBalance;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getLeaveBalance() {
        return LeaveBalance;
    }

    public void setLeaveBalance(int LeaveBalance) {
        this.LeaveBalance = LeaveBalance;
    }
    
}
