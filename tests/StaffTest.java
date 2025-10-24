import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StaffTest {
    Staff staff = new Staff();

    @Test
    public void isIndex0ANumberTest() {
        assertFalse(staff.isIndex0ANumber("Beata Schleisner-Petersen"));

        assertTrue(staff.isIndex0ANumber("830214-4785"));
    }

    @Test
    public void isContainingInvalidCharactersTest() {
        assertTrue(staff.isContainingInvalidCharacters("!"));
        assertTrue(staff.isContainingInvalidCharacters("."));
        assertTrue(staff.isContainingInvalidCharacters("+"));
        assertTrue(staff.isContainingInvalidCharacters(","));
        assertTrue(staff.isContainingInvalidCharacters("^"));

        assertFalse(staff.isContainingInvalidCharacters("1A"));
        assertFalse(staff.isContainingInvalidCharacters("Älva"));
        assertFalse(staff.isContainingInvalidCharacters("Schleisner-Petersen"));
        assertFalse(staff.isContainingInvalidCharacters("Èron"));
        assertFalse(staff.isContainingInvalidCharacters("Pokémon"));
        assertFalse(staff.isContainingInvalidCharacters("Über"));
        assertFalse(staff.isContainingInvalidCharacters("abrâ"));
    }
    @Test
    public void isHyphenOnlyOneOfTest() {
        assertTrue(staff.isHyphenOnlyOneOf("860923-1258"));
        assertFalse(staff.isHyphenOnlyOneOf("860-23-1258"));
    }

    @Test
    public void isContainsHyphenTest() {
        assertTrue(staff.isContainsHyphen("860923-1258"));

        assertFalse(staff.isContainsHyphen("8609231258"));
        assertFalse(staff.isContainsHyphen("860923 1258"));
        assertFalse(staff.isContainsHyphen("860923.1258"));
    }

    @Test
    public void personNrIsOnlyNumbersTest() {
        assertTrue(staff.personNrIsOnlyNumbers("860923-1258"));
        assertFalse(staff.personNrIsOnlyNumbers("860a23-1258"));
        assertFalse(staff.personNrIsOnlyNumbers("860923-12f8"));
    }

    @Test
    public void isPersonNumberRightAmountNumbersTest() {
        assertTrue(staff.isPersonNumberRightAmountNumbers("860923-1258"));

        assertFalse(staff.isPersonNumberRightAmountNumbers("86092-1258"));
        assertFalse(staff.isPersonNumberRightAmountNumbers("860923-125"));
    }

    @Test
    public void isHyphenOnRightPlaceTest() {
        assertTrue(staff.isHyphenOnRightPlace("860923-1258"));
    }

    @Test
    public void isNameOnlyContainsLetterTest() {
        assertTrue(staff.isNameOnlyContainsLetter("Älva"));
        assertTrue(staff.isNameOnlyContainsLetter("Schleisner-Petersen"));
        assertTrue(staff.isNameOnlyContainsLetter("Èron"));
        assertTrue(staff.isNameOnlyContainsLetter("Pokémon"));
        assertTrue(staff.isNameOnlyContainsLetter("Über"));
        assertTrue(staff.isNameOnlyContainsLetter("abrâ"));

        assertFalse(staff.isNameOnlyContainsLetter("El1as"));
        assertFalse(staff.isNameOnlyContainsLetter("Elin Maz0r"));
    }

    @Test
    public void isValidInputTest() {
        assertTrue(staff.isValidInput("Kim Hansén-Smith"));
        assertTrue(staff.isValidInput("860923-1258"));

        assertFalse(staff.isValidInput("K1m Hansén-Smith"));
        assertFalse(staff.isValidInput("860a23-1258"));
    }
}
