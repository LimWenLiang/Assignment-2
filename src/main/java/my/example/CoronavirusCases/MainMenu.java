package my.example.CoronavirusCases;

import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) throws Exception {

        ListCoronaCases listCoronaCases = new ListCoronaCases();
        Scanner input = new Scanner(System.in);
        int access;

        do {
            System.out.println("------------Main Menu------------");
            System.out.println("1. View Coronavirus Update (Live)");
            System.out.println("2. Exit");
            System.out.printf("Please select your choice: ");
            access = input.nextInt();
            System.out.println("");

            if (access == 1) {
                listCoronaCases.main();

            } else if (access == 2) {
                System.out.println("Good Bye.");
                System.out.println("#StayHomeStaySafe");

            } else {
                System.out.println("Invalid input, please try again.\n");
                Thread.sleep(1000);

            }
        } while (access != 2);
    }
}

