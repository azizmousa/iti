package lab2.main;

import lab2.stringcompare.StringTester;

import java.util.Scanner;

public class Runner {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter First String: ");
        String input1 = scanner.nextLine();
        System.out.print("Enter Second String: ");
        String input2 = scanner.nextLine();

        System.out.println("The Better String is: " + isButter(input1, input2, (s1, s2)->s1.length() > s2.length()));
    }

    public static String isButter(String s1, String s2, StringTester tester){
        if(tester.isBetter(s1, s2))
            return s1;
        return s2;
    }

}
