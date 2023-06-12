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
    private String NameProject;
    private String Team_Name;
    private int ProjectId;
    private int Team_ID;
    private String Role;

    public User() {
    }

    public User(int UserID, String Name, String Image, String Phone, String Email, String Username, String Password, String Address, Date Birthday, String NameProject, String Team_Name, String Role) {
        this.UserID = UserID;
        this.Name = Name;
        this.Image = Image;
        this.Phone = Phone;
        this.Email = Email;
        this.Username = Username;
        this.Password = Password;
        this.Address = Address;
        this.Birthday = Birthday;
        this.NameProject = NameProject;
        this.Team_Name = Team_Name;
        this.Role = Role;
    }
    

    public User(int UserID, String Name, String Image, String Phone, String Email, String Username, String Password, String Address, Date Birthday, int ProjectId, int Team_ID, String Role) {
        this.UserID = UserID;
        this.Name = Name;
        this.Image = Image;
        this.Phone = Phone;
        this.Email = Email;
        this.Username = Username;
        this.Password = Password;
        this.Address = Address;
        this.Birthday = Birthday;
        this.ProjectId = ProjectId;
        this.Team_ID = Team_ID;
        this.Role = Role;
    }

    public User(String Name, String Image, String Phone, String Email, String Username, String Password, String Address, Date Birthday, int ProjectId, int Team_ID, String Role) {
        this.Name = Name;
        this.Image = Image;
        this.Phone = Phone;
        this.Email = Email;
        this.Username = Username;
        this.Password = Password;
        this.Address = Address;
        this.Birthday = Birthday;
        this.ProjectId = ProjectId;
        this.Team_ID = Team_ID;
        this.Role = Role;
    }

    public User(int UserID, String Name, String Image, String Phone, String Email, String Username, String Address, Date Birthday, int ProjectId, int Team_ID, String Role) {
        this.UserID = UserID;
        this.Name = Name;
        this.Image = Image;
        this.Phone = Phone;
        this.Email = Email;
        this.Username = Username;
        this.Address = Address;
        this.Birthday = Birthday;
        this.ProjectId = ProjectId;
        this.Team_ID = Team_ID;
        this.Role = Role;
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

    public String getNameProject() {
        return NameProject;
    }

    public void setNameProject(String NameProject) {
        this.NameProject = NameProject;
    }

    public String getTeam_Name() {
        return Team_Name;
    }

    public void setTeam_Name(String Team_Name) {
        this.Team_Name = Team_Name;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int ProjectId) {
        this.ProjectId = ProjectId;
    }

    public int getTeam_ID() {
        return Team_ID;
    }

    public void setTeam_ID(int Team_ID) {
        this.Team_ID = Team_ID;
    }
    
}
