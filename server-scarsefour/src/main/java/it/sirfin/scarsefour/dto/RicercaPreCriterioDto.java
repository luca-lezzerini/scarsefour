package it.sirfin.scarsefour.dto;

public class RicercaPreCriterioDto {

    private String criterioRicerca;

    public RicercaPreCriterioDto() {
    }

    public RicercaPreCriterioDto(String criterioRicerca) {
        this.criterioRicerca = criterioRicerca;
    }

    public String getCriterioRicerca() {
        return criterioRicerca;
    }

    public void setCriterioRicerca(String criterioRicerca) {
        this.criterioRicerca = criterioRicerca;
    }

    @Override
    public String toString() {
        return "RicercaPreCriterioDto{" + "criterioRicerca=" + criterioRicerca + '}';
    }
    
    
}
