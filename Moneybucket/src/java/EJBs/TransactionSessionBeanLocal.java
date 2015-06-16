/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import Entities.Account;
import Entities.Transaction;
import javax.ejb.Local;

/**
 *
 * @author Shang
 */
@Local
public interface TransactionSessionBeanLocal {

    boolean AddNewTransaction(Transaction transaction);
    
}
