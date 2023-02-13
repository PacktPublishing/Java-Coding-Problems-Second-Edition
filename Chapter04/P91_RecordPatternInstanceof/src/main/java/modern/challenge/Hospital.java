package modern.challenge;

public final class Hospital {
    
    private Hospital() {
        throw new AssertionError("Cannot be instantiated");
    }
    
    /*
    public static String cabinet(Staff staff) {

        if (staff instanceof Doctor) {
            Doctor dr = (Doctor) staff;
            return "Cabinet of " + dr.speciality() + ". Doctor: " + dr.name();
        }
        
        if (staff instanceof Resident) {
            Resident rs = (Resident) staff;
            return "Cabinet of " + rs.doctor().speciality() + ". Doctor: " 
                    + rs.doctor().name() + ", Resident: " + rs.name();
        }
        
        return "Cabinet closed";
    }    
    */        
    
    public static String cabinet(Staff staff) {
        
        /*
        if (staff instanceof Doctor dr) { // type pattern matching
            return "Cabinet of " + dr.speciality() + ". Doctor: " + dr.name();
        }
        */
        
        if (staff instanceof Doctor(String name, String speciality)) { // record pattern matching
            return "Cabinet of " + name + ". Doctor: " + speciality;
        }
        
        /*
        if (staff instanceof Doctor(String name, String speciality) dr) { // record pattern matching
            return "Cabinet of " + dr.speciality() + ". Doctor: " + dr.name();
        }
        */
        
        /*
        if (staff instanceof Resident rs) { // type pattern matching
            return "Cabinet of " + rs.doctor().speciality() + ". Doctor: " 
                    + rs.doctor().name() + ", Resident: " + rs.name();
        }
        */
        
        /*
        if (staff instanceof Resident(String name, Doctor dr)) { // record pattern matching
            return "Cabinet of " + dr.speciality() + ". Doctor: " 
                    + dr.name() + ", Resident: " + name;
        }
        */
                                              
        if (staff instanceof Resident(String rsname, 
                                      Doctor(String drname, String speciality))) { // record pattern matching
            return "Cabinet of " + speciality + ". Doctor: " 
                    + drname + ", Resident: " + rsname;
        }        
        
        /*
        if (staff instanceof Resident(String rsname, 
                                      Doctor(String drname, String speciality) dr)) { // record pattern matching
            return "Cabinet of " + dr.speciality() + ". Doctor: " 
                    + dr.name() + ", Resident: " + rsname;
        }
        */
        
        /*
        if (staff instanceof Resident(String rsname, 
                                      Doctor(String drname, String speciality) dr) rs) { // record pattern matching
            return "Cabinet of " + dr.speciality() + ". Doctor: " 
                    + dr.name() + ", Resident: " + rs.name();
        } 
        */

        return "Cabinet closed";
    }
        
    public static String reception(Object o) {
        
        /*
        if(o instanceof Patient(String ptname, int npi, 
                        Appointment(LocalDateTime date, 
                        Doctor (String drname, String speciality)))) {
        
          return "Patient " + ptname + " (NPI: " + npi + ") has an appointment at " 
                  + date + " to the doctor " + drname + " (" + speciality + ").";
        }
        */
        
        /*
        if(o instanceof Patient(String ptname, int npi, 
                        Appointment(LocalDateTime date, 
                        Doctor (String drname, String speciality) dr) ap) pt) {
        
          return "Patient " + pt.name() + " (NPI: " + pt.npi() + ") has an appointment at " 
                  + ap.date() + " to the doctor " + dr.name() + " (" + dr.speciality() + ").";
        }
        */
        
        if(o instanceof Patient(var ptname, var npi, 
                        Appointment(var date, 
                        Doctor (var drname, var speciality)))) {
        
          return "Patient " + ptname + " (NPI: " + npi + ") has an appointment at " 
                  + date + " to the doctor " + drname + " (" + speciality + ").";
        }
        
        return "";
    }    
}