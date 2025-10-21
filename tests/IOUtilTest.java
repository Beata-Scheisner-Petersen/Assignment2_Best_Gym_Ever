import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
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
        assertFalse(fileHandler.findInFile(" "));
    }
    @Test
    public void setInforTest() {
        try(Scanner reader = new Scanner(new FileReader(readFilePath))) {
            assertTrue(fileHandler.setInfo(reader));
        } catch (FileNotFoundException eFile) {
            IO.println("File not found");
            eFile.printStackTrace();
        } catch (IOException eIO) {
            IO.println("IO error");
            eIO.printStackTrace();
        } catch (Exception e) {
            IO.println("Error:");
            e.printStackTrace();
        }

    }
}
