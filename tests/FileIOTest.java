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
        assertEquals("Fredrik Berggren", fileHandler.checkIfContentIsCorrect("Fredrik Berggren"));
        assertEquals("Fredrik Berggren", fileHandler.checkIfContentIsCorrect("361026-1822"));
        assertNotEquals("Fredrika Berggren", fileHandler.checkIfContentIsCorrect("Fredrik Berggren"));
    }
}
