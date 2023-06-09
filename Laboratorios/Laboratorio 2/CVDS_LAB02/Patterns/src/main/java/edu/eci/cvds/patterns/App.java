package edu.eci.cvds.patterns;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        String message = "Hello";
        if (args.length == 0) {
            message += " World";
        } else {
            for (String word: args) {
                message += " " + word;
            }
        }
        message += "!";
        System.out.println(message);
    }
}
