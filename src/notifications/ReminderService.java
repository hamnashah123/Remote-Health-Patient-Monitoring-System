//package notifications;
//
//public class ReminderService {
//    private final Notifiable notifier;
//
//    public ReminderService(Notifiable notifier) {
//        this.notifier = notifier;
//    }
//
////    public void sendReminder(String patient, String task) {
////        notifier.sendNotification(patient + "@hospital.com",
////                "REMINDER: " + task);
////    }
//
//    public void sendReminder(String patient, String task,
//                              String details) {
//        String fullMessage = String.format("REMINDER: %s : %s",
//                task, details);
//        notifier.sendNotification(patient + "@hospital.com", fullMessage);
//    }
//
//}
//

package notifications;

public class ReminderService implements Notifiable {
    private final Notifiable notifier;

    public ReminderService(Notifiable notifier) {
        if (notifier == null) {
            throw new IllegalArgumentException("Notifier cannot be null");
        }
        this.notifier = notifier;
    }

    public void sendReminder(String recipient, String title, String details) {
        String message = "REMINDER: " + title + "\nDetails: " + details;
        notifier.sendNotification(recipient, message);
    }

    @Override
    public void sendNotification(String recipient, String message) {
        notifier.sendNotification(recipient, message);
    }
}
