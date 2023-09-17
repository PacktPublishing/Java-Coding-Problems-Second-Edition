package modern.challenge;

import com.fasterxml.jackson.databind.JsonNode;

public class Main {

    public static void main(String[] args) {

        PhoneProcessor pp = new PhoneProcessor();
        String workPhone = "072-825-9009";
        String homePhone = "(040)234-9670";
        
        JsonNode jsonMessage = pp."""
           { "contact": {
               "work": "\{workPhone}",
               "home": "\{homePhone}"
               }
           }  
           """;
           
        System.out.println(jsonMessage);
    }
}