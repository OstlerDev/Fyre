import me.ostlerdev.fyre.input.Keyboard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class KeyboardTest {
    @Test
    @DisplayName("No key pressed")
    void noKeyPressedTest()
    {
        Assertions.assertThrows(NullPointerException.class, () -> {
            KeyEvent ke;
            (new Keyboard()).keyPressed(ke);
        });
    }
}
