package modern.challenge;

import java.time.LocalDate;

public final class Hospital {
    
    private Hospital() {
        throw new AssertionError("Cannot be instantiated");
    }          
    
    public static String cabinet(Staff staff) {
         
        /*
        if (staff instanceof Doctor dr 
                && dr.speciality().equals("Dermatology")) { 
            return "The cabinet of " + dr.speciality() + " is currently under renovation";
        }
        */
                
        if (staff instanceof Doctor(String name, String speciality) 
                && speciality.equals("Dermatology")) { 
            return "The cabinet of " + speciality + " is currently under renovation";
        }
                
        if (staff instanceof Doctor(String name, String speciality) 
                && (speciality.equals("Allergy") && (name.equals("Kyle Ulm")))) { 
            return "The cabinet of " + speciality + " is closed. The doctor " 
                    + name + " is on holiday.";
        }                
                
        if (staff instanceof Doctor(String name, String speciality) 
                && (speciality.equals("Allergy") && (name.equals("John Hora")))) { 
            return "The cabinet of " + speciality + " is open. The doctor " 
                    + name + " is ready to receive patients.";
        }
                         
        if (staff instanceof Resident(String rsname, 
                             Doctor(String drname, String speciality))
                               && (speciality.equals("Dermatology") && rsname.equals("Mark Oil"))) { 
            return "Cabinet of " + speciality + ". Doctor " 
                    + drname + " and resident " + rsname + " are ready to receive patients.";
        }        
         
        return "Cabinet closed";
    }
        
    public static String reception(Object o) {
                
        if(o instanceof Patient(var ptname, var npi, 
                        Appointment(var date, 
                        Doctor (var drname, var speciality)))
             && (ptname.equals("Alicia Goy") && npi == 1234567890 && LocalDate.now().equals(date))) {
        
          return "The doctor " + drname + " from " + speciality + " is ready for you " + ptname;
        }
        
        return "";
    }    
}