package BussinessLayer.Service;

public interface IService {
    void addHotel();
    void checkExistHotel();
    void updateHotel();
    void deleteHotel();
    void searchByHotelId();
    void searchByHotelName();
    void displayHotelList();
    void saveToFile();
    void printHotelBaseOnRoom();
}
