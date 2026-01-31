package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * A class made for the sole intent of creating a process that will run java code
 */
public class Runner {

    /**
     * Name of the class that is run by run()
     */
    private String classApp;
    /**
     * The code that is run by run()
     */
    private String code;

    public Runner(String classApp, String code) {
        this.classApp = classApp;
        this.code = code;
    }

    /**
     * Runs code by creating a new process that runs a dockerfile that runs the javacode
     * 
     * TODO: check whether the method will return whenever anything is outputed regardless of if the process has completed
     * 
     * @return The direct output of the code
     */
    public String run() {
        try {
            Path tempDir = Files.createTempDirectory("dockerLocation");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempDir + "/" + classApp + ".java"));
            writer.write(code);
            writer.close();
            String[] command = {"docker", "run", "-e", "CLASS_NAME=" + classApp + "", "-v", tempDir + ":/app", "java-runner:1.0.0"};
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            InputStream is = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String output = "";
            String line;
            process.waitFor();
            while ((line = reader.readLine()) != null) {
                output += line + "\n";
            }
            return output;
        } catch (IOException a) {
            return null;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
