/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MovimentiScaffale implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int quantità;
    @Column
    private LocalDateTime timestamp;

    public MovimentiScaffale() {
    }

    public MovimentiScaffale(LocalDateTime timestamp, int quantità) {
        this.timestamp = timestamp;
        this.quantità = quantità;
    }

}
