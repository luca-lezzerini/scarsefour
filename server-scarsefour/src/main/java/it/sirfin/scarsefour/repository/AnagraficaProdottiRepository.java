package it.sirfin.scarsefour.repository;

import it.sirfin.scarsefour.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnagraficaProdottiRepository extends JpaRepository<Prodotto, Long> {

}
