//package consultation;
//
//public class ChatClient {
//    private final String username;
//    private final ChatServer server;
//
//    public ChatClient(String username, ChatServer server) {
//        this.username = username;
//        this.server = server;
//    }
//
//    public void send(String receiver, String message) {
//        server.sendMessage(username, receiver, message);
//    }
//}
//
//

package consultation;

public class ChatClient {
    private final String username;
    private final ChatServer server;

    public ChatClient(String username, ChatServer server) {
        if (username == null || server == null) {
            throw new IllegalArgumentException("Username/server cannot be null");
        }
        this.username = username;
        this.server = server;
    }

    public void send(String receiver, String message) {
        if (receiver == null || message == null) {
            throw new IllegalArgumentException("Receiver/message cannot be null");
        }
        server.sendMessage(username, receiver, message);
    }
}
