package com.wildcodeschool.whereismyband.repository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckerRepository {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public boolean checkEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
    }

    public boolean checkPassword (String pass, String checker){
        return pass.equals(checker);
    }

    public boolean checkPostcode (String postcode){

        if (postcode.length() == 5) {
            for (int i = 0; i < 5 ; i++){
                if (postcode.charAt(i) < 48 || postcode.charAt(i) > 57){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
