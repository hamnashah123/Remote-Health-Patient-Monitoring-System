package consultation;

public class FeedbackSystem {
    public void submitFeedback(String doctorId, String patientId, String comments) {
        System.out.printf("\nFeedback for Dr. %s (Patient: %s):\n%s\n",
                doctorId, patientId, comments);
    }
}