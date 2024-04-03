package sn.noj.historique.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.noj.historique.dao.HistoriqueRepository;
import sn.noj.historique.entities.HistoriqueEntity;

@RestController
@RequestMapping("/historique")
public class HistoriqueResource {

    private final HistoriqueRepository historiqueRepository;

    public HistoriqueResource(HistoriqueRepository historiqueRepository) {
        this.historiqueRepository = historiqueRepository;
    }

    @GetMapping("/all")
    public List<HistoriqueEntity> getAll() {
        return historiqueRepository.findAll();
    }
}
