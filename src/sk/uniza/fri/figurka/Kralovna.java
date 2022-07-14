package sk.uniza.fri.figurka;

import sk.uniza.fri.sachovnica.Sachovnica;
import sk.uniza.fri.zobrazenie.Obdlznik;
import sk.uniza.fri.zobrazenie.Trojuholnik;

import java.util.ArrayList;

public class Kralovna extends Figurka {
    private final Trojuholnik hlava;
    private final Obdlznik lavyRohKoruny;
    private final Obdlznik pravyRohKoruny;

    public Kralovna(int paRiadok, int paStlpec, String paFarba) {
        super(paRiadok, paStlpec, paFarba);
        if (paFarba.equals("biela")) {
            paFarba = "white";
        } else {
            paFarba = "black";
        }

        super.setPodstava(new Obdlznik(paFarba));
        super.setTelo(new Obdlznik(paFarba));
        this.hlava = new Trojuholnik(paFarba);
        this.lavyRohKoruny = new Obdlznik(paFarba);
        this.pravyRohKoruny = new Obdlznik(paFarba);

        super.nastavRozmery(50, 20, 20, 60);
        this.hlava.zmenRozmery(40, 40);
        this.lavyRohKoruny.zmenStrany(10, 40);
        this.pravyRohKoruny.zmenStrany(10, 40);
    }

    public void zobrazFigurku() {
        super.zobrazFigurku();
        this.hlava.zobraz();
        this.lavyRohKoruny.zobraz();
        this.pravyRohKoruny.zobraz();
    }

    public void setZobrazenie() {
        int riadok = super.getRiadokFigurky();
        int stlpec = super.getStlpecFigurky();

        int suradnicaY = 90 * riadok;
        int suradnicaX = 90 * stlpec;

        super.nastavSuradnice(suradnicaX + 60, suradnicaY + 105, suradnicaX + 75, suradnicaY + 65);
        this.hlava.setSuradnice(suradnicaX + 84, suradnicaY + 42);
        this.lavyRohKoruny.setSuradnice(suradnicaX + 65, suradnicaY + 44);
        this.pravyRohKoruny.setSuradnice(suradnicaX + 94, suradnicaY + 44);

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

        i = riadok + 1;
        y = stlpec;

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
