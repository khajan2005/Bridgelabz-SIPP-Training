import java.util.*;

class Patient {
    String name;

    Patient(String name) {
        this.name = name;
    }
}

class Doctor {
    String name;
    List<Patient> patients = new ArrayList<>();

    Doctor(String name) {
        this.name = name;
    }

    void consult(Patient p) {
        patients.add(p);
        System.out.println("Dr. " + name + " is consulting patient " + p.name);
    }
}

class Hospital {
    String hospitalName;

    Hospital(String name) {
        this.hospitalName = name;
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Care");

        Doctor drSmith = new Doctor("Smith");
        Doctor drEmily = new Doctor("Emily");

        Patient p1 = new Patient("Raj");
        Patient p2 = new Patient("Anita");

        drSmith.consult(p1);
        drSmith.consult(p2);
        drEmily.consult(p2);
    }
}
