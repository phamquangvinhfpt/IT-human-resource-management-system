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
   private int ID_Experience;
    private String Decription;

    public Team() {
    }

    public Team(int ID_Team, String Name_Team, int ID_Experience, String Decription) {
        this.ID_Team = ID_Team;
        this.Name_Team = Name_Team;
        this.ID_Experience = ID_Experience;
        this.Decription = Decription;
    }

  

 



    public int getID_Team() {
        return ID_Team;
    }

    public void setID_Team(int ID_Team) {
        this.ID_Team = ID_Team;
    }

    public int getID_Experience() {
        return ID_Experience;
    }

    public void setID_Experience(int ID_Experience) {
        this.ID_Experience = ID_Experience;
    }

    public String getName_Team() {
        return Name_Team;
    }

    public void setName_Team(String Name_Team) {
        this.Name_Team = Name_Team;
    }

    public String getDecription() {
        return Decription;
    }

    public void setDecription(String Decription) {
        this.Decription = Decription;
    }

    @Override
    public String toString() {
        return "Team{" + "ID_Team=" + ID_Team + ", ID_Experience=" + ID_Experience + ", Name_Team=" + Name_Team + ", Decription=" + Decription + '}';
    }
    
}
