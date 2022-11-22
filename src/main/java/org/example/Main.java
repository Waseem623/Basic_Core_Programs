package org.example;

import java.util.Scanner;

import static java.lang.Character.toLowerCase;

public class Main {
    public static final int FLIP_COIN = 1;
    public static final int LEAP_YEAR = 2;
    public static final int TWO_POWERS_TABLE = 3;
    public static final int HARMONIC_NUMBER = 4;
    public static final int PRIME_FACTORS = 5;
    public static final int QUOTIENT_AND_REMAINDER = 6;
    public static final int SWAP_NUMBERS = 7;
    public static final int EVEN_ODD = 8;
    public static final int VOWEL_CONSONANT = 9;
    public static final int LARGEST_AMONG_THREE = 10;
    static Scanner sc;

    public static void main(String[] args) {
        Main mainObj = new Main();
        System.out.println("Select an option : ");
        System.out.println(" 1 : Flip a coin ");
        System.out.println(" 2 : Check leap year ");
        System.out.println(" 3 : Print table of powers of two ");
        System.out.println(" 4 : Find nth harmonic number ");
        System.out.println(" 5 : Print all prime factors of given number ");
        System.out.println(" 6 : Print quotient and remainder");
        System.out.println(" 7 : Swap two numbers ");
        System.out.println(" 8 : Check number is even or odd ");
        System.out.println(" 9 : Check alphabet is vowel or consonant ");
        System.out.println(" 10 : Find largest among three numbers ");
        sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case FLIP_COIN:
                mainObj.flipCoin();
                break;
            case LEAP_YEAR:
                mainObj.isLeapYear();
                break;
            case TWO_POWERS_TABLE:
                mainObj.printPowersTable();
                break;
            case HARMONIC_NUMBER:
                mainObj.getHarmonicNum();
                break;
            case PRIME_FACTORS:
                mainObj.printPrimeFactors();
                break;
            case QUOTIENT_AND_REMAINDER:
                mainObj.printQuotientAndRemainder();
                break;
            case SWAP_NUMBERS:
                mainObj.swapNumbers();
                break;
            case EVEN_ODD:
                mainObj.isEven();
                break;
            case VOWEL_CONSONANT:
                mainObj.isVowel();
                break;
            case LARGEST_AMONG_THREE:
                mainObj.findLargest();
                break;
            default:
                System.out.println("INVALID CHOICE");
        }
    }

    private void findLargest() {
        System.out.println("Enter three numbers : ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        int largest = Math.max(num3, (Math.max(num1, num2)));
        System.out.println("Largest number is : " + largest);
    }

    private void isVowel() {
        System.out.println("Enter a alphabet :");
        sc = new Scanner(System.in);
        char alphabet = sc.next().charAt(0);
        toLowerCase(alphabet);
        boolean isVowel;
        switch (alphabet) {
            case 'a':
            case 'u':
            case 'e':
            case 'i':
            case 'o':
                isVowel = true;
                break;
            default:
                isVowel = false;
                break;
        }
        if (isVowel)
            System.out.println("It is vowel");
        else System.out.println("It is Consonant");
    }

    private void isEven() {
        System.out.println("Enter number ");
        int num = sc.nextInt();
        System.out.println(num % 2 == 0 ? num + " is even number" : num + " is odd number");
    }

    private void swapNumbers() {
        System.out.println("Enter two numbers ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println("Numbers before swapping num1 = " + num1 + " num2 = " + num2);
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("Numbers after swapping num1 = " + num1 + " num2 = " + num2);
    }

    private void printQuotientAndRemainder() {
        System.out.println("Enter a dividend and divisor");
        int dividend = sc.nextInt();
        int divisor = sc.nextInt();
        int quotient = dividend / divisor;
        int remainder = dividend % divisor;
        System.out.println("Quotient = " + quotient);
        System.out.println("Remainder = " + remainder);
    }

    private void printPrimeFactors() {
        System.out.println("Enter a number");
        int num = sc.nextInt();

        while (num % 2 == 0) {
            System.out.print(2 + " ");
            num = num / 2;
        }

        for (int i = 3; (i * i) <= num; i += 2) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num = num / i;
            }
        }

        if (num > 2)
            System.out.print(num);
    }

    private void getHarmonicNum() {
        System.out.println("Enter a number");
        int num = sc.nextInt();
        if (num != 0) {
            double harmonicNumber = 0;
            for (int term = 1; term <= num; term++) {
                harmonicNumber += (double) 1 / term;
            }
            System.out.println("Harmonic number = " + harmonicNumber);
        } else {
            System.out.println("Enter positive number ");
        }
    }

    private void printPowersTable() {
        System.out.println("How many terms do you wants to print :");
        int uptoNum = sc.nextInt();
        int tableOf = 2;
        for (int powValue = 1; powValue <= uptoNum; powValue++) {
            int term = (int) Math.pow(tableOf, powValue);
            System.out.println(term);
        }
    }

    private void isLeapYear() {
        int year;
        boolean isLeap = false;
        System.out.println("Enter year");
        year = sc.nextInt();
        int digitCount = (int) Math.floor(Math.log10(year) + 1);
        isLeap = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
        if (digitCount == 4) {
            System.out.println(isLeap ? year + " is leap year" : year + " is not leap year");
        } else
            System.out.println("Invalid year");
    }

    private void flipCoin() {
        System.out.println("Enter how many times you want to flip coin");
        int num = sc.nextInt();
        int head = 0;
        int tails = 0;

        for (int flip = 0; flip < num; flip++) {
            int toss = (int) (Math.random() * 2);
            if (toss == 1)
                head++;
            else
                tails++;
        }

        double headPercentage = head * 100 / num;
        double tailsPercentage = tails * 100 / num;
        System.out.println("Heads = " + head);
        System.out.println("Tails = " + tails);
        System.out.println("Percentage of head = " + headPercentage);
        System.out.println("Percentage of tails = " + tailsPercentage);
    }
}