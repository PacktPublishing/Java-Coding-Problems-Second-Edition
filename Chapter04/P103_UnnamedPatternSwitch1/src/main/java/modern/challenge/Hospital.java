package modern.challenge;

public final class Hospital {
    
    private Hospital() {
        throw new AssertionError("Cannot be instantiated");
    }        
    
    public static String cabinet(Staff staff) {
          
        /*
        return switch(staff) { 
            case Doctor(String name, String specialty) -> 
                "The cabinet of " + specialty + " is currently under renovation";
            case Resident(String name, Doctor dr) -> 
                "The resident of this cabinet is : " + name;
            default -> "Cabinet closed";
        };
        */
        
        return switch(staff) { 
            case Doctor(_, String specialty) -> 
                "The cabinet of " + specialty + " is currently under renovation";
            case Resident(String name, _) -> 
                "The resident of this cabinet is : " + name;
            default -> "Cabinet closed";
        };                          
    }
    
    public static String reception(Object o) {
              
        /*
        return switch(o) {            
            case Patient(String ptname, int npi, 
                        Appointment(LocalDate date, 
                        Doctor (String drname, String specialty))) ->
                  "Patient " + ptname + " has an appointment";
            default -> "";
        };
        */
        
        return switch(o) {            
            case Patient(String ptname, _, _) ->
                  "Patient " + ptname + " has an appointment";
            default -> "";
        };       
    }    
}