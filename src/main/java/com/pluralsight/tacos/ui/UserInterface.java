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
    private final ReceiptManager receiptManager = new ReceiptManager();


    public void begin() {
        while(true) {
            System.out.println("\n****************************");
            System.out.println("      Taco-licious Shop        ");
            System.out.println("****************************");
            System.out.println("1. New Order");
            System.out.println("0. Exit");
            System.out.print("Enter choice please: ");

            int choice = myScanner.nextInt();
            myScanner.nextLine();

            if (choice == 1) {
                startNewOrder();
            } else if (choice == 0) {
                System.out.println("See ya!");
                return;
            }else {
                System.out.println("Invalid choice!");
            }
        }
    }

    private void startNewOrder() {
        order = new Order();
        int choice;
        do {
            System.out.println("\n****************************");
            System.out.println("         Food Menu        ");
            System.out.println("****************************");
            System.out.println("1. Add Taco");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips & Salsa");
            System.out.println("4. Checkout");
            System.out.println("0. Cancel Order");
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
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private void addTaco() {
        System.out.print("Size (Single, 3-taco, burrito): ");
        String size = myScanner.nextLine();
        System.out.print("Shell(Corn, flour, Hard shell, bowl): ");
        String shell = myScanner.nextLine();

        List<String>toppings = new ArrayList<>();
        System.out.print("Enter meat(Carne Asada, Al Pastor, Carnitas, Pollo, Chorizo, Pescado): ");
        while (true) {
            String topping = myScanner.nextLine().trim();
            if (topping.isEmpty()) {
                break;
            }
            toppings.add(topping);
        }

        System.out.println("Add extra meat? (Y/N): ");
        boolean extraMeat = myScanner.nextLine().equalsIgnoreCase("Y");

        System.out.println("Add extra cheese? (Y/N): ");
        boolean extraCheese = myScanner.nextLine().equalsIgnoreCase("Y");

        System.out.print("Deep fried Y/N: ");
        boolean deepFried = myScanner.nextLine().equalsIgnoreCase("Y");

        Taco taco = new Taco(0.0,size,shell,deepFried,toppings);
        taco.setExtraMeat(extraMeat);
        taco.setExtraCheese(extraCheese);


        order.addItem(taco);
        System.out.println("Taco placed!");
    }

    private void addDrink() {
        System.out.print("Size (Small, Medium, Large): ");
        String size = myScanner.nextLine();
        System.out.print("What flavor: ");
        String flavor = myScanner.nextLine();

        Drink drink = new Drink(0.0,size,flavor);
        order.addItem(drink);
        System.out.println("Drink placed!");

    }

    private void chipsSalsa() {
        System.out.println("Sauces (Salsa verde, Salsa roja, Chipotle, Habanero, Mild, Extra hot): ");
        String salsaType = myScanner.nextLine();

        ChipsSalsa side = new ChipsSalsa(0.0, salsaType);
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
            String receipt = order.getOrderDetails();
            receiptManager.saveReceipt(receipt);
            System.out.println("Order Done! Thanks for eating at Jays Tacos-licious!");
        } else {
            System.out.println("Order cancelled!");
        }
    }
}
