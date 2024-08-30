package Data;

import Tools.Validation;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Management {
    private ArrayList <Customers> cusList = new ArrayList();
    private ArrayList <Products> proList = new ArrayList();
    private ArrayList <Orders> orderList = new ArrayList();
    
    private Scanner sc = new Scanner(System.in);
    
    public void printAllProducts () {
        for (Products a : proList) {
            System.out.println(a.toString());
        }
    }
    
    public void printAllCusInfo() {  
        for (Customers a : cusList) {
            System.out.println(a.toString());
        }        
    }
    
    public void printAllOrders () {
        Collections.sort(cusList, Comparator.comparing(Customers::getCusName).reversed());
        for (int i = 0; i < cusList.size(); i++) {
            for (int j = 0; j < orderList.size(); j++) {
                if (orderList.get(j).getCusID().equals(cusList.get(i).getCusID())) {
                    System.out.println(orderList.get(j).toString());
                }  
            }    
        }      
    }
    
    public  void printAllPendingOrders () {
        for (Orders a : orderList) {
            if(a.getOrdStatus().equals("false")) {
                System.out.println(a);
            }
        }
    }
      
    public int searchCustomersByID(String id) {
        for (int i = 0; i <= cusList.size() - 1; i++) {
            if (id.equalsIgnoreCase(cusList.get(i).getCusID())) {
                return i;
            }
        }
        return -1;
    }
    
    public int searchOrderByID (String id) {
        for (int i = 0; i <= orderList.size()- 1; i++) {
            if(id.equalsIgnoreCase(orderList.get(i).getOrdID())) {
                return i;
            }
        }
        return -1;
    }
    public Orders searchOrdObjectByID(String id) {
        if(orderList.isEmpty()) {
            return null;
        }
        for (Orders a: orderList) {
            if(a.getOrdID().equalsIgnoreCase(id)) {
                return a;
            }
        }
        return null;
    }
    
    public Customers searchCusObjectByID(String id) {
        if (cusList.isEmpty()) {
            return null;
        }
        for (Customers o : cusList) {
            if (o.getCusID().equalsIgnoreCase(id)) {
                return o;
            }
        }
        return null;
    }
    
    public void searchCusByID() {
        String id;
        int pos;
        int flag = 0;
        id = Validation.getID("Input Customer ID (Cxxx): ",
                "The format of id is Cxxx(x stands for a digit)",
                "^[C|c]\\d{3}$");
        System.out.println("Customer information: ");
        pos = searchCustomersByID(id);
        if (pos != -1) {
            for (Customers a : cusList) {
               if (a.getCusID().equalsIgnoreCase(id))                   
               System.out.println(a.toString()); 
               flag =1;
            }    
        }
        else {
            System.out.println("Customer does not exist");
        }      
    }
    
    public void addNewCustomer() {
        String ID, Name, Address;
        String Phone;
        int pos;
        do {
            ID = Validation.getID("Input Customer ID (Cxxx): ",
                "The format of id is Cxxx(x stands for a digit)",
                "^[C|c]\\d{3}$");
            pos = searchCustomersByID(ID);
        } while (pos != -1);
        Name = Validation.getString("Input Customer Name: ",
                "You are required to input customer name!");
        Address = Validation.getString("Input Customer Address: ", "You are required to input customer address!");
        Phone = Validation.getID("Input Customer Phone: ",
                "The format is 10-12 digits)",
                "^[0-9]{10}|[0-9]{11}|[0-9]{12}$");
        
        cusList.add(new Customers(ID, Name, Address, Phone));
        System.out.println("Customer is added successfully\n");
        printAllCusInfo();       
    }
    
    public String customersSubmenu () {
        for (int i = 0; i < cusList.size(); i++) {
            System.out.println("["+i+"] " + cusList.get(i).getCusID() + ", " + cusList.get(i).getCusName());
        }
        System.out.println("Choose Customer: ");
        int maxOption = cusList.size()-1;
        int choice = Validation.getInteger("Choose [0..."+ maxOption +"]", 
                "You are required to choose [0..."+ maxOption +"]", 0, maxOption);
        return cusList.get(choice).getCusID();
    }
    
    public String productsSubmenu () {
        for (int i = 0; i < proList.size(); i++) {
            System.out.println("["+i+"] " + proList.get(i).getProID() + ", " + proList.get(i).getProName());            
        }
        System.out.println("Choose Product: ");
        int maxOption = proList.size() -1;
        int choice = Validation.getInteger("Choose [0..."+ maxOption +"]", 
                "You are required to choose [0..."+ maxOption+"]", 0, maxOption);
        return proList.get(choice).getProID();
    }
    public void addNewOrder() {
        String ordid, status, date, cusid, proid; 
        int quantity;
        int pos;
        do {
            ordid =Validation.getID("Input Order ID (Dxxx): ",
                    "The format of id is Dxxx(x stands for a digit)",
                    "^[D|d]\\d{3}$");
            pos = searchOrderByID(ordid);
        } while (pos != -1);
        
        System.out.println("Customers list: ");
        cusid = customersSubmenu();
        
        System.out.println("Products list: ");
        proid = productsSubmenu();
        
        status = Validation.getStatus("Order Status: ", "You are required to input order status(Right format!)");
        
        date = Validation.getID("Input date: ", "The format is dd/mm/yyyy(Invalid date!)",
                "^(?:(?:31(\\/|)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");        
        
        quantity = Validation.getAnInteger("Quantity: ", "You are required to input quantity(Only number!)");
        orderList.add(new Orders(ordid, cusid, proid, String.valueOf(quantity), date, status));
        System.out.println("Order is added successfully\n");
        printAllOrders();
    }
        
    public void updateOrdersbasedonID() { //can coi lai 
        int pos;
        String id;
        do {
            id = Validation.getID("Input Order ID(Dxxx)", 
                    "The format of id is Dxxx(x stands for a digit)",
                    "^[D|d]\\d{3}$");
        pos = searchOrderByID(id);
        if (pos ==- 1) {
            System.out.println("Order does not exist");
        }
        } while (pos == -1);
        System.out.println("Order information: ");
        System.out.println(orderList.get(pos).toString());
        String status;
        Orders a = new Orders();
        a = (Orders) searchOrdObjectByID(id);
        status = Validation.getStatus("Order Status: ", "You are required to input order status(Right format!)");
        if(!status.equals("")) {
            a.setOrdStatus(status);
        }    
        System.out.println("Updated orders Sucessfully!");
        System.out.println("Order Updated info: ");
        System.out.println(orderList.get(pos).toString());
    }
    
        
    public void updateCustomer() {
        int pos;
        String id;
        do {
            id = Validation.getID("Input Customer ID (Cxxx): ",
                    "The format of id is Cxxx(x stands for a digit)",
                    "^[C|c]\\d{3}$");
            pos = searchCustomersByID(id);
            if (pos == -1) {
                System.out.println("Customer does not exist");
            }
        } while (pos == -1);
        System.out.println("Customer information: ");
        System.out.println(cusList.get(pos).toString());
        String Name, Address; 
        String Phone;
        Customers a = new Customers();
        a = (Customers) searchCusObjectByID(id);
        Name = Validation.getString("Input Customer Name: ", "You are required to input customer name!");
        String nameFormat = "";
        boolean match1 = Name.matches(nameFormat);
        if (Name.equals("") && match1) {
            a.setCusName(Name);
        }
        
        Address = Validation.getString("Input Customer Address: ", "You are required to input customer address!");
        if(!Address.equals("")) {
            a.setCusAdd(Address);
        }
        
        Phone = Validation.getString("Input Customer Phone: ", "You are required to input customer phone!"); 
        String format = "^[0-9]{10}|[0-9]{11}|[0-9]{12}$";
        boolean match;
        match = Phone.matches(format);
        if (!Phone.equals("") && match) {
            a.setCusPhone(Phone);
        }
        System.out.println("Updated Customer Sucessfully!");
        System.out.println("Customer Updated Info: ");
        System.out.println(cusList.get(pos).toString());        
    }
    
    public void deleteOrderbasedonID() {
        String id; 
        int pos;
        id = Validation.getID("Input Order ID (Dxxx): ",
                    "The format of id is Dxxx(x stands for a digit)",
                    "^[D|d]\\d{3}$");
        pos = searchOrderByID(id);
        if (pos == -1) {
            System.out.println("Order does not exist");
        } else {
            boolean a = Validation.getVerification("Do you want to remove it? (Y/N)");
            if (a) {
                orderList.remove(pos);
                System.out.println("Delete order successfully!");
            } else {
                System.out.println("Remove fail!");
            }
        }
        printAllOrders();
    }
    public boolean saveCusToFile(String fileName) {
        try {
            FileWriter file = new FileWriter("customers.txt");
            for (int i = 0; i < cusList.size(); i++) {
                if (i != 0) {
                    file.write("\n");
                }
                file.write(cusList.get(i).toString());
            }
            System.out.println("Save to file successfully !");
            file.close();
            return true;
        } catch (Exception e) {
            System.out.println("Cannot save to file !");
        }
        return false;
    }
    
    public boolean saveOrdersToFile(String fileName) {
        try {
            FileWriter file = new FileWriter("orders.txt");
            for (int i = 0; i < orderList.size(); i++) {
                if (i != 0) {
                    file.write("\n");
                }
                file.write(orderList.get(i).toString());
            }
            System.out.println("Save to file successfully !");
            file.close();
            return true;
        } catch (Exception e) {
            System.out.println("Cannot save to file !");
        }
        return false;
    }
    public void loadCustomerFromFile(String fName) {
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
                String address = stk.nextToken().toUpperCase();
                String phone = stk.nextToken();
                cusList.add(new Customers(id, name, address, phone));
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.err.println(e);
        }

    }
    
     public void loadProductsFromFile(String fName) {
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
                String unit = stk.nextToken();
                String origin = stk.nextToken();
                String price = stk.nextToken();
                proList.add(new Products(id, name, unit, origin, price));
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public void loadOrdersFromFile(String fName) {
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

                String ordid = stk.nextToken().toUpperCase();
                String cusid = stk.nextToken().toUpperCase();
                String proid = stk.nextToken().toUpperCase();
                String ordquantity = stk.nextToken();
                String orddate = stk.nextToken();
                String ordstatus = stk.nextToken();
                orderList.add(new Orders(ordid, cusid, proid, ordquantity, orddate, ordstatus));
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.err.println(e);
        }

    }
    
}
