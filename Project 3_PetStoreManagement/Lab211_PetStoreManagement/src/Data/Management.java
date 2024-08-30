package Data;

import Tools.Validation;
import java.util.Scanner;
import java.util.TreeMap;

public class Management {

    TreeMap<String, Pet> petMap = new TreeMap<>();
    TreeMap<OrderHeader, OrderDetails> orderMap = new TreeMap<>();

    private Scanner sc = new Scanner(System.in);

    public void addPet() {
        String id = Validation.getString("Enter Pet Id: ", "Cannot skip!");
        petMap.put(id, inputPet());
        System.out.println("Added successfully!");
    }

    Pet inputPet() {
        Pet pet = new Pet();
        String description = Validation.getANonBlankString("Description: ", "Cannot skip!", ".{3,50}");
        pet.setDescription(description);
        String date = Validation.getID("Input date: ", "The format is dd/mm/yyyy(Invalid date!)",
                "^(?:(?:31(\\/|)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
        pet.setDate(date);
        int unitPrice = Validation.getPositiveNumber("Enter unit price: ", "You are required to input number(Cannot skip!)");
        pet.setUnitPrice(unitPrice);
        String category = Validation.getCategory("Enter pet category: ", "Cannot skip!");
        pet.setCategory(category);
        return pet;
    }

    public void printPet() {
        petMap.forEach((id, pet) -> System.out.println(id + "," + pet));
    }

    public void findPet(String id) {
        if (id.isEmpty()) id = Validation.getString("Enter Pet Id: ", "You are required to input pet id");
        if (petMap.get(id) != null) {
            System.out.println(petMap.get(id));
        } else {
            System.out.println("The pet does not exist!");
        }
    }

    public void updatePet() {
        String id = Validation.getString("Enter Pet Id: ", "You are require to input pet id(Rigt format!)");
        if (petMap.containsKey(id)) {
            petMap.replace(id, inputPet());
            System.out.println("Updated successfully!");
            printPet();
        } else {
            System.out.println("The pet does not exist!");
        }
    }
    
    public void deletePet() {
        String id = Validation.getString("Enter Pet Id: ", "You are require to input pet id");
        findPet(id);
        if(petMap.containsKey(id)) {
            boolean a = Validation.getVerification("Do you want to remove it? (Y/N)");
            petMap.remove(id);
            System.out.println("Remove successfully");
        } else {
            System.out.println("Remove fail!");
        }
    }
    

}
