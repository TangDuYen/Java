package lab211_ordermanagement;

import Data.Management;
import java.io.FileNotFoundException;
import Interfaces.Menu;
import Tools.Validation;

public class Lab211_OrderManagement {

        public static void main(String[] args) throws FileNotFoundException {
        Menu menu = new Menu("Order Management");
        menu.addNewOption("1.List all Products");
        menu.addNewOption("2.List all Customers");
        menu.addNewOption("3.Search a Customer based on his/her ID");
        menu.addNewOption("4.Add a Customer");
        menu.addNewOption("5.Update a Customer");
        menu.addNewOption("6.Save Customers to file");
        menu.addNewOption("7.List all Orders");
        menu.addNewOption("8.List all pending Orders");
        menu.addNewOption("9.Add an Order");
        menu.addNewOption("10.Update an Order");
        menu.addNewOption("11.Save Orders to file");
        menu.addNewOption("Others-Quit");

        Management manage = new Management();
        int choice, choice1; 
        boolean cont = false;
        manage.loadCustomerFromFile("customers.txt");
        manage.loadProductsFromFile("products.txt");
        manage.loadOrdersFromFile("orders.txt");
        do {
            menu.printMenu();
            choice = menu.getChoice();
            
            switch (choice) {
                case 1:
                    manage.printAllProducts();                    
                    break;
                case 2:
                    manage.printAllCusInfo();
                    break;
                case 3: 
                    manage.searchCusByID(); 
                    break;
                case 4: 
                    do {
                    manage.addNewCustomer();
                    } while (Validation.getVerification("Do you want to continue create a new customer? (Y/N)"));
                    break;
                case 5: 
                    manage.updateCustomer();
                    break;
                case 6: 
                    manage.saveCusToFile("customers.txt");
                    break;
                case 7: 
                    manage.printAllOrders();
                    break;
                case 8:
                    manage.printAllPendingOrders();
                    break;
                case 9: 
                    do {
                        manage.addNewOrder();
                    } while (Validation.getVerification("Do you want to continue create a new order? (Y/N)"));
                    break;
                case 10:   
                    Menu menu1 = new Menu("Update an Order");
                    menu1.addNewOption("1.Update an Order based on its ID");
                    menu1.addNewOption("2.Delete an Order based on its ID"); 
                    menu1.addNewOption("3.Back to main menu");
                    boolean cont1 = false;
                    do { 
                        menu1.printMenu();
                        choice1 = menu1.getChoice();
                            switch (choice1) {
                                case 1:
                                    manage.updateOrdersbasedonID();
                                    break;
                                case 2:
                                    manage.deleteOrderbasedonID();
                                    break;
                                case 3: 
                                    cont1 = true;
                                    break;
                            }                           
                    } while (!cont1);
                    break;
                case 11:
                    manage.saveOrdersToFile("orders.txt");
                    break;
                case 12: 
                    cont = true;
                    break;
            }                    
            } while (!cont);
            
        }

        
        }

