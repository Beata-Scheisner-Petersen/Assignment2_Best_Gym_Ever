import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Staff {
    private InputOutputHandler ioh = new InputOutputHandler();

    public boolean isValidInput(String input) {
        boolean isValid = false;
        if (input.isBlank()) {
            IO.println("Error: input cant be blank");
        } else if (isContainingInvalidCharacters(input)) {
            IO.println("Error: input contains invalid characters!");
        } else if (isIndex0ANumber(input) ) {
            if ((((isPersonNumberRightAmountNumbers(input)) && isContainsHyphen(input)) && isHyphenOnRightPlace(input)) && isHyphenOnlyOneOf(input)
                    && personNrIsOnlyNumbers(input)) {
                isValid = true;
            } else {
                IO.println("person number have invalid format or contains invalid character");
            }
        } else {
            if (isNameOnlyContainsLetter(input)) {
                isValid = true;
            } else {
                IO.println("Error: name contains something it shouldn't");
            }
        }
        return isValid;
    }
    protected boolean isContainingInvalidCharacters(String input) {
        Pattern patternForSpecialCharacters = Pattern.compile("[^a-ö0-9 -]", Pattern.CASE_INSENSITIVE);
        Matcher matcherForSpecialCharacters = patternForSpecialCharacters.matcher(input);
        return matcherForSpecialCharacters.find();
    }
    protected boolean isIndex0ANumber(String input) {
        String containsNumber = "[0123456789]";
        boolean onlyNumbers = false;
        try {
            onlyNumbers = containsNumber.indexOf(input.charAt(0)) >= 0;
        } catch (StringIndexOutOfBoundsException eOutOfBound) {
            IO.println("Error can't be null/blank");
        } catch (Exception e) {
            IO.println("Error:");
            e.printStackTrace();
        }
        return onlyNumbers;
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
    protected boolean isNameOnlyContainsLetter(String input) {
        Pattern isNotLetterPattern = Pattern.compile("[^a-ö -]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = isNotLetterPattern.matcher(input);
        return !matcher.find();
    }
}
