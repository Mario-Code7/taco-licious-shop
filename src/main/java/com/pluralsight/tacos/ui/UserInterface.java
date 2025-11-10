package com.pluralsight.tacos.ui;

import com.pluralsight.tacos.data.Order;
import com.pluralsight.tacos.data.ReceiptManager;
import com.pluralsight.tacos.model.ChipsSalsa;
import com.pluralsight.tacos.model.Drink;
import com.pluralsight.tacos.model.Taco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Scanner myScanner = new Scanner(System.in);
    private Order order;
    private ReceiptManager receiptManager = new ReceiptManager();


    public void begin() {
        while(true) {
            System.out.println("\n**************************");
            System.out.println("      Taco-licious Shop        ");
            System.out.println("****************************");
            System.out.println("1. New Order");
            System.out.println("0. Exit");
            System.out.print("Enter choice please: ");

            int choice = myScanner.nextInt();
            myScanner.nextLine();

            if (choice == 1)
                break;
            if (choice == 0)
                startNewOrder();
        }
    }

    private void startNewOrder() {
        order = new Order();
        int choice;
        do {
            System.out.println("\n**************************");
            System.out.println("         Food Menu        ");
            System.out.println("****************************");
            System.out.println("1. Add Taco");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips & Salsa");
            System.out.println("4. Checkout");
            System.out.println("0. Exit");
            System.out.print("Enter choice please: ");

            choice = myScanner.nextInt();
            myScanner.nextLine();

            switch (choice) {
                case 1:
                    addTaco();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    chipsSalsa();
                    break;
                case 4:
                    checkout();
                    return;
                case 0:
                    System.out.println("Order is cancelled.");
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private void addTaco() {
        System.out.println("Taco Name: ");
        String name = myScanner.nextLine();
        System.out.println("Size (Single, 3-taco, burrito): ");
        String size = myScanner.nextLine();
        System.out.println("Shell(Corn, flour, Hard shell, bowl): ");
        String shell = myScanner.nextLine();
        System.out.println("Price: ");
        double price = myScanner.nextDouble();
        myScanner.nextLine();

        List<String>toppings = new ArrayList<>();
        System.out.println("Enter toppings(leave empty to finish");
        while (true){
            String topping = myScanner.nextLine();
            if (topping.isEmpty()) {
                toppings.add(topping);
                break;
            }
        }
        System.out.println("Deep fried Y/N: ");
        boolean deepFried = myScanner.nextBoolean();
        myScanner.nextLine();

        Taco taco = new Taco(name,price,size,shell,deepFried,toppings);
        order.addItem(taco);
        System.out.println("Taco placed!");
    }

    private void addDrink() {
        System.out.println("Drink Name: ");
        String name = myScanner.nextLine();
        System.out.println("Size (Small, Medium, Large): ");
        String size = myScanner.nextLine();
        System.out.println("What Flavour: ");
        String flavor = myScanner.nextLine();
        System.out.println("Price: ");
        double price = myScanner.nextDouble();
        myScanner.nextLine();

        Drink drink = new Drink(name,price,size,flavor);
        order.addItem(drink);
        System.out.println("Drink placed!");

    }

    private void chipsSalsa() {
        System.out.println("Name: ");
        String name = myScanner.nextLine();
        System.out.println("Salsa choice: ");
        String salsaType = myScanner.nextLine();
        System.out.println("Price: ");
        double price = myScanner.nextDouble();
        myScanner.nextLine();

        ChipsSalsa side = new ChipsSalsa(name, price, salsaType);
        order.addItem(side);
        System.out.println("Chips & Salsa added!");
    }

    private void checkout() {
        if (order == null || order.isEmpty()) {
            System.out.println("No items in the order in checkout");
            return;
        }
        order.displayOrder();
        System.out.println("Confirm order? (Yes/No)");
        String confirm = myScanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            receiptManager.saveReceipt(order);
            System.out.println("Order Done! Thanks!");
        } else {
            System.out.println("Order cancelled!");
        }
    }
}
