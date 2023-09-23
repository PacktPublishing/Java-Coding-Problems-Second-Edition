package modern.challenge;

import java.util.Arrays;

public class Main {     
       
    final static class PlayerClub implements Sport {};        
    private enum PlayerTypes implements Sport { TENNIS, FOOTBALL, SNOOKER }
    
    sealed interface Sport permits PlayerTypes, PlayerClub {};
    
    // JDK 20
    /*
    private static String createPlayerOrClub(Sport s) {       

        return switch (s) {
            case PlayerTypes p when p == PlayerTypes.TENNIS -> "Creating a tennis player ...";
            case PlayerTypes p when p == PlayerTypes.FOOTBALL -> "Creating a football player ...";
            case PlayerTypes p -> "Creating a snooker player ...";             
            case PlayerClub p -> "Creating a sport club ...";
        };
    }
    */
    
    // JDK 21    
    private static String createPlayerOrClub(Sport s) {       

        return switch (s) {
            case PlayerTypes.TENNIS -> "Creating a tennis player ...";
            case PlayerTypes.FOOTBALL -> "Creating a football player ...";
            case PlayerTypes.SNOOKER -> "Creating a snooker player ...";   
            case PlayerClub p -> "Creating a sport club ...";
        };
    }             

    public static void main(String[] args) {
        
        Arrays.asList(PlayerTypes.FOOTBALL, PlayerTypes.SNOOKER, PlayerTypes.TENNIS, new PlayerClub()).stream()
                .map(Main::createPlayerOrClub)
                .forEach(System.out::println);
    }
}