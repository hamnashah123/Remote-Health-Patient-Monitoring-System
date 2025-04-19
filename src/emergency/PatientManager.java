package emergency;


import java.util.HashMap;
import java.util.Map;

public class PatientManager {
    private final Map<String, Patient> patients;

    public PatientManager() {
        patients = new HashMap<>();

        // Example patient creation (You can remove this later)
        Patient patient = new Patient("P001", "Ali Khan");
        patient.updateVitals(75, 110, 98.6); // Example vitals
        patients.put(patient.getId(), patient);

        // Debugging print statement
        System.out.println("Patient added: " + patient.getId() + " - " + patient.getName());
    }

    public Patient getPatient(String patientId) {
        Patient patient = patients.get(patientId);
        if (patient == null) {
            System.out.println("Patient not found with ID: " + patientId);
        }
        return patient;  // Return null if patient is not found
    }


    public void addPatient(String patientId, String patientName) {
        if (patients.containsKey(patientId)) {
            System.out.println("Patient with ID " + patientId + " already exists.");
            return;
        }

        if (patientId == null || patientId.isEmpty() || patientName == null || patientName.isEmpty()) {
            throw new IllegalArgumentException("Patient ID and name cannot be null or empty.");
        }

        Patient patient = new Patient(patientId, patientName);
        patients.put(patientId, patient);
        System.out.println("Patient added: " + patientId + " - " + patientName);
    }


    public void listPatients() {
        // List all stored patients
        if (patients.isEmpty()) {
            System.out.println("No patients available.");
        } else {
            for (Patient p : patients.values()) {
                System.out.println(p.getId() + " - " + p.getName());
            }
        }
    }
}
