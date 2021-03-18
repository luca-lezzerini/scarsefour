package it.sirfin.scarsefour.repository;

import it.sirfin.scarsefour.model.Cassa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CassaRepository extends JpaRepository<Cassa, Long>{
    
}
