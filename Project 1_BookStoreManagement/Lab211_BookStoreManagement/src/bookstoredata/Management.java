
package bookstoredata;

import Tools.Validation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Management {

    private ArrayList<PublisherData> pubList = new ArrayList();
    private ArrayList<BookData> bookList = new ArrayList();

    private Scanner sc = new Scanner(System.in);

    public int searchPubByID(String id) {
        for (int i = 0; i <= pubList.size() - 1; i++) {
            if (id.equalsIgnoreCase(pubList.get(i).getPublisherID())) {
                return i;
            }
        }
        return -1;
    }

    public void printAllPub() {
        String header = String.format("|%-15s|%-20s|%-15s|",
                "Publisher ID", "Publisher Name", "Publisher Phone");
        System.out.println(header);

        for (PublisherData a : pubList) {
            System.out.println(a.showInfo());

        }

    }

    public void createNewPublisher() {
        String ID, Name;
        String Phone;

        int pos;
        do {
            ID = Validation.getID("Input Publisher ID (Pxxxxx): ",
                    "The format of id is Pxxxxx(X stands for a digit)",
                    "^[P|p]\\d{5}$");
            pos = searchPubByID(ID);
        } while (pos != -1);

        Name = Validation.getName("Input Publisher Name: ",
                "Invalid (5-30 characters)");
        Phone = Validation.getID("Input Publisher Phone: ",
                "The format of id is 10-12 digits)",
                "^[0-9]{10}|[0-9]{11}|[0-9]{12}$");

        pubList.add(new PublisherData(ID, Name, Phone));
        System.out.println("Publisher is added successfully\n");
        printAllPub();
    }

    public void removePublisher() {
        String id;
        int pos;

        id = Validation.getID("Input Publisher ID (Pxxxxx): ",
                "The format of id is Pxxxxx(X stands for a digit)",
                "^[P|p]\\d{5}$");
        pos = searchPubByID(id);
        System.out.println("-------------------------------");
        if (pos == -1) {
            System.out.println("Publisher's ID does not exist");

        } else {
            boolean a = Validation.getVerification("Do you want to remove it?(Y/N)");
            if (a) {
                pubList.remove(pos);
                System.out.println("The Publisher info is removed successfully!");
            } else {
                System.out.println("Removed fail");
            }
        }
        printAllPub();

    }

    public boolean savePubToFile(String fileName) {
        try {
            FileWriter file = new FileWriter(fileName);
            for (int i = 0; i < pubList.size(); i++) {
                if (i != 0) {
                    file.write("\n");
                }
                file.write(pubList.get(i).toString());
            }
            System.out.println("Save to file successfully !");
            file.close();
            return true;
        } catch (Exception e) {
            System.out.println("Cannot save to file !");
        }
        return false;
    }

    public void loadPubFromFile(String fName) {
        try {
            File f = new File(fName);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");

                String id = stk.nextToken().toUpperCase();
                String name = stk.nextToken();
                String phone = stk.nextToken();

                pubList.add(new PublisherData(id, name, phone));

            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void printAllPubAsd() {
        String header = String.format("|%-15s|%-20s|%-15s|",
                "Publisher ID", "Publisher Name", "Publisher Phone");
        System.out.println(header);
        Collections.sort(pubList, (o1, o2)
                -> o1.getPublisherName().compareTo(o2.getPublisherName()));
        for (PublisherData o : pubList) {
            System.out.println(o.showInfo());

        }

    }

    public int searchBookByID(String id) {
        for (int i = 0; i <= bookList.size() - 1; i++) {
            if (id.equalsIgnoreCase(bookList.get(i).getID())) {
                return i;
            }
        }
        return -1;
    }

    public void printAllBook() {
        String header = String.format("|%-7s|%-40s|%-20s|%-10s|%-20s|%-20s|%-20s|",
                "BookID", "BookName", "Price", "Quantity", "Subtotal", "PubID", "Status");
        System.out.println(header);

        for (BookData o : bookList) {
            System.out.printf("|%-7s|%-40s|%-20s|%-10s|%-20s|%-20s|%-20s|\n",
                    o.getID(), o.getName(), o.getPrice(), o.getQuantity(),
                    (o.getPrice() * o.getQuantity()), o.getPubID(), o.getStatus());

        }

    }

    public void createNewBook() {
        String ID, Name, Status, PubID;
        int Price, Quantity;

        int pos, pos1;
        do {
            ID = Validation.getID("Input Book ID (Bxxxxx): ",
                    "The format of id is Bxxxxx(X stands for a digit)",
                    "^[B|b]\\d{5}$");
            pos = searchBookByID(ID);
        } while (pos != -1);

        Name = Validation.getName("Input Book Name: ",
                "Invalid (5-30 characters)");
        
        Price = Validation.getInteger("Input Price: ");
        Quantity = Validation.getInteger("Input Quantity: ");

        Status = Validation.getString("Input Status: ");
        
        do {
            PubID = Validation.getID("Input Publisher ID (Pxxxxx): ",
                    "The format of id is Pxxxxx(X stands for a digit)",
                    "^[P|p]\\d{5}$");
            pos1 = searchPubByID(PubID);
            if (pos1 == -1) {
                System.out.println("Publisher’s Id is not found");
            }
        } while (pos1 == -1);
        
        bookList.add(new BookData(ID, Name, PubID, Status, Price, Quantity));
        System.out.println("Book is added successfully\n");
        printAllBook();
    }

    public void searchBookByName() {
        String name;
        int flag = 0;
        name = Validation.getName("Input Book Name: ",
                "Invalid (5-30 characters)");

        System.out.println("-------------------------------");
        ArrayList<BookData> tmp = new ArrayList<>();
        for (BookData o : bookList) {
            if (o.getName().toLowerCase().contains(name.toLowerCase())) {
                tmp.add(o);
                flag = 1;

            }
        }
        if (flag == 0) {
            System.out.println("Not Found");
        } else {

            String header = String.format("|%-7s|%-40s|%-20s|%-10s|%-20s|%-20s|",
                    "BookID", "BookName", "Price", "Quantity", "PubID", "Status");
            System.out.println(header);
            for (BookData o : tmp) {
                System.out.println(o.showInfo());
            }
        }

    }

    public int searchBookByPubID(String id) {
        for (int i = 0; i <= bookList.size() - 1; i++) {
            if (id.equalsIgnoreCase(bookList.get(i).getPubID())) {
                return i;
            }
        }
        return -1;
    }

    public void searchBookByID() {
        String id;
        int pos;
        int flag = 0;
        id = Validation.getID("Input Publisher ID (Pxxxxx): ",
                "The format of id is Pxxxxx(X stands for a digit)",
                "^[P|p]\\d{5}$");
        pos = searchBookByPubID(id);
        System.out.println("-------------------------------");
        if (pos == -1) {
            System.out.println("Not Found");
        } else {
            ArrayList<BookData> tmp1 = new ArrayList<>();
            for (BookData o : bookList) {
                if (o.getPubID().equalsIgnoreCase(id)) {
                    tmp1.add(o);
                    flag = 1;

                }
            }
            if (flag == 0) {
                System.out.println("Not Found");
                return;
            }
            String header = String.format("|%-7s|%-25s|%-20s|%-10s|%-20s|%-20s|",
                    "BookID", "Name", "Price", "Quantity", "PubID", "Status");
            System.out.println(header);
            for (BookData o : tmp1) {
                System.out.println(o.showInfo());
            }
        }
    }

    public BookData searchBookObjectByID(String id) {
        if (bookList.isEmpty()) {
            return null;
        }
        for (BookData o : bookList) {
            if (o.getID().equalsIgnoreCase(id)) {
                return o;
            }
        }
        return null;
    }

    public void showBookInfo(int pos) {
        String header = String.format("|%-7s|%-25s|%-20s|%-10s|%-20s|%-20s|",
                "BookID", "BookName", "Price", "Quantity", "PubID", "Status");
        System.out.println(header);
        System.out.println(bookList.get(pos).showInfo());

    }

    public void update() {
        int pos;
        String id;
        do {
            id = Validation.getID("Input Book ID (Bxxxxx): ",
                    "The format of id is Bxxxxx(X stands for a digit)",
                    "^[B|b]\\d{5}$");
            pos = searchBookByID(id);
            if (pos == -1) {
                System.out.println("Book does not exist");
            }
        } while (pos == -1);
        System.out.println("Book Infomation: \n ");
        showBookInfo(pos);
        String Name, Status, PubID;
        int Price, Quantity;

        BookData c = new BookData();
        c = (BookData) searchBookObjectByID(id);

        Name = Validation.getBlankableString("Input Book Name: ");
        if (!Name.equals("")) {
            c.setName(Name);
        }
        String a = Validation.getBlankableString("Input Book Price: ");
        if (!a.equals("")) {
            Price = Integer.parseInt(a);
            if (Price > 0) {
                c.setPrice(Price);
            }
        }
        String b = Validation.getBlankableString("Input Book Quantity: ");
        if (!b.equals("")) {
            Quantity = Integer.parseInt(b);
            if (Quantity > 0) {
                c.setQuantity(Quantity);
            }
        }

        Status = Validation.getBlankableString("Input Book Status: ");
        if (!Status.equals("")) {
            c.setStatus(Status);
        }

        String format = "^[P|p]\\d{5}$";
        boolean match;

        PubID = Validation.getBlankableString("Input Book PubID: ");
        match = PubID.matches(format);

        if (!PubID.equals("") && match) {
            c.setPubID(PubID);
        }

        System.out.println("Updated Book Sucessfully ");
        System.out.println("Book Updated Info:\n ");
        showBookInfo(pos);
    }

    public void removeBookInfo() {
        String id;
        int pos;

        id = Validation.getID("Input Book ID (Bxxxxx): ",
                "The format of id is Bxxxxx(X stands for a digit)",
                "^[B|b]\\d{5}$");
        pos = searchBookByID(id);
        System.out.println("-------------------------------");
        if (pos == -1) {
            System.out.println("Book's ID does not exist");

        } else {
            boolean a = Validation.getVerification("Do you want to remove it?(Y/N)");
            if (a) {
                bookList.remove(pos);
                System.out.println("The Book info is removed successfully!");
            } else {
                System.out.println("Removed fail\n");
            }
        }
        printAllBook();

    }

    public boolean saveBookInfoToFile(String fileName) {
        try {
            FileWriter file = new FileWriter(fileName);
            for (int i = 0; i < bookList.size(); i++) {
                if (i != 0) {
                    file.write("\n");
                }
                file.write(bookList.get(i).toString());
            }
            System.out.println("Save to file successfully !");
            file.close();
            return true;
        } catch (Exception e) {
            System.out.println("Cannot save to file !");
        }
        return false;
    }

    public void loadBookInfoFromFile(String fName) {
        try {
            File f = new File(fName);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");

                String id = stk.nextToken().toUpperCase();
                String name = stk.nextToken();
                int price = Integer.parseInt(stk.nextToken());
                int quantity = Integer.parseInt(stk.nextToken());
                String PubID = stk.nextToken();
                String Status = stk.nextToken();
                bookList.add(new BookData(id, name, PubID, Status, price, quantity));

            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public String getBookNameByPubID(String id) {
        for (int i = 0; i <= pubList.size() - 1; i++) {
            if (id.equalsIgnoreCase(pubList.get(i).getPublisherID())) {
                return pubList.get(i).getPublisherName();
            }
        }
        return "";
    }

    public void printAllBookDes() {
        String header = String.format("|%-7s|%-25s|%-20s|%-10s|%-20s|%-20s|%-20s|",
                "BookID", "BookName", "Price", "Quantity", "Subtotal", "PubName", "Status");
        System.out.println(header);
        
        Collections.sort(bookList, (o1, o2)
                -> (int) (o2.getQuantity() - o1.getQuantity())); 

        for (BookData o : bookList) {
            System.out.printf("|%-7s|%-25s|%-20s|%-10s|%-20s|%-20s|%-20s|\n",
                    o.getID(), o.getName(), o.getPrice(), o.getQuantity(),
                    (o.getPrice() * o.getQuantity()), getBookNameByPubID(o.getPubID()), o.getStatus());

        }

    }

}
