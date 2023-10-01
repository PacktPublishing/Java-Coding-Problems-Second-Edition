package modern.challenge;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Doctor dr = new Doctor("John Beer", "Dermatology");        
        Resident rs = new Resident("Mark Oil", dr);
        Patient pt = new Patient("Alicia Goy", 1234567890,
                new Appointment(LocalDate.now(),
                        new Doctor("Rares Masdd", "Rheumatology")));
        
        System.out.println(Hospital.cabinet(dr));
        System.out.println(Hospital.cabinet(rs));
        System.out.println(Hospital.reception(pt));
    }
}
