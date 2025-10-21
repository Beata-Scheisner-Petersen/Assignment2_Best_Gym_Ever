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
       //
   }
}