
package it.sirfin.scarsefour.repository;

import it.sirfin.scarsefour.model.Scontrino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScontrinoRepository extends JpaRepository<Scontrino, Long>{
    
}
