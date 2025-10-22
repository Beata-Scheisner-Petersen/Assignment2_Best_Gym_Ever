void main() {
   User user = new User();
   InputOutputHandler ioh = new InputOutputHandler();
   String input = null;
   String temp;
   while (true) {
       System.out.print("Enter name or social security number or q to quit: ");
       temp = IO.readln().trim();
       if (temp.equals("q")) {
           break;
       }else if (user.isValidInput(temp)) {
           input = temp;
           break;
       } else {
           IO.println("Invalid info");
       }
   }
   if ((!temp.equals("q")) && ioh.findInFile(input)) {
       // Todo
       // Få ut medlemstyp
       String customerType = ioh.getCustomerType(ioh.timeDiff());
       if (customerType.equals("customer")) {
           //
       } else {
           //
       }
       //skriva till fil
       // skriva ut
   } else {
       System.out.printf("%s don't exist in the register and is unauthorized", input);
   }
}