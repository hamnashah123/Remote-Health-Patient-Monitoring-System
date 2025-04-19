//import emergency.*;
//import consultation.*;
//import notifications.*;
//import java.time.LocalDateTime;
//
//
//public class MainApp {
//    public static void main(String[] args) {
//
//
//        try {
//            Notifiable email = new EmailNotification();
//            Notifiable sms = new SMSNotification();
//            NotificationService notificationService = new NotificationService(email, sms);
//
//            EmergencyAlert alert = new EmergencyAlert("PAT789", sms, 100, 140, 101.5);
//
//
//            // Test Patient Management (Adding Patients)
//            testPatientManagement();
//
//            // Test Appointment Scheduling
//            testAppointments();
//
//            // Test Emergency System
//            testEmergencySystem(notificationService, email);
//
//            // Test Doctor Feedback
//              testAppointments();
//
//            // Test Chat System
//            testChatSystem();
//
//            // Test Video Calls
//            testVideoCalls();
//
//            // Test Reminders
//            testReminders(email);
//
//
//            alert.checkVitals(82, 120, 98.6);
//            alert.checkVitals(112, 145, 102.1);
//
//
//        } catch (Exception e) {
//            System.err.println("System error: " + e.getMessage());
//
//        }
//    }
//
//    private static void testEmergencySystem(NotificationService notifier, Notifiable email) {
//        System.out.println("\n=== EMERGENCY SYSTEM TEST ===");
//        EmergencyAlert alert = new EmergencyAlert("PAT789", notifier, 100, 140, 101.5);
//
//        // Normal vitals
//        alert.checkVitals(82, 120, 98.6);
//
//        // Critical vitals
//        alert.checkVitals(112, 145, 102.1);
//
//        // Panic button
//        new PanicButton(email).press();
//    }
//
//    private static void testFeedback() {
//        System.out.println("\nTESTING DOCTOR FEEDBACK");
//        FeedbackSystem feedback = new FeedbackSystem();
//        feedback.submitFeedback("D001", "PAT001", "Excellent care");
//        feedback.submitFeedback("D002", "PAT002", "Needs more follow-up");
//    }
//
//    private static void testPatientManagement() {
//        System.out.println("\nTESTING PATIENT MANAGEMENT");
//        PatientManager manager = new PatientManager();
//        manager.addPatient("PAT001");
//        manager.addPatient("PAT002");
//        manager.listPatients();
//    }
//
//    private static void testAppointments() {
//        System.out.println("\nTESTING APPOINTMENTS ");
//        AppointmentScheduler scheduler = new AppointmentScheduler();
//        LocalDateTime time1 = LocalDateTime.now().plusDays(1);
//        LocalDateTime time2 = LocalDateTime.now().plusDays(2);
//        scheduler.scheduleAppointment("PAT001", time1);
//        scheduler.scheduleAppointment("PAT002", time2);
//    }
//
//    private static void testChatSystem() {
//        System.out.println("\nCHAT SYSTEM TEST");
//        ChatServer server = new ChatServer();
//        ChatClient doctor = new ChatClient("Dr. Faizan", server);
//        ChatClient patient = new ChatClient("Ahad", server);
//
//        doctor.send("Ahad", "How are you feeling today?");
//        patient.send("Dr. Faizan", "Much better, thank you!");
//
//        System.out.println("\nChat History:");
//        server.getHistory().forEach(System.out::println);
//    }
//
//    private static void testVideoCalls() {
//        System.out.println("\nVIDEO CALL TEST");
//        VideoCall zoomCall = new VideoCall("Zoom");
//        zoomCall.startCall("Dr. Ilsa", "Patient Hareem");
//        System.out.println("Meeting Link: " + zoomCall.getMeetingLink());
//    }
//
//    private static void testReminders(Notifiable notifier) {
//        System.out.println("\nREMINDERS TEST");
//        ReminderService reminders = new ReminderService(notifier);
//        reminders.sendReminder("ahad@patient.com", "Medication", "Take 200mg Ibuprofen at 10AM");
//    }
//}

import emergency.*;
import consultation.*;
import notifications.*;
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

        while (true) {
            System.out.println("\nHEALTHCARE SYSTEM MENU");
            System.out.println("1. Test Patient Management");
            System.out.println("2. Test Appointment Scheduling");
            System.out.println("3. Test Emergency Module");
            System.out.println("4. Test Doctor Feedback");
            System.out.println("5. Test Chat Module");
            System.out.println("6. Test Video Calls");
            System.out.println("7. Test Reminders");
            System.out.println("8. Test All Modules");
            System.out.println("9. Exit");
            System.out.print("Select an option (1-9): ");

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
                    case 8 -> testAllModules(notificationService, email);
                    case 9 -> {
                        System.out.println("Exiting program...");
                        return;
                    }
                    default -> System.out.println("Invalid choice! Please select 1-9.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a number (1-9)");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    // ====== NEW PATIENT MANAGEMENT ======
    private static void testPatientManagement() {
        try {
            System.out.println("\nPATIENT MANAGEMENT TEST ");
            PatientManager manager = new PatientManager();
            manager.addPatient("PAT001 (Ali Khan)");
            manager.addPatient("PAT002 (Sara Ahmed)");
            System.out.println("\nCurrent Patients:");
            manager.listPatients();
        } catch (Exception e) {
            System.out.println("Error in Patient Management: " + e.getMessage());
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

            scheduler.scheduleAppointment("PAT001", time1);
            scheduler.scheduleAppointment("PAT002", time2);
            System.out.println("\nScheduled Appointments:");
            System.out.println("- PAT001 @ " + time1);
            System.out.println("- PAT002 @ " + time2);
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
            feedback.submitFeedback("DR101", "PAT001", "Excellent diagnosis");
            feedback.submitFeedback("DR102", "PAT002", "Could explain better");
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

// ====== REQUIRED SUPPORTING CLASSES ======
class PatientManager {
    private final List<String> patients = new ArrayList<>();

    public void addPatient(String patientId) {
        patients.add(patientId);
    }

    public void listPatients() {
        patients.forEach(System.out::println);
    }
}

class AppointmentScheduler {
    private final Map<String, LocalDateTime> appointments = new HashMap<>();

    public void scheduleAppointment(String patientId, LocalDateTime time) {
        appointments.put(patientId, time);
    }
}

class FeedbackSystem {
    public void submitFeedback(String doctorId, String patientId, String comments) {
        System.out.printf("Feedback for Dr. %s (Patient: %s):\n%s\n",
                doctorId, patientId, comments);
    }
}