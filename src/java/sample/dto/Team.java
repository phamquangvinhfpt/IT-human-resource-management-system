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
    private String Decription;

    public Team(int ID_Team, String Name_Team, int ID_Project, String Decription) {
        this.ID_Team = ID_Team;
        this.Name_Team = Name_Team;
        this.ID_Project = ID_Project;
        this.Decription = Decription;
    }

    public Team() {
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

    public String getDecription() {
        return Decription;
    }

    public void setDecription(String Decription) {
        this.Decription = Decription;
    }



   
}
