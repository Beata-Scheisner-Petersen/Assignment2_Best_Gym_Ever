public class User {
    protected boolean isContainingNumber(String input) {
        String containsNumber = "[0123456789]";
        return containsNumber.indexOf(input.charAt(0)) >= 0;
    }
}
