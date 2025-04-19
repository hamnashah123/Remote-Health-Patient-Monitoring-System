package vitals;

import emergency.Patient;

public class VitalsProcessor {
    public static void analyzeVitals(Patient patient) {
        if (patient == null) {
            System.out.println("Error: Patient data is null.");
            return;
        }

        System.out.println("\nAnalyzing vitals for " + patient.getName());

        String hrStatus = (patient.getHeartRate() >= 60 && patient.getHeartRate() <= 100) ? "Normal" : "Abnormal";
        String bpStatus = (patient.getBloodPressure() >= 90 && patient.getBloodPressure() <= 120) ? "Normal" : "Abnormal";
        String tempStatus = (patient.getTemperature() >= 97 && patient.getTemperature() <= 99) ? "Normal" : "Abnormal";

        patient.displayVitals();
        System.out.println("Heart Rate Status: " + hrStatus);
        System.out.println("Blood Pressure Status: " + bpStatus);
        System.out.println("Temperature Status: " + tempStatus);
    }
}
