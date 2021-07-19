import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @MethodSource("provideValidPasswordArguments")
    public void validPassword(String password, boolean expected){
        // When
        boolean actual = PasswordValidator.validate(password);

        // Then
        assertEquals(expected, actual);
    }

    private static Arguments[] provideValidPasswordArguments(){
        return new Arguments[]{
                Arguments.of("Passwort123", true),
                Arguments.of("passwort123", false),
                Arguments.of("PASSWORT123", false),
                Arguments.of("pasW123", false),
                Arguments.of("123456789", false),
                Arguments.of("§/&%$&/§/()$(=)!(/$/&", false)
        };
    }

}