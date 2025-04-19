package consultation;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AppointmentScheduler {
    private final Map<String, LocalDateTime> appointments = new HashMap<>();

    public void scheduleAppointment(String patientId, LocalDateTime time) {
        if (appointments.containsValue(time)) {
            throw new IllegalStateException("Time slot already booked");
        }
        appointments.put(patientId, time);
        System.out.println("Scheduled appointment for " + patientId + " at " + time);
    }
}