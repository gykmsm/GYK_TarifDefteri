package com.merveakgormus.gyk_note_app.model;

public class Tarif {
    private String tarifadi;
    private String malzemeler;
    private String yapilisi;

    public Tarif(String tarifadi, String malzemeler, String yapilisi) {
        this.tarifadi = tarifadi;
        this.malzemeler = malzemeler;
        this.yapilisi = yapilisi;
    }

    public String getTarifadi() {
        return tarifadi;
    }

    public void setTarifadi(String tarifadi) {
        this.tarifadi = tarifadi;
    }

    public String getMalzemeler() {
        return malzemeler;
    }

    public void setMalzemeler(String malzemeler) {
        this.malzemeler = malzemeler;
    }

    public String getYapilisi() {
        return yapilisi;
    }

    public void setYapilisi(String yapilisi) {
        this.yapilisi = yapilisi;
    }
}
