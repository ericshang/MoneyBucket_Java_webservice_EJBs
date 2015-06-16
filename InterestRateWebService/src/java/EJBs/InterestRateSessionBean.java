/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import Entities.InterestRate;
import Globals.DB;
import Globals.RateType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.Singleton;
//import javax.ejb.Stateless;

/**
 *
 * @author Shang
 */
@Singleton
public class InterestRateSessionBean implements InterestRateSessionBeanLocal {

    @Override
    public ArrayList<InterestRate> getAllInterestRateList() {
        ArrayList<InterestRate> list;
        list = new ArrayList<InterestRate>();
        //get list from database
        DB db = new DB();
        String sql = "SELECT * FROM `interestrate`";
        ResultSet rs = db.query(sql);
        try{
            while(rs.next()){
                int iid = rs.getInt("iid");
                int month = rs.getInt("month");
                double rate = rs.getDouble("rate");
                RateType type = rs.getInt("type")==1 ? RateType.BORROW : RateType.SAVING;//1 == borrow, 0 == saving
                list.add(new InterestRate(iid, month, rate, type));
            }
        }catch(SQLException e){
        }
        //sort list by month
        list.sort(null);
        
        return list;
    }

    @Override
    public ArrayList<InterestRate> getInterestRateListByType(RateType type) {
        ArrayList<InterestRate> list,templist;
        list = new ArrayList<InterestRate>();
        templist = this.getAllInterestRateList();
        templist.stream().filter((ir) -> (ir.getType() == type)).forEach((ir) -> {
            list.add(ir);
        });
        return list;
    }

    @Override
    public InterestRate getInterestRateByMonth(RateType type, int month) {        
        ArrayList<InterestRate> listOfSameType = getInterestRateListByType(type);
        
        int sizeOfList = listOfSameType.size();
        
        for(int i =0; i < sizeOfList; i ++){
            InterestRate ir = listOfSameType.get(i);
            if( i< sizeOfList-1 ){
                if(month>= ir.getMonth() && month < listOfSameType.get(i+1).getMonth()){
                    return ir;
                }
            }else{
                if( month >= ir.getMonth()){
                    return ir;
                }
            }
        }
        return null;
    }
}
