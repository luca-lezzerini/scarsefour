
package it.sirfin.scarsefour.dto;


public class RigaScontrinoClientDto {

    private Long idRiga;
    private Long idScontrino;
    private Long idProdotto;
    private Integer quantita = 1;
    private String descrizione;
    private Double prezzo;

    public RigaScontrinoClientDto() {
    }
     

    public RigaScontrinoClientDto(Long idRiga, Long idScontrino, Long idProdotto, String descrizione, Double prezzo) {
        this.idRiga = idRiga;
        this.idScontrino = idScontrino;
        this.idProdotto = idProdotto;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public Long getIdRiga() {
        return idRiga;
    }

    public void setIdRiga(Long idRiga) {
        this.idRiga = idRiga;
    }

    public Long getIdScontrino() {
        return idScontrino;
    }

    public void setIdScontrino(Long idScontrino) {
        this.idScontrino = idScontrino;
    }

    public Long getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(Long idProdotto) {
        this.idProdotto = idProdotto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    @Override
    public String toString() {
        return "RigaScontrinoClientGalDto{" + "idRiga=" + idRiga + ", idScontrino=" + idScontrino + ", idProdotto=" + idProdotto + ", descrizione=" + descrizione + ", prezzo=" + prezzo + ", quantita=" + quantita + '}';
    }
        
}
