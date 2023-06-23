/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

/**
 *
 * @author MY MSI
 */
public class Team {
    private int ID_Team;
    private String Name_Team;
    private int ID_Project;
    private int Leader_ID;
    private int status_ID;
    private String Decription;

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getID_Team() {
        return ID_Team;
    }

    public void setID_Team(int ID_Team) {
        this.ID_Team = ID_Team;
    }

    public String getName_Team() {
        return Name_Team;
    }

    public void setName_Team(String Name_Team) {
        this.Name_Team = Name_Team;
    }

    public int getID_Project() {
        return ID_Project;
    }

    public void setID_Project(int ID_Project) {
        this.ID_Project = ID_Project;
    }

    public int getLeader_ID() {
        return Leader_ID;
    }

    public void setLeader_ID(int Leader_ID) {
        this.Leader_ID = Leader_ID;
    }

    public int getStatus_ID() {
        return status_ID;
    }

    public void setStatus_ID(int status_ID) {
        this.status_ID = status_ID;
    }

    public String getDecription() {
        return Decription;
    }

    public void setDecription(String Decription) {
        this.Decription = Decription;
    }

    public Team(int ID_Team, String Name_Team, int ID_Project, int Leader_ID, int status_ID, String Decription) {
        this.ID_Team = ID_Team;
        this.Name_Team = Name_Team;
        this.ID_Project = ID_Project;
        this.Leader_ID = Leader_ID;
        this.status_ID = status_ID;
        this.Decription = Decription;
    }

    public Team() {
    }



   
}
