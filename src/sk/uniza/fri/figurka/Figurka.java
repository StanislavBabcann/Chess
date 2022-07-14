package sk.uniza.fri.figurka;

import sk.uniza.fri.sachovnica.Sachovnica;
import sk.uniza.fri.zobrazenie.Obdlznik;

import java.util.ArrayList;

public abstract class Figurka implements IFigurka {
    private int riadokFigurky;
    private int stlpecFigurky;
    private final String farbaFigurky;
    private Obdlznik podstava;
    private Obdlznik telo;

    public Figurka(int paRiadok, int paStlpec, String paFarba) {
        this.riadokFigurky = paRiadok;
        this.stlpecFigurky = paStlpec;
        this.farbaFigurky = paFarba;
        this.podstava = null;
        this.telo = null;
    }

    public int getRiadokFigurky() {
        return this.riadokFigurky;
    }

    public int getStlpecFigurky() {
        return this.stlpecFigurky;
    }

    public String getFarbaFigurky() {
        return this.farbaFigurky;
    }

    public void zmenSuradnice(int paRiadokFigurky, int paStlpecFigurky) {
        this.riadokFigurky = paRiadokFigurky;
        this.stlpecFigurky = paStlpecFigurky;
    }

    public void setPodstava(Obdlznik paPodstava) {
        this.podstava = paPodstava;
    }

    public void setTelo(Obdlznik paTelo) {
        this.telo = paTelo;
    }

    public void zobrazFigurku() {
        this.podstava.zobraz();
        this.telo.zobraz();
    }

    public void nastavRozmery(int paDlzkaPodstavy, int paSirkaPodstavy, int paDlzkaTela, int paSirkaTela) {
        this.podstava.zmenStrany(paDlzkaPodstavy, paSirkaPodstavy);
        this.telo.zmenStrany(paDlzkaTela, paSirkaTela);
    }

    public void nastavSuradnice(int paXPodstavy, int paYPodstavy, int paXTela, int paYTela) {
        this.podstava.setSuradnice(paXPodstavy, paYPodstavy);
        this.telo.setSuradnice(paXTela, paYTela);
    }

    public void zobrazMozneTahy(ArrayList<String> mozneTahy) {
        for (String tah : mozneTahy) {
            int riadok = Integer.parseInt(String.valueOf(tah.charAt(0)));
            int stlpec = Integer.parseInt(String.valueOf(tah.charAt(1)));

            Figurka policko = Sachovnica.dajFigurku(riadok, stlpec);

            if (policko == null) {
                Sachovnica.oznacStvorec(riadok, stlpec, "green");
            } else {
                Sachovnica.oznacStvorec(riadok, stlpec, "red");
                policko.zobrazFigurku();
            }
        }
    }
}
