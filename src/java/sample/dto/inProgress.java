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
public class inProgress {
    private int Task_id;
    private String Description_Task;
    private int Status_task;
    private int Team_id;
    private String Team_name;
    private String Description_team;

    public inProgress() {
    }

    public inProgress(int Task_id, String Description_Task, int Status_task, int Team_id, String Team_name, String Description_team) {
        this.Task_id = Task_id;
        this.Description_Task = Description_Task;
        this.Status_task = Status_task;
        this.Team_id = Team_id;
        this.Team_name = Team_name;
        this.Description_team = Description_team;
    }

    /**
     * @return the Task_id
     */
    public int getTask_id() {
        return Task_id;
    }

    /**
     * @param Task_id the Task_id to set
     */
    public void setTask_id(int Task_id) {
        this.Task_id = Task_id;
    }

    /**
     * @return the Description_Task
     */
    public String getDescription_Task() {
        return Description_Task;
    }

    /**
     * @param Description_Task the Description_Task to set
     */
    public void setDescription_Task(String Description_Task) {
        this.Description_Task = Description_Task;
    }

    /**
     * @return the Status_task
     */
    public int getStatus_task() {
        return Status_task;
    }

    /**
     * @param Status_task the Status_task to set
     */
    public void setStatus_task(int Status_task) {
        this.Status_task = Status_task;
    }

    /**
     * @return the Team_id
     */
    public int getTeam_id() {
        return Team_id;
    }

    /**
     * @param Team_id the Team_id to set
     */
    public void setTeam_id(int Team_id) {
        this.Team_id = Team_id;
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
     * @return the Description_team
     */
    public String getDescription_team() {
        return Description_team;
    }

    /**
     * @param Description_team the Description_team to set
     */
    public void setDescription_team(String Description_team) {
        this.Description_team = Description_team;
    }
    
    
}
