package modern.challenge;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        PhoneProcessor pp = new PhoneProcessor();
        
        List<String> names = List.of("Arita Ion", "Mark Jurg", "Paul Istrate");
        List<String> phones= List.of("244-815-0089", "0721-825-8892", "(045)655-9230");
        
        StringBuilder xmlMessage = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
        
        xmlMessage.append(pp."""          
           <name>\{names.get(i)}</name>
           <phone>\{phones.get(i)}</phone>                   
           """);
        }
           
        System.out.println(xmlMessage);
    }
}