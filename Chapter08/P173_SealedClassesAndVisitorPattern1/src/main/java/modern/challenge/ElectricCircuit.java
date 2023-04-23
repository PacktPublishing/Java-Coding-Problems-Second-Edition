package modern.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElectricCircuit implements ElectricComponent {

    private final int id;
    private List<ElectricComponent> comps = new ArrayList<>();

    public ElectricCircuit(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<ElectricComponent> getComps() {
        return comps;
    }        

    public void add(ElectricComponent... comp) {
        comps.addAll(Arrays.asList(comp));
    }
    
    @Override
    public String accept(ElectricComponentVisitor visitor) {
        return visitor.visit(this);
    }   
}