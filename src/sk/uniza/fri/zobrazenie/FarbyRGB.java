package sk.uniza.fri.zobrazenie;

import java.awt.Color;
/**
  Trieda FarbyRGB.
  
 * @author (Babcan)
 * @version (7.1.2021)
 */
public class FarbyRGB {
    //konstantne atributy triedy
    
    /**
     * v konstantnych atributoch som si vytvoril nove farby a zakladne farby s inym odtienom, ktore som potreboval pouzit v triede Platno
     * ako vytvorit nove farby som zistil na stranke teaching.csse.uwa (https://teaching.csse.uwa.edu.au/units/CITS1001/colorinfo.html)
     */
    
    private static final Color VERY_LIGHT_BLUE = new Color(51, 204, 255);
    private static final Color VERY_LIGHT_GREEN = new Color(181, 245, 181);
    private static final Color VERY_LIGHT_YELLOW = new Color(255, 255, 185);
    private static final Color VERY_LIGHT_RED = new Color(255, 102, 102);
    private static final Color LIGHT_BROWN = new Color(153, 102, 0);
    private static final Color GREY = new Color(153, 153, 153);
    private static final Color LIGHT_GREY = new Color(204, 204, 204);
    private static final Color CORN_SILK = new Color(255, 238, 169);
    private static final Color SANDY_BROWN = new Color(244, 164, 96);
    private static final Color WHITE_SMOKE = new Color(245, 245, 245);

    /**
     * @return vrati prislusnu farbu podla zadaneho retazcu String
     * @param farba priradi k retazcu String prislusnu farbu
     */
    public static Color getFarba(String farba) {
        return switch (farba) {
            case "slaboModra" -> VERY_LIGHT_BLUE;
            case "slaboZelena" -> VERY_LIGHT_GREEN;
            case "slaboZlta" -> VERY_LIGHT_YELLOW;
            case "slaboCervena" -> VERY_LIGHT_RED;
            case "slaboHneda" -> LIGHT_BROWN;
            case "seda" -> GREY;
            case "slaboSeda" -> LIGHT_GREY;
            case "obilie" -> CORN_SILK;
            case "piesok" -> SANDY_BROWN;
            case "dymovoBiela" -> WHITE_SMOKE;
            default -> null;
        };
        
    }
}
