package com.toxalanch.apCompWebsite;

import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;

/**
 * A utility class for the webapp
 * 
 * Hosts any methods that don't fit into a single class or that will get changed as the project gets bigger
 * 
 * @author Toxalanch
 * @since 1.0
 * @version 1.0
 */
public class AppUtil {
    
    /**
     * Finds the class that inhabits the code by taking the word after the first instance of the phrase "public class"
     * TODO: refactor this method by seeing if using indexOf() on the entire string works well.
     * TODO: refactor method to be able to find the class name of any file by filtering out all keywords relating to the creation of the class such as enum, static, abstract, and others
     * 
     * @param code The string that is searched through for public class
     * @return The name of the file that this code would inhabit
     */
    public static String findClass(String code) {
        try (BufferedReader reader = new BufferedReader(new StringReader(code))) {
            String line;
            boolean quit = false;
            while ((line = reader.readLine()) != null && !quit) {
                int x = line.indexOf("public class");
                if (x != -1) {
                    System.out.println(line);
                    quit = true;
                    String[] words = line.split(" ");
                    if (words[2].substring(words[2].length() - 1).equals("{")) { // Checks whether or not the curly bracket is seperated from the name with a space and deletes it if true
                        return words[2].substring(0, words[2].length() - 1);
                    }
                    return words[2];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}