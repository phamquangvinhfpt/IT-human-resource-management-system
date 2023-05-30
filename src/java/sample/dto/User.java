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
public class User {
    private int UserID;
    private String Name;
    private String Image;
    private String Phone;
    private String Email;
    private String Username;
    private String Password;
    private String Address;
    private Date Birthday;
    private int ExperienceId;
    private boolean Status;
    private String token;

    public User() {
    }

    public User(int UserID, String Name, String Image, String Phone, String Email, String Username, String Password, String Address, Date Birthday, int ExperienceId, boolean Status) {
        this.UserID = UserID;
        this.Name = Name;
        this.Image = Image;
        this.Phone = Phone;
        this.Email = Email;
        this.Username = Username;
        this.Password = Password;
        this.Address = Address;
        this.Birthday = Birthday;
        this.ExperienceId = ExperienceId;
        this.Status = Status;
    }
    
    

    public User(int UserID, String Name, String Image, String Phone, String Email, String Username, String Password, String Address, Date Birthday, int ExperienceId, boolean Status, String token) {
        this.UserID = UserID;
        this.Name = Name;
        this.Image = Image;
        this.Phone = Phone;
        this.Email = Email;
        this.Username = Username;
        this.Password = Password;
        this.Address = Address;
        this.Birthday = Birthday;
        this.ExperienceId = ExperienceId;
        this.Status = Status;
        this.token = token;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    public int getExperienceId() {
        return ExperienceId;
    }

    public void setExperienceId(int ExperienceId) {
        this.ExperienceId = ExperienceId;
    }
    
}
