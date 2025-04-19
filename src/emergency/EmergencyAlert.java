//package emergency;
//import notifications.Notifiable;
//
//public class EmergencyAlert {
//    private final String patientId;
//    private final Notifiable notifier;
//    private final double heartRateThreshold;
//    private final double bloodPressureThreshold;
//    private final double temperatureThreshold;
//
//    public EmergencyAlert(String patientId, Notifiable notifier,
//                          double heartRateThreshold,
//                          double bloodPressureThreshold,
//                          double temperatureThreshold) {
//        this.patientId = patientId;
//        this.notifier = notifier;
//        this.heartRateThreshold = heartRateThreshold;
//        this.bloodPressureThreshold = bloodPressureThreshold;
//        this.temperatureThreshold = temperatureThreshold;
//    }
//
//    public void checkVitals(double heartRate, double bloodPressure, double temperature) {
//        if (heartRate > heartRateThreshold) {
//            triggerAlert("CRITICAL HEART RATE: " + heartRate + " bpm (Threshold: " + heartRateThreshold + ")");
//        }
//
//        if (bloodPressure > bloodPressureThreshold) {
//            triggerAlert("CRITICAL BLOOD PRESSURE: " + bloodPressure + " mmHg (Threshold: " + bloodPressureThreshold + ")");
//        }
//
//        if (temperature > temperatureThreshold) {
//            triggerAlert("CRITICAL TEMPERATURE: " + temperature + "°F (Threshold: " + temperatureThreshold + ")");
//        }
//        else {
//            System.out.println("All vitals are normal");
//        }
//    }
//
//    private void triggerAlert(String message) {
//        String fullMessage = "PATIENT " + patientId + ": " + message;
//        notifier.sendNotification("emergency_team@hospital.com", fullMessage);
//        notifier.sendNotification(patientId + "@patientportal.com", "ALERT SENT: " + message);
//    }
//}
//
//


package emergency;
import notifications.Notifiable;

public class EmergencyAlert {
    private final String patientId;
    private final Notifiable notifier;
    private final double heartRateThreshold;
    private final double bloodPressureThreshold;
    private final double temperatureThreshold;

    public EmergencyAlert(String patientId, Notifiable notifier,
                          double heartRateThreshold,
                          double bloodPressureThreshold,
                          double temperatureThreshold) {
        if (patientId == null || patientId.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient ID cannot be empty");
        }
        if (notifier == null) {
            throw new IllegalArgumentException("Notifier cannot be null");
        }
        if (heartRateThreshold <= 0 || bloodPressureThreshold <= 0 || temperatureThreshold <= 0) {
            throw new IllegalArgumentException("Thresholds must be positive");
        }

        this.patientId = patientId;
        this.notifier = notifier;
        this.heartRateThreshold = heartRateThreshold;
        this.bloodPressureThreshold = bloodPressureThreshold;
        this.temperatureThreshold = temperatureThreshold;
    }

    public void checkVitals(double heartRate, double bloodPressure, double temperature) {
        if (heartRate <= 0 || bloodPressure <= 0 || temperature <= 0) {
            throw new IllegalArgumentException("Vital signs must be positive");
        }

        boolean isCritical = false;

        if (heartRate > heartRateThreshold) {
            triggerAlert("CRITICAL HEART RATE: " + heartRate + " bpm (Threshold: " + heartRateThreshold + ")");
            isCritical = true;
        }

        if (bloodPressure > bloodPressureThreshold) {
            triggerAlert("CRITICAL BLOOD PRESSURE: " + bloodPressure + " mmHg (Threshold: " + bloodPressureThreshold + ")");
            isCritical = true;
        }

        if (temperature > temperatureThreshold) {
            triggerAlert("CRITICAL TEMPERATURE: " + temperature + "°F (Threshold: " + temperatureThreshold + ")");
            isCritical = true;
        }

        if (!isCritical) {
            System.out.println("All vitals are normal for patient " + patientId);
        }
    }

    private void triggerAlert(String message) {
        String fullMessage = "PATIENT " + patientId + ": " + message;
        notifier.sendNotification("emergency_team@hospital.com", fullMessage);
        notifier.sendNotification(patientId + "@patientportal.com", "ALERT: " + message);
    }
}