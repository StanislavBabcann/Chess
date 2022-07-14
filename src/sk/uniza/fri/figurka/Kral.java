package sk.uniza.fri.figurka;

import sk.uniza.fri.sachovnica.Sachovnica;
import sk.uniza.fri.zobrazenie.Obdlznik;
import sk.uniza.fri.zobrazenie.Stvorec;

import java.util.ArrayList;
import java.util.HashSet;

public class Kral extends Figurka {
    private final Obdlznik hlava;
    private final Stvorec lavyRohKoruny;
    private final Obdlznik strednyRohKoruny;
    private final Obdlznik strednaCiaraKoruny;
    private final Stvorec pravyRohKoruny;

    public Kral(int paRiadok, int paStlpec, String paFarba) {
        super(paRiadok, paStlpec, paFarba);
        if (paFarba.equals("biela")) {
            paFarba = "white";
        } else {
            paFarba = "black";
        }

        super.setPodstava(new Obdlznik(paFarba));
        super.setTelo(new Obdlznik(paFarba));

        this.hlava = new Obdlznik(paFarba);
        this.lavyRohKoruny = new Stvorec(paFarba);
        this.strednyRohKoruny = new Obdlznik(paFarba);
        this.pravyRohKoruny = new Stvorec(paFarba);
        this.strednaCiaraKoruny = new Obdlznik(paFarba);

        super.nastavRozmery(60, 20, 30, 30);
        this.hlava.zmenStrany(50, 30);
        this.lavyRohKoruny.zmenStranu(10);
        this.strednyRohKoruny.zmenStrany(10, 30);
        this.pravyRohKoruny.zmenStranu(10);
        this.strednaCiaraKoruny.zmenStrany(26, 10);

    }

    public void zobrazFigurku() {
        super.zobrazFigurku();
        this.hlava.zobraz();
        this.lavyRohKoruny.zobraz();
        this.strednyRohKoruny.zobraz();
        this.pravyRohKoruny.zobraz();
        this.strednaCiaraKoruny.zobraz();
    }

    public void setZobrazenie() {
        int riadok = super.getRiadokFigurky();
        int stlpec = super.getStlpecFigurky();

        int suradnicaY = 90 * riadok;
        int suradnicaX = 90 * stlpec;

        super.nastavSuradnice(suradnicaX + 55, suradnicaY + 105, suradnicaX + 70, suradnicaY + 75);
        this.hlava.setSuradnice(suradnicaX + 60, suradnicaY + 70);
        this.lavyRohKoruny.setSuradnice(suradnicaX + 60, suradnicaY + 60);
        this.strednyRohKoruny.setSuradnice(suradnicaX + 80, suradnicaY + 42);
        this.pravyRohKoruny.setSuradnice(suradnicaX + 100, suradnicaY + 60);
        this.strednaCiaraKoruny.setSuradnice(suradnicaX + 72, suradnicaY + 47);

    }

    public ArrayList<String> ukazMozneTahy() {
        ArrayList<String> mozneTahy = new ArrayList<>();

        int riadok = super.getRiadokFigurky();
        int stlpec = super.getStlpecFigurky();
        String farbaFigurky = super.getFarbaFigurky();

        String policko;

        int i = riadok;
        int y = stlpec - 1;

        Figurka figurka;

        if (y > -1) {
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

        if (y < 8) {
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
        y = stlpec;

        if (i < 8) {
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

        if (i > -1) {
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
        y = stlpec + 1;

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

        i = riadok - 1;

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

        return mozneTahy;
    }

    public void zobrazMozneTahy(ArrayList<String> paMoznetahy) {
        super.zobrazMozneTahy(paMoznetahy);
    }

    public ArrayList<String> zbavOhrozenychPolicok(ArrayList<String> paMozneTahy) {
        HashSet<String> mozneOhrozenie = new HashSet<>();

        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 8; k++) {
                Figurka kontrolovana = Sachovnica.dajFigurku(j , k);
                if (kontrolovana != null && (!kontrolovana.getFarbaFigurky().equals(super.getFarbaFigurky()))) {
                    ArrayList<String> moznostiFigurky = kontrolovana.ukazMozneTahy();
                    mozneOhrozenie.addAll(moznostiFigurky);
                }
            }
        }

        int d = 0;

        while (d < paMozneTahy.size()) {
            String moznyTah = paMozneTahy.get(d);
            if (mozneOhrozenie.contains(moznyTah)) {
                paMozneTahy.remove(d);
                d--;
            }
            d++;
        }

        return paMozneTahy;
    }
}
