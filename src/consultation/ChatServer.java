

package consultation;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private final List<String> messageHistory = new ArrayList<>();

    public void sendMessage(String sender, String receiver, String message) {
        if (sender == null || receiver == null || message == null) {
            throw new IllegalArgumentException("Sender/receiver/message cannot be null");
        }
        String msg = sender + " → " + receiver + ": " + message;
        messageHistory.add(msg);
        System.out.println("[CHAT] " + msg);
    }

    public List<String> getHistory() {
        return new ArrayList<>(messageHistory); // Defensive copy
    }
}
