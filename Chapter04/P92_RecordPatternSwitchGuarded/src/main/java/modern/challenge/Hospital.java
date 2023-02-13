package modern.challenge;

import java.time.LocalDate;

public final class Hospital {
    
    private Hospital() {
        throw new AssertionError("Cannot be instantiated");
    }        
    
    public static String cabinet(Staff staff) {
                
        return switch(staff) { 
            //case Doctor dr
            //  when dr.speciality().equals("Dermatology") 
            //       -> "The cabinet of " + dr.speciality() + " is currently under renovation";
            case Doctor(var name, var speciality) 
               when speciality.equals("Dermatology") 
                    -> "The cabinet of " + speciality + " is currently under renovation";
            case Doctor(var name, var speciality) 
               when (speciality.equals("Allergy") && (name.equals("Kyle Ulm"))) 
                    -> "The cabinet of " + speciality + " is closed. The doctor " + name + " is on holiday.";
            case Doctor(var name, var speciality) 
               when (speciality.equals("Allergy") && (name.equals("John Hora"))) 
                    -> "The cabinet of " + speciality + " is open. The doctor " + name + " is ready to receive patients.";
            case Resident(var rsname, Doctor(var drname, var speciality)) 
               when (speciality.equals("Dermatology") && rsname.equals("Mark Oil")) 
                    -> "Cabinet of " + speciality + ". Doctor " + drname + " and resident " + rsname + " are ready to receive patients.";
            default -> "Cabinet closed";
        };                
    }
    
    public static String reception(Object o) {
                
        return switch(o) {
            
            case Patient(String ptname, int npi, 
                        Appointment(LocalDate date, 
                        Doctor (String drname, String speciality)))
                        when (ptname.equals("Alicia Goy") && npi == 1234567890 && LocalDate.now().equals(date)) 
                            -> "The doctor " + drname + " from " + speciality + " is ready for you " + ptname;
          default -> "";
        };                
    }    
}