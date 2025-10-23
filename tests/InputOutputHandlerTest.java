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
    public void findInFileTest() {
        assertEquals("Fredrik Berggren", ioh.findInFile("Fredrik Berggren"));
        assertEquals("540815-4382", ioh.findInFile("540815-4382"));
        assertNotEquals(540815-4382, ioh.findInFile("540815-b382"));
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
    public void textToFileTest() {
        ioh.findInFile("Pia Johansson");
        assertEquals("Pia Johansson;361026-1822;" + LocalDate.now(), ioh.textToFile());
        ioh.findInFile("680127-2300");
        assertEquals("Maria Lindström;680127-2300;" + LocalDate.now(), ioh.textToFile());
    }

    @Test
    public void checkIfPathExistTest() {
        assertTrue(ioh.checkIfPathExist());
    }

    @Test
    public void didItWriteToFileTest() {
        ioh.findInFile("Pia Johansson");
        assertTrue(ioh.didItWriteToFile());

        ioh.findInFile("680127-2300");
        assertTrue(ioh.didItWriteToFile());
    }

    @Test
    public void printTest() {
        ioh.findInFile("Maria Lindström");
        String testExample = String.format("""
                Name: %s
                CustomerType: %s
                MemberType: %s \n
                """, "Maria Lindström", "customer", "Standard");
        assertEquals(testExample, ioh.print());

        ioh.findInFile("Gustav Johansson");
        testExample = String.format("""
                Name: %s
                CustomerType: %s
                MemberType: %s \n
                """, "Gustav Johansson", "customer", "Platina");
        assertEquals(testExample, ioh.print());
    }
}
