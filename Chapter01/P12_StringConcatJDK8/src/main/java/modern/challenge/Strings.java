package modern.challenge;

import java.util.List;

public class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String concatViaPlus(String str1, String str2, String str3, String str4) {

        return str1 + str2 + str3 + str4;
    }

    public static String concatViaStringBuilder(String str1, String str2, String str3, String str4) {

        StringBuilder sb = new StringBuilder();

        sb.append(str1)
                .append(str2)
                .append(str3)
                .append(str4);

        return sb.toString();
    }
    
    public static String concatListViaPlus(List<String> strs) {

        String result = "";
        for(String str: strs) {
            result = result + str;
        }
        
        return result;
    }
    
    public static String concatListViaStringBuilder(List<String> strs) {

        StringBuilder result = new StringBuilder();
        
        for(String str: strs) {
            result.append(str);
        }
        
        return result.toString();
    }
}