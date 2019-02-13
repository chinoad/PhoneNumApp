package PhoneNumApp;

import java.io.*;

public class PhoneNumberApp {

    public static void main(String[] args) {


        String filename = "/Users/chihiro/Desktop/JavaPrograms/PhoneNumApp/phonenumber.txt";
        File file = new File(filename);
        String[] phoneNums = new String[4];
        String phoneNum = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            for (int i = 0; i < phoneNums.length; i++) {
                phoneNums[i] = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error!! File not found!");
        } catch (IOException e) {
            System.out.println("Error! Cannot read file");
        }

        for (int i = 0; i < phoneNums.length; i++) {
            phoneNum = phoneNums[i];
            try {
                if ((phoneNum == "911") || (phoneNum.length() != 10) || (phoneNum.substring(0, 1).equals("0"))) {
                    throw new EmergencyException(phoneNum);
                } else if (phoneNum.substring(0, 1).equals("0")) {
                    throw new AreaCodeException(phoneNum);
                } else if (phoneNum.length() != 10) ;
                throw new TenDigitsException(phoneNum);

            } catch (EmergencyException e) {
                System.out.println("Error! The number cannot be 911");
                System.out.println(e.toString());

            } catch (TenDigitsException e) {
                System.out.println("Error! The number is not 10 digits");
                System.out.println(e.toString());
            } catch (AreaCodeException e) {
                System.out.println("Error! The number cannot start with 0");
                System.out.println(e.toString());
            }

        }

    }
}

class TenDigitsException extends Exception {
    String num;

    TenDigitsException(String num) {
        this.num = num;
    }

    public String toString() {
        return ("TenDigitsException: " + num);
    }
}

class AreaCodeException extends Exception {
    String num;

    AreaCodeException(String num) {
        this.num = num;
    }

    public String toString() {
        return ("AreaCodeException: " + num);
    }
}

class EmergencyException extends Exception {
    String num;

    EmergencyException(String num) {
        this.num = num;
    }

    public String toString() {
        return ("EmergencyException: " + num);
    }
}
