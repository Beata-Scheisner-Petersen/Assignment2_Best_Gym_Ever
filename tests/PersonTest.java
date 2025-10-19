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
        CustomerType ct = new CustomerType();

        person.setCustomerType(ct.CUSTOMER);
        assertEquals(ct.CUstomer, person.getCustomerType());
        assertNotEquals(ct.FORMER_CUSTOMER, person.getCustomerType());

        person.setCustomerType(ct.FORMER_CUSTOMER);
        assertEquals(ct.FORMER_CUSTOMER, person.getCustomerType());
        assertNotEquals(ct.UNAUTHORIZED, person.getCustomerType());

        person.setCustomerType(ct.UNAUTHORIZED);
        assertEquals(ct.UNAUTHORIZED, person.getCustomerType());
        assertNotEquals(ct.FORMER_CUSTOMER, person.getCustomerType());
    }

}
