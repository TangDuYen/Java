package Application.UI;

import Application.Utilities.DataInput;
import BussinessLayer.Service.HotelService;
import BussinessLayer.Service.IService;
import java.io.File;
import java.util.Collections;

public class Program {

    public static void main(String[] args) {
        int choice;
        String hotelInputFile = "hotel.txt";

        System.out.println(String.join("", Collections.nCopies(10, "**********")));
        try {
            File f = new File(hotelInputFile);
            f.createNewFile();
            
            IService hotelService = new HotelService(hotelInputFile);

            do {
                Menu.print("1. Hotel Management|2. Exit");
                choice = DataInput.inputter("Select: ", 1, 2);
                switch (choice) {
                    case 1:
                        Menu.manageHotel(hotelService);
                        break;
                    case 2:
                        System.out.println("Quit Program...");
                        System.exit(0);
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
