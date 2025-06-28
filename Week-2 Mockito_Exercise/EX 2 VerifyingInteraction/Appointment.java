import java.time.LocalDateTime;

public class Appointment {
    private String id;
    private String doctorId;
    private String patientName;
    private LocalDateTime time;

    public Appointment(String id, String doctorId, String patientName, LocalDateTime time) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientName = patientName;
        this.time = time;
    }

    public String getId() { return id; }
    public String getDoctorId() { return doctorId; }
    public String getPatientName() { return patientName; }
    public LocalDateTime getTime() { return time; }
}

