package bookstoredata;

public class BookData {
    private String ID, BookName, PublisherID, Status;
    private int Price, Quantity;

    public BookData() {
    }

    public BookData(String ID, String BookName, String PublisherID, String Status, int Price, int Quantity) {
        this.ID = ID;
        this.BookName = BookName;
        this.PublisherID = PublisherID;
        this.Status = Status;
        this.Price = Price;
        this.Quantity = Quantity;
    }

    public String getName() {
        return BookName;
    }

    public void setName(String Name) {
        this.BookName = Name;
    }

    public String getPubID() {
        return PublisherID;
    }

    public void setPubID(String PubID) {
        this.PublisherID = PubID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return ID + "," + BookName + "," + Price + "," + Quantity +  "," + PublisherID + "," + Status  ;
    }
    
    public String showInfo() {
        String msg;
        msg = String.format("|%-7s|%-40s|%-20s|%-10s|%-20s|%-20s|",
                ID,BookName,Price,Quantity,PublisherID, Status);
        return msg;
    }
    
}
