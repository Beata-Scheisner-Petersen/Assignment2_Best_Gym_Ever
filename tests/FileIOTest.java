import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class FileIOTest {
    FileIO fileHandler = new FileIO();

    @Test
    public void checkReadFilePathTest() {
        assertTrue(fileHandler.checkReadFilePath(fileHandler.readFilePath));
        assertFalse(!fileHandler.checkReadFilePath(fileHandler.readFilePath));
    }
}
