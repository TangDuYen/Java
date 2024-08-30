package BussinessLayer.Entity;


public class Hotel {
    private String hotelId;
    private String name;
    private int roomAvailable = 0;
    private String address;
    private String phone;
    private String rating;

    public Hotel(String hotelId, String name, int roomAvailable, String address, String phone, String rating) {
        this.hotelId = hotelId;
        this.name = name;
        this.roomAvailable = roomAvailable;
        this.address = address;
        this.phone = phone;
        this.rating = rating;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomAvailable() {
        return roomAvailable;
    }

    public void setRoomAvailable(int roomAvailable) {
        this.roomAvailable = roomAvailable;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setData(String name, int roomAvailable, String address, String phone, String rating) {
        this.name = name;
        this.roomAvailable = roomAvailable;
        this.address = address;
        this.phone = phone;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("%-8s | %-25s | %-15s | %-65s | %-12s | %-12s", hotelId, name, roomAvailable, address, phone, rating);
    }   
}


