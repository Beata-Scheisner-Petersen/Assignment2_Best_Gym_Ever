import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class FileIOTest {
    FileIO fileHandler = new FileIO();

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
}
