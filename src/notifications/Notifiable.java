
package notifications;

public interface Notifiable {
    void sendNotification(String recipient, String message);
}