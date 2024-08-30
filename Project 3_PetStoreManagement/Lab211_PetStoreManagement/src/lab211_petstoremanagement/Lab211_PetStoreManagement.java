package lab211_petstoremanagement;

import Data.Management;
import Tools.Validation;
import Interfaces.Menu;

public class Lab211_PetStoreManagement {

    public static void main(String[] args) {
        Menu menu = new Menu("Pet Store Management");
        menu.addNewOption("1.Add a pet");
        menu.addNewOption("2.Find a pet");
        menu.addNewOption("3.Update a pet");
        menu.addNewOption("4.Delete a pet");
        menu.addNewOption("5.Add an order");
        menu.addNewOption("6.List orders");
        menu.addNewOption("7.Sort orders");
        menu.addNewOption("8.Save data");
        menu.addNewOption("9.Load data");
        menu.addNewOption("10.Quit");
        Management manage = new Management();
        int choice;
        boolean cont = false;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    manage.addPet();
                    manage.printPet();
                    break;
                case 2:
                    manage.findPet("");
                    break;
                case 3:
                    do {
                        manage.updatePet();
                    } while (Validation.getVerification("Do you want to continue updating pet?(Y/N)"));
                    break;
                case 4:
                    do {
                        manage.deletePet();
                    } while(Validation.getVerification("Do you want to continue removing pet?(Y/N)"));
                    break;
                case 5: 
                    break;
                case 6: 
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9: 
                    break;
                case 10: 
                    System.out.println("Good bye! See you later");
                    cont = true;
                    break;
            }
        } while (!cont);

    }

}
