package me.ostlerdev.fyre;
import me.ostlerdev.fyre.input.Keyboard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.awt.event.KeyEvent;
public class KeyboardTest {
    @Test
    @DisplayName("No key pressed")
    void noKeyPressedTest()
    {
        KeyEvent ke = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            (new Keyboard()).keyPressed(ke);
        });
    }
}
