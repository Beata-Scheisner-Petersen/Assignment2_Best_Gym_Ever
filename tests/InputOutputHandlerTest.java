import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class InputOutputHandlerTest {
    InputOutputHandler fileHandler = new InputOutputHandler();
    String readFilePath = "gym_medlemmar.txt";

    @Test
    public void checkReadFilePathTest() {
        assertTrue(fileHandler.checkReadFilePath(readFilePath));
        assertFalse(!fileHandler.checkReadFilePath(readFilePath));
    }

    @Test
    public void checkIfContentIsCorrectTest() {
        assertTrue(fileHandler.checkIfContentIsCorrect("Astrid Larsson"));
        assertTrue(fileHandler.checkIfContentIsCorrect("540815-4382"));
        assertFalse(fileHandler.checkIfContentIsCorrect("Fredrika Berggren"));
    }

    @Test
    public void findInFileTest() {
        assertTrue(fileHandler.findInFile("Fredrik Berggren"));
        assertTrue(fileHandler.findInFile("540815-4382"));
        assertFalse(fileHandler.findInFile("540815-b382"));
    }
}
