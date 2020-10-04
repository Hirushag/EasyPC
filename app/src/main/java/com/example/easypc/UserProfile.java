package com.example.easypc;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor

public class UserProfile {
    public String userName;
    public String userAddress;
    public String userEmail;
    public String userContact;

    public UserProfile(){

    }


    public UserProfile(String userName, String userAddress, String userEmail, String userContact) {
        this.userName = userName;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userContact = userContact;
        ;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }


}
