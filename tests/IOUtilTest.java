import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class IOUtilTest {
    IOUtil fileHandler = new IOUtil();
    String readFilePath = "gym_medlemmar.txt";

    @Test
    public void checkReadFilePathTest() {
        assertTrue(fileHandler.checkReadFilePath(fileHandler.readFilePath));
        assertFalse(!fileHandler.checkReadFilePath(fileHandler.readFilePath));
    }

    @Test
    public void checkIfContentIsCorrectTest() {
        assertTrue(fileHandler.checkIfContentIsCorrect(fileHandler.readFilePath, "Fredrik Berggren"));
        assertTrue(fileHandler.checkIfContentIsCorrect(fileHandler.readFilePath, "540815-4382"));
        assertFalse(fileHandler.checkIfContentIsCorrect(fileHandler.readFilePath, "Fredrika Berggren"));
    }

    @Test
    public void findInFileTest() {
        assertTrue(fileHandler.findInFile("Fredrik Berggren"));
        assertTrue(fileHandler.findInFile("540815-4382"));
    }
}
