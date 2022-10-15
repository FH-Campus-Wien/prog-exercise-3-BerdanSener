package at.ac.fhcampuswien;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    public static void oneMonthCalendar(int groesse, int tag){
        int[] monat = new int[groesse];
        for(int i = 0; i < groesse; i++){
            monat[i] = i+1;
        }
        int tagI = tag-1;
        for (int i = 0; i < tagI; i++){
            System.out.print("   ");
        }
        for (int i = 0; i < groesse; i++){
            if(tagI == 7){
                System.out.print("\n");
                System.out.printf("%2d ",monat[i]);
                tagI = 1;
            }else {
                tagI++;
                if(i == 0 && tagI == 1){
                    System.out.printf("%2d ",monat[i]);
                }else {
                    System.out.printf("%2d ",monat[i]);
                }
            }
        }
        System.out.print("\n");
    }

    public static long[] lcg(long seed){

        long[] ausgabe = new long[10];

        double m = Math.pow(2, 31);
        long a = 1103515245;
        int c = 12345;

        for (int i = 0; i < ausgabe.length; i++) {

            ausgabe[i] = ((long) a*seed+c)% (long) m;
            seed = ausgabe[i];
        }

        return ausgabe;
    }

    public static void guessingGame(int numberToGuess){
        int versuche = 10;
        Scanner sc = new Scanner(System.in);
        int eingabe;

        for (int i = 0; i<versuche; i++){
            System.out.printf("Guess number %d: ",i+1);
            eingabe = sc.nextInt();
            if((eingabe < numberToGuess || eingabe > numberToGuess) && i == versuche-1) break;
            if(eingabe < numberToGuess){
                System.out.println("The number AI picked is higher than your guess.");
            }
            if (eingabe > numberToGuess){
                System.out.println("The number AI picked is lower than your guess.");
            }
            if (eingabe == numberToGuess){
                System.out.println("You won wisenheimer!");
                return;
            }
        }
        System.out.println("You lost! Have you ever heard of divide & conquer?");
    }

    public static int randomNumberBetweenOneAndHundred(){
        return new Random().nextInt(100)+1;
    }

    public static boolean swapArrays(int[] arr1, int[] arr2){
        if (arr1.length != arr2.length) return false;

        int temp;
        for (int i = 0; i < arr1.length; i++) {
            temp = arr1[i];
            arr1[i] = arr2[i];
            arr2[i] = temp;
        }

        return true;
    }

    public static String camelCase(String input){

        String ausgabe = "";

        input = input.toLowerCase();
        input = input.replace(".","");
        input = input.replace("?","");
        input = input.replace("!","");
        input = input.replace("'","");
        input = input.replace(",","");

        char[] c = input.toCharArray();
        c[0] = Character.toUpperCase(c[0]);
        boolean up = false;
        for (char zeichen : c) {
            if (zeichen == ' '){
                up = true;
            }
            if(zeichen != ' ' ){
                if (up) {
                    ausgabe += Character.toUpperCase(zeichen);
                    up = false;
                } else {
                    ausgabe += zeichen;
                }
            }
        }
        return ausgabe;
    }

    public static int checkDigit(int[] code){
        int[] gewichtng  = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            gewichtng[i] = i + 2;
        }
        int[] produkt = new int[code.length];
        int summe = 0;
        for (int i = 0; i < code.length; i++) {
            produkt[i] = gewichtng[i] * code[i];
            summe += produkt[i];
        }
        double rest = summe%11;

        if (11-rest == 10){
            return 0;
        }
        if(11-rest == 11){
            return 5;
        }

        return (int) (11-rest);
    }

    public static void main(String[] args) {
        App.oneMonthCalendar(28,1);
        App.guessingGame(App.randomNumberBetweenOneAndHundred());
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
    }
}