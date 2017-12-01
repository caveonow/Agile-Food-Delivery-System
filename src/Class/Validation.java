/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author caveon
 */
public class Validation {
    
    public static boolean email_Validation(String email){
        boolean status = false;
        
        String email_Pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
        Pattern pattern = Pattern.compile(email_Pattern);
        Matcher matcher = pattern.matcher(email);
        
        if(matcher.matches()){
            status = true;
        }else {
            status = false;
        }
        return status;
    }
}