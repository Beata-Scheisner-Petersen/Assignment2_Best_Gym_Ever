import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class User {
    protected boolean isContainingNumber(String input) {
        String containsNumber = "[0123456789]";
        return containsNumber.indexOf(input.charAt(0)) >= 0;
    }

    protected boolean isContainingInvalidCharacters(String input) {
        Pattern patternForSpecialCharacters = Pattern.compile("[^a-ö0-9 -]", Pattern.CASE_INSENSITIVE);
        Matcher matcherForSpecialCharacters = patternForSpecialCharacters.matcher(input);
        IO.println(matcherForSpecialCharacters.find());
        return matcherForSpecialCharacters.find();
    }

    protected int hyphenCounter(String input) {
        int counter = 0;
        String searchFor = "-";
        for (int i = 0; i < input.length(); i++) {
            if (searchFor.indexOf(input.charAt(i)) == 0) {
                counter++;
            }
        }
        return counter;
    }
}
