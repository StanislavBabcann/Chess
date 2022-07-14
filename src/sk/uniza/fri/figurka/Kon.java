package sk.uniza.fri.figurka;

import sk.uniza.fri.sachovnica.Sachovnica;
import sk.uniza.fri.zobrazenie.Obdlznik;
import java.util.ArrayList;

public class Kon extends Figurka {
    private final Obdlznik krk;
    private final Obdlznik hlava;

    public Kon(int paRiadok, int paStlpec, String paFarba) {
        super(paRiadok, paStlpec, paFarba);
        if (paFarba.equals("biela")) {
            paFarba = "white";
        } else {
            paFarba = "black";
        }

        super.setPodstava(new Obdlznik(paFarba));
        super.setTelo(new Obdlznik(paFarba));

        this.krk = new Obdlznik(paFarba);
        this.hlava = new Obdlznik(paFarba);

        super.nastavRozmery(50, 20, 20, 50);
        this.krk.zmenStrany(40 , 15);
        this.hlava.zmenStrany(25, 30);
    }

    public void zobrazFigurku() {
        super.zobrazFigurku();
        this.krk.zobraz();
        this.hlava.zobraz();
    }

    public void setZobrazenie() {
        int riadok = super.getRiadokFigurky();
        int stlpec = super.getStlpecFigurky();

        int suradnicaY = 90 * riadok;
        int suradnicaX = 90 * stlpec;

        super.nastavSuradnice(suradnicaX + 55, suradnicaY + 105, suradnicaX + 80, suradnicaY + 55);
        this.krk.setSuradnice(suradnicaX + 60, suradnicaY + 50);
        this.hlava.setSuradnice(suradnicaX + 50, suradnicaY + 50);

    }

    public ArrayList<String> ukazMozneTahy() {
        ArrayList<String> mozneTahy = new ArrayList<>();

        int riadok = super.getRiadokFigurky();
        int stlpec = super.getStlpecFigurky();
        String farbaFigurky = super.getFarbaFigurky();

        String policko;

        int i = riadok + 2;
        int y = stlpec + 1;

        Figurka figurka;

        if (i < 8 && y < 8) {
            figurka = Sachovnica.dajFigurku(i, y);
            policko = i + "" + y;
            if (figurka == null) {
                mozneTahy.add(policko);
            } else {
                if (!figurka.getFarbaFigurky().equals(farbaFigurky)) {
                    mozneTahy.add(policko);
                }
            }
        }

        y = stlpec - 1;

        if (i < 8 && y > -1) {
            figurka = Sachovnica.dajFigurku(i, y);
            policko = i + "" + y;
            if (figurka == null) {
                mozneTahy.add(policko);
            } else {
                if (!figurka.getFarbaFigurky().equals(farbaFigurky)) {
                    mozneTahy.add(policko);
                }
            }
        }

        i = riadok - 2;

        if (i > -1 && y > -1) {
            figurka = Sachovnica.dajFigurku(i, y);
            policko = i + "" + y;
            if (figurka == null) {
                mozneTahy.add(policko);
            } else {
                if (!figurka.getFarbaFigurky().equals(farbaFigurky)) {
                    mozneTahy.add(policko);
                }
            }
        }

        y = stlpec + 1;

        if (i > -1 && y < 8) {
            figurka = Sachovnica.dajFigurku(i, y);
            policko = i + "" + y;
            if (figurka == null) {
                mozneTahy.add(policko);
            } else {
                if (!figurka.getFarbaFigurky().equals(farbaFigurky)) {
                    mozneTahy.add(policko);
                }
            }
        }

        i = riadok + 1;
        y = stlpec + 2;

        if (i < 8 && y < 8) {
            figurka = Sachovnica.dajFigurku(i, y);
            policko = i + "" + y;
            if (figurka == null) {
                mozneTahy.add(policko);
            } else {
                if (!figurka.getFarbaFigurky().equals(farbaFigurky)) {
                    mozneTahy.add(policko);
                }
            }
        }

        i = riadok - 1;

        if (i > -1 && y < 8) {
            figurka = Sachovnica.dajFigurku(i, y);
            policko = i + "" + y;
            if (figurka == null) {
                mozneTahy.add(policko);
            } else {
                if (!figurka.getFarbaFigurky().equals(farbaFigurky)) {
                    mozneTahy.add(policko);
                }
            }
        }

        y = stlpec - 2;

        if (i > -1 && y > -1) {
            figurka = Sachovnica.dajFigurku(i, y);
            policko = i + "" + y;
            if (figurka == null) {
                mozneTahy.add(policko);
            } else {
                if (!figurka.getFarbaFigurky().equals(farbaFigurky)) {
                    mozneTahy.add(policko);
                }
            }
        }

        i = riadok + 1;

        if (i < 8 && y > -1) {
            figurka = Sachovnica.dajFigurku(i, y);
            policko = i + "" + y;
            if (figurka == null) {
                mozneTahy.add(policko);
            } else {
                if (!figurka.getFarbaFigurky().equals(farbaFigurky)) {
                    mozneTahy.add(policko);
                }
            }
        }

        return mozneTahy;

    }

    public void zobrazMozneTahy(ArrayList<String> paMoznetahy) {
        super.zobrazMozneTahy(paMoznetahy);
    }
}
