package _01_If_Statements;

public class StringUtils {

    public String transform(String in) {
        if (in != null) {
            if (in.length() > 0) {
                if (in.length() < 5) {
                    return in.toLowerCase();
                } else {
                    if (in.length() > 10) {
                        return in.toUpperCase();
                    } else {
                        return in.toLowerCase();
                    }
                }
            } else {
                return "";
            }
        }
        return "";
    }
}
