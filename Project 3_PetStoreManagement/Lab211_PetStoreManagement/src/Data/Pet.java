package Data;

public class Pet {
    private String date,description, category;
    private int unitPrice;

    public Pet() {
    }

    public Pet(String description,String date,int unitPrice,String category ) {
        this.date = date;
        this.description = description;
        this.category = category;
        this.unitPrice = unitPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return description + "," + date + "," + unitPrice + "," + category;
    }
    
    
    
}
