
package WebServiceClient;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebService(name = "InterestRateWS", targetNamespace = "http://WS/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface InterestRateWS {


    /**
     * 
     * @return
     *     returns java.util.List<WebServiceClient.InterestRate>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllInterestRateList", targetNamespace = "http://WS/", className = "WebServiceClient.GetAllInterestRateList")
    @ResponseWrapper(localName = "getAllInterestRateListResponse", targetNamespace = "http://WS/", className = "WebServiceClient.GetAllInterestRateListResponse")
    @Action(input = "http://WS/InterestRateWS/getAllInterestRateListRequest", output = "http://WS/InterestRateWS/getAllInterestRateListResponse")
    public List<InterestRate> getAllInterestRateList();

    /**
     * 
     * @return
     *     returns java.util.List<WebServiceClient.InterestRate>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBorrowRateList", targetNamespace = "http://WS/", className = "WebServiceClient.GetBorrowRateList")
    @ResponseWrapper(localName = "getBorrowRateListResponse", targetNamespace = "http://WS/", className = "WebServiceClient.GetBorrowRateListResponse")
    @Action(input = "http://WS/InterestRateWS/getBorrowRateListRequest", output = "http://WS/InterestRateWS/getBorrowRateListResponse")
    public List<InterestRate> getBorrowRateList();

    /**
     * 
     * @param month
     * @return
     *     returns WebServiceClient.InterestRate
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSavingInterestRateByMonth", targetNamespace = "http://WS/", className = "WebServiceClient.GetSavingInterestRateByMonth")
    @ResponseWrapper(localName = "getSavingInterestRateByMonthResponse", targetNamespace = "http://WS/", className = "WebServiceClient.GetSavingInterestRateByMonthResponse")
    @Action(input = "http://WS/InterestRateWS/getSavingInterestRateByMonthRequest", output = "http://WS/InterestRateWS/getSavingInterestRateByMonthResponse")
    public InterestRate getSavingInterestRateByMonth(
        @WebParam(name = "month", targetNamespace = "")
        int month);

    /**
     * 
     * @return
     *     returns java.util.List<WebServiceClient.InterestRate>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSavingRateList", targetNamespace = "http://WS/", className = "WebServiceClient.GetSavingRateList")
    @ResponseWrapper(localName = "getSavingRateListResponse", targetNamespace = "http://WS/", className = "WebServiceClient.GetSavingRateListResponse")
    @Action(input = "http://WS/InterestRateWS/getSavingRateListRequest", output = "http://WS/InterestRateWS/getSavingRateListResponse")
    public List<InterestRate> getSavingRateList();

    /**
     * 
     * @param month
     * @return
     *     returns WebServiceClient.InterestRate
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBorrowInterestRateByMonth", targetNamespace = "http://WS/", className = "WebServiceClient.GetBorrowInterestRateByMonth")
    @ResponseWrapper(localName = "getBorrowInterestRateByMonthResponse", targetNamespace = "http://WS/", className = "WebServiceClient.GetBorrowInterestRateByMonthResponse")
    @Action(input = "http://WS/InterestRateWS/getBorrowInterestRateByMonthRequest", output = "http://WS/InterestRateWS/getBorrowInterestRateByMonthResponse")
    public InterestRate getBorrowInterestRateByMonth(
        @WebParam(name = "month", targetNamespace = "")
        int month);

}
