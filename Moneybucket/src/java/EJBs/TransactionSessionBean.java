/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import Entities.Account;
import Entities.Transaction;
import Globals.DB;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author Shang
 */
@Stateless
public class TransactionSessionBean implements TransactionSessionBeanLocal {

    @Override
    public boolean AddNewTransaction(Transaction transaction) {
        boolean result = false;
        
        if(transaction.getTid()>0){//it is already in the db
            return false;
        }
        if(transaction.getAid() >0 && transaction.getAmount()!=0 ){//it is already in the db
            DB db = new DB();
            int aid = transaction.getAid();
            double amount = transaction.getAmount();
            Date now = new Date();       
            long timestamp = now.getTime()/1000;//in seconds
            String note = transaction.getNote();
            
            String sql = "INSERT INTO `transaction` (`aid`, `amount`,`time`,`note`)"
                    + "VALUES ('"+aid+"', '"+amount+"', '"+timestamp+"', '"+note+"');";
            int rs = db.update(sql);
            if(rs>0){
                result = true;
            }
        }
        
        return result;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
