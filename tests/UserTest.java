import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    User user = new User();
    String input;

    @Test
    public void isContainingNumberTest() {
        input = "Beata Schleisner-Petersen";
        assertFalse(user.isContainingNumber(input));

        input = "830214-4785";
        assertTrue(user.isContainingNumber(input));
    }
}
