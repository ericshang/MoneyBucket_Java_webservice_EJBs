/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import EJBs.InterestRateSessionBeanLocal;
import Entities.InterestRate;
import Globals.RateType;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Shang
 */
@WebService(serviceName = "InterestRateWS")
public class InterestRateWS {
    @EJB
    private InterestRateSessionBeanLocal interestRateSessionBean;
    
    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getAllInterestRateList")
    public ArrayList<InterestRate> getAllInterestRateList() {
        ArrayList<InterestRate> list;
        list = interestRateSessionBean.getAllInterestRateList();        
        return list;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getBorrowRateList")
    public ArrayList<InterestRate> getBorrowRateList() {
        ArrayList<InterestRate> list;
        list = interestRateSessionBean.getInterestRateListByType(RateType.BORROW);        
        return list;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getSavingRateList")
    public ArrayList<InterestRate> getSavingRateList() {
        ArrayList<InterestRate> list;
        list = interestRateSessionBean.getInterestRateListByType(RateType.SAVING);        
        return list;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getSavingInterestRateByMonth")
    public InterestRate getSavingInterestRateByMonth(@WebParam(name = "month") int month){
        InterestRate rate;
        System.out.println("month is: "+month);
        rate = interestRateSessionBean.getInterestRateByMonth(RateType.SAVING, month);
        return rate;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getBorrowInterestRateByMonth")
    public InterestRate getBorrowInterestRateByMonth(@WebParam(name = "month") int month) {
        month = month ==0 ? 1 : month;
        InterestRate rate;
        rate = interestRateSessionBean.getInterestRateByMonth(RateType.BORROW, month);
        return rate;
    }
    
}
