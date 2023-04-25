package me.ostlerdev.fyre;
import me.ostlerdev.fyre.input.Keyboard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.awt.event.KeyEvent;
public class KeyboardTest {
    @Test
    @DisplayName("No key pressed, but caught")
    void noKeyPressedTest()
    {
        KeyEvent ke = null;
        Assertions.assertDoesNotThrow(() -> {
            (new Keyboard()).keyPressed(ke);
        });
    }

    @Test
    @DisplayName("No key pressed, but caught")
    void noKeyReleasedTest()
    {
        KeyEvent ke = null;
        Assertions.assertDoesNotThrow(() -> {
            (new Keyboard()).keyReleased(ke);
        });
    }
}

