import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
public class IOUtil {
    protected String readFilePath = "gym_medlemmar.txt";
    private Person person = new Person();

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

    protected boolean findInFile(String input) {
        boolean findResult = false;
        if (checkReadFilePath(readFilePath) && checkIfContentIsCorrect(readFilePath, input)) {

                try(Scanner reader = new Scanner(new FileReader(readFilePath))) {

                    while (reader.hasNext()) {
                        if (setInfo(reader)) {
                            if (person.getName().contains(input.trim())){
                                findResult = true;
                                break;
                            }
                        }
                    }
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
