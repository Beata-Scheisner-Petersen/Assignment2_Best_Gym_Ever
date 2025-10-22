void main() {
    User user = new User();
    InputOutputHandler ioh = new InputOutputHandler(); // kolla varför gammalt skrivs ut igen!
    String input = null;
    String temp;
    while (true) {
        System.out.print("Enter name or social security number or q to quit: ");
        temp = IO.readln().trim();
        if (temp.equals("q")) {
            break;
        } else if (user.isValidInput(temp)) {
            input = temp;
            temp = null;
        }

        if ((!temp.equals("q")) && ioh.findInFile(input)) {
            String customerType = ioh.getCustomerType(ioh.timeDiff());
            if (customerType.equals("customer")) {
                System.out.println(ioh.print());
                if (ioh.checkIfPathExist()) {
                    String textToAddToFile = ioh.textToFile();
                    if (ioh.didItWriteToFile()) {
                        IO.println("Printing to file was successful");
                        break;
                    }
                }
            } else {
                System.out.printf("%s is a former customer", ioh.getMemberInfo().get(0));
            }
        } else {
            System.out.printf("%s don't exist in the register and is unauthorized \n", input);
        }
    }

}