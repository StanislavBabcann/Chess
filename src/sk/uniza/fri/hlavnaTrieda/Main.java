package sk.uniza.fri.hlavnaTrieda;

import sk.uniza.fri.hrac.FarbaFigurky;
import sk.uniza.fri.hrac.Manazer;
import sk.uniza.fri.sachovnica.Sachovnica;
import sk.uniza.fri.hrac.Hrac;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Dimension;

public class Main {

    public static void main(String[] args) {
        JPanel zadavanie = new JPanel();

        zadavanie.add(new JLabel("Zadaj meno hraca s bielymi figurkami:"));
        JTextField menoPrveho = new JTextField(2);
        zadavanie.add(menoPrveho);
        zadavanie.add(new JLabel("Zadaj meno hraca s ciernymi figurkami:"));
        JTextField menoDruheho = new JTextField(2);
        zadavanie.add(menoDruheho);
        zadavanie.setLayout(new GridLayout(4, 2, 2, 2));
        zadavanie.setPreferredSize(new Dimension(300, 120));

        int vysledok = JOptionPane.showConfirmDialog(null, zadavanie, ("Zadajte mena hracov:"), JOptionPane.OK_CANCEL_OPTION);

        if (vysledok == JOptionPane.OK_OPTION) {
            Hrac prvyHrac = new Hrac(menoPrveho.toString(), FarbaFigurky.BIELA);
            Hrac druhyHrac = new Hrac(menoDruheho.toString(), FarbaFigurky.CIERNA);

            JOptionPane.showMessageDialog(null, "Ovladanie\nHrac s bielymi figurkami - klavesa S\nHrac s ciernymi figurkami - klavesa K\nPo stlaceni prislusneho klavesu sa Vam zobrazi okno,\ndo ktoreho zadavate riadok a stlpec policka, s ktorym chcete zahrat.\nHru zacina hrac s bielymi figurkami.");

            new Sachovnica(prvyHrac, druhyHrac);

            new Manazer(prvyHrac, druhyHrac);


        }
    }
}
