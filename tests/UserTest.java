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

    @Test
    public void isContainsHyphenTest() {
        assertTrue(user.isContainsHyphen("860923-1258"));

        assertFalse(user.isContainsHyphen("8609231258"));
        assertFalse(user.isContainsHyphen("860923 1258"));
        assertFalse(user.isContainsHyphen("860923.1258"));
    }

    @Test
    public void personNrIsOnlyNumbersTest() {
        assertTrue(user.personNrIsOnlyNumbers("860923-1258"));
        assertFalse(user.personNrIsOnlyNumbers("860a23-1258"));
        assertFalse(user.personNrIsOnlyNumbers("860923-12f8"));
    }

    @Test
    public void isPersonNumberRightAmountNumbersTest() {
        assertTrue(user.isPersonNumberRightAmountNumbers("860923-1258"));

        assertFalse(user.isPersonNumberRightAmountNumbers("86092-1258"));
        assertFalse(user.isPersonNumberRightAmountNumbers("860923-125"));
    }
}
