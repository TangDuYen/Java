package Application.UI;

import Application.Utilities.DataInput;
import BussinessLayer.Service.IService;

public class HotelMenu {

    IService service;

    public HotelMenu() {
    }

    public HotelMenu(IService service) {
        this.service = service;
    }

    public void processMenuForHotel() {
        int sel = -1;
        boolean cont = false;
        do {
            Menu.print("******Hotel Management******|1. Adding new Hotel.|2. Checking exist Hotel.|3. Updating Hotel information."
                    + "|4. Deleting Hotel.|5. Searching Hotel.|6. Displaying a hotel list (descending by Hotel Name).|7. Save data to file.|"
                    + "8. Display Hotels by Room|9. Quit Program");
            sel = DataInput.inputter("Select: ", 1, 9);
            System.out.println("-----------------------------------");
            switch (sel) {
                case 1:
                    System.out.println("1. Adding new Hotel.");
                    service.addHotel();
                    break;
                case 2:
                    System.out.println("2. Checking exist Hotel.");
                    service.checkExistHotel();
                    break;
                case 3:
                    System.out.println("3. Updating Hotel information.");
                    service.updateHotel();
                    break;
                case 4:
                    System.out.println("4. Deleting Hotel.");
                    service.deleteHotel();
                    break;
                case 5:
                    System.out.print("5. Searching Hotel.");
                    Menu.print("|\t5.1. Searching by Hotel Id.|\t5.2. Searching by Hotel Name.|");
                    int opt = DataInput.inputter("\tSelect: ", 1, 2);
                    switch (opt) {
                        case 1:
                            service.searchByHotelId();
                            break;
                        case 2:
                            service.searchByHotelName();
                            break;
                    }
                    break;
                case 6:
                    System.out.println("6. Displaying a hotel list (descending by Hotel Name).");
                    service.displayHotelList();
                    break;
                case 7:
                    System.out.println("7. Save data to file.");
                    service.saveToFile();
                    break;
                case 8: 
                    System.out.println("8. Display Hotels by Room");
                    service.printHotelBaseOnRoom();
                    break;
                case 9:
                    System.out.println("\tApplication has stopped...");
                    break;
            }
        } while (sel != 9);
    }
}
