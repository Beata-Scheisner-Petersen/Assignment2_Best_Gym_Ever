import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class InputOutputHandler {
    private String readFilePath = "gym_medlemmar.txt";
    private Person person = new Person();
    private List<String> findPersonList;

    public List<String> getFindPersonList() {
        return findPersonList;
    }

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

    protected boolean checkIfContentIsCorrect(String input) {
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

    protected boolean findInFile(String input) {
        boolean findResult = false;
        String fromFile;
        if (checkReadFilePath(readFilePath) && checkIfContentIsCorrect(input)) {
            try(BufferedReader reader = new BufferedReader(new FileReader(readFilePath))) {
                for (int i = 0; (fromFile = reader.readLine()) != null; i++) {
                    if (fromFile.contains(input)){
                        findPersonList = new ArrayList<>(List.of(fromFile.split(";")));
                        findResult = true;
                        break;
                    }
                }
            } catch (FileNotFoundException eFile) {
                IO.println("Error: File not found");
            } catch (IOException eIO) {
                IO.println("Error: IO error");
                eIO.printStackTrace();
            } catch (Exception e) {
                IO.println("Error:");
                e.printStackTrace();
            }
        } else {
            IO.println("Something went wrong when trying to read the file");
        }
        return findResult;
    }
}
