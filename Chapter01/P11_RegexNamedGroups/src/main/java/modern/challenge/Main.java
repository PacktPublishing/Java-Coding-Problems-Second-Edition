package modern.challenge;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String nameAndAddress = "Mark Janson;243 West Main St;Louisville;40202;USA";        
        
        Pattern pattern = Pattern.compile("""
                 (?<name>[ a-zA-Z]+);\
                 (?<address>[ 0-9a-zA-Z]+);\
                 (?<city>[ a-zA-Z]+);\
                 (?<zip>[\\d]+);\
                 (?<country>[ a-zA-Z]+)$""");

        Matcher matcher = pattern.matcher(nameAndAddress);

        matcher.matches();

        if (matcher.hasMatch()) {

            System.out.println(matcher.namedGroups());

            String name = matcher.group("name");
            String address = matcher.group("address");
            String city = matcher.group("city");
            String zip = matcher.group("zip");
            String country = matcher.group("country");

            System.out.println(name);
            System.out.println(address);
            System.out.println(city);
            System.out.println(zip);
            System.out.println(country);
        }

        String[] result = Pattern.compile(";+").splitWithDelimiters(nameAndAddress, 0);
        System.out.println(Arrays.toString(result));
    }
}