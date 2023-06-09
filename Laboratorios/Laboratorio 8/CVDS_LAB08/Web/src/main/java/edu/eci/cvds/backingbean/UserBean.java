package edu.eci.cvds.backingbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

@Component
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {
    
    private String userName;

    public UserBean () {}

    public String welcomeMessage() {
        return "Welcome " + getUserName() + " to Guess Game!";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
