import java.time.LocalDateTime;

public class AppointmentService {
    private final ExternalApi externalApi;

    public AppointmentService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public Appointment bookAppointment(Doctor doctor, String patientName, LocalDateTime time) {
        if (!doctor.isAvailable()) {
            throw new IllegalStateException("Doctor not available");
        }

        Appointment appointment = new Appointment(
                "APT-" + System.currentTimeMillis(),
                doctor.getId(),
                patientName,
                time
        );

        doctor.setAvailable(false);
        externalApi.reportAppointment(doctor.getId(), patientName, time.toString());

        return appointment;
    }
}

