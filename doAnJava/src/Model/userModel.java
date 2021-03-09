package Model;

import java.io.Serializable;

public class userModel implements Serializable {
    private String id;
    private String email;
    private String userName;
    private String passWord;
    private int roleID;

    public userModel() {
    }

    public userModel(String id, String email, String userName, String passWord, int roleID) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.passWord = passWord;
        this.roleID = roleID;
    }

    public userModel(String email, String userName, String passWord) {
        this.email = email;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
}
