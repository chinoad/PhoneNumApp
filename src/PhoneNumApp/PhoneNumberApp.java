package PhoneNumApp;

import java.io.*;

public class PhoneNumberApp {

    public static void main(String[] args) {


        String filename = "/Users/chihiro/Desktop/JavaPrograms/PhoneNumApp/phonenumber.txt";
        File file = new File(filename);
        String phoneNum = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            phoneNum = br.readLine();
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error!! File not found!");
        } catch (IOException e) {
            System.out.println("Error! Cannot read file");
        }


        try {
            if (phoneNum.length() != 10) {
                throw new TenDigitsException();
            }
            System.out.println(phoneNum);
        } catch(TenDigitsException e) {
            System.out.println("Error! The number is not 10 digits");
        }

    }


}

class TenDigitsException extends Exception{

}

class AreaCodeException extends Exception {

}

class EmergencyException extends Exception {

}