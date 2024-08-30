package Application.UI;

import BussinessLayer.Service.IService;

public class Menu {
    public static void print(String str) {
        String[] menuList = str.trim().split("\\|");
        for(String menuItem : menuList) {
            if(menuItem.equalsIgnoreCase("Select")) {
                System.out.print(menuItem);
            } else {
                System.out.println(menuItem);
            }
        }
    }
    
    public static void manageHotel(IService service) {
        HotelMenu holMenu = new HotelMenu(service);
        holMenu.processMenuForHotel();
    }
}
