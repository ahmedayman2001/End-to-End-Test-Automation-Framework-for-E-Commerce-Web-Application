package MainPack;

import DataTypes.*;
import Utils.HelperClass;


public class Main {



    public static void main(String[] args){


        

        ValidPayment[] TestUser1 = HelperClass.readJson
                ("src/main/java/TestData/ValidPaymentData.JSON" , ValidPayment[].class ) ;






        for (ValidPayment test : TestUser1){

            System.out.println("===================");
            System.out.println(test.getCardNumber());
            System.out.println(test.getExpirationYear());
            System.out.println("====================");

        }


  }

}
