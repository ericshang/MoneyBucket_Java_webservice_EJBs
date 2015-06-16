/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;

/**
 *
 * @author Shang
 */
public class Transaction implements Serializable {
    private int tid;
    private int aid;
    private double amount;
    private long time;
    private String note;
    
    //constructor
    public Transaction(int tid, int aid, double amount, long time, String note){
        setTid(tid);
        setAid(aid);
        setAmount(amount);
        setTime(time);
        setNote(note);
    }

    public int getTid() {
        return tid;
    }

    public int getAid() {
        return aid;
    }

    public double getAmount() {
        return amount;
    }

    public long getTime() {
        return time;
    }

    public String getNote() {
        return note;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
