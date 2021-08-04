/*
 * This program belongs to Eduardo A. Sosa Torres
 * WakkoTheWarner
 * https://github.com/wakkoTheWarner
 * Created in 8/2/2021
 * Version: 1.1
 */

import javax.sound.midi.SysexMessage;
import java.util.Scanner;
public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // variables
        String generate = "yes";

        // code
        while (generate.equalsIgnoreCase("yes")) {
            generatingPassword();
            System.out.print("Would you like to make another Password? ");
            generate = scanner.next();
        }

        sayingGoodbye();
        System.exit(0);
    }

    public static void generatingPassword() {
        // variables
        String capitalLetters = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String lowercaseLetters = "qwertyuiopasdfghjklzxcvbnm";
        String numbers = "1234567890";
        String specialLetters = "@#$";
        String password = "";
        int randomizer;
        boolean passwordValidator = false;
        int userNum = 0;
        String userInput;

        // code
        while (userNum == 0) { // this while will verify if the number chosen by the user is long enough. If not, the program will ask the user to try again.
            System.out.print("How long should your prefered password be? (a good password should be from 6 - 18) ");
            userNum = scanner.nextInt();
            if (userNum <6) {
                System.out.println(userNum + " is too low! Please try again!");
                userNum = 0;
                passwordValidator = true;
            } else { // if the number chosen by the user is good enough, the program will run correctly as it should.
                passwordValidator = false;
                while (passwordValidator == false) {
                    password = "";
                    for (int i = 1; i <= userNum; i++) {
                        randomizer =(int)(4 * Math.random());
                        switch (randomizer) {
                            case 0:
                                randomizer = (int)(capitalLetters.length() * Math.random());
                                password += String.valueOf(capitalLetters.charAt(randomizer));
                                break;
                            case 1:
                                randomizer = (int)(lowercaseLetters.length() * Math.random());
                                password += String.valueOf(lowercaseLetters.charAt(randomizer));
                                break;
                            case 2:
                                randomizer = (int)(numbers.length() * Math.random());
                                password += String.valueOf(numbers.charAt(randomizer));
                                break;
                            case 3:
                                randomizer = (int)(specialLetters.length() * Math.random());
                                password += String.valueOf(specialLetters.charAt(randomizer));
                                break;
                        }
                    }
                    if (checkingPasswords(password) == false) { // removed user request to see failed password for ease of use.
                        /* System.out.println("\nOh uh! The password generated seems to fail the verification test!");
                        System.out.print("Would you still want to generate it? ");
                        userInput = scanner.next();
                        if (userInput.equalsIgnoreCase("yes")) {
                            passwordValidator = true;
                        } else {
                            passwordValidator = false;
                        }
                         */
                        passwordValidator = false;
                    } else {
                        passwordValidator = true;
                    }
                }
            }
        }
        System.out.println("");
        System.out.println(password);
        System.out.println("");
    }

    public static boolean checkingPasswords(String password) {
        // variables
        passwordChecker passwordValidator = new passwordChecker(password);
        boolean results = true;

        // code
        results = passwordValidator.findComplexity();
        return results;
    }

    public static void sayingGoodbye() {
        System.out.println("\n*********************");
        System.out.println("**   Goodbye! :)   **");
        System.out.println("*********************");
    }
}
