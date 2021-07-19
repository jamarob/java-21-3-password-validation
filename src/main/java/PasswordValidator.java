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
}
