/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.repository;

import it.sirfin.scarsefour.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 39392
 */
@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long>{
    
}
