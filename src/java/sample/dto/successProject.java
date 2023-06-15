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
public class successProject {
    private ProjectManageDTO project;
    private TeamDTO team;

    public successProject() {
    }

    public successProject(ProjectManageDTO project, TeamDTO team) {
        this.project = project;
        this.team = team;
    }

    /**
     * @return the project
     */
    public ProjectManageDTO getProject() {
        return project;
    }

    /**
     * @param project the project to set
     */
    public void setProject(ProjectManageDTO project) {
        this.project = project;
    }

    /**
     * @return the team
     */
    public TeamDTO getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(TeamDTO team) {
        this.team = team;
    }
    
    
}
