package common;

import views.DialogOk;

public class Account {

    private String name;
    private String level;
    private String username;
    private String password;
    private String contactNumber;
    private String lastLogin;


    public Account(String name, String level, String username, String password, String contactNumber) {
        this(name, level, username, password, contactNumber, "");
    }

    public Account(String name, String level, String username, String password, String contactNumber, String lastLogin) {
        this.name = name;
        this.level = level;
        this.username = username;
        this.password = password;
        this.contactNumber = contactNumber;
        this.lastLogin = lastLogin;
    }

    public void resetPassword(){
        this.password = "reset";
    }

    public void editInformation(String name, String contactNumber){
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public void editPassword(String oldpassword, String newpassword, String confirmPassword){
        if (!oldpassword.equals(this.password)){
            DialogOk dialogOk = new DialogOk("Edit Failed","Old password is incorrect.");
            dialogOk.setVisible(true);
            return;
        }

        if (newpassword.equals(confirmPassword)){
            // success
            this.password = newpassword;

            DialogOk dialogOk = new DialogOk("Edit Success","Account information has been updated.");
            dialogOk.setVisible(true);
        } else {
            DialogOk dialogOk = new DialogOk("Edit Failed","New Password & Confirm Password does not match.");
            dialogOk.setVisible(true);
        }

    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }
}