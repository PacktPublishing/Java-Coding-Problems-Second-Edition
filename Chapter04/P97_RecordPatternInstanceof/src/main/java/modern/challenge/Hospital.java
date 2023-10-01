package modern.challenge;

public final class Hospital {
    
    private Hospital() {
        throw new AssertionError("Cannot be instantiated");
    }
    
    /*
    public static String cabinet(Staff staff) {

        if (staff instanceof Doctor) {
            Doctor dr = (Doctor) staff;
            return "Cabinet of " + dr.specialty() + ". Doctor: " + dr.name();
        }
        
        if (staff instanceof Resident) {
            Resident rs = (Resident) staff;
            return "Cabinet of " + rs.doctor().specialty() + ". Doctor: " 
                    + rs.doctor().name() + ", Resident: " + rs.name();
        }
        
        return "Cabinet closed";
    }    
    */        
    
    public static String cabinet(Staff staff) {
        
        /*
        if (staff instanceof Doctor dr) { // type pattern matching
            return "Cabinet of " + dr.specialty() + ". Doctor: " + dr.name();
        }
        */
                
        if (staff instanceof Doctor(String name, String specialty)) { // record pattern matching
            return "Cabinet of " + name + ". Doctor: " + specialty;
        }        
                            
        /*
        if (staff instanceof Resident rs) { // type pattern matching
            return "Cabinet of " + rs.doctor().specialty() + ". Doctor: " 
                    + rs.doctor().name() + ", Resident: " + rs.name();
        }
        */
        
        /*
        if (staff instanceof Resident(String name, Doctor dr)) { // record pattern matching
            return "Cabinet of " + dr.specialty() + ". Doctor: " 
                    + dr.name() + ", Resident: " + name;
        }
        */
                                              
        if (staff instanceof Resident(String rsname, 
                                      Doctor(String drname, String specialty))) { // record pattern matching
            return "Cabinet of " + specialty + ". Doctor: " 
                    + drname + ", Resident: " + rsname;
        }                                               

        return "Cabinet closed";
    }
        
    public static String reception(Object o) {
        
        /*
        if (o instanceof Patient(String ptname, int npi, 
                        Appointment(LocalDate date, 
                        Doctor (String drname, String specialty)))) {
        
          return "Patient " + ptname + " (NPI: " + npi + ") has an appointment at " 
                  + date + " to the doctor " + drname + " (" + specialty + ").";
        }
        */                               
        
        /*
        if (o instanceof Patient(var ptname, var npi, var ap)) {
        
          return "Patient " + ptname + " (NPI: " + npi + ") has an appointment at " 
                  + ap.date() + " to the doctor " + ap.doctor().name() + " (" + ap.doctor().specialty() + ").";
        }
        */
        
        if (o instanceof Patient(var ptname, var npi, 
                        Appointment(var date, 
                        Doctor (var drname, var specialty)))) {
        
          return "Patient " + ptname + " (NPI: " + npi + ") has an appointment at " 
                  + date + " to the doctor " + drname + " (" + specialty + ").";
        }
        
        return "";
    }    
}