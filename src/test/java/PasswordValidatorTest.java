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
}