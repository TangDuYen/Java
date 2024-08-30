package DataLayer.HotelDao;

import BussinessLayer.Entity.Hotel;
import java.util.List;

public interface IHotelDao<T> {
    void loadDataFromFile() throws Exception;
    List<Hotel> getList();
    void addNew(Hotel h);
}
