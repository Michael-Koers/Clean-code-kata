package _01_If_Statements;

public class StringUtils {

    public String transform(String in) {
        if (in == null || in.isEmpty()) {return "";}
        if (in.length() <= 10) {return in.toLowerCase();}

        return in.toUpperCase();
    }
}
