/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import Entities.InterestRate;
import Globals.RateType;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Shang
 */
@Local
public interface InterestRateSessionBeanLocal {

    ArrayList<InterestRate> getAllInterestRateList();
    ArrayList<InterestRate> getInterestRateListByType(RateType type);

    InterestRate getInterestRateByMonth(RateType type, int month);
    
}
