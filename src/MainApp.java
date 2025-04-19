import emergency.*;
import consultation.*;
import notifications.*;
import vitals.*;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;



public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize services
        Notifiable email = new EmailNotification();
        Notifiable sms = new SMSNotification();
        NotificationService notificationService = new NotificationService(email, sms);
        PatientManager manager = new PatientManager();
        Patient patient = manager.getPatient("PAT001");

        vitals.VitalsProcessor.analyzeVitals(patient);

        while (true) {
            System.out.println("\nHEALTHCARE SYSTEM MENU");
            System.out.println("1. Patient Management");
            System.out.println("2. Appointment Scheduling");
            System.out.println("3. Emergency Module");
            System.out.println("4. Doctor Feedback");
            System.out.println("5. Chat Module");
            System.out.println("6. Video Calls");
            System.out.println("7. Reminders");
            System.out.println("8. Patient Vitals");
            System.out.println("9. All Modules");
            System.out.println("10. Exit");
            System.out.print("Select an option (1-10): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> testPatientManagement();
                    case 2 -> testAppointments();
                    case 3 -> testEmergencySystem(notificationService, email);
                    case 4 -> testFeedback();
                    case 5 -> testChatSystem();
                    case 6 -> testVideoCalls();
                    case 7 -> testReminders(email);
                    case 8 -> testPatientVitals();
                    case 9 -> testAllModules(notificationService, email);
                    case 10 -> {
                        System.out.println("Exiting program...");
                        return;
                    }
                    default -> System.out.println("Invalid choice! Please select 1-10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a number (1-10)");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static void testPatientManagement() {
        try {
            System.out.println("\nPATIENT MANAGEMENT");
            PatientManager manager = new PatientManager();
            boolean done = false;

            while (!done) {
                System.out.println("\n1. Add Patient");
                System.out.println("2. List Patients");
                System.out.println("3. Go Back to Main Menu");
                System.out.print("Choose an option (1-3): ");
                String option = scanner.nextLine();

                switch (option) {
                    case "1" -> {
                        System.out.print("Enter Patient ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Patient Name: ");
                        String name = scanner.nextLine();
                        manager.addPatient(id, name);
                    }
                    case "2" -> {
                        System.out.println("\nCurrent Patients:");
                        manager.listPatients();
                    }
                    case "3" -> done = true;
                    default -> System.out.println("Invalid option. Try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error in Patient Management: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private static void testPatientVitals() {
        try {
            PatientManager manager = new PatientManager();

            // Add patients
            manager.addPatient("PAT003", "Bilal Raza");
            manager.addPatient("PAT004", "Maham Tariq");

            // Simulate updating and analyzing vitals
            Patient patient = manager.getPatient("PAT003");
            patient.updateVitals(95, 130, 98.6);
            VitalsProcessor.analyzeVitals(patient);

            Patient patient2 = manager.getPatient("PAT004");
            patient2.updateVitals(110, 150, 101.3);
            VitalsProcessor.analyzeVitals(patient2);
        } catch (Exception e) {
            System.out.println("Error in Patient Vitals Module: " + e.getMessage());
        }
        pressEnterToContinue();
    }


    // ====== NEW APPOINTMENT SCHEDULING ======
    private static void testAppointments() {
        try {
            System.out.println("\nAPPOINTMENT TEST ");
            AppointmentScheduler scheduler = new AppointmentScheduler();
            LocalDateTime time1 = LocalDateTime.now().plusDays(1).withHour(10).withMinute(0);
            LocalDateTime time2 = LocalDateTime.now().plusDays(2).withHour(14).withMinute(30);

            scheduler.scheduleAppointment("S.Abubak001", time1);
            scheduler.scheduleAppointment("H.shah002", time2);
            System.out.println("\nScheduled Appointments:");
            System.out.println("- S.Abubak001 at " + time1);
            System.out.println("- H.shah002 at " + time2);
        } catch (Exception e) {
            System.out.println("Error in Appointments: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    // ====== EXISTING TEST METHODS (with try-catch) ======
    private static void testEmergencySystem(NotificationService notifier, Notifiable email) {
        try {
            System.out.println("\nEMERGENCY SYSTEM TEST");
            EmergencyAlert alert = new EmergencyAlert("PAT789", notifier, 100, 140, 101.5);
            alert.checkVitals(82, 120, 98.6);
            alert.checkVitals(112, 145, 102.1);
            new PanicButton(email).press();
        } catch (Exception e) {
            System.out.println("Error in Emergency System: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private static void testFeedback() {
        try {
            System.out.println("\nDOCTOR FEEDBACK TEST =");
            FeedbackSystem feedback = new FeedbackSystem();
            feedback.submitFeedback("DR101", "S.Abubak001", "Excellent diagnosis");
            feedback.submitFeedback("DR102", "H.shah002", "Could explain better");
        } catch (Exception e) {
            System.out.println("Error in Feedback System: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private static void testChatSystem() {
        try {
            System.out.println("\nCHAT SYSTEM TEST ");
            ChatServer server = new ChatServer();
            ChatClient doctor = new ChatClient("Dr Faizan", server);
            ChatClient patient = new ChatClient("Ahad", server);
            doctor.send("Ahad", "How are you feeling?");
            patient.send("Dr Faizan", "Much better!");
            System.out.println("\nChat History:");
            server.getHistory().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error in Chat System: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private static void testVideoCalls() {
        try {
            System.out.println("\n VIDEO CALL TEST");
            VideoCall zoomCall = new VideoCall("Zoom");
            zoomCall.startCall("Dr Rizwan", "Sameer");
            System.out.println("Zoom Link: " + zoomCall.getMeetingLink());
        } catch (Exception e) {
            System.out.println("Error in Video Calls: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private static void testReminders(Notifiable notifier) {
        try {
            System.out.println("\n REMINDERS TEST");
            ReminderService reminders = new ReminderService(notifier);
            reminders.sendReminder("Sameer", "Take medication", "Dosage: 200mg Ibuprofen at 10AM");
            reminders.sendReminder("Tayyaba", "Take medication", "Dosage: 100mg Aspirin at 8AM");
        } catch (Exception e) {
            System.out.println("Error in Reminders: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private static void testAllModules(NotificationService notifier, Notifiable email) {
        testPatientManagement();
        testAppointments();
        testEmergencySystem(notifier, email);
        testFeedback();
        testChatSystem();
        testVideoCalls();
        testReminders(email);
    }

    private static void pressEnterToContinue() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
}



class PatientManager {
    private final List<Patient> patients = new ArrayList<>();

    public void addPatient(String patientId, String name) {
        // Prevent duplicates
        for (Patient p : patients) {
            if (p.getId().equals(patientId)) {
                System.out.println("Patient with ID " + patientId + " already exists.");
                return;
            }
        }

        Patient p = new Patient(patientId, name);  // use the passed 'name'!
        patients.add(p);
    }

    public void listPatients() {
        for (Patient p : patients) {
            System.out.println(p.getId() + " - " + p.getName());
        }
    }

    public Patient getPatient(String patientId) {
        for (Patient p : patients) {
            if (p.getId().equals(patientId)) {
                return p;
            }
        }
        return null;
    }
}
