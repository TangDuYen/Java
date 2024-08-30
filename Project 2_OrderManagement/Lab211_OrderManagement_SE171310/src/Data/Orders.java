package Data;

public class Orders {
    private String OrdID, CusID, ProID, OrdStatus, OrdDate, OrdQuantity;
    
    public Orders() {
    }

    public Orders(String OrdID, String CusID, String ProID, String OrdQuantity, String OrdDate,String OrdStatus) {
        this.OrdID = OrdID;
        this.CusID = CusID;
        this.ProID = ProID;
        this.OrdStatus = OrdStatus;
        this.OrdQuantity = OrdQuantity;
        this.OrdDate = OrdDate;
    }

    public String getOrdID() {
        return OrdID;
    }

    public void setOrdID(String OrdID) {
        this.OrdID = OrdID;
    }

    public String getCusID() {
        return CusID;
    }

    public void setCusID(String CusID) {
        this.CusID = CusID;
    }

    public String getProID() {
        return ProID;
    }

    public void setProID(String ProID) {
        this.ProID = ProID;
    }

    public String getOrdStatus() {
        return OrdStatus;
    }

    public void setOrdStatus(String OrdStatus) {
        this.OrdStatus = OrdStatus;
    }

    public String getOrdQuantity() {
        return OrdQuantity;
    }

    public void setOrdQuantity(String OrdQuantity) {
        this.OrdQuantity = OrdQuantity;
    }

    public String getOrdDate() {
        return OrdDate;
    }

    public void setOrdDate(String OrdDate) {
        this.OrdDate = OrdDate;
    }

    @Override
    public String toString() {
        return OrdID + "," + CusID + "," + ProID + "," + OrdQuantity + "," + OrdDate + "," + OrdStatus;
    }
    
}
