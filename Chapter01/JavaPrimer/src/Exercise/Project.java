/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author whtbl3
 */
public class Project {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the number of line: ");
//        int num_lines = sc.nextInt();
//        sc.nextLine();
//        String[] lines = new String[num_lines];
//        for (int i = 0; i < num_lines; i++) {
//            System.out.print("Enter line no." + (i+1) + ": ");
//            lines[i] = sc.nextLine();
//        }
//        displayReverse(lines, num_lines);
          simulateCalculator();
        
    }
    /**
     * P-1.26
     * @param lines
     * @param num_lines
     */
    public static void displayReverse(String[] lines, int num_lines) {
        System.out.println("Printing the line in reverse: ");
        for (int i = (num_lines - 1); i >= 0; i--) {
            System.out.println(lines[i]);
        }
    }
    /**
     * P-1.27
     * Print out the result.
     */
    public static void simulateCalculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Enter second number: ");
        double num2 = Double.parseDouble(scanner.nextLine().trim());
        System.out.println("Enter operator: [+,-]");
        char op = scanner.next().charAt(0);
        switch (op) {
            case '+':
                System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                break;
            case '-':
                System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                break;
        }
    }
    
}

class Typos {
    public static void main(String[] args) {
        // store the sentence in a String variable
        String sentence = "I will never spam my friends again.";
        // variable to store the length of sentence
        int length = sentence.length();
        // String variable to store the possible typos
        // only one character wfrom the String will be selected for 1 typo
        String typos = "qpzuojk";
        // an obect of class Random, to geerate random numbers
        Random rand = new Random();
        // varible to count the number of sentence with  typo
        int count = 0;
        /*
        Loop to display sentence at each iteration with or without typo
        Ex: i = 0,  "I will never spam my friends again." (without typo)
        Ex: i = 1,  "I will nqver spam my friends again." (with typo)
        */
        for (int i = 0; i < 100; i++) {
            double prob = rand.nextDouble();
            /*
            We want to generate the typos randomly at any iteration, and
            not consecutively, so we generate a random no. between 0 and 1
            and if the no. is less than o.14 and also the no. of sentences
            with typo is less than 8, then only we generate the typo
            (this no. 0.14 can be further decreased till we are sure that
            we can get 8 case out of 100 with value less than 0.14).
            */
            if (prob < 0.14 && count < 8) {
                /*
                A StringBuilder class is used to create modiable string,
                (in thí case deleting and changing characters)
                Creating a StringBuilder instance with the input string
                StringBuilder mode_sentence = new StringBuilder(sentence)
                */
                StringBuilder mode_setence = new StringBuilder(sentence);
                /*
                There can be two types of typos
                1) Deleteing a character at any position
                2) Changing the character at any position
                The random no. can be used for the 2 cases
                i,e if the random no is less than 0.07, delete character
                and if the (0.14 > random no. >= 0.07), change character
                */
                if (prob < 0.07) {
                    /*
                    Delete character at the position (count * 3), if prob < 0.7
                    Ex: i = 7, prob = 0.03, count = 1
                        mode_sentence = "I wll never spam my friends again."
                        char at i = 3 (i) get deleted
                    Ex: i = 37, prob = 0.05, count = 4
                        mode_sentence = "I will neverspam my friends again."
                        char at i = 12 (space) gets deleted.
                    */
                    mode_setence.deleteCharAt(count*3);
                    // Convert the StringBuilder instace to String & display
                    // Ex: i = 3, "3: I will never spam my friends again."
                    System.out.println((i+1) + ": " + mode_setence.toString());
                } else {
                    // if the (0.14 > random no. >= 0.07), change character.
                    /*
                    Store the type at count posistion of String typos
                    Ex: count = 5, mode = 'j'
                    */
                    char mod = typos.charAt(count);
                    /*
                    set character at the postion (count * 3) to the typo
                    Ex: count = 5, mode = 'j'
                    mode_sentence = "I will never spjm my friends again."
                    */
                    mode_setence.setCharAt(count*3, mod);
                    // Convert the StringBuilder instance to String & display
                    // Ex: i = 34, "34: I will never spjm my friends again."
                    System.out.println((i+1) + ": " + mode_setence.toString());
                }
                /* inrease the counter by 1 to keep track of the no. of
                sentences with typo i.e if we get prob < 0.14 but no. of
                sentences with typo is already 8, then it will do nothing
                */
                count++;
            }
            /*
            If no. of senteces with typo is 8
            */
            else {
                /*
                Ex: i =47, prob = 0.02, count = 8,
                Display "I will never spam my friends again." (count = 8)
                Ex: i = 53, prob = 0.35, count = 4
                Display "I iwll never spam my friends again." (prob >= 0.2)
                */
                System.out.println((i+1) + ": " + sentence);
            }
        }
    }
}