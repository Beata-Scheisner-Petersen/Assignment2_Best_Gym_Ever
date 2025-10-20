import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User user = new User();

    @Test
    public void isContainingNumberTest() {
        assertFalse(user.isContainingNumber("Beata Schleisner-Petersen"));

        assertTrue(user.isContainingNumber("830214-4785"));
    }

    @Test
    public void isContainingInvalidCharactersTest() {
        assertFalse(user.isContainingInvalidCharacters("!"));
        assertTrue(!user.isContainingInvalidCharacters("."));
        assertTrue(!user.isContainingInvalidCharacters("+"));
        assertTrue(!user.isContainingInvalidCharacters(","));
        assertTrue(!user.isContainingInvalidCharacters("^"));

        assertFalse(user.isContainingInvalidCharacters("1A"));
        assertFalse(user.isContainingInvalidCharacters("Älva"));
        assertFalse(user.isContainingInvalidCharacters("Schleisner-Petersen"));
        assertFalse(user.isContainingInvalidCharacters("Èron"));
        assertFalse(user.isContainingInvalidCharacters("Pokémon"));
        assertFalse(user.isContainingInvalidCharacters("Über"));
        assertFalse(user.isContainingInvalidCharacters("abrâ"));
    }
    @Test
    public void hyphenCounterTest() {
        assertEquals(1, user.hyphenCounter("860923-1258"));
        assertNotEquals(0, user.hyphenCounter("860923-1258"));
        assertNotEquals(1, user.hyphenCounter("860-23-1258"));
    }
}
