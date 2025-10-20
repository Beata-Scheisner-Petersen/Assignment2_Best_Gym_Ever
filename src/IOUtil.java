import java.io.*;
import java.util.Scanner;
public class IOUtil {
    protected String readFilePath = "gym_medlemmar.txt";
    private User user = new User();

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

    public void findInFile() {
        user.userInput();
        if (checkReadFilePath(readFilePath) && checkIfContentIsCorrect(readFilePath, user.getInput())) {
            String temp;
            try(Scanner scan = new Scanner(new FileReader(readFilePath))) {
                scan.useDelimiter(";");
                while (scan.hasNext()) {
                    scan.skip("Namn;Adress;Mailadress;Personnummer;Datum_köpt_gymmedlemskap;Datum_senast_uppdaterad;Medlemsnivå");
                    temp = scan.next();
                    if (temp.contains(user.getInput())) {
                        System.out.println(scan.next());
                    }
                }
            } catch (FileNotFoundException eFile) {
                IO.println("Error: file not found");
            } catch (IOException eIO) {
                IO.println("IO Error:");
                eIO.printStackTrace();
            } catch (Exception e) {
                IO.println("Error:");
                e.printStackTrace();
            }
        }
    }

}
