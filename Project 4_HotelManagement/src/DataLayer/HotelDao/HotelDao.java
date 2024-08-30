package DataLayer.HotelDao;

import BussinessLayer.Entity.Hotel;
import DataLayer.IFileManager;
import java.util.ArrayList;
import java.util.List;

public class HotelDao implements IHotelDao {

    IFileManager<String> fileManager;
    List<Hotel> hotelList;

    public HotelDao() {

    }

    public HotelDao(IFileManager fileManager) throws Exception {
        this.fileManager = fileManager;
        hotelList = new ArrayList<>();
        loadDataFromFile();
    }

    @Override
    public void loadDataFromFile() throws Exception {
        List<String> hotelData = fileManager.readDataFromFile();
        String id, name, address, phone, rating;
        int roomAvail;
        for(String lines : hotelData) {
            String[] arr = lines.trim().split("\\|");
            id = arr[0].trim();
            name = arr[1].trim();
            roomAvail = Integer.parseInt(arr[2].trim());
            address = arr[3].trim();
            phone = arr[4].trim();
            rating = arr[5].trim();
            addNew(new Hotel(id.toUpperCase(), name, roomAvail, address, phone, rating));
        }
    }

    @Override
    public List<Hotel> getList()  {
        if (hotelList.isEmpty()) {
            return null;
        }
        return hotelList;
    }

    @Override
    public void addNew(Hotel t) {
        hotelList.add(t);
    }
}
