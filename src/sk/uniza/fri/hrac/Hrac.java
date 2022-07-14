package sk.uniza.fri.hrac;

import sk.uniza.fri.figurka.Figurka;
import sk.uniza.fri.figurka.Pesiak;
import sk.uniza.fri.figurka.Veza;
import sk.uniza.fri.figurka.Kon;
import sk.uniza.fri.figurka.Strelec;
import sk.uniza.fri.figurka.Kralovna;
import sk.uniza.fri.figurka.Kral;
import sk.uniza.fri.sachovnica.Sachovnica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.util.ArrayList;

public class Hrac {
    private final String meno;
    private final String farba;
    private boolean poradie;

    public Hrac(String paMeno, FarbaFigurky paFarba) {
        this.meno = paMeno;
        this.farba = paFarba.getReprezentacia();
        this.poradie = this.farba.equals("biela");
    }

    public boolean getPoradie() {
        return this.poradie;
    }

    public void setPoradie(boolean paPoradie) {
        this.poradie = paPoradie;
    }

    public Figurka[] dajFigurky() {
        Figurka[] figurky = new Figurka[16];
        int riadokPesiakov;
        int riadokOstatnych;
        if (this.farba.equals("cierna")) {
            riadokPesiakov = 1;
            riadokOstatnych = 0;
        } else {
            riadokPesiakov = 6;
            riadokOstatnych = 7;
        }

        for (int i = 0; i < 8; i++) {
            Pesiak pesiak = new Pesiak(riadokPesiakov, i, this.farba);
            pesiak.setZobrazenie();
            figurky[i] = pesiak;
        }

        Veza vezaVlavo = new Veza(riadokOstatnych, 0, this.farba);
        Veza vezaVpravo = new Veza(riadokOstatnych, 7, this.farba);

        vezaVlavo.setZobrazenie();
        vezaVpravo.setZobrazenie();

        figurky[8] = vezaVlavo;
        figurky[9] = vezaVpravo;

        Kon konVlavo = new Kon(riadokOstatnych, 1, this.farba);
        Kon konVpravo = new Kon(riadokOstatnych, 6, this.farba);

        figurky[10] = konVlavo;
        figurky[11] = konVpravo;

        konVlavo.setZobrazenie();
        konVpravo.setZobrazenie();

        Strelec strelecVlavo = new Strelec(riadokOstatnych, 2, this.farba);
        Strelec strelecVpravo = new Strelec(riadokOstatnych, 5, this.farba);

        strelecVlavo.setZobrazenie();
        strelecVpravo.setZobrazenie();

        figurky[12] = strelecVlavo;
        figurky[13] = strelecVpravo;

        Kral kral = new Kral(riadokOstatnych, 4, this.farba);

        kral.setZobrazenie();

        figurky[14] = kral;

        Kralovna kralovna = new Kralovna(riadokOstatnych, 3, this.farba);

        kralovna.setZobrazenie();

        figurky[15] = kralovna;

        return figurky;
    }

    public void oznacFigurku() {
        JPanel zahranieFigurky = new JPanel();

        zahranieFigurky.add(new JLabel("Riadok:"));
        JTextField prvyRiadok = new JTextField(2);
        zahranieFigurky.add(prvyRiadok);
        zahranieFigurky.add(new JLabel("Stlpec:"));
        JTextField druhyRiadok = new JTextField(2);
        zahranieFigurky.add(druhyRiadok);
        zahranieFigurky.setLayout(new GridLayout(4, 2, 2, 2));
        zahranieFigurky.setPreferredSize(new Dimension(300, 120));

        int vysledok = JOptionPane.showConfirmDialog(null, zahranieFigurky, ("Zadajte riadok s tlpec figurky, ktoru chete zahrat:"), JOptionPane.OK_CANCEL_OPTION);

        if (vysledok == JOptionPane.OK_OPTION) {

            try {

                int riadokFigurky = Integer.parseInt(prvyRiadok.getText()) - 1;
                int stlpecFigurky = this.prevodStlpca(druhyRiadok.getText());

                if (riadokFigurky > -1 && riadokFigurky < 8 && stlpecFigurky != -1) {

                    Figurka figurka = Sachovnica.dajFigurku(riadokFigurky, stlpecFigurky);
                    if (figurka != null && figurka.getFarbaFigurky().equals(this.farba)) {
                        ArrayList<String> mozneTahy = figurka.ukazMozneTahy();
                        if (figurka instanceof Kral) {
                            mozneTahy = ((Kral) figurka).zbavOhrozenychPolicok(mozneTahy);
                        }
                        figurka.zobrazMozneTahy(mozneTahy);
                        if (mozneTahy.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "S toutou figurkou sa nemozete pohnut!");
                        } else {
                            if (this.posunFigurkou(mozneTahy, figurka)) {
                                Sachovnica.zmenPolicko(riadokFigurky, stlpecFigurky, null, this);

                                if (figurka instanceof Pesiak) {
                                    if (this.skontrolujPesiaka(figurka)) {
                                        Sachovnica.vycistiSachovnicu(mozneTahy);
                                        Pesiak pesiak = (Pesiak)figurka;
                                        Figurka menena = pesiak.premena();
                                        mozneTahy = new ArrayList<>();
                                        String menenePolicko = pesiak.getRiadokFigurky() + "" + pesiak.getStlpecFigurky();
                                        mozneTahy.add(menenePolicko);
                                        Sachovnica.zmenPolicko(menena.getRiadokFigurky(), menena.getStlpecFigurky(), menena, this);
                                    }
                                }
                            }
                        }
                        Sachovnica.vycistiSachovnicu(mozneTahy);

                        if (!Sachovnica.getStavHry()) {
                            JOptionPane.showMessageDialog(null, "Koniec hry!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Na tomto policku nemate figurku!");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Neplatny vstup!");
                }

            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Neplatny vstup!");
            }
        }
    }

    public boolean posunFigurkou(ArrayList<String> mozneTahy, Figurka paFigurka) {

        boolean posun = false;

        JPanel presunFigurky = new JPanel();

        presunFigurky.add(new JLabel("Riadok:"));
        JTextField prvyRiadok = new JTextField(2);
        presunFigurky.add(prvyRiadok);
        presunFigurky.add(new JLabel("Stlpec:"));
        JTextField druhyRiadok = new JTextField(2);
        presunFigurky.add(druhyRiadok);
        presunFigurky.setLayout(new GridLayout(4, 2, 2, 2));
        presunFigurky.setPreferredSize(new Dimension(300, 120));

        int vysledok = JOptionPane.showConfirmDialog(null, presunFigurky, ("Zadajte riadok s tlpec policka, kam chcete posunut figurku:"), JOptionPane.OK_CANCEL_OPTION);

        if (vysledok == JOptionPane.OK_OPTION) {

            try {
                int riadokFigurky = Integer.parseInt(prvyRiadok.getText()) - 1;
                int stlpecFigurky = this.prevodStlpca(druhyRiadok.getText());

                if (riadokFigurky > -1 && riadokFigurky < 8 && stlpecFigurky != -1) {

                    String kluc = riadokFigurky + "" + stlpecFigurky;

                    if (mozneTahy.contains(kluc)) {
                        paFigurka.zmenSuradnice(riadokFigurky, stlpecFigurky);
                        Sachovnica.zmenPolicko(riadokFigurky, stlpecFigurky, paFigurka, this);
                        posun = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Na taketo policko nemozete ist!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Neplatny vstup!");
                }
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Neplatny vstup!");
            }
        }


        return posun;

    }

    public boolean skontrolujPesiaka(Figurka paFigurka) {
        int riadokFigurky = paFigurka.getRiadokFigurky();

        if (riadokFigurky == 0 && this.farba.equals("biela")) {
            return true;
        } else {
            return riadokFigurky == 7 && this.farba.equals("cierna");
        }

    }

    public int prevodStlpca(String znak) {
        znak = znak.toLowerCase();

        return switch ((znak)) {
            case "a" -> 0;
            case "b" -> 1;
            case "c" -> 2;
            case "d" -> 3;
            case "e" -> 4;
            case "f" -> 5;
            case "g" -> 6;
            case "h" -> 7;
            default -> -1;
        };
    }
}
