package com.example.demo4;

public class User {

    private String login;
    private String passvord;
    private String time;
    private String money;




    public User(String login, String passvord) {
        this.login = login;
        this.passvord = passvord;
    }

    public User() {
        
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassvord() {
        return passvord;
    }

    public void setPassvord(String passvord) {
        this.passvord = passvord;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}