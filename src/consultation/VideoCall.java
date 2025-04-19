//package consultation;
//
//public class VideoCall {
//    private final String meetingId;
//    private final String platform;
//    private boolean isActive;
//
//    public VideoCall(String platform) {
//        this.platform = platform;
//        this.meetingId = generateMeetingId();
//        this.isActive = false;
//    }
//
//    private String generateMeetingId() {
//        return platform.toUpperCase().charAt(0) +
//                "-" + (int)(Math.random() * 10000);
//    }
//
//    public void startCall(String participant1, String participant2) {
//        isActive = true;
//        System.out.printf("[%s CALL] Started (%s) between %s and %s\n",
//                platform.toUpperCase(), meetingId, participant1, participant2);
//    }
//
//    public void endCall() {
//        isActive = false;
//        System.out.println("[" + platform.toUpperCase() + "] Call ended: " + meetingId);
//    }
//
//    public String getMeetingLink() {
//        String baseUrl = platform.toLowerCase().replace(" ", "");
//        return String.format("https://%s.com/join/%s", baseUrl, meetingId);
//    }
//
//    // Additional useful methods
//    public boolean isCallActive() {
//        return isActive;
//    }
//
//    public String getPlatform() {
//        return platform;
//    }
//}
//
//


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