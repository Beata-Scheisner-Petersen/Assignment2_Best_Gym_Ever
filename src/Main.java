void main() {
   User user = new User();
   String input;
   while (true) {
       System.out.print("Enter name or social security number or q to quit: ");
       String temp = IO.readln().trim();
       if (temp.equals("q")) {
           break;
       }else if (user.isValidInput(temp)) {
           input = temp;
           break;
       }
   }
}