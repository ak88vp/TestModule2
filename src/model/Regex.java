package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static boolean validateOfBirth(String regex) {
        Pattern pattern = Pattern.compile("\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}");
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean validateEmail(String regex){
        Pattern pattern = Pattern.compile("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$");
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean validateNumberPhone(String regex){
        Pattern pattern = Pattern.compile("[0][0-9]{9}");
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }


}
