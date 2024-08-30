package DataLayer;

import BussinessLayer.Entity.Hotel;
import DataLayer.HotelDao.HotelDao;
import DataLayer.HotelDao.IHotelDao;

public class DaoFactory implements IDaoFactory {  
    IFileManager fileManager;
    
    public DaoFactory() {        
    }
            
    public DaoFactory(String inputDataFile) {       
        this.fileManager = new FileManager(inputDataFile);
    }
        
    @Override
    public IHotelDao<Hotel> hotelDAO() throws Exception {
        return new HotelDao(fileManager);
    }
    
}
