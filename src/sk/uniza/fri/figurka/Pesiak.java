package sk.uniza.fri.figurka;

import sk.uniza.fri.sachovnica.Sachovnica;
import sk.uniza.fri.zobrazenie.Obdlznik;
import javax.swing.JOptionPane;

import java.util.ArrayList;

public class Pesiak extends Figurka {

    public Pesiak(int paRiadok, int paStlpec, String paFarba) {
        super(paRiadok, paStlpec, paFarba);
        if (paFarba.equals("biela")) {
            paFarba = "white";
        } else {
            paFarba = "black";
        }

        super.setPodstava(new Obdlznik(paFarba));
        super.setTelo(new Obdlznik(paFarba));

        super.nastavRozmery(60, 20, 30, 30);
    }

    public void zobrazFigurku() {
        super.zobrazFigurku();
    }

    public void setZobrazenie() {
        int riadok = super.getRiadokFigurky();
        int stlpec = super.getStlpecFigurky();

        int suradnicaY = 105 + 90 * riadok;
        int suradnicaX = 55 + 90 * stlpec;

        super.nastavSuradnice(suradnicaX, suradnicaY, suradnicaX + 15, suradnicaY - 30);

    }

    public ArrayList<String> ukazMozneTahy() {
        ArrayList<String> mozneTahy = new ArrayList<>();

        int riadok = super.getRiadokFigurky();
        int stlpec = super.getStlpecFigurky();

        String policko;

        if (super.getFarbaFigurky().equals("biela")) {

            for (int i = 1; i < 3; i++) {
                if (Sachovnica.obsadenostPolicka(riadok - i, stlpec)) {
                    policko = (riadok - i) + "" + stlpec;
                    mozneTahy.add(policko);
                }

                if (riadok != 6) {
                    break;
                }

            }

            Figurka nalavo = null;
            Figurka napravo = null;

            if (riadok - 1 > -1 && stlpec - 1 > -1) {
                nalavo = Sachovnica.dajFigurku(riadok - 1, stlpec - 1);
            }

            if (riadok - 1 > -1 && stlpec + 1 < 8) {
                napravo = Sachovnica.dajFigurku(riadok - 1, stlpec + 1);
            }

            if (nalavo != null) {
                if (nalavo.getFarbaFigurky().equals("cierna")) {
                    policko = (riadok - 1) + "" + (stlpec - 1);
                    mozneTahy.add(policko);
                }
            }

            if (napravo != null) {
                if (napravo.getFarbaFigurky().equals("cierna")) {

                    policko = (riadok - 1) + "" + (stlpec + 1);
                    mozneTahy.add(policko);
                }
            }

        } else {
            for (int i = 1; i < 3; i++) {
                if (Sachovnica.obsadenostPolicka(riadok + i, stlpec)) {
                    policko = riadok + i + "" + stlpec;
                    mozneTahy.add(policko);
                }

                if (riadok != 1) {
                    break;
                }
            }

            Figurka nalavo = null;
            Figurka napravo = null;

            if (riadok + 1 < 8 && stlpec - 1 > -1) {
                nalavo = Sachovnica.dajFigurku(riadok + 1, stlpec - 1);
            }

            if (riadok + 1 < 8 && stlpec + 1 < 8) {
                napravo = Sachovnica.dajFigurku(riadok + 1, stlpec + 1);
            }

            if (nalavo != null) {
                if (nalavo.getFarbaFigurky().equals("biela")) {
                    policko = (riadok + 1) + "" + (stlpec - 1);
                    mozneTahy.add(policko);
                }
            }

            if (napravo != null) {
                if (napravo.getFarbaFigurky().equals("biela")) {
                    policko = (riadok + 1) + "" + (stlpec + 1);
                    mozneTahy.add(policko);
                }
            }
        }

        return mozneTahy;
    }

    public Figurka premena() {
        int riadokFigurky = super.getRiadokFigurky();
        int stlpecFigurky = super.getStlpecFigurky();

        JOptionPane.showMessageDialog(null, "Dosiahli ste so svojim pesiakom druhu stranu sachovnice, mozete ho zmenit na inu figurku");

        Figurka menena = null;

        boolean spravny = false;

        while (!spravny) {
            String zmena = JOptionPane.showInputDialog("Zadajte cislo figurky, na ktoru ho chcete premenit:\nkralovna - 1 \nveza - 2 \nstrelec - 3\nkon - 4");

            try {
                int cislo = Integer.parseInt(zmena);

                if (cislo == 1) {
                    menena = new Kralovna(riadokFigurky, stlpecFigurky, this.getFarbaFigurky());
                    spravny = true;
                } else if (cislo == 2) {
                    menena = new Veza(riadokFigurky, stlpecFigurky, this.getFarbaFigurky());
                    spravny = true;
                } else if (cislo == 3) {
                    menena = new Strelec(riadokFigurky, stlpecFigurky, this.getFarbaFigurky());
                    spravny = true;
                } else if (cislo == 4) {
                    menena = new Kon(riadokFigurky, stlpecFigurky, this.getFarbaFigurky());
                    spravny = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Neplatny vstup");
                }

            } catch (NumberFormatException exp) {
                JOptionPane.showMessageDialog(null, "Neplatny vstup");
            }
        }

        return menena;

    }

    public void zobrazMozneTahy(ArrayList<String> paMoznetahy) {
        super.zobrazMozneTahy(paMoznetahy);
    }

}
