void main() {
    Staff staff = new Staff();
    InputOutputHandler ioh = new InputOutputHandler();
    String temp;
    String customerType = "";
    String textToAddToFile;
    Scanner scanner = new Scanner(System.in);

    while (true) {
        String input = null;
        boolean isCustomer = false;
        System.out.print("Enter name or social security number or q to quit: ");
        temp = scanner.nextLine().trim();
        if (temp.equals("q")) {
            IO.println("Exit the program \n");
            break;
        }

        if (staff.isValidInput(temp)) {
            if (ioh.findInFile(temp).equals(temp)) {
                input = temp;
                customerType = ioh.getCustomerType(ioh.timeDiff());
                if (customerType.equals("customer")) {
                    isCustomer = true;
                    System.out.println(ioh.print());
                } else {
                    System.out.printf("%s is a former customer \n", ioh.getMemberInfo().get(0));
                }
            } else {
                System.out.printf("%s don't exist in the register and is unauthorized \n", temp);
            }
        }

        if (isCustomer) {
            if (ioh.checkIfPathExist()) {
                textToAddToFile = ioh.textToFile();
                if (ioh.didItWriteToFile()) {
                    IO.println("Printing to file was successful");
                }
            }
        }
    }
    scanner.close();
}