package tn.esprit.springproject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.springproject.Repository.ReservationRepository;
import tn.esprit.springproject.Service.ReservationService;
import tn.esprit.springproject.entity.Reservation;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ContextConfiguration(classes = {ReservationService.class})
@ExtendWith(SpringExtension.class)
class ReservationServiceTest {

    @MockBean
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationService reservationService;


    @Test
    void retrieveAllReservations() {
        ArrayList<Reservation> reservations = new ArrayList<>();
        when(reservationRepository.findAll()).thenReturn(reservations);
        List<Reservation> actualRetrieveAllReservation = reservationService.retrieveAllReservations();
        assertSame(reservations, actualRetrieveAllReservation);
        assertTrue(actualRetrieveAllReservation.isEmpty());
        verify(reservationRepository).findAll();
    }
}

