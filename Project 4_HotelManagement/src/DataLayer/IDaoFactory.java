package DataLayer;

import BussinessLayer.Entity.Hotel;
import DataLayer.HotelDao.IHotelDao;

public interface IDaoFactory {
    IHotelDao<Hotel> hotelDAO() throws Exception;
}
