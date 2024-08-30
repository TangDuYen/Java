package Tools;

import java.util.Scanner;

public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getInteger(String inputMesg, String errorMesg, int lowerBound, int upperBound) {
        if (upperBound < lowerBound) {
            int tmp = upperBound;
            upperBound = lowerBound;
            lowerBound = tmp;

        }
        int n;
        while (true) {
            try {
                System.out.println(inputMesg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMesg);
            }
        }

    }

    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.println(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || !match) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static String getString(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.println(inputMsg);
            id = sc.nextLine();
            if (id.length() == 0) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static String getStatus(String inputMsg, String errorMsg) {
        String status;
        while (true) {
            System.out.println(inputMsg);
            status = sc.nextLine().trim().toLowerCase();
            if (!status.isEmpty()) {
                if (status.equals("true") || status.equals("false")) {
                    return status;
                } else {
                    System.out.println(errorMsg);
                }
            }

        }
    }

    public static String getNonBlankString(String inputMsg, String errorMsg) {
        Scanner sc = new Scanner(System.in);
        String str = null;
        while (true) {
            System.out.println(inputMsg);
            str = sc.nextLine();
            if (str.length() > 250 || str == null || str.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return str;
            }
        }
    }

    public static String getANonBlankString(String inputMsg, String errorMsg, String format) {
        while (true) {
            String str = Validation.getNonBlankString(inputMsg, errorMsg);
            if (str.matches(format)) {
                return str;
            } else {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getCategory(String inputMsg, String errorMsg) {
        while(true) {
            String str = Validation.getNonBlankString(inputMsg, errorMsg);
            if(str.equals("Cat")||str.equals("Dog")||str.equals("Parrot")){
            return str;
            } else {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static boolean getVerification(String inputMesg) {
        return getANonBlankString(inputMesg,
                "Confirmation failed. You are required to enter Y or N.",
                "^[Y|y|N|n]$").toUpperCase().equals("Y");
    }
}
