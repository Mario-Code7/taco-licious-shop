package com.pluralsight.tacos.ui;

import com.pluralsight.tacos.model.*;
import com.pluralsight.tacos.data.ReceiptManager;

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
            System.out.println("4. Add Signature Taco");
            System.out.println("5. Checkout");
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
                    addSignatureTaco();
                    break;
                case 5:
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
        System.out.println("Sauce? (Salsa verde, Salsa roja, Chipotle, Habanero, Mild, Extra hot): ");
        String salsaType = myScanner.nextLine();

        System.out.println("Chips? (Doritos nacho cheese, Hot cheetos, Lay's, Frito's Flamin Hot, Torilla chips): ");
        String chipType = myScanner.nextLine();

        ChipsSalsa side = new ChipsSalsa(0.0, salsaType,chipType);
        order.addItem(side);
        System.out.println("Chips & Salsa added!");
    }

    private void addSignatureTaco() {
        System.out.println("\nSelect a Signature Taco:");
        System.out.println("1. Street Taco");
        System.out.println("2. Super Burrito");
        System.out.print("Enter choice: ");

        int choice = myScanner.nextInt();
        myScanner.nextLine();

        Taco taco;
        switch (choice) {
            case 1:
                taco = new StreetTaco();
                break;
            case 2:
                taco = new SuperBurrito();
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("Would you like to customize toppings? (Y/N): ");
        if (myScanner.nextLine().equalsIgnoreCase("Y")) {
            customizeTaco(taco);
        }

        order.addItem(taco);
        System.out.println("Signature Taco added to order!");
    }

    private void customizeTaco(Taco taco) {
        System.out.println("\nCurrent toppings: " + taco.getToppings());
        boolean changing = true;

        while(changing) {
            System.out.println("\n1. Add topping");
            System.out.println("2. Remove topping");
            System.out.println("0. Completed");
            System.out.print("Choose: ");
            int option = myScanner.nextInt();
            myScanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter a topping: ");
                    taco.getToppings().add(myScanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter topping to remove: ");
                    String remove = myScanner.nextLine();
                    taco.getToppings().remove(remove);
                    break;
                case 0:
                    changing = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

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
