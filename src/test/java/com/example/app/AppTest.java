package com.example.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for App class
 */
public class AppTest {
    
    private App app;
    
    @BeforeEach
    public void setUp() {
        app = new App();
    }
    
    @Test
    public void testGetMessage() {
        String message = app.getMessage();
        assertNotNull(message);
        assertEquals("This is a simple Maven project configured for Jenkins CI/CD!", message);
    }
    
    @Test
    public void testAdd() {
        assertEquals(5, app.add(2, 3));
        assertEquals(0, app.add(-1, 1));
        assertEquals(-5, app.add(-2, -3));
    }
    
    @Test
    public void testAddZero() {
        assertEquals(5, app.add(5, 0));
        assertEquals(0, app.add(0, 0));
    }
}