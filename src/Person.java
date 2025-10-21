import java.time.LocalDate;
public class Person {
    private String name;
    private String adress;
    private String mailadress;
    private String personNumber;
    private LocalDate dateStarted;
    private LocalDate latestBoughtMembership;
    private MemberType memberType;
    private CustomerType customerType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getMailadress() {
        return mailadress;
    }

    public void setMailadress(String mailadress) {
        this.mailadress = mailadress;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public LocalDate getLatestBoughtMembership() {
        return latestBoughtMembership;
    }

    public void setLatestBoughtMembership(LocalDate latestBoughtMembership) {
        this.latestBoughtMembership = latestBoughtMembership;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }
}
