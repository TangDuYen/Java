package lab211_bookstoremanagement;

import Interfaces.Menu;
import Tools.Validation;
import bookstoredata.Management;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Lab211_BookStoreManagement {

    public static void main(String[] args) throws FileNotFoundException {
        Menu menu = new Menu("Book Store Management");
        menu.addNewOption("1.Publishers' Management");
        menu.addNewOption("2.Books Management");
        menu.addNewOption("3.Quit");

        Management manage = new Management();
        int choice, choice1, choice2, choice3;

        Scanner sc = new Scanner(System.in);
        boolean cont = false;
        manage.loadPubFromFile("Publisher.txt");
        do {
            menu.printMenu();
            choice = menu.getChoice();

            switch (choice) {
                case 1:
                    Menu menu1 = new Menu("Publishers’ Management");
                    menu1.addNewOption("1.Create Publisher");
                    menu1.addNewOption("2.Delete Publisher");
                    menu1.addNewOption("3.Save Publishers list to file");
                    menu1.addNewOption("4.Print Publisher list from the file");
                    menu1.addNewOption("5.Back to the main Menu");
                    boolean cont1 = false;
                    do {
                        menu1.printMenu();
                        choice1 = menu1.getChoice();
                        switch (choice1) {
                            case 1:
                                do {
                                    manage.createNewPublisher();
                                } while (Validation.getVerification("Do you want to continue to create Publisher?(Y/N)"));
                                break;
                            case 2:
                                manage.removePublisher();
                                break;
                                        

                            case 3:
                                manage.savePubToFile("Publisher.txt");
                                break;
                            case 4:
                                manage.printAllPubAsd();
                                break;
                            case 5:
                                cont1 = true;

                                break;
                        }
                    } while (!cont1);
                    break;
                case 2:

                    Menu menu2 = new Menu("Book’ Management");

                    menu2.addNewOption("1.Create Book");
                    menu2.addNewOption("2.Search Book ");
                    menu2.addNewOption("3.Update Book");
                    menu2.addNewOption("4.Delete Book");
                    menu2.addNewOption("5.Save Books list to file.");
                    menu2.addNewOption("6.Print Books list from the file.");
                    menu2.addNewOption("7.Back to the main Menu");
                    boolean cont2 = false;
                    do {
                        menu2.printMenu();
                        choice2 = menu2.getChoice();
                        switch (choice2) {
                            case 1:
                                do {
                                    manage.createNewBook();
                                } while (Validation.getVerification("Do you want to continue to create Book?(Y/N)"));

                                break;
                            case 2:
                                Menu menu4 = new Menu("Book’ Management");

                                menu4.addNewOption("1.Search Book By Name");
                                menu4.addNewOption("2.Search By ID ");
                                menu4.addNewOption("3.Return");
                                boolean cont4 = false;
                                do {
                                    menu4.printMenu();
                                    choice3 = menu4.getChoice();
                                    switch (choice3) {
                                        case 1:

                                            manage.searchBookByName();

                                            break;
                                        case 2:
                                            manage.searchBookByID();
                                            break;

                                        case 3:
                                            cont4 = true;
                                            break;
                                    }
                                } while (!cont4);

                                break;
                            case 3:
                                manage.update();
                                break;
                            case 4:
                                manage.removeBookInfo();
                                break;
                            case 5:
                                manage.saveBookInfoToFile("Book.txt");
                                break;
                            case 6:
                                manage.loadBookInfoFromFile("Book.txt");
                                manage.printAllBookDes();
                                break;
                            case 7:
                                cont2 = true;

                                break;
                        }

                    } while (!cont2);
                    break;

                case 3:
                    System.out.println("Good bye! See you later");
                    cont = true;
                    break;
            }

        } while (!cont);
    }

        
    }
    

