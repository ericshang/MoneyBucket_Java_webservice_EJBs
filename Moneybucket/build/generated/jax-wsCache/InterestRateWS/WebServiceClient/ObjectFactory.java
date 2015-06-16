
package WebServiceClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the WebServiceClient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetSavingInterestRateByMonth_QNAME = new QName("http://WS/", "getSavingInterestRateByMonth");
    private final static QName _GetSavingInterestRateByMonthResponse_QNAME = new QName("http://WS/", "getSavingInterestRateByMonthResponse");
    private final static QName _GetAllInterestRateListResponse_QNAME = new QName("http://WS/", "getAllInterestRateListResponse");
    private final static QName _GetBorrowRateList_QNAME = new QName("http://WS/", "getBorrowRateList");
    private final static QName _GetBorrowInterestRateByMonth_QNAME = new QName("http://WS/", "getBorrowInterestRateByMonth");
    private final static QName _GetBorrowInterestRateByMonthResponse_QNAME = new QName("http://WS/", "getBorrowInterestRateByMonthResponse");
    private final static QName _GetSavingRateList_QNAME = new QName("http://WS/", "getSavingRateList");
    private final static QName _GetBorrowRateListResponse_QNAME = new QName("http://WS/", "getBorrowRateListResponse");
    private final static QName _GetAllInterestRateList_QNAME = new QName("http://WS/", "getAllInterestRateList");
    private final static QName _GetSavingRateListResponse_QNAME = new QName("http://WS/", "getSavingRateListResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: WebServiceClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSavingInterestRateByMonthResponse }
     * 
     */
    public GetSavingInterestRateByMonthResponse createGetSavingInterestRateByMonthResponse() {
        return new GetSavingInterestRateByMonthResponse();
    }

    /**
     * Create an instance of {@link GetSavingInterestRateByMonth }
     * 
     */
    public GetSavingInterestRateByMonth createGetSavingInterestRateByMonth() {
        return new GetSavingInterestRateByMonth();
    }

    /**
     * Create an instance of {@link GetBorrowInterestRateByMonth }
     * 
     */
    public GetBorrowInterestRateByMonth createGetBorrowInterestRateByMonth() {
        return new GetBorrowInterestRateByMonth();
    }

    /**
     * Create an instance of {@link GetBorrowInterestRateByMonthResponse }
     * 
     */
    public GetBorrowInterestRateByMonthResponse createGetBorrowInterestRateByMonthResponse() {
        return new GetBorrowInterestRateByMonthResponse();
    }

    /**
     * Create an instance of {@link GetAllInterestRateListResponse }
     * 
     */
    public GetAllInterestRateListResponse createGetAllInterestRateListResponse() {
        return new GetAllInterestRateListResponse();
    }

    /**
     * Create an instance of {@link GetBorrowRateList }
     * 
     */
    public GetBorrowRateList createGetBorrowRateList() {
        return new GetBorrowRateList();
    }

    /**
     * Create an instance of {@link GetSavingRateList }
     * 
     */
    public GetSavingRateList createGetSavingRateList() {
        return new GetSavingRateList();
    }

    /**
     * Create an instance of {@link GetBorrowRateListResponse }
     * 
     */
    public GetBorrowRateListResponse createGetBorrowRateListResponse() {
        return new GetBorrowRateListResponse();
    }

    /**
     * Create an instance of {@link GetAllInterestRateList }
     * 
     */
    public GetAllInterestRateList createGetAllInterestRateList() {
        return new GetAllInterestRateList();
    }

    /**
     * Create an instance of {@link GetSavingRateListResponse }
     * 
     */
    public GetSavingRateListResponse createGetSavingRateListResponse() {
        return new GetSavingRateListResponse();
    }

    /**
     * Create an instance of {@link InterestRate }
     * 
     */
    public InterestRate createInterestRate() {
        return new InterestRate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSavingInterestRateByMonth }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getSavingInterestRateByMonth")
    public JAXBElement<GetSavingInterestRateByMonth> createGetSavingInterestRateByMonth(GetSavingInterestRateByMonth value) {
        return new JAXBElement<GetSavingInterestRateByMonth>(_GetSavingInterestRateByMonth_QNAME, GetSavingInterestRateByMonth.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSavingInterestRateByMonthResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getSavingInterestRateByMonthResponse")
    public JAXBElement<GetSavingInterestRateByMonthResponse> createGetSavingInterestRateByMonthResponse(GetSavingInterestRateByMonthResponse value) {
        return new JAXBElement<GetSavingInterestRateByMonthResponse>(_GetSavingInterestRateByMonthResponse_QNAME, GetSavingInterestRateByMonthResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllInterestRateListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getAllInterestRateListResponse")
    public JAXBElement<GetAllInterestRateListResponse> createGetAllInterestRateListResponse(GetAllInterestRateListResponse value) {
        return new JAXBElement<GetAllInterestRateListResponse>(_GetAllInterestRateListResponse_QNAME, GetAllInterestRateListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBorrowRateList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getBorrowRateList")
    public JAXBElement<GetBorrowRateList> createGetBorrowRateList(GetBorrowRateList value) {
        return new JAXBElement<GetBorrowRateList>(_GetBorrowRateList_QNAME, GetBorrowRateList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBorrowInterestRateByMonth }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getBorrowInterestRateByMonth")
    public JAXBElement<GetBorrowInterestRateByMonth> createGetBorrowInterestRateByMonth(GetBorrowInterestRateByMonth value) {
        return new JAXBElement<GetBorrowInterestRateByMonth>(_GetBorrowInterestRateByMonth_QNAME, GetBorrowInterestRateByMonth.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBorrowInterestRateByMonthResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getBorrowInterestRateByMonthResponse")
    public JAXBElement<GetBorrowInterestRateByMonthResponse> createGetBorrowInterestRateByMonthResponse(GetBorrowInterestRateByMonthResponse value) {
        return new JAXBElement<GetBorrowInterestRateByMonthResponse>(_GetBorrowInterestRateByMonthResponse_QNAME, GetBorrowInterestRateByMonthResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSavingRateList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getSavingRateList")
    public JAXBElement<GetSavingRateList> createGetSavingRateList(GetSavingRateList value) {
        return new JAXBElement<GetSavingRateList>(_GetSavingRateList_QNAME, GetSavingRateList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBorrowRateListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getBorrowRateListResponse")
    public JAXBElement<GetBorrowRateListResponse> createGetBorrowRateListResponse(GetBorrowRateListResponse value) {
        return new JAXBElement<GetBorrowRateListResponse>(_GetBorrowRateListResponse_QNAME, GetBorrowRateListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllInterestRateList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getAllInterestRateList")
    public JAXBElement<GetAllInterestRateList> createGetAllInterestRateList(GetAllInterestRateList value) {
        return new JAXBElement<GetAllInterestRateList>(_GetAllInterestRateList_QNAME, GetAllInterestRateList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSavingRateListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getSavingRateListResponse")
    public JAXBElement<GetSavingRateListResponse> createGetSavingRateListResponse(GetSavingRateListResponse value) {
        return new JAXBElement<GetSavingRateListResponse>(_GetSavingRateListResponse_QNAME, GetSavingRateListResponse.class, null, value);
    }

}
