package sk.uniza.fri.figurka;

import sk.uniza.fri.sachovnica.Sachovnica;
import sk.uniza.fri.zobrazenie.Obdlznik;
import sk.uniza.fri.zobrazenie.Stvorec;

import java.util.ArrayList;

public class Strelec extends Figurka {
    private final Stvorec hlava;

    public Strelec(int paRiadok, int paStlpec, String paFarba) {
        super(paRiadok, paStlpec, paFarba);
        if (paFarba.equals("biela")) {
            paFarba = "white";
        } else {
            paFarba = "black";
        }

        super.setPodstava(new Obdlznik(paFarba));
        super.setTelo(new Obdlznik(paFarba));

        this.hlava = new Stvorec(paFarba);

        super.nastavRozmery(40, 20, 20, 50);
        this.hlava.zmenStranu(26);
    }

    public void zobrazFigurku() {
        super.zobrazFigurku();
        this.hlava.zobraz();
    }

    public void setZobrazenie() {
        int riadok = super.getRiadokFigurky();
        int stlpec = super.getStlpecFigurky();

        int suradnicaY = 90 * riadok;
        int suradnicaX = 90 * stlpec;

        super.nastavSuradnice(suradnicaX + 65, suradnicaY + 105, suradnicaX + 75, suradnicaY + 65);
        this.hlava.setSuradnice(suradnicaX + 72, suradnicaY + 45);

    }

    public ArrayList<String> ukazMozneTahy() {
        ArrayList<String> mozneTahy = new ArrayList<>();

        int riadok = super.getRiadokFigurky();
        int stlpec = super.getStlpecFigurky();
        String farbaFigurky = super.getFarbaFigurky();

        String policko;

        int i = riadok + 1;
        int y = stlpec + 1;

        Figurka figurka;

        while (i < 8 && y < 8) {
            figurka = Sachovnica.dajFigurku(i, y);
            policko = i + "" + y;
            if (figurka == null) {
                mozneTahy.add(policko);
            } else {
                if (!figurka.getFarbaFigurky().equals(farbaFigurky)) {
                    mozneTahy.add(policko);
                }
                break;
            }
            i++;
            y++;
        }

        i = riadok - 1;
        y = stlpec - 1;

        while (i > -1 && y > -1) {
            figurka = Sachovnica.dajFigurku(i, y);
            policko = i + "" + y;
            if (figurka == null) {
                mozneTahy.add(policko);
//                Sachovnica.oznacStvorec(i, y, "green");
            } else {
                if (!figurka.getFarbaFigurky().equals(farbaFigurky)) {
                    mozneTahy.add(policko);
                }
                break;
            }
            i--;
            y--;
        }

        i = riadok + 1;
        y = stlpec - 1;

        while (i < 8 && y > -1) {
            figurka = Sachovnica.dajFigurku(i, y);
            policko = i + "" + y;
            if (figurka == null) {
                mozneTahy.add(policko);
            } else {
                if (!figurka.getFarbaFigurky().equals(farbaFigurky)) {
                    mozneTahy.add(policko);
                }
                break;
            }
            i++;
            y--;
        }

        i = riadok - 1;
        y = stlpec + 1;

        while (i > -1 && y < 8) {
            figurka = Sachovnica.dajFigurku(i, y);
            policko = i + "" + y;
            if (figurka == null) {
                mozneTahy.add(policko);
            } else {
                if (!figurka.getFarbaFigurky().equals(farbaFigurky)) {
                    mozneTahy.add(policko);
                }
                break;
            }
            i--;
            y++;
        }

        return mozneTahy;
    }

    public void zobrazMozneTahy(ArrayList<String> paMoznetahy) {
        super.zobrazMozneTahy(paMoznetahy);
    }
}
