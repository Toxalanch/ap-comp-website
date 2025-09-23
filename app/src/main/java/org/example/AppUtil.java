package org.example;

import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;

public class AppUtil{
	public static String findClass (String code) {
        try (BufferedReader reader = new BufferedReader(new StringReader(code))) {
        	String line;
            boolean quit = false;
            while ((line = reader.readLine()) != null && !quit) {
                int x = line.indexOf("public class");
            	if (x != -1) {
                    System.out.println(line);
                    quit = true;
                    String[] words = line.split(" ");
                    if (words[2].substring(words[2].length() - 1).equals("{")) {
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