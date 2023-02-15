package modern.challenge;

import java.time.LocalDate;

public final class Hospital {
    
    private Hospital() {
        throw new AssertionError("Cannot be instantiated");
    }        
    
    public static String cabinet(Staff staff) {
        
        /*
        return switch(staff) { // type pattern matching
            case Doctor dr -> "Cabinet of " + dr.specialty() + ". Doctor: " + dr.name();
            case Resident rs -> "Cabinet of " + rs.doctor().specialty() + ". Doctor: " 
                    + rs.doctor().name() + ", Resident: " + rs.name();
            default -> "Cabinet closed";
        };
        */
        
        /*
        return switch(staff) { // record pattern matching
            case Doctor(String name, String specialty) -> "Cabinet of " + specialty + ". Doctor: " + name;
            case Resident(String rsname, Doctor(String drname, String specialty)) -> "Cabinet of " + specialty + ". Doctor: " 
                    + drname + ", Resident: " + rsname;
            default -> "Cabinet closed";
        };
        */
        
        return switch(staff) { // record pattern matching
            case Doctor(var name, var specialty) -> "Cabinet of " + specialty + ". Doctor: " + name;
            case Resident(var rsname, Doctor(var drname, var specialty)) -> "Cabinet of " + specialty + ". Doctor: " 
                    + drname + ", Resident: " + rsname;
            default -> "Cabinet closed";
        };
        
        /*
        return switch(staff) { // record pattern matching
            case Doctor(String name, String specialty) dr -> "Cabinet of " + dr.specialty() + ". Doctor: " + dr.name();
            case Resident(String rsname, Doctor(String drname, String specialty)) rs -> "Cabinet of " 
                    + rs.doctor().specialty() + ". Doctor: " + rs.doctor().name() + ", Resident: " + rs.name();
            default -> "Cabinet closed";
        };
        */
        
        /*
        return switch(staff) { // record pattern matching
            case Doctor(String name, String specialty) dr -> "Cabinet of " + dr.specialty() + ". Doctor: " + dr.name();
            case Resident(String rsname, Doctor(String drname, String specialty) dr ) rs -> "Cabinet of " 
                    + dr.specialty() + ". Doctor: " + dr.name() + ", Resident: " + rs.name();
            default -> "Cabinet closed";
        };
        */
    }
    
    public static String reception(Object o) {
                
        return switch(o) {
            
            case Patient(String ptname, int npi, 
                        Appointment(LocalDate date, 
                        Doctor (String drname, String specialty))) ->
                  "Patient " + ptname + " (NPI: " + npi + ") has an appointment at " 
                       + date + " to the doctor " + drname + " (" + specialty + ").";
          default -> "";
        };        
        
        /*
        return switch(o) {
            
            case Patient(var ptname, var npi, 
                        Appointment(var date, 
                        Doctor (var drname, var specialty))) ->
                  "Patient " + ptname + " (NPI: " + npi + ") has an appointment at " 
                       + date + " to the doctor " + drname + " (" + specialty + ").";
          default -> "";
        };
        */
        
        /*
        return switch(o) {
            
            case Patient(String ptname, int npi, 
                        Appointment(LocalDate date, 
                        Doctor (String drname, String specialty) dr) ap) pt ->
                  "Patient " + pt.name() + " (NPI: " + pt.npi() + ") has an appointment at " 
                       + ap.date() + " to the doctor " + dr.name() + " (" + dr.specialty() + ").";
          default -> "";
        };
        */
    }    
}