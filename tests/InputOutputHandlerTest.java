import org.junit.jupiter.api.Test;

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
    public void getCustomerTypeTest() {
        ioh.findInFile("Fredrik Berggren");
        assertTrue(ioh.isMemberType("Fredrik Berggren"));
    }

}
