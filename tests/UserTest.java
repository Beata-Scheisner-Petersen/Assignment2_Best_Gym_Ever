import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    User user = new User();
    String input;

    @Test
    public void isContainingNumberTest() {
        input = "Beata Schleisner-Petersen";
        assertTrue(false, user.isContainingNumber(input));
        assertFalse(true, user.isContainingNumber(input));

        input = "830214-4785";
        assertTrue(true, user.isContainingNumber(input));
        assertFalse(false, user.isContainingNumber(input));
    }
}
