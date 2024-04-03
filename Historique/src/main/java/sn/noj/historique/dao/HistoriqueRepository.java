package sn.noj.historique.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.noj.historique.entities.HistoriqueEntity;

public interface HistoriqueRepository extends JpaRepository<HistoriqueEntity, Long> {}
