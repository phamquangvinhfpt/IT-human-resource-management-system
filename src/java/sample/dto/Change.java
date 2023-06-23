/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

/**
 *
 * @author Administrator
 */
public class Change {
    private boolean status;
    private String Email;
    private String Code;

    public Change() {
    }

    public Change(boolean status, String Email, String Code) {
        this.status = status;
        this.Email = Email;
        this.Code = Code;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Code
     */
    public String getCode() {
        return Code;
    }

    /**
     * @param Code the Code to set
     */
    public void setCode(String Code) {
        this.Code = Code;
    }

   
}

    
