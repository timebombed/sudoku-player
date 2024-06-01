package edu.sandiego.cs.comp305.sp24;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import java.lang.Exception;
import java.util.Random;

public class Simulator {
    static Dashboard applicationWindow = new Dashboard();
    static Board board;
    static Board userInputBoard;
    static ArrayList<int[]> parsedFile;
    public static void main(String[] args) {
        // calls runSimulation to remove logic from main method
        runSimulation();
    }

    public static void runSimulation() {
        // Initialize main menu window
        applicationWindow.changeState(applicationWindow.mainMenuWindow);
    }

    public static ArrayList<String> readFile(String fileName) throws Exception {
        File file = new File(fileName);
        ArrayList<String> fileContents = new ArrayList<>();
        String line;
        // if the file name exists and is a file/not a directory, the file will be read
        if (file.exists() && file.isFile()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            // rids of "Sudoku Board Organized by Rows"
            br.readLine();
            while ((line = br.readLine()) != null) {
                // saves each line to string in an array
                fileContents.add(line);
            }
            return fileContents;
        }
        else {
            throw new IncorrectFileNameException("Incorrect File: " + fileName);
        }
    }

    public static class IncorrectFileNameException extends Exception {
        public IncorrectFileNameException(String error) {
            super(error);
        }
    }

    public static ArrayList<int[]> parseFile(ArrayList<String> fileContents) {
        ArrayList<int[]> parsedContent = new ArrayList<int[]>();
        for (String item: fileContents) {
            int j = 0;
            String[] tempNums = new String[9];

            // init indices with empty string to avoid exception
            for (int h = 0; h < 9; h++) {
                tempNums[h] = "";
            }

            int[] finalNums = new int[9];
            for (int i = 0; i < item.length(); i++) {
                String ch = String.valueOf(item.charAt(i));
                if (ch.equals(",") || ch.equals(" ")) {
                    // skip , to convert characters to integers correctly
                    continue;
                } else if (ch.equals("\n")) {
                    continue;
                } else {
                    // adds character value to floor string
                    tempNums[j] += ch;
                    j++;
                }
            }
            for (int k = 0; k < 9; k++) {
                // converts string values of number to integer value one call at a time
                finalNums[k] = Integer.parseInt(tempNums[k]);
            }
            parsedContent.add(finalNums);
        }
        return parsedContent;
    }

    public static File pickBoard(String difficulty) throws Exception {
        String diff = difficulty.trim().toLowerCase();
        String path;
        // navigates to directory based on which button player selects
        if(diff.equals("easy")) {
            path = "src/main/resources/EasyBoards";
        } else if(diff.equals("medium")) {
            path = "src/main/resources/MediumBoards";
        } else {
            path = "src/main/resources/HardBoards";
        }
        File dir = new File(path);
        File[] files = dir.listFiles();

        // uses rand to select a random board within specified directory
        Random rand = new Random();
        if(files == null) {
            throw new FileNotFoundException("The directory does not exist or cannot be accessed.");
        }

        return files[rand.nextInt(files.length)];

    }
}
