package sk.uniza.fri.figurka;

import java.util.ArrayList;

public interface IFigurka {
    ArrayList<String> ukazMozneTahy();
    void zobrazFigurku();
    void setZobrazenie();
    void zobrazMozneTahy(ArrayList<String> paMozneTahy);
}
