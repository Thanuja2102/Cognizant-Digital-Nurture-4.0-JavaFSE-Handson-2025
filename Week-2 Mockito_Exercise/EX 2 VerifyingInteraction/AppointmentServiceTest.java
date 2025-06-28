import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

public class AppointmentServiceTest {

    private ExternalApi externalApi;
    private AppointmentService service;

    @Before
    public void setUp() {
        externalApi = mock(ExternalApi.class);
        service = new AppointmentService(externalApi);
    }

    @Test
    public void testBookAppointmentSuccessfully() {
        Doctor doctor = new Doctor("D001", "Dr. Strange", true);
        String patient = "Tony Stark";
        LocalDateTime time = LocalDateTime.of(2025, 7, 1, 9, 0);

        Appointment appt = service.bookAppointment(doctor, patient, time);

        assertNotNull(appt);
        assertEquals("D001", appt.getDoctorId());
        assertEquals("Tony Stark", appt.getPatientName());
        assertEquals(time, appt.getTime());
        assertFalse(doctor.isAvailable());

        verify(externalApi).reportAppointment("D001", "Tony Stark", time.toString());
    }

    @Test(expected = IllegalStateException.class)
    public void testDoctorNotAvailable() {
        Doctor doctor = new Doctor("D002", "Dr. Banner", false);
        service.bookAppointment(doctor, "Steve Rogers", LocalDateTime.now());
    }


    @Test
    public void testAppointmentFieldsCorrect() {
        Doctor doctor = new Doctor("D003", "Dr. Fate", true);
        String patient = "Bruce Wayne";
        LocalDateTime time = LocalDateTime.of(2025, 8, 10, 10, 30);

        Appointment appt = service.bookAppointment(doctor, patient, time);

        assertNotNull(appt.getId());
        assertEquals("D003", appt.getDoctorId());
        assertEquals("Bruce Wayne", appt.getPatientName());
        assertEquals(time, appt.getTime());
    }


    @Test
    public void testDoctorAvailabilityChangesAfterBooking() {
        Doctor doctor = new Doctor("D004", "Dr. Who", true);
        LocalDateTime time = LocalDateTime.of(2025, 9, 5, 12, 0);

        service.bookAppointment(doctor, "Amy Pond", time);

        assertFalse("Doctor should not be available after booking", doctor.isAvailable());
    }


    @Test
    public void testExternalApiCalledOnce() {
        Doctor doctor = new Doctor("D005", "Dr. House", true);
        String patient = "Lisa Cuddy";
        LocalDateTime time = LocalDateTime.of(2025, 10, 3, 11, 15);

        service.bookAppointment(doctor, patient, time);

        verify(externalApi, times(1)).reportAppointment("D005", "Lisa Cuddy", time.toString());
    }
}


