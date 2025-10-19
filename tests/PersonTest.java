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
}
