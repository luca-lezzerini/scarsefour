package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.Cassiera;

public class CassieraDto {

    private Cassiera cassiera;

    public CassieraDto() {
    }

    public CassieraDto(Cassiera cassiera) {
        this.cassiera = cassiera;
    }

    public Cassiera getCassiera() {
        return cassiera;
    }

    public void setCassiera(Cassiera cassiera) {
        this.cassiera = cassiera;
    }

    @Override
    public String toString() {
        return "CassieraDto{" + "cassiera=" + cassiera + '}';
    }

}
