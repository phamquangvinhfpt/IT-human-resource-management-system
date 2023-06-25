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
public class ExperienedProject {
    private int ProjectID;
    private String NameProject;
    private Date startDate;
    private Date endDate;
    private String techStack;
    private String decs;
    private int team_id;
    private int status;

    public ExperienedProject() {
    }

    public ExperienedProject(int ProjectID, String NameProject, Date startDate, Date endDate, String techStack, String decs, int team_id, int status) {
        this.ProjectID = ProjectID;
        this.NameProject = NameProject;
        this.startDate = startDate;
        this.endDate = endDate;
        this.techStack = techStack;
        this.decs = decs;
        this.team_id = team_id;
        this.status = status;
    }

    /**
     * @return the ProjectID
     */
    public int getProjectID() {
        return ProjectID;
    }

    /**
     * @param ProjectID the ProjectID to set
     */
    public void setProjectID(int ProjectID) {
        this.ProjectID = ProjectID;
    }

    /**
     * @return the NameProject
     */
    public String getNameProject() {
        return NameProject;
    }

    /**
     * @param NameProject the NameProject to set
     */
    public void setNameProject(String NameProject) {
        this.NameProject = NameProject;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the techStack
     */
    public String getTechStack() {
        return techStack;
    }

    /**
     * @param techStack the techStack to set
     */
    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    /**
     * @return the decs
     */
    public String getDecs() {
        return decs;
    }

    /**
     * @param decs the decs to set
     */
    public void setDecs(String decs) {
        this.decs = decs;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
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
