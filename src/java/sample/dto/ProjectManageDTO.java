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
public class ProjectManageDTO {
    private int ProjectID;
    private String NameProject;
    private String startDate;
    private String endDate;
    private String techStack;
    private String decs;
    private int status;

    public ProjectManageDTO() {
    }

    public ProjectManageDTO(int ProjectID, String NameProject, String startDate, String endDate, String techStack, String decs, int status) {
        this.ProjectID = ProjectID;
        this.NameProject = NameProject;
        this.startDate = startDate;
        this.endDate = endDate;
        this.techStack = techStack;
        this.decs = decs;
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
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
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
