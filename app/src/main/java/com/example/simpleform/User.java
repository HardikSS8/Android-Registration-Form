package com.example.simpleform;

public class User {

    int id;
    String first_name;
    String last_name;
    String gender;
    String email;
    String date_of_birth;
    String password;
    String sign_up_date;

    public User() {

    }

    public User(String first_name, String last_name, String gender, String email,
                String date_of_birth, String password, String sign_up_date) {

        this.first_name =first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.password = password;
        this.sign_up_date = sign_up_date;
    }
    public User(int id, String first_name, String last_name, String gender, String email,
                String date_of_birth, String password, String sign_up_date) {

        this.id = id;
        this.first_name =first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.password = password;
        this.sign_up_date = sign_up_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSignup_date() {
        return sign_up_date;
    }

    public void setSignup_date(String signup_date) {
        this.sign_up_date = signup_date;
    }

}
