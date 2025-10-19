public enum CustomerType {
    CUSTOMER("Customer"),
    FORMER_CUSTOMER("Former customer"),
    UNAUTHORIZED("Unauthorized");

    public final String customerType;

    CustomerType(String customerType) {
        this.customerType = customerType;
    }
}
