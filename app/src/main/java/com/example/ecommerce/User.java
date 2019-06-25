package com.example.ecommerce;
class User {
    String Displayname;
    String Password;

    String Email;
    long createdAt;

    public User (){};
    public User(String displayname,String email, String password,long createdAt){
        this.Displayname=displayname;
        this.Email=email;
        this.Password=password;
        this.createdAt=createdAt;
    }

    public User(String displayName, String userEmail, long time) {

    }


    public String getDisplayname() {
        return Displayname;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword(){
        return Password;
    }

    public long getCreatedAt() {
        return createdAt;
    }

}