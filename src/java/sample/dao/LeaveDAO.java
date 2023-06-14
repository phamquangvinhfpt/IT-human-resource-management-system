/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sample.dto.LeaveRequest;
import sample.dto.LeaveTypes;
import sample.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class LeaveDAO {

    public static List<LeaveTypes> getListLeaveType() {
        List<LeaveTypes> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.makeConnection();
            PreparedStatement ps = conn.prepareStatement("select * from LeaveTypes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LeaveTypes(rs.getInt(1), rs.getString(2)));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<LeaveRequest> getListLeaveRequest() throws Exception {
        List<LeaveRequest> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.makeConnection();
            PreparedStatement ps = conn.prepareStatement("select [UserID], [LeaveTypeID], [StartDate], [EndDate], [Reason], [Status], [time_req] from [dbo].[LeaveRequests]");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LeaveRequest(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean addLeaveRequest(LeaveRequest leaveRequest) throws Exception {
        try {
            Connection conn = DBUtils.makeConnection();
            PreparedStatement ps = conn.prepareStatement("insert into LeaveRequests values(?,?,?,?,?,?,?)");
            ps.setInt(2, leaveRequest.getLeaveTypeID());
            ps.setInt(1, leaveRequest.getUserID());
            ps.setDate(3, leaveRequest.getStartDate());
            ps.setDate(4, leaveRequest.getEndDate());
            ps.setString(5, leaveRequest.getReason());
            ps.setString(6, leaveRequest.getStatus());
            ps.setString(7, leaveRequest.getTime_req());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int getLeaveTypeId(String type) {
        int typeId = 0;
        try {
            Connection conn = DBUtils.makeConnection();
            PreparedStatement ps = conn.prepareStatement("select [LeaveTypeID] from [dbo].[LeaveTypes] where [LeaveTypeName] = ?");
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                typeId = rs.getInt(1);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return typeId;
    }
}
