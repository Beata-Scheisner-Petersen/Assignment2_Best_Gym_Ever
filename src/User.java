import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class User {

    public boolean isValidInput(String input) {
        boolean isValid = false;
        if (isContainingInvalidCharacters(input)) {
            IO.println("Error: input contains invalid characters!");
        } else if ((isContainingNumber(input)) && isContainsHyphen(input) && isHyphenOnRightPlace(input) && isHyphenOnlyOneOf(input)
            && isPersonNumberRightAmountNumbers(input)) {
            if (personNrIsOnlyNumbers(input)) {
                isValid = true;
            }
        } else {
            //
        }
        return isValid;
    }
    protected boolean isContainingInvalidCharacters(String input) {
        Pattern patternForSpecialCharacters = Pattern.compile("[^a-ö0-9 -]", Pattern.CASE_INSENSITIVE);
        Matcher matcherForSpecialCharacters = patternForSpecialCharacters.matcher(input);
        IO.println(matcherForSpecialCharacters.find());
        return matcherForSpecialCharacters.find();
    }

    protected boolean isContainingNumber(String input) {
        String containsNumber = "[0123456789]";
        return containsNumber.indexOf(input.charAt(0)) >= 0;
    }
    protected boolean isContainsHyphen(String input) {
        return input.contains("-");
    }
    protected boolean isHyphenOnRightPlace(String input) {
        int indexOfHyphen = 0;
        String searchFor = "-";
        for (int i = 0; i < input.length(); i++) {
            if (searchFor.indexOf(input.charAt(i)) == 0) {
                indexOfHyphen = i;
                break;
            }
        }
        return indexOfHyphen == 6;
    }

    protected boolean isHyphenOnlyOneOf(String input) {
        int counter = 0;
        String searchFor = "-";
        for (int i = 0; i < input.length(); i++) {
            if (searchFor.indexOf(input.charAt(i)) == 0) {
                counter++;
            }
        }
        return counter == 1;
    }

    protected boolean isPersonNumberRightAmountNumbers(String input) {
        return input.length() == 11;
    }


    protected boolean personNrIsOnlyNumbers(String input) {
        boolean onlyContainsNumbers = true;
        Pattern patternForNotNumbers = Pattern.compile("[^0-9]");
        String sub1 = input.substring(0, input.indexOf("-"));
        String sub2 = input.substring(input.indexOf("-") + 1);
        Matcher matcherSub1 = patternForNotNumbers.matcher(sub1);
        Matcher matcherSub2 = patternForNotNumbers.matcher(sub2);

        if (matcherSub1.find() || matcherSub2.find()) {
            onlyContainsNumbers = false;
        }
        return onlyContainsNumbers;
    }
}
