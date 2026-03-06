package com.example.prg_fx_listwiew2;

public class Ukol {

private String jmeno;
private String predmet;
private String priorita;
private boolean splneno;

public Ukol(String jmeno, String predmet, String priorita, boolean splneno) {
    this.jmeno=jmeno;
    this.predmet=predmet;
    this.priorita=priorita;
    this.splneno=splneno;
}

public String toString(){
    String stav = splneno ? "[SPLNĚNO]" : "[NESPLĚNO]";
    return jmeno+ " " +predmet+ " " +priorita+ " " +stav;
}


    public String getJmeno() {
        return jmeno;
    }

    public String getPredmet() {
        return predmet;
    }

    public String getPriorita() {
        return priorita;
    }

    public boolean isSplneno() {
        return splneno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public void setPriorita(String priorita) {
        this.priorita = priorita;
    }

    public void setSplneno(boolean splneno) {
        this.splneno = splneno;
    }
}
