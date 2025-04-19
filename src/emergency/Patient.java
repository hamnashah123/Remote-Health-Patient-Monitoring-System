package emergency;

public class Patient {
    private String id;
    private String name;
    private int heartRate;
    private int bloodPressure;
    private double temperature;

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void updateVitals(int heartRate, int bloodPressure, double temperature) {
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.temperature = temperature;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getHeartRate() { return heartRate; }
    public int getBloodPressure() { return bloodPressure; }
    public double getTemperature() { return temperature; }

    public void displayVitals() {
        System.out.printf("Vitals for %s (%s): HR: %d bpm | BP: %d mmHg | Temp: %.1f°F\n",
                name, id, heartRate, bloodPressure, temperature);
    }
}
