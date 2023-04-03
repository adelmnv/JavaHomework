package Dz2;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if(passwordCheck(scanner.nextLine())){
            System.out.println("Password is correct");
        }
        else{
            System.out.println("Password is incorrect");
        }

    }

    public static boolean passwordCheck(String password){
        if(password.length() >= 10){
            if(password.matches("^.*[a-zA-Z0-9]*[0-9]{2,}.*$")){
                return true;
            }
        }
        return false;
    }
}