import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PersonTest {
    Person person = new Person();

    @Test
    public void testSetAndGetName(){
        person.setName("Karl");
        assertEquals("Karl", person.getName());
        assertNotEquals("Mia", person.getName());

        person.setName("Mia");
        assertEquals("Mia", person.getName());
        assertNotEquals("Karl", person.getName());
    }

    @Test
    public void testSetAndGetPersonNumber() {
        person.setPersonNumber("851020-6728");
        assertEquals("851020-6728", person.getPersonNumber());
        assertNotEquals("861020-6728", person.getPersonNumber());

        person.setPersonNumber("870614-1573");
        assertEquals("870614-1573", person.getPersonNumber());
        assertNotEquals("570614-1573", person.getPersonNumber());
    }

    @Test
    public void testGetAndSetCustomerType() {
        person.setCustomerType(CustomerType.CUSTOMER);
        assertEquals(CustomerType.CUSTOMER, person.getCustomerType());
        assertNotEquals(CustomerType.FORMER_CUSTOMER, person.getCustomerType());

        person.setCustomerType(CustomerType.FORMER_CUSTOMER);
        assertEquals(CustomerType.FORMER_CUSTOMER, person.getCustomerType());
        assertNotEquals(CustomerType.UNAUTHORIZED, person.getCustomerType());

        person.setCustomerType(CustomerType.UNAUTHORIZED);
        assertEquals(CustomerType.UNAUTHORIZED, person.getCustomerType());
        assertNotEquals(CustomerType.FORMER_CUSTOMER, person.getCustomerType());
    }

    @Test
    public void testGetAndSetMemberType() {
        person.setMemberType(MemberType.GOLD);
        assertEquals(MemberType.GOLD, person.getMemberType());
        assertNotEquals(MemberType.PLATINUM, person.getMemberType());

        person.setMemberType(MemberType.PLATINUM);
        assertEquals(MemberType.PLATINUM, person.getMemberType());
        assertNotEquals(MemberType.STANDARD, person.getMemberType());

        person.setMemberType(MemberType.STANDARD);
        assertEquals(MemberType.STANDARD, person.getMemberType());
        assertNotEquals(MemberType.GOLD, person.getMemberType());
    }

}
