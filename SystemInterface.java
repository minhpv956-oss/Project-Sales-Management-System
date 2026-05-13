package salemanagementsysteminterface;

import java.util.Scanner;

public class SystemInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            try {

                System.out.println("========================");
                System.out.println("SALES MANAGEMENT SYSTEM");
                System.out.println("========================");
                System.out.println("1. Manage Products");
                System.out.println("2. Manage Customers");
                System.out.println("3. Manage Sales Transactions");
                System.out.println("4. Reports");
                System.out.println("5. Exit");
                System.out.println("----------------------------");

                System.out.print("Choose an option: ");

                int n = sc.nextInt();

                if (n == 1) {

                    System.out.println("Manage Products");

                } else if (n == 2) {

                    System.out.println("Manage Customers");

                } else if (n == 3) {

                    System.out.println("Manage Sales Transactions");

                } else if (n == 4) {

                    System.out.println("Reports");

                } else if (n == 5) {

                    System.out.println("Exit Program");

                    break;

                } else {

                    System.out.println("Invalid option");

                }

            } catch (Exception e) {

                System.out.println("Please enter a number!");

                sc.nextLine();

            }

        }

    }

}