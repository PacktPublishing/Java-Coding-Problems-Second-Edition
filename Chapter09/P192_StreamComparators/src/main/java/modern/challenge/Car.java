package modern.challenge;

import java.util.Objects;

public class Car { // implements Comparable<Car> {

    private final String brand;
    private final String fuel;
    private final int horsepower;

    public Car(String brand, String fuel, int horsepower) {
        this.brand = brand;
        this.fuel = fuel;
        this.horsepower = horsepower;
    }

    public String getBrand() {
        return brand;
    }

    public String getFuel() {
        return fuel;
    }

    public int getHorsepower() {
        return horsepower;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.brand);
        hash = 17 * hash + Objects.hashCode(this.fuel);
        hash = 17 * hash + this.horsepower;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if (this.horsepower != other.horsepower) {
            return false;
        }
        if (!Objects.equals(this.brand, other.brand)) {
            return false;
        }
        return Objects.equals(this.fuel, other.fuel);
    }

    @Override
    public String toString() {
        return "Car{" + "brand=" + brand + ", fuel=" + fuel + ", horsepower=" + horsepower + '}';
    }

    /*
    @Override
    public int compareTo(Car c) {

        return this.getHorsepower() > c.getHorsepower()
                ? 1 : this.getHorsepower() < c.getHorsepower() ? -1 : 0;
    }
    */
}
