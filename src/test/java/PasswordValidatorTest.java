import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    public void passwordLengthToShort(){
        // Given
        String password = "Passwort";

        // When
        boolean actual = PasswordValidator.isLongEnough(password);

        // Then
        assertFalse(actual);
    }

    @Test
    public void passwordLengthOkay(){
        // Given
        String password = "Passwort123";

        // When
        boolean actual = PasswordValidator.isLongEnough(password);

        // Then
        assertTrue(actual);
    }

    @Test
    public void passwordContainsDigits(){
        // Given
        String password = "Passwort123";

        // When
        boolean actual = PasswordValidator.containsDigit(password);

        // Then
        assertTrue(actual);
    }

    @Test
    public void passwordContainsNoDigits(){
        // Given
        String password = "Passwort";

        // When
        boolean actual = PasswordValidator.containsDigit(password);

        // Then
        assertFalse(actual);
    }

    @Test
    public void passwordWithAllLowercase(){
        // Given
        String password = "passwort";

        // When
        boolean actual = PasswordValidator.containsUppercaseAndLowercase(password);

        // Then
        assertFalse(actual);
    }

    @Test
    public void passwordWithAllUppercase(){
        // Given
        String password = "PASSWORT";

        // When
        boolean actual = PasswordValidator.containsUppercaseAndLowercase(password);

        // Then
        assertFalse(actual);
    }

    @Test
    public void passwordWithMixedCase(){
        // Given
        String password = "PassWort";

        // When
        boolean actual = PasswordValidator.containsUppercaseAndLowercase(password);

        // Then
        assertTrue(actual);
    }
}