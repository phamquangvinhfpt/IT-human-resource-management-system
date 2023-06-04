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
public class Project {
    private int Id;
    private String NameProject;
    private Date StartDate;
    private Date EndDate;
    private String TechStack;
    private String Description;
    private int Status_id;

    public Project() {
    }

    public Project(int Id, String NameProject, Date StartDate, Date EndDate, String TechStack, String Description, int Status_id) {
        this.Id = Id;
        this.NameProject = NameProject;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.TechStack = TechStack;
        this.Description = Description;
        this.Status_id = Status_id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNameProject() {
        return NameProject;
    }

    public void setNameProject(String NameProject) {
        this.NameProject = NameProject;
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

    public String getTechStack() {
        return TechStack;
    }

    public void setTechStack(String TechStack) {
        this.TechStack = TechStack;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getStatus_id() {
        return Status_id;
    }

    public void setStatus_id(int Status_id) {
        this.Status_id = Status_id;
    }
    
}
