package modern.challenge;

import java.time.LocalDate;

public final class Hospital {
    
    private Hospital() {
        throw new AssertionError("Cannot be instantiated");
    }          
    
    public static String cabinet(Staff staff) {
         
        /*
        if (staff instanceof Doctor dr 
                && dr.specialty().equals("Dermatology")) { 
            return "The cabinet of " + dr.specialty() + " is currently under renovation";
        }
        */
                
        if (staff instanceof Doctor(String name, String specialty) 
                && specialty.equals("Dermatology")) { 
            return "The cabinet of " + specialty + " is currently under renovation";
        }
                
        if (staff instanceof Doctor(String name, String specialty) 
                && (specialty.equals("Allergy") && (name.equals("Kyle Ulm")))) { 
            return "The cabinet of " + specialty + " is closed. The doctor " 
                    + name + " is on holiday.";
        }                
                
        if (staff instanceof Doctor(String name, String specialty) 
                && (specialty.equals("Allergy") && (name.equals("John Hora")))) { 
            return "The cabinet of " + specialty + " is open. The doctor " 
                    + name + " is ready to receive patients.";
        }
                         
        if (staff instanceof Resident(String rsname, 
                             Doctor(String drname, String specialty))
                               && (specialty.equals("Dermatology") && rsname.equals("Mark Oil"))) { 
            return "Cabinet of " + specialty + ". Doctor " 
                    + drname + " and resident " + rsname + " are ready to receive patients.";
        }        
         
        return "Cabinet closed";
    }
        
    public static String reception(Object o) {
                
        if(o instanceof Patient(var ptname, var npi, 
                        Appointment(var date, 
                        Doctor (var drname, var specialty)))
             && (ptname.equals("Alicia Goy") && npi == 1234567890 && LocalDate.now().equals(date))) {
        
          return "The doctor " + drname + " from " + specialty + " is ready for you " + ptname;
        }
        
        return "";
    }    
}