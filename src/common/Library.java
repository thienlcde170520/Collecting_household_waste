
package common;

import java.util.Scanner;


public class Library { 
            
    private  Scanner sc = new Scanner(System.in);
    
    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public int getIntInput(String promt) {
        int a = -1;
        while (true) {
            System.out.print(promt);
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a > 0 && a <= 10000) {
                    return a;
                } else {
                    System.out.println("Invalid input");
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }
    
    public boolean checkInputYN(String mes) {
        System.out.print(mes);
        while (true) {
            String result = sc.nextLine();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N!!!");
            System.out.print("Please enter again: ");
        }
    }
}
