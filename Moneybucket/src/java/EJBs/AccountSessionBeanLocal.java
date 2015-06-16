/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import Entities.Account;
import javax.ejb.Local;

/**
 *
 * @author Shang
 */
@Local
public interface AccountSessionBeanLocal {

    Account getAccount(String username, String password);

    void updateTransactionList(Account account);

    String sayHello(String msg);

    Account RegisterNewAccount(String username, String password);
    
}
