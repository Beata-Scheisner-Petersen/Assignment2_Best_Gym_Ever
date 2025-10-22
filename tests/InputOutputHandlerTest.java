import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

public class InputOutputHandlerTest {
    InputOutputHandler ioh = new InputOutputHandler();
    String readFilePath = "gym_medlemmar.txt";
    String writeFilePath = "PTFile.txt";

    @Test
    public void checkReadFilePathTest() {
        assertTrue(ioh.checkReadFilePath(readFilePath));
        assertFalse(!ioh.checkReadFilePath(readFilePath));
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
       assertEquals("former customer", ioh.getCustomerType(2));
       assertEquals("customer", ioh.getCustomerType(0));
       assertNotEquals("former customer", ioh.getCustomerType(0));
    }
    @Test
    public String printToFileTest() {
        ioh.findInFile("Pia Johansson");
        assertEquals("Pia Johansson;361026-1822;" + LocalDate.now(), ioh.printToFile());
        ioh.findInFile("680127-2300");
        assertEquals("Maria Lindström;680127-2300;" + LocalDate.now(), ioh.printToFile());
    }
}
