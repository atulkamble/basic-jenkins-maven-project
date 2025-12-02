package com.example.app;

/**
 * Hello World application
 */
public class App {
    
    public static void main(String[] args) {
        System.out.println("Hello World from Jenkins Maven Project!");
        
        App app = new App();
        String message = app.getMessage();
        System.out.println(message);
    }
    
    /**
     * Get a greeting message
     * @return greeting message
     */
    public String getMessage() {
        return "This is a simple Maven project configured for Jenkins CI/CD!";
    }
    
    /**
     * Add two numbers
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }
}