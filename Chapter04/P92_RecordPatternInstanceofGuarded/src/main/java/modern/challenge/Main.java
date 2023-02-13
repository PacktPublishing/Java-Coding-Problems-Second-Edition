package modern.challenge;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Doctor dr1 = new Doctor("John Beer", "Dermatology");
        Doctor dr2 = new Doctor("Kyle Ulm", "Allergy");
        Doctor dr3 = new Doctor("John Hora", "Allergy");
        
        Resident rs = new Resident("Mark Oil", dr1);
        Patient pt = new Patient("Alicia Goy", 1234567890,
                new Appointment(LocalDate.now(),
                        new Doctor("Rares Masdd", "Rheumatology")));
        
        System.out.println(Hospital.cabinet(dr1));
        System.out.println(Hospital.cabinet(dr2));
        System.out.println(Hospital.cabinet(dr3));
        System.out.println(Hospital.cabinet(rs));        
        System.out.println(Hospital.reception(pt));        
    }
}
