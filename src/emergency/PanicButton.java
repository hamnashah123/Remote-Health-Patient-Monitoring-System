
package emergency;
import notifications.Notifiable;

public class PanicButton {
    private final Notifiable notifier;

    public PanicButton(Notifiable notifier) {
        if (notifier == null) {
            throw new IllegalArgumentException("Notifier cannot be null");
        }
        this.notifier = notifier;
    }

    public void press() {
        notifier.sendNotification("emergency@hospital.com", "PANIC BUTTON ACTIVATED!");
    }
}