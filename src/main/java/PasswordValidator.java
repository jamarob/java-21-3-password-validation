public class PasswordValidator {

    private static final int MIN_LENGTH = 8;

    public static boolean isLongEnough(String password) {
        return password.length() > MIN_LENGTH;
    }
}
