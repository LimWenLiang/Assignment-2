package my.example.CoronavirusCases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

    public boolean isMatch(String pattern, String myString) {
        Pattern pt = Pattern.compile(pattern);
        Matcher mt = pt.matcher(myString);

        if (mt.find()) {
            return true;
        } else {
            return false;
        }
    }
}
