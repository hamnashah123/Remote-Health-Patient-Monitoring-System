
package notifications;

public class EmailNotification implements Notifiable {
    @Override
    public void sendNotification(String recipient, String message) {
        if (recipient == null || message == null) {
            throw new IllegalArgumentException("Recipient/message cannot be null");
        }
        System.out.println("[EMAIL] To: " + recipient + " | " + message);
    }
}
