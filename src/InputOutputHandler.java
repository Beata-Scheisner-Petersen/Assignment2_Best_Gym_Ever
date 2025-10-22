import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
public class InputOutputHandler {
    private String readFilePath = "gym_medlemmar.txt";
    private String writeToFile = "PTFile.txt";
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

    protected boolean findInFile(String input) {
        boolean findResult = false;
        String fromFile;
        if (checkReadFilePath(readFilePath)) {
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

    protected int timeDiff() {
        LocalDate boughtMembershipDate = LocalDate.parse(findPersonList.get(5));
        int timeDifference = Period.between(boughtMembershipDate, LocalDate.now()).getYears();
        return timeDifference;
    }

    protected String getCustomerType(int timeDifference) {
        if (timeDifference == 0) {
            return "customer";
        } else {
            return "former customer";
        }
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    protected String printToFile() {
        StringBuilder builder = new StringBuilder();
        builder.append(findPersonList.get(0)).append(";");
        builder.append(findPersonList.get(3)).append(";");
        builder.append(LocalDate.now());
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(writeToFile))) {
            //
        } catch (FileNotFoundException eFile) {
            IO.println("File not found");
        } catch (IOException eIO) {
            IO.println("Error: IO");
            eIO.printStackTrace();
        } catch (Exception e) {
            IO.println("Error:");
            e.printStackTrace();
        }
        return builder.toString();
    }
}
