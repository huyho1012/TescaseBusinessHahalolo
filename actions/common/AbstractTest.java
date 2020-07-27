package common;

import org.openqa.selenium.WebDriver;

import java.util.Random;
public class AbstractTest {
    private WebDriver driver;
    protected String randomPassword(int chars) {
        String text = null;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "0123456789"+ "abcdefghijklmnopqrstuvxyz";
        StringBuilder bd = new StringBuilder(chars);
        for(int i =0 ; i< chars;i++) {
            int index = (int)(AlphaNumericString.length()*Math.random());
            text = bd.append(AlphaNumericString.charAt(index)).toString();
        }
        return text;
    }
    protected int randomEmail(){
        Random rd = new Random();
        return rd.nextInt(1000);
    }
}
