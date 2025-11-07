package com.pluralsight.tacos.ui;

import com.pluralsight.tacos.data.Order;
import com.pluralsight.tacos.data.ReceiptManager;

import java.util.Scanner;

public class UserInterface {
    private Scanner myScanner = new Scanner(System.in);
    private Order order;
    private ReceiptManager receiptManager = new ReceiptManager();


    public void go() {
        boolean running = true;
        while (running) {
            System.out.println("\n**************************");
            System.out.println("      Taco-licious Shop        ");
            System.out.println("****************************");
            System.out.println("1. New Order");
            System.out.println("0. Exit");
            System.out.print("Enter choice please: ");

            int choice = myScanner.nextInt();
            myScanner.nextLine();

            switch (choice) {
                case 1:
                    order = new Order();
            }

        }
    }
    private void orderMenu() {
        boolean ordering = true;
        while(ordering) {
            System.out.println("\n**************************");
            System.out.println("         Food Menu        ");
            System.out.println("****************************");
            System.out.println("1. Add Taco");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips & Salsa");
            System.out.println("(C). Checkout");
            System.out.println("0. Exit");
            System.out.print("Enter choice please: ");

            int choice = myScanner.nextInt();
            myScanner.nextLine();

            switch (choice) {
            }
        }
    }
    private void addTaco() {
    }

    private void addDrink() {
    }

    private void chipsSalsa() {
    }

    private void checkout() {
    }

}
