package modern.challenge;

import java.time.LocalDate;

public final class Hospital {
    
    private Hospital() {
        throw new AssertionError("Cannot be instantiated");
    }          
    
    public static String cabinet(Staff staff) {
        
        /*
        if (staff instanceof Doctor(String name, String specialty)) { 
            return "The cabinet of " + specialty + " is currently under renovation";
        }
        */
        
        if (staff instanceof Doctor(_, String specialty)) { // if (staff instanceof Doctor(var _, String specialty))
            return "The cabinet of " + specialty + " is currently under renovation";
        }
         
        /*
        if (staff instanceof Resident(String name, Doctor dr)) { 
            return "The resident of this cabinet is : " + name;
        } 
        */
        
        if (staff instanceof Resident(String name, _)) { 
            return "The resident of this cabinet is : " + name;
        }
                         
        if (staff instanceof Resident(String rsname, Doctor(String drname, _))) { 
            return "This is the cabinet of doctor " + drname + " and resident " + rsname;
        }        
         
        return "Cabinet closed";
    }
        
    public static String reception(Object o) {
        
        /*        
        if (o instanceof Patient(var ptname, var npi, 
                        Appointment(var date, 
                        Doctor (var drname, var specialty)))) {
        
          return "Patient " + ptname + " has an appointment for the date of " + date;
        }
        */
        
        if (o instanceof Patient(var ptname, _, Appointment(var date, _))) {
        
          return "Patient " + ptname + " has an appointment for the date of " + date;
        }
        
        /*
        if (o instanceof Patient(var ptname, var npi, 
                        Appointment(var date, 
                        Doctor (var drname, var specialty)))) {
        
          return "Patient " + ptname + " has an appointment";
        }
        */
        
        if (o instanceof Patient(var ptname, _, _)) {
        
          return "Patient " + ptname + " has an appointment";
        }
        
        /*
        if (o instanceof Patient pt) {
        
          return "Patient " + pt.name() + " has an appointment";
        }
        */
        
        return "";
    }    
}