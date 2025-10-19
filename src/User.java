import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class User {
    protected boolean isContainingNumber(String input) {
        String containsNumber = "[0123456789]";
        return containsNumber.indexOf(input.charAt(0)) >= 0;
    }

    protected boolean isContainingInvalidCharacters(String input) {
        Pattern patternForSpecialCharacters = Pattern.compile(".[!,.*+/|<>#¤%&=?@£${}_].");
        Matcher matcherForSpecialCharacters = patternForSpecialCharacters.matcher(input);
        return matcherForSpecialCharacters.find();
    }
}
