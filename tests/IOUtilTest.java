import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class IOUtilTest {
    IOUtil fileHandler = new IOUtil();

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
        assertTrue(fileHandler.findInFile("Fredrik Berggren;Skolgränd 8, 16819 Norrköping;fredde@fakemail.se;851020-6728;2019-12-30;2021-12-30;Platina"));
        assertFalse(fileHandler.FindInFile(" "));
    }
}
