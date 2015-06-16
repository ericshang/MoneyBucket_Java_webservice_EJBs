/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Globals.RateType;

/**
 *
 * @author Shang
 */
public class InterestRate implements Comparable<InterestRate> {
    private int iid;
    private int month;
    private double rate;
    private RateType type;
    
    //constructor
    public InterestRate(int id, int month, double rate, RateType type){
        setIid(id);
        setMonth(month);
        setRate(rate);
        setType(type);
    }
    
    //getters
    public int getIid(){
        return iid;
    }
    public int getMonth(){
        return month;
    }
    public double getRate(){
        return rate;
    }
    public RateType getType(){
        return type;
    }
    
    //setters
    public void setIid(int id){
        this.iid = id;
    }
    public void setMonth(int m){
        this.month = m;
    }
    public void setRate(double rate){
        this.rate = rate;
    }
    public void setType(RateType t){
        this.type = t;
    }

    @Override
    public int compareTo(InterestRate t) {
        return this.getMonth() -t.getMonth();
    }
}
