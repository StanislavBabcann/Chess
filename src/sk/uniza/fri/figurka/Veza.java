package sk.uniza.fri.figurka;

import sk.uniza.fri.sachovnica.Sachovnica;
import sk.uniza.fri.zobrazenie.Obdlznik;

import java.util.ArrayList;

public class Veza extends Figurka {

    public Veza(int paRiadok, int paStlpec, String paFarba) {
        super(paRiadok, paStlpec, paFarba);
        if (paFarba.equals("biela")) {
            paFarba = "white";
        } else {
            paFarba = "black";
        }

        super.setPodstava(new Obdlznik(paFarba));
        super.setTelo(new Obdlznik(paFarba));

        super.nastavRozmery(60, 30, 50, 60);
    }

    public void zobrazFigurku() {
        super.zobrazFigurku();
    }

    public void setZobrazenie() {
        int riadok = super.getRiadokFigurky();
        int stlpec = super.getStlpecFigurky();

        int suradnicaY = 95 + 90 * riadok;
        int suradnicaX = 53 + 90 * stlpec;

        super.nastavSuradnice(suradnicaX, suradnicaY, suradnicaX + 5, suradnicaY - 50);

    }

    public ArrayList<String> ukazMozneTahy() {
        ArrayList<String> mozneTahy = new ArrayList<>();

        int riadok = super.getRiadokFigurky();
        int stlpec = super.getStlpecFigurky();
        String farbaFigurky = super.getFarbaFigurky();

        String policko;

        int i = riadok + 1;
        int y = stlpec;

        Figurka figurka;

        while (i < 8) {
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
        }

        i = riadok - 1;

        while (i > -1) {
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
        }

        i = riadok;
        y = stlpec + 1;

        while (y < 8) {
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
            y++;
        }

        y = stlpec - 1;

        while (y > -1) {
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
            y--;
        }

        return mozneTahy;
    }

    public void zobrazMozneTahy(ArrayList<String> paMoznetahy) {
        super.zobrazMozneTahy(paMoznetahy);
    }
}
