package modern.challenge;

public class Main {

    public enum PlayerTypes {
        TENNIS,
        FOOTBALL,
        SNOOKER,
        UNKNOWN
    }

    public static void main(String[] args) {

        createPlayerNoNullCheck(PlayerTypes.TENNIS);
        createPlayerNoNullCheck(null);

        createPlayerNullCheck(PlayerTypes.TENNIS);
        createPlayerNullCheck(null);

        createPlayerNullCase(PlayerTypes.TENNIS);
        createPlayerNullCase(null);

        createPlayerNullAndDefaultCase(PlayerTypes.TENNIS);
        createPlayerNullAndDefaultCase(null);      
    }

    private static Player createPlayerNoNullCheck(PlayerTypes playerType) {

        return switch (playerType) {
            case TENNIS ->
                new TennisPlayer();
            case FOOTBALL ->
                new FootballPlayer();
            case SNOOKER ->
                new SnookerPlayer();
            case UNKNOWN ->
                throw new UnknownPlayerException("Player type is unknown");
            // default is not mandatory
            default ->
                throw new IllegalArgumentException("Invalid player type: " + playerType);
        };
    }
    
    private static Player createPlayerNoNullCheckYield(PlayerTypes playerType) {

        return switch (playerType) {
            case TENNIS:
                yield new TennisPlayer();
            case FOOTBALL:
                yield new FootballPlayer();
            case SNOOKER:
                yield new SnookerPlayer();
            case UNKNOWN:
                throw new UnknownPlayerException("Player type is unknown");
            // default is not mandatory
            default:
                throw new IllegalArgumentException("Invalid player type: " + playerType);
        };
    }

    private static Player createPlayerNullCheck(PlayerTypes playerType) {

        // handling null values in a condition outside switch
        if (playerType == null) {
            throw new IllegalArgumentException("Player type cannot be null");
        }

        return switch (playerType) {
            case TENNIS ->
                new TennisPlayer();
            case FOOTBALL ->
                new FootballPlayer();
            case SNOOKER ->
                new SnookerPlayer();
            case UNKNOWN ->
                throw new UnknownPlayerException("Player type is unknown");
            // default is not mandatory
            default ->
                throw new IllegalArgumentException("Invalid player type: " + playerType);
        };
    }
    
    private static Player createPlayerNullCheckYield(PlayerTypes playerType) {

        // handling null values in a condition outside switch
        if (playerType == null) {
            throw new IllegalArgumentException("Player type cannot be null");
        }

        return switch (playerType) {
            case TENNIS:
                yield new TennisPlayer();
            case FOOTBALL:
                yield new FootballPlayer();
            case SNOOKER:
                yield new SnookerPlayer();
            case UNKNOWN:
                throw new UnknownPlayerException("Player type is unknown");
            // default is not mandatory
            default:
                throw new IllegalArgumentException("Invalid player type: " + playerType);
        };
    }

    private static Player createPlayerNullCase(PlayerTypes playerType) {

        return switch (playerType) {
            case TENNIS ->
                new TennisPlayer();
            case FOOTBALL ->
                new FootballPlayer();
            case SNOOKER ->
                new SnookerPlayer();
            case null ->
                throw new NullPointerException("Player type cannot be null");
            case UNKNOWN ->
                throw new UnknownPlayerException("Player type is unknown");
            // default is not mandatory
            default ->
                throw new IllegalArgumentException("Invalid player type: " + playerType);
        };
    }
    
    private static Player createPlayerNullCaseYield(PlayerTypes playerType) {

        return switch (playerType) {
            case TENNIS:
                yield new TennisPlayer();
            case FOOTBALL:
                yield new FootballPlayer();
            case SNOOKER:
                yield new SnookerPlayer();
            case null:
                throw new NullPointerException("Player type cannot be null");
            case UNKNOWN:
                throw new UnknownPlayerException("Player type is unknown");
            // default is not mandatory
            default:
                throw new IllegalArgumentException("Invalid player type: " + playerType);
        };
    }

    private static Player createPlayerNullAndDefaultCase(PlayerTypes playerType) {

        return switch (playerType) {
            case TENNIS ->
                new TennisPlayer();
            case FOOTBALL ->
                new FootballPlayer();
            case SNOOKER ->
                new SnookerPlayer();            
            // default is not mandatory
            case null, default ->
                throw new IllegalArgumentException("Invalid player type: " + playerType);
        };
    }
    
    private static Player createPlayerNullAndDefaultCaseYield(PlayerTypes playerType) {

        return switch (playerType) {
            case TENNIS:
                yield new TennisPlayer();
            case FOOTBALL:
                yield new FootballPlayer();
            case SNOOKER:
                yield new SnookerPlayer();
            // default is not mandatory
            case null, default:
                throw new IllegalArgumentException("Invalid player type: " + playerType);
        };
    }       
}
