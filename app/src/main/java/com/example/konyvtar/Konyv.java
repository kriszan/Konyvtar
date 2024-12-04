package com.example.konyvtar;

public class Konyv {
    private String cim;
    private String szerzo;
    private Integer oldalszam;

    public Konyv(String cim, String szerzo, Integer oldalszam) {
        this.cim = cim;
        this.szerzo = szerzo;
        this.oldalszam = oldalszam;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }

    public Integer getOldalszam() {
        return oldalszam;
    }

    public void setOldalszam(Integer oldalszam) {
        this.oldalszam = oldalszam;
    }
}
