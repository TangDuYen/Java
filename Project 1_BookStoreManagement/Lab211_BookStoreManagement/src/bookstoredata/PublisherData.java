package bookstoredata;

public class PublisherData {
    private String PublisherID, PublisherName;
    private String PublisherPhone;

    public PublisherData() {
    }

    public PublisherData(String PublisherID, String PublisherName, String PublisherPhone) {
        this.PublisherID = PublisherID;
        this.PublisherName = PublisherName;
        this.PublisherPhone = PublisherPhone;
    }

    public String getPublisherID() {
        return PublisherID;
    }

    public void setPublisherID(String PublisherID) {
        this.PublisherID = PublisherID;
    }

    public String getPublisherName() {
        return PublisherName;
    }

    public void setPublisherName(String PublisherName) {
        this.PublisherName = PublisherName;
    }

    public String getPublisherPhone() {
        return PublisherPhone;
    }

    public void setPublisherPhone(String PublisherPhone) {
        this.PublisherPhone = PublisherPhone;
    }
    
    @Override
    public String toString() {
        return  PublisherID + "," + PublisherName + "," + PublisherPhone ;
    }
    
    public String showInfo() {
        String msg;
        msg = String.format("|%-15s|%-20s|%-15s|",
                PublisherID,PublisherName,PublisherPhone);
        return msg;
    }
    }
