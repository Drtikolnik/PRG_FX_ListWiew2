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
    String stav = splneno ? "[HOTOVO]" : "[ ]";
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
}
