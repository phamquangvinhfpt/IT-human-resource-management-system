/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

/**
 *
 * @author ADMIN
 */
public class TeamDTO {
    private int Team_Id;
    private String Team_name;
    private int project_id;
    private String decs;

    public TeamDTO() {
    }

    public TeamDTO(int Team_Id, String Team_name, int project_id, String decs) {
        this.Team_Id = Team_Id;
        this.Team_name = Team_name;
        this.project_id = project_id;
        this.decs = decs;
    }

    /**
     * @return the Team_Id
     */
    public int getTeam_Id() {
        return Team_Id;
    }

    /**
     * @param Team_Id the Team_Id to set
     */
    public void setTeam_Id(int Team_Id) {
        this.Team_Id = Team_Id;
    }

    /**
     * @return the Team_name
     */
    public String getTeam_name() {
        return Team_name;
    }

    /**
     * @param Team_name the Team_name to set
     */
    public void setTeam_name(String Team_name) {
        this.Team_name = Team_name;
    }

    /**
     * @return the project_id
     */
    public int getProject_id() {
        return project_id;
    }

    /**
     * @param project_id the project_id to set
     */
    public void setProject_id(int project_id) {
        this.project_id = project_id;
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
    
    
}
