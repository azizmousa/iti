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

        if(littersOnly(input1))
            System.out.println("The First input is litters only");
        else
            System.out.println("The First input is not litters only");

        if(littersOnly(input2))
            System.out.println("The Second input is litters only");
        else
            System.out.println("The Second input is not litters only");
    }

    public static String isButter(String s1, String s2, StringTester tester){
        if(tester.isBetter(s1, s2))
            return s1;
        return s2;
    }

    public static boolean littersOnly(String s1){
        StringTester tester = (ss1, ss2) ->{
            for(int i =0; i<ss1.length();++i){
                if(!Character.isLetter(ss1.charAt(i)))
                    return false;
            }
            return true;
        };
        return tester.isBetter(s1, null);
    }

}
