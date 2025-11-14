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
        int choice;
        do {
            System.out.println("\n \uD83C\uDF2E Welcome my friend, use the tablet to order! \uD83C\uDF2E");
            System.out.println("\n*****************************");
            System.out.println("✨ Jay's Taco-licious Shop ✨    ");
            System.out.println("*****************************");
            System.out.println("1. New Order");
            System.out.println("0. Exit");
            System.out.print("Enter choice please: ");

            choice = myScanner.nextInt();
            myScanner.nextLine();

            switch (choice) {
                case 1 -> startNewOrder();
                case 0 -> System.out.println("See ya again!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private void startNewOrder() {
        order = new Order();
        int choice;
        do {
            System.out.println("\n===========================");
            System.out.println("   \uD83C\uDF2E  Food Menu \uD83C\uDF2E  ");
            System.out.println("===========================");

            System.out.println("1. \uD83C\uDF2E Add Taco");
            System.out.println("2. \uD83E\uDD64 Add Drink");
            System.out.println("3. \uD83C\uDF5F Add Chips & Salsa");
            System.out.println("4. Add Signature Meals");
            System.out.println("5. Checkout");
            System.out.println("0. Cancel Order");
            System.out.print("Enter choice please: ");

            choice = myScanner.nextInt();
            myScanner.nextLine();

            switch (choice) {
                case 1 -> orderTaco();
                case 2 ->orderDrink();
                case 3 ->chipsSalsa();
                case 4 -> orderSignatureTaco();
                case 5 -> {
                    checkout();
                    return;
                }
                case 0 -> System.out.println("Order is cancelled!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private void orderTaco() {
        System.out.print("Enter Meat(Carne Asada, Al Pastor, Carnitas, Pollo, Chorizo, Pescado): ");
        String meat = myScanner.nextLine();
        System.out.print("Size (Single, 3-taco, burrito): ");
        String size = myScanner.nextLine();

        System.out.print("Shell (Corn, flour, Hard shell, bowl): ");
        String shell = myScanner.nextLine();

        List<String> toppings = new ArrayList<>();
        System.out.print("Enter Toppings(Lettuce, Cilantro, Onions, Tomatoes, Jalapenos, Radishes, Pico de Gallo, Guacamole, Corn): ");
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

        Taco taco = new Taco(meat,0.0, size, shell, deepFried, toppings);
        taco.setExtraMeat(extraMeat);
        taco.setExtraCheese(extraCheese);


        order.addItem(taco);
        System.out.println();
        System.out.println("✔ Taco placed!");
    }

    private void orderDrink() {
        System.out.print("Size (Small, Medium, Large): ");
        String size = myScanner.nextLine();
        System.out.print("What flavor (Pepsi, Dr.Pepper, RC, Horachta, Agua de Jamaica) : ");
        String flavor = myScanner.nextLine();

        Drink drink = new Drink(0.0, size, flavor);
        order.addItem(drink);
        System.out.println("✔ Drink placed!");

    }

    private void chipsSalsa() {
        System.out.println("Sauce? (Salsa verde, Salsa roja, Chipotle, Habanero, Mild, Extra hot): ");
        String salsaType = myScanner.nextLine();

        System.out.println("Chips? (Doritos nacho cheese, Hot cheetos, Lay's, Frito's Flamin Hot, Torilla chips): ");
        String chipType = myScanner.nextLine();

        ChipsSalsa side = new ChipsSalsa(0.0, salsaType, chipType);
        order.addItem(side);
        System.out.println("✔ Chips & Salsa added!");
    }

    private void orderSignatureTaco() {
        System.out.println("\n*************************************");
        System.out.println("\nSelect a Signature Taco:");
        System.out.println("1. \uD83C\uDF2E Street Taco");
        System.out.println("2. \uD83C\uDF2F Super Burrito");
        System.out.print("Enter choice: ");

        int choice = myScanner.nextInt();
        myScanner.nextLine();

        Taco taco;
        switch (choice) {
            case 1:
                taco = new StreetTaco();
                System.out.println("==========================================================================");
                System.out.println("|| Street Taco (includes): Carne asada, Onions, Salsa verde, Lime wedges ||");
                System.out.println("===========================================================================");
                break;
            case 2:
                taco = new SuperBurrito();
                System.out.println("=================================================================================================");
                System.out.println("|| Super Burrito (includes): Carnitas, Cheddar, Pico de gallo, Lettuce, Tomatoes, Birria dipped ||");
                System.out.println("=================================================================================================");
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Would you like to customize? (Y/N): ");
        if (myScanner.nextLine().equalsIgnoreCase("Y")) {
            orderCustomizeTaco(taco);
        }

        order.addItem(taco);
        System.out.println("✔ Signature Taco added to order!");
    }

    private void orderCustomizeTaco(Taco taco) {
        System.out.println("================================================================================================================");
        System.out.println("|| New Toppings: " + "Lettuce, Cilantro, Onions, Tomatoes, Jalapenos, Radishes, Pico de Gallo, Guacamole, Corn ||");
        System.out.println("================================================================================================================");
        int choose;
        boolean change = true;

        do {
            System.out.println("\n1. Add topping");
            System.out.println("2. Remove topping");
            System.out.println("0. Finished");
            System.out.print("Choose: ");
            choose = myScanner.nextInt();
            myScanner.nextLine();

            switch (choose) {
                case 1 -> {
                    System.out.print("Enter topping: ");
                    taco.addTopping(myScanner.nextLine());
                }
                case 2 -> {
                    System.out.print("Enter topping:  ");
                    taco.removeTopping(myScanner.nextLine());
                }
                case 0 -> change = false;
                default -> System.out.println("Invalid choice!");
            }
        }while (change);

    }

    private void checkout() {
        if (order == null || order.isEmpty()) {
            System.out.println("Cart empty!");
            return;
        }
        order.displayOrder();


        System.out.println("Confirm order? (Yes/No)");
        String confirmOrder = myScanner.nextLine();
        if (confirmOrder.equalsIgnoreCase("yes")) {
            String receipt = order.getOrderDetails();
            receiptManager.saveReceipt(receipt);
            System.out.println("Order Done! Thanks for eating at Jays Tacos-licious!");
        } else {
            System.out.println("Order cancelled!");
        }
    }
}
