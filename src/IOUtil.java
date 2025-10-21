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

                if (setInfo(reader)) {
                    if (person.getName().contains(input)){
                        findResult = true;
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
    protected boolean setInfo (Scanner reader) {
        reader.skip("Namn;Adress;Mailadress;Personnummer;Datum_köpt_gymmedlemskap;Datum_senast_uppdaterad;Medlemsnivå");
        reader.useDelimiter(";");
        person.setName(reader.next());
        person.setAdress(reader.next());
        person.setMailadress(reader.next());
        person.setPersonNumber(reader.next());
        person.setDateStarted(LocalDate.parse(reader.next()));
        person.setLatestBoughtMembership(LocalDate.parse(reader.next()));
        String temp = reader.next();
        if (temp.contains("Platina")) {
            person.setMemberType(MemberType.PLATINUM);
        } else if (temp.contains("Guld")) {
            person.setMemberType(MemberType.GOLD);
        } else if (temp.contains("Standard")) {
            person.setMemberType(MemberType.STANDARD);
        } else {
            IO.println("Sorry error occurred couldn't get data");
        }
        if (person.getName() != null && person.getAdress() != null && person.getMailadress() != null && person.getPersonNumber() != null &&
                person.getDateStarted().toString() != null && person.getLatestBoughtMembership().toString() != null && person.getMemberType() != null) {
            return true;
        } else {
            return false;
        }
    }
}
