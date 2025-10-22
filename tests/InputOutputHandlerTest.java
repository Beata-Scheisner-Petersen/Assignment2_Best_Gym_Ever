import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

public class InputOutputHandlerTest {
    InputOutputHandler ioh = new InputOutputHandler();
    String readFilePath = "gym_medlemmar.txt";

    @Test
    public void checkReadFilePathTest() {
        assertTrue(ioh.checkReadFilePath(readFilePath));
        assertFalse(!ioh.checkReadFilePath(readFilePath));
    }

    @Test
    public void checkIfContentIsCorrectTest() {
        assertTrue(ioh.checkIfContentIsCorrect("Astrid Larsson"));
        assertTrue(ioh.checkIfContentIsCorrect("540815-4382"));
        assertFalse(ioh.checkIfContentIsCorrect("Fredrika Berggren"));
    }

    @Test
    public void findInFileTest() {
        assertTrue(ioh.findInFile("Fredrik Berggren"));
        assertTrue(ioh.findInFile("540815-4382"));
        assertFalse(ioh.findInFile("540815-b382"));
    }

    @Test
    public void timeDiffTest() {
        LocalDate today = LocalDate.now();
        int timeInYears;
        LocalDate testDate;

        testDate = today.minusYears(3);
        timeInYears = Period.between(testDate, today).getYears();
        assertEquals(3, timeInYears);
        assertNotEquals(1, timeInYears);

        testDate = today.minusYears(2);
        timeInYears = Period.between(testDate, today).getYears();
        assertEquals(2, timeInYears);
        assertNotEquals(0, timeInYears);
    }
    @Test
    public void getCustomerTypeTest() {
       assertTrue(ioh.getCustomer(2), "former customer");
    }
}
