import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class FileIO {
    protected String readFilePath = "gym_medlemmar.txt";

    protected boolean checkReadFilePath(String readFilePath) {
        boolean pathValid = false;
        try(BufferedReader br = new BufferedReader(new FileReader(readFilePath))) {
            pathValid = true;
        } catch (FileNotFoundException eFile) {
            IO.println("File not found");
        } catch (IOException eIO) {
            IO.println("IO error");
            eIO.printStackTrace();
        } catch (Exception e) {
            IO.println("Error:");
            e.printStackTrace();
        }
        return pathValid;
    }

    protected boolean checkIfContentIsCorrect(String readFilePath, String input) {
        boolean checkValid = false;
        String temp;
        try(BufferedReader br = new BufferedReader(new FileReader(readFilePath))) {
            while ((temp = br.readLine()) != null) {
                if (temp.contains(input)) {
                    checkValid = true;
                    break;
                }
            }
        } catch (FileNotFoundException eFile) {
            IO.println("File not found");
        } catch (IOException eIO) {
            IO.println("IO error");
            eIO.printStackTrace();
        } catch (Exception e) {
            IO.println("Error:");
            e.printStackTrace();
        }
        return checkValid;
    }
}
