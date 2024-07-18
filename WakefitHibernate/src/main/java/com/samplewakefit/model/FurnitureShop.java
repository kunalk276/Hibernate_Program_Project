package com.samplewakefit.model;

import com.samplewakefit.dao.FurnitureDAO;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FurnitureShop {
    private final Scanner scanner;
    private final FurnitureDAO furnitureDAO;
    private final Cart cart;

    public FurnitureShop() {
        scanner = new Scanner(System.in);
        furnitureDAO = new FurnitureDAO();
        this.cart = new Cart();
    }

    public void start() {
        while (true) {
            System.out.println("\nWELCOME TO WAKEFIT FURNITURE!\n");
            System.out.println("1. Add Furniture to Inventory");
            System.out.println("2. View Inventory");
            System.out.println("3. Search Furniture by Name");
            System.out.println("4. Browse Products");
            System.out.println("5. Add to Cart");
            System.out.println("6. View Cart");
            System.out.println("7. Checkout");
            System.out.println("8. clearCart");
            System.out.println("9. EXIT !");

            try {
                System.out.print("\nEnter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addFurnitureToInventory();
                        break;
                    case 2:
                        viewInventory();
                        break;
                    case 3:
                        searchFurnitureByName();
                        break;
                    case 4:
                        browseProducts();
                        break;
                    case 5:
                        addToCart();
                        break;
                    case 6:
                        viewCart();
                        break;
                    case 7:
                        checkout();
                        break;
                    case 8:
                        clearCart();
                        break;
                    case 9:
                        System.out.println("Exiting the Wakefit App. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }
    private void addFurnitureToInventory() {
        System.out.println("\nAdding Furniture to Inventory\n");

        System.out.print("Enter furniture name: ");
        String name = scanner.nextLine();

        System.out.print("Enter furniture type: ");
        String type = scanner.nextLine();

        System.out.print("Enter furniture price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Furniture furniture = new Furniture(name, type, price);
        furnitureDAO.saveFurniture(furniture);

        System.out.println("Furniture added to inventory successfully!");
    }

    private void viewInventory() {
        System.out.println("\nViewing Inventory\n");

        List<Furniture> furnitureList = furnitureDAO.getAllFurniture();
        if (furnitureList.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (Furniture furniture : furnitureList) {
                System.out.println(furniture);
            }
        }
    }

    private void searchFurnitureByName() {
        System.out.print("\nEnter furniture name to search: ");
        String name = scanner.nextLine();

        System.out.println("Searching for furniture with name: " + name); // Debug statement
        List<Furniture> furnitureList = furnitureDAO.searchFurnitureByName(name);
        if (furnitureList.isEmpty()) {
            System.out.println("No furniture found with name: " + name);
        } else {
            System.out.println("Search Results:");
            for (Furniture furniture : furnitureList) {
                System.out.println(furniture);
            }
        }
    }

    private void browseProducts() {
        System.out.println("\nBrowsing Products\n");

        List<Furniture> furnitureList = furnitureDAO.getAllFurniture();
        if (furnitureList.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("Available Products:");
            for (int i = 0; i < furnitureList.size(); i++) {
                System.out.println((i + 1) + ". " + furnitureList.get(i));
            }
        }
    }

    private void addToCart() {
        System.out.println("\nAdding to Cart\n");

        browseProducts(); // Display available products for selection

        List<CartItem> cartItemsToAdd = new ArrayList<>();

        // Ask the user to enter product numbers and quantities until they're finished
        while (true) {
            System.out.print("\nEnter the ID of the product to add to cart (press 0 to exit Cart): ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (productId == 0) {
                break; // Exit loop if user enters 0
            }

            Furniture selectedProduct = furnitureDAO.getFurnitureById(productId);
            if (selectedProduct != null) {
                System.out.print("Enter the quantity for this product: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (quantity > 0) {
                    CartItem cartItem = new CartItem();
                    cartItem.setFurniture(selectedProduct);
                    cartItem.setQuantity(quantity);
                    cartItemsToAdd.add(cartItem);
                } else {
                    System.out.println("Invalid quantity. Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid product ID: " + productId);
            }
        }

        // Add the selected products with quantities to the cart
        for (CartItem cartItem : cartItemsToAdd) {
            cart.addItem(cartItem);
        }

        System.out.println("Product(s) added to cart.");
    }



    private void viewCart() {
        System.out.println("\nViewing Cart\n");

        List<CartItem> cartItems = cart.getCartItems();
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your Cart:");
            for (CartItem item : cartItems) {
                System.out.println(item);
            }
        }
    }
    
    
    private void clearCart() {
    	  
        cart.clearCart();
        System.out.println("Cart cleared.");
    }

    private void checkout() {
        System.out.println("\nCheckout\n");

        viewCart(); // Display items in the cart

        // Calculate total price of items in the cart
        double totalPrice = cart.getCartItems().stream().mapToDouble(cartItem -> cartItem.getFurniture().getPrice() * cartItem.getQuantity()).sum();
        System.out.println("Total Price: Rs." + totalPrice);

        //cart.clearCart();

        System.out.println("Thank you for your purchase!");
    }
}