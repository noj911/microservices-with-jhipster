package sn.noj.dayfinder.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services/calendar")
public class DayFinderResource {

    private final HistoriqueService historiqueService;

    public DayFinderResource(HistoriqueService historiqueService) {
        this.historiqueService = historiqueService;
    }

    @PostMapping("/dayfinder")
    public ResponseEntity<DayResponse> getDay(@RequestParam String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String dayOfWeek = localDate.getDayOfWeek().toString();

        // Sauvegarder la date dans l'entité Historique
        Historique historique = new Historique();
        historique.setDate(localDate);
        historique.setJour(dayOfWeek);
        historiqueService.save(historique);

        DayResponse response = new DayResponse(dayOfWeek);
        return ResponseEntity.ok(response);
    }
}

class DayResponse {

    public DayResponse(String dayOfWeek) {}
    // Getters and setters
}
