void main() {
   User user = new User();
   System.out.print("Enter name or social security number: ");
   String temp = IO.readln();
   if (user.isValidInput(temp)) {
       user.setInput(temp);
   }
}