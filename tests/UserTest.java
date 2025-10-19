import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    User user = new User();

    @Test
    public void isContainingNumberTest() {
        assertFalse(user.isContainingNumber("Beata Schleisner-Petersen"));

        assertTrue(user.isContainingNumber("830214-4785"));
    }

    @Test
    public void isContainingInvalidCharactersTest() {
        assertTrue(!user.isContainingInvalidCharacters("!"));
        assertTrue(!user.isContainingInvalidCharacters("."));
        assertTrue(!user.isContainingInvalidCharacters("+"));
        assertTrue(!user.isContainingInvalidCharacters(","));

        assertFalse(user.isContainingInvalidCharacters("1"));
        assertFalse(user.isContainingInvalidCharacters("A"));
        assertFalse(user.isContainingInvalidCharacters("a"));
    }
}
