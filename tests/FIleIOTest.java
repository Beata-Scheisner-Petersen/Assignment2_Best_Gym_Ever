import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class FIleIOTest {
    FileIO fileHandler = new FileIO();
    String readFilePath = "gym_medlemmar.txt";

    @Test
    public void checkReadFilePath() {
        assertTrue(fileHandler.CheckReadFilePath());
    }
}
