package Data;

public class Products {
    private String ProID, ProName, ProUnit, ProOrigin, ProPrice; 

    public Products() {
    }

    public Products(String ProID, String ProName, String ProUnit, String ProOrigin, String ProPrice) {
        this.ProID = ProID;
        this.ProName = ProName;
        this.ProUnit = ProUnit;
        this.ProOrigin = ProOrigin;
        this.ProPrice = ProPrice;
    }

    public String getProID() {
        return ProID;
    }

    public void setProID(String ProID) {
        this.ProID = ProID;
    }

    public String getProName() {
        return ProName;
    }

    public void setProName(String ProName) {
        this.ProName = ProName;
    }

    public String getProUnit() {
        return ProUnit;
    }

    public void setProUnit(String ProUnit) {
        this.ProUnit = ProUnit;
    }

    public String getProOrigin() {
        return ProOrigin;
    }

    public void setProOrigin(String ProOrigin) {
        this.ProOrigin = ProOrigin;
    }

    public String getProPrice() {
        return ProPrice;
    }

    public void setProPrice(String ProPrice) {
        this.ProPrice = ProPrice;
    }

    @Override
    public String toString() {
        return ProID + "," + ProName + "," + ProUnit + "," + ProOrigin + "," + ProPrice ;
    }
    
    
    
}
