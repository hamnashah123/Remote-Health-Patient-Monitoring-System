package emergency;

import java.util.ArrayList;
import java.util.List;

public class PatientManager {
    private final List<String> patients = new ArrayList<>();

    public void addPatient(String patientId) {
        if (patientId == null || patientId.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient ID cannot be empty");
        }
        patients.add(patientId);
        System.out.println("Added patient: " + patientId);
    }

    public void listPatients() {
        System.out.println("\nCurrent Patients:");
        patients.forEach(System.out::println);
    }
}