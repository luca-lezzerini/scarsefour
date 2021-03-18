package it.sirfin.scarsefour.repository;

import it.sirfin.scarsefour.model.Cassiera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnagraficaCassiereRepository extends JpaRepository<Cassiera, Long> {

}
