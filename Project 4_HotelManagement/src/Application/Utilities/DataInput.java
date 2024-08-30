package Application.Utilities;

import java.util.Scanner;

public class DataInput {
    private static Scanner in = new Scanner(System.in);

    public static String getString(String welcome) {
        boolean check = true;
        String result = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println("Input text!!!");
            } else { 
                check = false;
            }
        } while (check);
        return result;
    }
    
    public static boolean confirmYesNo(String welcome) {
        boolean result = false;
        String confirm = DataInput.getString(welcome);
        if ("Y".equalsIgnoreCase(confirm)) {
            result = true;
        }
        return result;
    }
    
    public static String inputStr(String mess, String pattern, String messError) {
        String s = "";
        do {
            System.out.print(mess);
            s = in.nextLine().trim().toLowerCase();
            if(!s.matches(pattern)) {
                System.out.println(messError);
            }
        } while(!s.matches(pattern)); 
        return s;
    }

    public static int inputInt(String mess, String messError) {
        int d = -1;
        boolean check = true; //Khi số lượng <= 0 thì nhập lại
        do {
            System.out.print(mess);
            try {
                d = Integer.parseInt(in.nextLine().trim()); 
                if(d < 0) throw new Exception(); 
                check = false; 
            } catch(Exception e) {
                System.out.println(messError);
            }
        } while(check); 
        return d;
    }    
    
    
    public static int inputInt(String mess, String messError, int oldInformation) {
        int d = -1;
        boolean check = true; 
        do {
            System.out.print(mess);
            try {
                String t = in.nextLine().trim();
                if(t.equals("")) {
                    return oldInformation;
                }
                d = Integer.parseInt(t); 
                if(d < 0) throw new Exception(); 
                check = false; 
            } catch(Exception e) {
                System.out.println(messError);
            }
        } while(check); 
        return d;
    }    

    public static int inputter(String mess, int range1, int range2) {
        int resInput = -1;
        boolean repeat = true;
        do {
            try {
                System.out.print(mess);
                resInput = Integer.parseInt(in.nextLine());
                if (resInput < range1 || resInput > range2) {
                    throw new Exception();
                }
                repeat = false;
            } catch (Exception e) {
                System.out.println("\tInvalid option!");
            }
        } while(repeat);          
        return resInput;
    }        
}
