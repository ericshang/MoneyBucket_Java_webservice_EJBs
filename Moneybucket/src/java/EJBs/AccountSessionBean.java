/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import Entities.Account;
import Entities.Transaction;
import Globals.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author Shang
 */
@Stateless
public class AccountSessionBean implements AccountSessionBeanLocal {

    @Override
    public Account getAccount(String username, String password) {
        Account account;
        DB db = new DB();
        String sql = "SELECT * FROM `account` WHERE `username` = '"+username +"'"
                + " AND `password` = '"+password + "' ;";
        ResultSet rs = db.query(sql);
        try{
            if(rs.next()){
                int aid = rs.getInt("aid");
                String name = rs.getString("username");
                String pw = rs.getString("password");
                long regtime = rs.getInt("regtime")*1000;//in mil second
                account = new Account(aid, name, pw, regtime);
                this.updateTransactionList(account);
                return account;
            }
        }catch(SQLException e){
        }
        return null;
    }

    @Override
    public void updateTransactionList(Account account) {
        DB db = new DB();
        String sql = "SELECT * FROM `transaction` WHERE `aid` = '"+account.getAid()+"' ;";
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        ResultSet rs = db.query(sql);
        try{
            while(rs.next()){
                int tid = rs.getInt("tid");
                int aid = rs.getInt("aid");
                double amount = rs.getDouble("amount");
                int time = rs.getInt("time");//in mil seconds
                long timestamp = time*1000;
                String note = rs.getString("note");
                transactions.add(new Transaction(tid, aid, amount, timestamp, note));
            }
            account.setTransactions(transactions);
        }catch(SQLException e){
        }
    }
    

    @Override
    public String sayHello(String msg) {
        return msg;
    }

    @Override
    public Account RegisterNewAccount(String username, String password) {
        Account account = this.getAccount(username, password);
        
        //check if account existed!
        if(account!=null){//user existed
            return null;
        }else{//register a new user
            DB db = new DB();
            int rs =0;
            Date now = new Date();       
            long timestamp = now.getTime();
            String sql = "INSERT INTO `account` (`username`,`password`,`regtime`) "
                    + "VALUES('"+username+"', '"+password+"', '"+(timestamp/1000)+"');";
            
            rs = db.update(sql);
            //update account info
            if(rs>0){
                account = this.getAccount(username, password);
            }else{ 
                return null;
            }
        }
        return account;
    }
}
