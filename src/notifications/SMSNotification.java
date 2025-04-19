

package notifications;

public class SMSNotification implements Notifiable {
    @Override
    public void sendNotification(String recipient, String message) {
        if (recipient == null || message == null) {
            throw new IllegalArgumentException("Recipient/message cannot be null");
        }
        System.out.println("[SMS] To: " + recipient + " | " + message);
    }
}