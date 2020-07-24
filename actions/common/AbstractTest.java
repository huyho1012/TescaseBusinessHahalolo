package common;

import java.util.Random;
public class AbstractTest {
    public String randomPassword(int chars) {
        String text = null;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "0123456789"+ "abcdefghijklmnopqrstuvxyz";
        StringBuilder bd = new StringBuilder(chars);
        for(int i =0 ; i< chars;i++) {
            int index = (int)(AlphaNumericString.length()*Math.random());
            text = bd.append(AlphaNumericString.charAt(index)).toString();
        }
        return text;
    }
    public int randomEmail(){
        Random rd = new Random();
        return rd.nextInt(1000);
    }
}
