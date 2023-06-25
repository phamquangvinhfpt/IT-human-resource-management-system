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
public class InforProjectOut {
    private ExperienedProject ep;
    private TeamDTO team;

    public InforProjectOut() {
    }

    public InforProjectOut(ExperienedProject ep, TeamDTO team) {
        this.ep = ep;
        this.team = team;
    }

    /**
     * @return the ep
     */
    public ExperienedProject getEp() {
        return ep;
    }

    /**
     * @param ep the ep to set
     */
    public void setEp(ExperienedProject ep) {
        this.ep = ep;
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
