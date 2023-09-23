package modern.challenge;

import static modern.challenge.FuelType.GASOLINE;
import static modern.challenge.FuelType.HYDROGEN;
import static modern.challenge.FuelType.KEROSENE;

enum FuelType { GASOLINE, HYDROGEN, KEROSENE }

class Vehicle {
    
    private final int gallon;
    private final FuelType fuel;

    public Vehicle(int gallon, FuelType fuel) {
        this.gallon = gallon;
        this.fuel = fuel;
    }

    public int getGallon() {
        return gallon;
    }

    public FuelType getFuel() {
        return fuel;
    }            
}

public class Assess {

    private static String theVehicle(Vehicle vehicle) {

        return switch (vehicle) {
            case Vehicle v when (v.getFuel().equals(GASOLINE)
                    && v.getGallon() < 120) -> "probably a car/van"; 
            case Vehicle v when (v.getFuel().equals(GASOLINE)
                    && v.getGallon() > 120) -> "probably a big rig"; 
            case Vehicle v when (v.getFuel().equals(HYDROGEN) 
                    && v.getGallon() < 300_000) -> "probably an aircraft";
            case Vehicle v when (v.getFuel().equals(HYDROGEN) 
                    && v.getGallon() > 300_000) -> "probably a rocket";
            case Vehicle v when (v.getFuel().equals(KEROSENE) 
                    && v.getGallon() > 2_000 && v.getGallon() < 6_000) 
                    -> "probably a narrow-body aircraft";
            case Vehicle v when (v.getFuel().equals(KEROSENE) 
                    && v.getGallon() > 6_000 && v.getGallon() < 55_000)
                    -> "probably a large (B747-400) aircraft";
            default -> "no clue";
        };
    }

    public static void main(String[] args) {
        System.out.println(theVehicle(new Vehicle(500, GASOLINE)));
        System.out.println(theVehicle(new Vehicle(2000, HYDROGEN)));
        System.out.println(theVehicle(new Vehicle(20000, KEROSENE)));
        System.out.println(theVehicle(new Vehicle(20, KEROSENE)));
    }
}