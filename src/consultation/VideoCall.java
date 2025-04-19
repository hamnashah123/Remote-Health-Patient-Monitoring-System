

package consultation;

public class VideoCall {
    private final String platform;
    private String meetingLink;
    private boolean isActive;

    public VideoCall(String platform) {
        if (platform == null || platform.trim().isEmpty()) {
            throw new IllegalArgumentException("Platform cannot be empty");
        }
        this.platform = platform;
    }

    public void startCall(String host, String participant) {
        if (host == null || participant == null) {
            throw new IllegalArgumentException("Host/participant cannot be null");
        }
        this.meetingLink = generateMeetingLink();
        this.isActive = true;
        System.out.println(platform + " call started between " + host + " and " + participant);
    }

    private String generateMeetingLink() {
        return "https://" + platform.toLowerCase() + ".com/meeting/" + System.currentTimeMillis();
    }

    public String getMeetingLink() {
        if (!isActive) {
            throw new IllegalStateException("Call is not active");
        }
        return meetingLink;
    }
}