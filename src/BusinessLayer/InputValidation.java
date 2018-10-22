/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Innes Herbst
 */
public class InputValidation {

    public static boolean isNumeric(String input) {

        for (int i = 0; i < input.length(); i++) {
            try {
                Integer.parseInt(input.substring(i, i + 1));
                //Testing purposes
                //System.out.println("Input Tested : "+input.substring(i,i+1));
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    public static boolean isString(String input) {
        for (int i = 0; i < input.length(); i++) {
            try {
                Integer.parseInt(input.substring(i, i + 1));
                //If the parse succeeds, the input contains an integer,
                //Thus return false.
                return false;
            } catch (NumberFormatException e) {
                //Input should always throw an exception, as the input is string
            }
        }

        return true;
    }

    public static boolean isEmail(String input) {

        return input.contains("@");
    }

    public static boolean isPassword(char[] input) {

        boolean containsNumeric = false;
        boolean containsSChar = false;
        boolean containsAlpha = false;

        //USE REGEX - Pattern and Matcher
        //FOR SPECIAL CHARACTERS
        if (!containsSChar) {
            StringBuilder password = new StringBuilder();
            for (int i = 0; i < input.length; i++) {
                password.append(Character.toString(input[i]));
            }

            //^ -- Alt+94
            Pattern stringPat = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
            Matcher stringMatcher = stringPat.matcher(password.toString());

            if (stringMatcher.find()) {
                containsSChar = true;
            } else {
                return false;
            }
        }

        //FOR NUMBERS
        if (!containsNumeric) {
            for (char c : input) {
                if (Character.isDigit(c)) {
                    containsNumeric = true;
                    break;
                }
            }
        }

        //FOR UPPER and LOWER CASE LETTERS
        if (!containsAlpha) {
            boolean ucAlpha = false;
            boolean lcAlpha = false;
            for (char c : input) {
                if (Character.isUpperCase(c)) {
                    ucAlpha = true;
                    if (ucAlpha && lcAlpha) {
                        break;
                    }
                }
                if (Character.isLowerCase(c)) {
                    lcAlpha = true;
                    if (ucAlpha && lcAlpha) {
                        break;
                    }
                }
            }

            if (ucAlpha || lcAlpha) {
                containsAlpha = true;
            }
        }

        return (containsAlpha && containsNumeric && containsSChar);
    }

    public static boolean isAlphaNum(String input) {
        boolean containsNum = false;
        boolean containsLet = false;
        for (int i = 0; i < input.length(); i++) {
            try {
                Integer.parseInt(input.substring(i, i + 1));
                containsNum = true;
                if (containsNum && containsLet) {
                    break;
                }
            } catch (NumberFormatException e) {
                containsLet = true;
                if (containsNum && containsLet) {
                    break;
                }
            }
        }

        return containsNum && containsLet;
    }

}
