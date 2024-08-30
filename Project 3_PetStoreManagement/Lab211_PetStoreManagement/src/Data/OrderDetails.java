package Data;

public class OrderDetails {
    private int ordID, petID, quantity, petCost;

    public OrderDetails() {
    }

    public OrderDetails(int ordID, int petID, int quantity, int petCost) {
        this.ordID = ordID;
        this.petID = petID;
        this.quantity = quantity;
        this.petCost = petCost;
    }

    public int getOrdID() {
        return ordID;
    }

    public void setOrdID(int ordID) {
        this.ordID = ordID;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPetCost() {
        return petCost;
    }

    public void setPetCost(int petCost) {
        this.petCost = petCost;
    }

    @Override
    public String toString() {
        return ordID + "," + petID + "," + quantity + "," + petCost;
    }
    
    
    
}
