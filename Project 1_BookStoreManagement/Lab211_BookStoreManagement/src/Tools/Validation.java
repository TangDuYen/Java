package Tools;

import java.util.Scanner;

public class Validation {
    private static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String inputMesg, String errorMesg) {
        int n;
        while (true) {
            try {
                System.out.println(inputMesg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMesg);
            }
        }
    }

    public static int getAnInteger(String inputMesg, String errorMesg, int lowerBound, int upperBound) {
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

    public static String getID(String inputMesg, String errorMesg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.println(inputMesg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || !match) {
                System.out.println(errorMesg);
            } else {
                return id;
            }
        }
    }

    public static String getString(String inputMesg, String errorMesg) {
        String id;
        while (true) {
            System.out.println(inputMesg);
            id = sc.nextLine().trim();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(errorMesg);
            } else {
                return id;
            }
        }
    }
    public static String getName(String inputMesg, String errorMesg) {
        String id;
        while (true) {
            System.out.println(inputMesg);
            id = sc.nextLine().trim();
            if (id.length() >= 30 || id.isEmpty() || id.length() <= 5) {
                System.out.println(errorMesg);
            } else {
                return id;
            }
        }
    }

    public static String getString(String welcome) {
        boolean check = true;
        String result = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println("Input text only!!!");
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    public static int getInteger(String welcome) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Must be greater than 0");
            }
        } while (number <0);
        return number;
    }

    public static String getBlankableString(String inputMesg) {
        Scanner sc = new Scanner(System.in);
        String str = null;

        System.out.println(inputMesg);
        str = sc.nextLine();
        return str;
    }

    public static String getANonBlankString(String inputMesg, String errorMesg) {
        Scanner sc = new Scanner(System.in);
        String str = null;
        while (true) {
            System.out.println(inputMesg);
            str = sc.nextLine();
            if (str.length() > 250 || str == null || str.isEmpty()) {
                System.out.println(errorMesg);
            } else {
                return str;
            }
        }
    }

    public static String getANonBlankString(String inputMesg, String errorMesg, String format) {
        while (true) {
            String str = Validation.getANonBlankString(inputMesg, errorMesg);
            if (str.matches(format)) {
                return str;
            } else {
                System.out.println(errorMesg);
            }
        }
    }

    public static boolean getVerification(String inputMesg) {
        return getANonBlankString(inputMesg,
                "Confirmation failed. You are required to enter Y or N.",
                "^[Y|y|N|n]$").toUpperCase().equals("Y");

    }
    
}
