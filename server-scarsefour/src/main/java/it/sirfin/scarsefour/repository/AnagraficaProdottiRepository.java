package it.sirfin.scarsefour.repository;

import it.sirfin.scarsefour.model.Prodotto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnagraficaProdottiRepository extends JpaRepository<Prodotto, Long> {

    /**
     * Questa query ci permette di fare una lettura dalla tabella dei prodotti,
     * precisamente nella colonna dei codici dove il criterio sarebbe quello che
     * poi sarà il valore della stringa.
     *
     * @param codice è una semplice stringa
     * @return ci ritorna una lista di prodotti
     */
    @Query("select p from Prodotto p where codice = :cod")
    List<Prodotto> trovaProdottoPerCodice(@Param("cod") String codice);
}
