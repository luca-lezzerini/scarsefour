package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.Posizione;


public class PosizioneDto {
    
    private Posizione posizione;

    public PosizioneDto() {
    }

    public PosizioneDto(Posizione posizione) {
        this.posizione = posizione;
    }

    public Posizione getPosizione() {
        return posizione;
    }

    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }

    @Override
    public String toString() {
        return "PosizioneDto{" + "posizione=" + posizione + '}';
    }
    
    
}
