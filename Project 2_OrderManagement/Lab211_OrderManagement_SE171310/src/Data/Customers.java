package Data;

public class Customers {
    private String CusID, CusName, CusAdd;
    private String CusPhone;

    public Customers() {
    }

    public Customers(String CusID, String CusName, String CusAdd, String CusPhone) {
        this.CusID = CusID;
        this.CusName = CusName;
        this.CusAdd = CusAdd;
        this.CusPhone = CusPhone;
    }

    public String getCusID() {
        return CusID;
    }

    public void setCusID(String CusID) {
        this.CusID = CusID;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String CusName) {
        this.CusName = CusName;
    }

    public String getCusAdd() {
        return CusAdd;
    }

    public void setCusAdd(String CusAdd) {
        this.CusAdd = CusAdd;
    }

    public String getCusPhone() {
        return CusPhone;
    }

    public void setCusPhone(String CusPhone) {
        this.CusPhone = CusPhone;
    }
    
    @Override
    public String toString () {
        return CusID + "," + CusName + "," + CusAdd + "," + CusPhone ;
    }    
    
    
        
    
    
    
    
}
