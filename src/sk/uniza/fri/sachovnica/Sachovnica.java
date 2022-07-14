package sk.uniza.fri.sachovnica;
import sk.uniza.fri.figurka.Figurka;
import sk.uniza.fri.figurka.Kral;
import sk.uniza.fri.hrac.Hrac;
import sk.uniza.fri.zobrazenie.Stvorec;

import java.util.ArrayList;

public class Sachovnica {
    private static Figurka[][] hraciaDoska;
    private static final Hrac[] HRACI = new Hrac[2];
    private static Stvorec[][] policka;
    private static boolean stavHry;

    public Sachovnica(Hrac paPrvyHrac, Hrac paDruhyHrac) {
        HRACI[0] = paPrvyHrac;
        HRACI[1] = paDruhyHrac;
        hraciaDoska = new Figurka[8][8];
        policka = new Stvorec[8][8];
        stavHry = true;

        for (int i = 0; i < 8; i++) {
            for (int y = 0; y < 8; y++) {
                Stvorec stvorec = new Stvorec("obilie");
                stvorec.setSuradnice(40 + y * 90, 40 + i * 90);
                if (i % 2 == 0) {
                    if (y % 2 == 1) {
                        stvorec.zmenFarbu("piesok");
                    }
                } else {
                    if (y % 2 == 0) {
                        stvorec.zmenFarbu("piesok");
                    }
                }
                policka[i][y] = stvorec;
                stvorec.zobraz();
            }
        }

        Figurka[] figurkyBiele = HRACI[0].dajFigurky();
        Figurka[] figurkyCierne = HRACI[1].dajFigurky();

        for (int i = 0; i < 16; i++) {
            Figurka figurkaBiela = figurkyBiele[i];
            Figurka figurkaCierna = figurkyCierne[i];
            int riadokBieleho = figurkaBiela.getRiadokFigurky();
            int stlpecBieleho = figurkaBiela.getStlpecFigurky();
            int riadokCierneho = figurkaCierna.getRiadokFigurky();
            int stlpecCierneho = figurkaCierna.getStlpecFigurky();
            hraciaDoska[riadokBieleho][stlpecBieleho] = figurkaBiela;
            hraciaDoska[riadokCierneho][stlpecCierneho] = figurkaCierna;
            figurkaBiela.zobrazFigurku();
            figurkaCierna.zobrazFigurku();
        }
    }

    public static boolean getStavHry() {
        return stavHry;
    }

    public static Figurka dajFigurku(int paRiadok, int paStlpec) {
        if (hraciaDoska[paRiadok][paStlpec] != null) {
            return hraciaDoska[paRiadok][paStlpec];
        } else {
            return null;
        }
    }

    public static boolean obsadenostPolicka(int paRiadok, int paStlpec) {
        return hraciaDoska[paRiadok][paStlpec] == null;

    }

    public static void oznacStvorec(int paRiadok, int paStlpec, String paFarba) {
        Stvorec meneny = policka[paRiadok][paStlpec];
        meneny.zmenFarbu(paFarba);
        meneny.zobraz();
    }

    public static void zmenPolicko(int paRiadok, int paStlpec, Figurka paFigurka, Hrac hrac) {
        if (hraciaDoska[paRiadok][paStlpec] instanceof Kral && paFigurka != null) {
            stavHry = false;
        }
        hraciaDoska[paRiadok][paStlpec] = paFigurka;
        if (paFigurka != null) {
            paFigurka.setZobrazenie();
        }

        if (hrac.equals(HRACI[0])) {
            HRACI[0].setPoradie(false);
            HRACI[1].setPoradie(true);
        } else {
            HRACI[0].setPoradie(true);
            HRACI[1].setPoradie(false);
        }
    }

    public static void vycistiSachovnicu(ArrayList<String> menenePolicka) {
        for (String policko : menenePolicka) {
            int riadok = Character.getNumericValue(policko.charAt(0));
            int stlpec = Character.getNumericValue(policko.charAt(1));

            Stvorec meneny = policka[riadok][stlpec];
            if (riadok % 2 == 0) {
                if (stlpec % 2 == 1) {
                    meneny.zmenFarbu("piesok");
                } else {
                    meneny.zmenFarbu("obilie");
                }
            } else {
                if (stlpec % 2 == 0) {
                    meneny.zmenFarbu("piesok");
                } else {
                    meneny.zmenFarbu("obilie");
                }
            }

            meneny.zobraz();

            if (hraciaDoska[riadok][stlpec] != null) {
                Figurka zobrazovana = hraciaDoska[riadok][stlpec];
                zobrazovana.zobrazFigurku();
            }
        }
    }
}
