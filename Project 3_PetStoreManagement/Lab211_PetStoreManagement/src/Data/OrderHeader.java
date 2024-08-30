package Data;

public class OrderHeader {
    private int id, date;
    private String cusName;

    public OrderHeader() {
    }

    public OrderHeader(int id, String cusName, int date ) {
        this.id = id;
        this.date = date;
        this.cusName = cusName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    @Override
    public String toString() {
        return id + "," + cusName + "," + date;
    }
    
    
    
    
    
    
    
}
