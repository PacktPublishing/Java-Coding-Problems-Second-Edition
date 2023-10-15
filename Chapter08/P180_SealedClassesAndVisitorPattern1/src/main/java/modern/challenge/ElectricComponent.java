package modern.challenge;

public interface ElectricComponent {
    
    public String accept(ElectricComponentVisitor visitor);
}
