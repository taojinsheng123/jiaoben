package com.tao.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TesseractRunner {
    public static void main(String[] args) {
        try {
            String imagePath = "/Users/taojinsheng/Pictures/1234.jpg";
            String outputPath = "/Users/taojinsheng/output.txt";

            // Create a ProcessBuilder for the tesseract command
            //eng chi_sim
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "/opt/local/bin/tesseract", imagePath, outputPath, "-l", "chi_sim"
            );

            // Redirect the error stream
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Get the process's input stream (output of the command)
            InputStream inputStream = process.getInputStream();

            // Read and print the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
