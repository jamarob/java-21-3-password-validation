import java.util.Locale;

public class PasswordValidator {

    private static final int MIN_LENGTH = 8;

    public static boolean isLongEnough(String password) {
        return password.length() > MIN_LENGTH;
    }

    public static boolean containsDigit(String password) {
        for(int i=0; i < password.length(); i++){
            char symbol = password.charAt(i);
            if(Character.isDigit(symbol)){
                return true;
            }
        }
        return false;
    }

    public static boolean containsUppercaseAndLowercase(String password) {
        String lowercase = password.toLowerCase();
        boolean isAllLowerCase = lowercase.equals(password);
        String uppercase = password.toUpperCase();
        boolean isAllUpperCase = uppercase.equals(password);
        boolean hasLowerAndUpperCase = !isAllUpperCase && !isAllLowerCase;
        return hasLowerAndUpperCase;
    }

    public static boolean validate(String password) {
        return isLongEnough(password) && containsDigit(password) && containsUppercaseAndLowercase(password);
    }
}
