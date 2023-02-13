package modern.challenge;

import java.time.LocalDateTime;

public final class Hospital {
    
    private Hospital() {
        throw new AssertionError("Cannot be instantiated");
    }        
    
    public static String cabinet(Staff staff) {
        
        /*
        return switch(staff) { // type pattern matching
            case Doctor dr -> "Cabinet of " + dr.speciality() + ". Doctor: " + dr.name();
            case Resident rs -> "Cabinet of " + rs.doctor().speciality() + ". Doctor: " 
                    + rs.doctor().name() + ", Resident: " + rs.name();
            default -> "Cabinet closed";
        };
        */
        
        /*
        return switch(staff) { // record pattern matching
            case Doctor(String name, String speciality) -> "Cabinet of " + speciality + ". Doctor: " + name;
            case Resident(String rsname, Doctor(String drname, String speciality)) -> "Cabinet of " + speciality + ". Doctor: " 
                    + drname + ", Resident: " + rsname;
            default -> "Cabinet closed";
        };
        */
        
        return switch(staff) { // record pattern matching
            case Doctor(var name, var speciality) -> "Cabinet of " + speciality + ". Doctor: " + name;
            case Resident(var rsname, Doctor(var drname, var speciality)) -> "Cabinet of " + speciality + ". Doctor: " 
                    + drname + ", Resident: " + rsname;
            default -> "Cabinet closed";
        };
        
        /*
        return switch(staff) { // record pattern matching
            case Doctor(String name, String speciality) dr -> "Cabinet of " + dr.speciality() + ". Doctor: " + dr.name();
            case Resident(String rsname, Doctor(String drname, String speciality)) rs -> "Cabinet of " 
                    + rs.doctor().speciality() + ". Doctor: " + rs.doctor().name() + ", Resident: " + rs.name();
            default -> "Cabinet closed";
        };
        */
        
        /*
        return switch(staff) { // record pattern matching
            case Doctor(String name, String speciality) dr -> "Cabinet of " + dr.speciality() + ". Doctor: " + dr.name();
            case Resident(String rsname, Doctor(String drname, String speciality) dr ) rs -> "Cabinet of " 
                    + dr.speciality() + ". Doctor: " + dr.name() + ", Resident: " + rs.name();
            default -> "Cabinet closed";
        };
        */
    }
    
    public static String reception(Object o) {
                
        return switch(o) {
            
            case Patient(String ptname, int npi, 
                        Appointment(LocalDateTime date, 
                        Doctor (String drname, String speciality))) ->
                  "Patient " + ptname + " (NPI: " + npi + ") has an appointment at " 
                       + date + " to the doctor " + drname + " (" + speciality + ").";
          default -> "";
        };        
        
        /*
        return switch(o) {
            
            case Patient(var ptname, var npi, 
                        Appointment(var date, 
                        Doctor (var drname, var speciality))) ->
                  "Patient " + ptname + " (NPI: " + npi + ") has an appointment at " 
                       + date + " to the doctor " + drname + " (" + speciality + ").";
          default -> "";
        };
        */
        
        /*
        return switch(o) {
            
            case Patient(String ptname, int npi, 
                        Appointment(LocalDateTime date, 
                        Doctor (String drname, String speciality) dr) ap) pt ->
                  "Patient " + pt.name() + " (NPI: " + pt.npi() + ") has an appointment at " 
                       + ap.date() + " to the doctor " + dr.name() + " (" + dr.speciality() + ").";
          default -> "";
        };
        */
    }    
}