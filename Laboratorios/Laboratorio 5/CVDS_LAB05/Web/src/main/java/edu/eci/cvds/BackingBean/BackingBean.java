package edu.eci.cvds.BackingBean;

import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "guessBean")
@SessionScoped

public class BackingBean {
    
    private int number = (int) (Math.random()*10)+1;
    private int attempts = 0;
    private int accumPrize = 100000;
    private String gameStatus = "Good Luck";
    private ArrayList<Integer> lastAttempts = new ArrayList<Integer>();

    public BackingBean() {}

    public void guess(int atteptNum) {
        lastAttempts.add(atteptNum);
        setAttempts(getAttempts()+1);
        if (this.number == atteptNum) {
            setGameStatus("You Win");
        } else {
            setAccumPrize(getAccumPrize()-10000);
        }
    }

    public void restart() {
        getLastAttempts().clear();
        setGameStatus("Good Luck");
        setAttempts(0);
        setNumber((int) (Math.random()*10)+1);
        setAccumPrize(100000);
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int getAttempts() {
        return attempts;
    }
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
    public int getAccumPrize() {
        return accumPrize;
    }
    public void setAccumPrize(int accumPrize) {
        this.accumPrize = accumPrize;
    }
    public String getGameStatus() {
        return gameStatus;
    }
    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }
    
    public ArrayList<Integer> getLastAttempts() {
        return lastAttempts;
    }

    public void setLastAttempts(ArrayList<Integer> lastAttempts) {
        this.lastAttempts = lastAttempts;
    }

}
