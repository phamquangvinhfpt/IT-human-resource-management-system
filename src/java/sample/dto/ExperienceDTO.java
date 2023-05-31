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
public class ExperienceDTO {
    private int ExperienceID;
    private String NameProject;
    private Date startDate;
    private Date endDate;
    private String techStack;

    public ExperienceDTO() {
    }

    public ExperienceDTO(int ExperienceID, String NameProject, Date startDate, Date endDate, String techStack) {
        this.ExperienceID = ExperienceID;
        this.NameProject = NameProject;
        this.startDate = startDate;
        this.endDate = endDate;
        this.techStack = techStack;
    }

    
    /**
     * @return the ExperienceID
     */
    public int getExperienceID() {
        return ExperienceID;
    }

    /**
     * @param ExperienceID the ExperienceID to set
     */
    public void setExperienceID(int ExperienceID) {
        this.ExperienceID = ExperienceID;
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
}
