/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class TaskDTO {
    private int ID;
    private String Desc;
    private Date EndDate;
    private int projectID;
    private int status;

    public TaskDTO() {
    }

    public TaskDTO(int ID, String Desc, Date EndDate, int projectID, int status) {
        this.ID = ID;
        this.Desc = Desc;
        this.EndDate = EndDate;
        this.projectID = projectID;
        this.status = status;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the Desc
     */
    public String getDesc() {
        return Desc;
    }

    /**
     * @param Desc the Desc to set
     */
    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    /**
     * @return the EndDate
     */
    public Date getEndDate() {
        return EndDate;
    }

    /**
     * @param EndDate the EndDate to set
     */
    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    /**
     * @return the projectID
     */
    public int getProjectID() {
        return projectID;
    }

    /**
     * @param projectID the projectID to set
     */
    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    
}
