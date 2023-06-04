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
public class Team {
    private int Team_ID;
    private String Team_Name;
    private int Project_id;
    private String Description;

    public Team() {
    }

    public Team(int Team_ID, String Team_Name, int Project_id, String Description) {
        this.Team_ID = Team_ID;
        this.Team_Name = Team_Name;
        this.Project_id = Project_id;
        this.Description = Description;
    }

    public int getTeam_ID() {
        return Team_ID;
    }

    public void setTeam_ID(int Team_ID) {
        this.Team_ID = Team_ID;
    }

    public String getTeam_Name() {
        return Team_Name;
    }

    public void setTeam_Name(String Team_Name) {
        this.Team_Name = Team_Name;
    }

    public int getProject_id() {
        return Project_id;
    }

    public void setProject_id(int Project_id) {
        this.Project_id = Project_id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
}
