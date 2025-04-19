//package emergency;
//
//import notifications.Notifiable;
//
//public class NotificationService {
//    private final Notifiable emailNotifier;
//    private final Notifiable smsNotifier;
//
//    public NotificationService(Notifiable email, Notifiable sms) {
//        this.emailNotifier = email;
//        this.smsNotifier = sms;
//    }
//
//    public void sendEmergencyAlert(String message) {
//        emailNotifier.sendNotification("staff@hospital.com", message);
//        smsNotifier.sendNotification("+92 3315333099", message);
//    }
//}

package emergency;
import notifications.Notifiable;

public class NotificationService implements Notifiable {
    private final Notifiable emailNotifier;
    private final Notifiable smsNotifier;

    public NotificationService(Notifiable email, Notifiable sms) {
        if (email == null || sms == null) {
            throw new IllegalArgumentException("Notifiers cannot be null");
        }
        this.emailNotifier = email;
        this.smsNotifier = sms;
    }

    public void sendEmergencyAlert(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }
        emailNotifier.sendNotification("staff@hospital.com", message);
        smsNotifier.sendNotification("+92 3315333099", message);
    }

    @Override
    public void sendNotification(String recipient, String message) {
        // Delegate to both notifiers
        emailNotifier.sendNotification(recipient, message);
        smsNotifier.sendNotification(recipient, message);
    }
}