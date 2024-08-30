package BussinessLayer.Service;

import Application.Utilities.DataInput;
import BussinessLayer.Components.DataValidation;
import BussinessLayer.Entity.Hotel;
import DataLayer.DaoFactory;
import DataLayer.IDaoFactory;
import DataLayer.HotelDao.IHotelDao;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HotelService implements IService {

    IHotelDao hotelAction;
    IDaoFactory hotelDaoFactory;
    List<Hotel> hotelList;

    public HotelService() {
    }

    public HotelService(String inputDataFile) throws Exception {
        hotelDaoFactory = new DaoFactory(inputDataFile);
        this.hotelAction = hotelDaoFactory.hotelDAO();
        hotelList = hotelAction.getList();
        if (hotelList == null) {
            hotelList = new ArrayList<>();
        }
    }

    @Override
    public void addHotel() {
        do {
            String hotelId = "";
            int pos = -1;
            do {
                hotelId = DataInput.inputStr("Enter Hotel Id (Hxx, x is digit): ", "^(H|h)[0-9]{2}$", "\tInvalid Hotel Id!");
                pos = getHotel(hotelId);
                if (pos != -1) {
                    System.out.println("\tHotel ID is already exist in file!");
                }
            } while (pos != -1);
            String hotelName = DataInput.inputStr("Enter Hotel Name: ", "[A-Za-z\\d\\s]+", "\tInvalid Hotel Name!");
            int roomAvailable = DataInput.inputInt("Enter room available: ", "\tInvalid number of room!");
            String hotelAddress = DataInput.inputStr("Enter Hotel Address: ", "[A-Za-z\\d\\s,]+", "\tInvalid Hotel Address!");
            String hotelPhone = DataInput.inputStr("Enter Hotel Phone (10 digits): ", "[\\d]{10}", "\tInvalid Hotel Phone!");
            String hotelRating = DataInput.inputStr("Enter rating (1->6 star): ", "^([1-6]){1}\\s+star$", "\tInvalid rating, must be entered (x star) x is digit!");
            hotelList.add(new Hotel(hotelId.toUpperCase(), hotelName, roomAvailable, hotelAddress, hotelPhone, hotelRating));
            System.out.println("\tSuccessfully add new hotel!");
        } while (DataInput.confirmYesNo("Do you want to continue adding hotel? (Y/N): ") == true);
    }

    @Override
    public void checkExistHotel() {
        if (hotelList.isEmpty()) {
            System.out.println("\tList Hotel is empty!");
            return;
        }
        do {
            String hotelId = DataInput.inputStr("Enter Hotel Id to check exist: ", "^(H|h)[0-9]{2}$", "\tInvalid Hotel Id, must be entered (Hxx, x is digit)!");
            if (getHotel(hotelId) == -1) {
                System.out.println("\tNo Hotel Found with id: " + hotelId + "!");
                return;
            }
            System.out.println("\tExist Hotel!");
        } while (DataInput.confirmYesNo("Do you want to continue checking exist hotel? (Y/N): ") == true);
    }

    @Override
    public void updateHotel() {
        if (hotelList.isEmpty()) {
            System.out.println("\tList Hotel is empty!");
            return;
        }
        String hotelId = DataInput.inputStr("Enter Hotel Id to update: ", "^(H|h)[0-9]{2}$", "\tInvalid Hotel Id, must be entered (Hxx, x is digit)!");
        int pos = getHotel(hotelId);
        if (pos == -1) {
            System.out.println("\tNo Hotel Found with id: " + hotelId + "!");
            System.out.println("\tFail updated hotel information!");
            return;
        }
        System.out.println("\tOld information:");
        DataValidation.printTitle(0);
        Hotel h = hotelList.get(pos);
        System.out.println(h);
        System.out.println("");

        String hotelName = DataInput.inputStr("Enter new Hotel Name: ", "([A-Za-z\\d\\s]+)?", "\tInvalid Hotel Name!");
        if (hotelName.equals("")) {
            hotelName = h.getName();
        }

        int roomAvailable = DataInput.inputInt("Enter new room available: ", "\tInvalid number of room!", h.getRoomAvailable());
        String hotelAddress = DataInput.inputStr("Enter new Hotel Address: ", "([A-Za-z\\d\\s]+)?", "\tInvalid Hotel Address!");
        if (hotelAddress.equals("")) {
            hotelAddress = h.getAddress();
        }
        String hotelPhone = DataInput.inputStr("Enter new Hotel Phone (10 digits): ", "([\\d]{10})?", "\tInvalid Hotel Phone!");
        if (hotelPhone.equals("")) {
            hotelPhone = h.getPhone();
        }
        String hotelRating = DataInput.inputStr("Enter new rating (1->6 star): ", "(^([1-6])\\s+star$)?", "\tInvalid rating, must be entered (x star) x is digit!");
        if (hotelRating.equals("")) {
            hotelRating = h.getRating();
        }

        h.setData(hotelName, roomAvailable, hotelAddress, hotelPhone, hotelRating);

        System.out.println("\tNew information:");
        DataValidation.printTitle(0);
        System.out.println(h);
        System.out.println("\tSuccessfully updated new information for hotel");
    }

    @Override
    public void deleteHotel() {
        if (hotelList.isEmpty()) {
            System.out.println("\tList Hotel is empty!");
            return;
        }
        String hotelId = DataInput.inputStr("Enter Hotel Id to delete: ", "^(H|h)[0-9]{2}$", "\tInvalid Hotel Id, must be entered (Hxx, x is digit)!");

        int pos = getHotel(hotelId);
        if (pos == -1) {
            System.out.println("\tNo Hotel Found with id: " + hotelId + "!");
            System.out.println("\tFail deleted hotel!");
            return;
        }

        if (DataInput.confirmYesNo("Do you ready want to delete this hotel?(Y/N): ") == true) {
            hotelList.remove(pos);
            System.out.println("\tSuccessfully remove hotel with id: " + hotelId + "!");
        } else {
            System.out.println("\tFail deleted hotel!");
        }
    }

    @Override
    public void searchByHotelId() {
        if (hotelList.isEmpty()) {
            System.out.println("\tList Hotel is empty!");
            return;
        }
        String hotelId = DataInput.getString("Enter Hotel Id want to search: ").toLowerCase();
        ArrayList<Hotel> temp = new ArrayList<>();
        for (Hotel h : hotelList) {
            if (h.getHotelId().toLowerCase().contains(hotelId)) {
                temp.add(h);
            }
        }

        if (temp.isEmpty()) {
            System.out.println("\tNo hotels have an Id that contains " + hotelId + "!");
            return;
        }
        Collections.sort(temp, new Comparator<Hotel>() {
            @Override
            public int compare(Hotel o1, Hotel o2) {
                return o2.getHotelId().compareToIgnoreCase(o1.getHotelId());
            }
        });

        DataValidation.printTitle(1);
        for (Hotel h : temp) {
            System.out.println(h);
        }
    }

    @Override
    public void searchByHotelName() {
        if (hotelList.isEmpty()) {
            System.out.println("\tList Hotel is empty!");
            return;
        }
        String hotelName = DataInput.getString("Enter Hotel Name want to search: ").toLowerCase();
        for (Hotel h : hotelList) {
            if (h.getName().contains(hotelName)) {
                System.out.println("\tInformation:");
                DataValidation.printTitle(0);
                System.out.println(h);
                return;
            }
        }
        System.out.println("\tNo hotels have the same name: " + hotelName);
    }

    @Override
    public void displayHotelList() {
        if (hotelList.isEmpty()) {
            System.out.println("\tList Hotel is empty!");
            return;
        }
        ArrayList<Hotel> temp = new ArrayList<>(hotelList);
        Collections.sort(temp, new Comparator<Hotel>() {
            @Override
            public int compare(Hotel o1, Hotel o2) {
                return o2.getName().compareToIgnoreCase(o1.getName());
            }
        });
        DataValidation.printTitle(1);
        for (Hotel h : temp) {
            System.out.println(h);
        }
    }

    @Override
    public void saveToFile() {
        try {
            FileWriter fw = new FileWriter("hotel.txt");
            BufferedWriter br = new BufferedWriter(fw);
            for (Hotel h : hotelList) {
                br.write(h.toString());
                br.newLine();
            }
            System.out.println("\tSuccessfully save data to file!");
            br.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("\tFail saveda data to file!");
        }
    }

    private int getHotel(String hotelId) {
        if (hotelList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < hotelList.size(); ++i) {
            if (hotelList.get(i).getHotelId().equalsIgnoreCase(hotelId)) {
                return i;
            }
        }
        return -1;
    }
    //Them chuc nang tim hotel co so phong >= x (nhap tu ban phim) va in danh sach theo so phong giam dan va cho biet co bao nhieu Hotel dc tim thay 

    @Override
    public void printHotelBaseOnRoom() {
        if (hotelList.isEmpty()) {
            System.out.println("\tList Hotel is empty!");
            return;
        }
        int roomAvailable = DataInput.inputInt("Enter room available: ", "\tInvalid number of room!");
        int count = 0;
        ArrayList<Hotel> temp = new ArrayList<>();
        for (Hotel a : hotelList) {
            if (a.getRoomAvailable() >= roomAvailable) {
                temp.add(a);
                count++;
            }
        }
        Collections.sort(temp, new Comparator<Hotel>() {
            @Override
            public int compare(Hotel o1, Hotel o2) {
                return o2.getRoomAvailable() - o1.getRoomAvailable();
            }
        });
        DataValidation.printTitle(1);
        for (Hotel b : temp) {
            System.out.println(b);
        }
        System.out.println("There are " + count + " Hotels in the list");
    }

}
