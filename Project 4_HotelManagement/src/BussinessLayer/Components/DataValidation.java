package BussinessLayer.Components;

public class DataValidation {
    public static void printTitle(int type) {
        if(type == 1) System.out.println("\tHotel List");      
        System.out.println(String.format("%-8s | %-25s | %-15s | %-65s | %-10s | %-12s", "Hotel Id", "Hotel Name", "Room Available", "Address", "Phone number", "Rating"));
    }
    
}
