/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Shang
 */
public class Account implements Serializable {
    private int aid;
    private String username;
    private String password;
    private long regtime;
    private ArrayList<Transaction> transactions;
    private double banlance;

    
    public Account(int aid, String username, String password, long regtime){
        setAid(aid);
        setUsername(username);
        setPassword(password);
        setRegtime(regtime);
        transactions = new ArrayList<Transaction>();//initialize arraylist
    }

    public int getAid() {
        return aid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public long getRegtime() {
        return regtime;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public double getBanlance() {
        return banlance;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegtime(long regtime) {
        this.regtime = regtime;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
        //!important set banlances
        this.setBanlance();
    }
    
    //extra methods
    public void addToTransactions(Transaction t){
        if(isTransactionsContains(t) == false){
            this.transactions.add(t);
            this.banlance += t.getAmount();//update banlace
        }
    }
    public void RemoveFromTransactions(Transaction t){
        int position = positionAtTransactionList(t);
        if(position>=0){
            this.transactions.remove(position);
            this.banlance -= t.getAmount();//update banlace
        }
    }
    //using list of transactions to set ballance
    private void setBanlance() {
        double num = 0;
        if(transactions.size()>0){
            for(Transaction t : transactions){
                num += t.getAmount();
            }
        }
        this.banlance = num;
    }    
    private boolean isTransactionsContains(Transaction t){
        if(this.transactions.size()>0){
            for(Transaction tempTransaction : this.transactions){
                if(tempTransaction.getTid() == t.getTid()){//if tid is the same
                    return true;
                }
            }
        }
        return false;
    }
    private int positionAtTransactionList(Transaction t){
        if(this.transactions.size()>0){
            int i=0;
            for(Transaction tempTransaction : this.transactions){
                if(tempTransaction.getTid() == t.getTid()){//if tid is the same
                    return i;
                }
                i++;
            }
        }
        return -1;
    }
}
