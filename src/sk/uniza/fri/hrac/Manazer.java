package sk.uniza.fri.hrac;

import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

import sk.uniza.fri.sachovnica.Sachovnica;
import sk.uniza.fri.zobrazenie.Platno;

import javax.swing.JOptionPane;

// tuto triedu mam zo systemu moodle predmetu Informatika 1 z projektu tvaryV3

/**
 * Automaticky posiela spravy danym objektom:<br />
 * posunDole() - pri stlaceni klavesy DOWN<br />
 * posunHore() - pri stlaceni klavesy UP<br />
 * posunVlavo() - pri stlacen klavesy LEFT<br />
 * posunVpravo() - pri stlaceni klavesy RIGHT<br />
 * aktivuj() - pri stlaceni klavesy ENTER alebo SPACE<br />
 * zrus() - pri stlaceni klavesy ESC<br />
 * tik() - kazdych 0,25 sekundy<br />
 * vyberSuradnice(x, y) - pri kliknuti mysou
 */
public class Manazer {
    private final ArrayList<Object> spravovaneObjekty;
    private long oldTick;
    private static final long TICK_LENGTH = 250000000;
    private final Hrac[] hraci = new Hrac[2];
    
    private class ManazerKlaves extends KeyAdapter {
        /**
         * tuto triedu som upravil tak, aby priradila spravovanym objektom klaves, pomoocu ktoreho im mozno posielat spravy
         */
        public void keyPressed(KeyEvent event) {
            if (Sachovnica.getStavHry()) {
                if (event.getKeyCode() == KeyEvent.VK_S && Manazer.this.hraci[0].getPoradie()) {
                    Manazer.this.posliSpravu("oznacFigurku", Manazer.this.hraci[0]);
                } else if (event.getKeyCode() == KeyEvent.VK_K && Manazer.this.hraci[0].getPoradie()) {
                    JOptionPane.showMessageDialog(null, "Na rade je hrac s bielymi figurkami!");
                } else if (event.getKeyCode() == KeyEvent.VK_S && Manazer.this.hraci[1].getPoradie()) {
                    JOptionPane.showMessageDialog(null, "Na rade je hrac s ciernymi figurkami!");
                } else if (event.getKeyCode() == KeyEvent.VK_K && Manazer.this.hraci[1].getPoradie()) {
                    Manazer.this.posliSpravu("oznacFigurku", Manazer.this.hraci[1]);
                }
            }
        }
    }
    
    private class ManazerCasovaca implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            long newTick = System.nanoTime();
            if (newTick - Manazer.this.oldTick >= Manazer.TICK_LENGTH || newTick < Manazer.TICK_LENGTH) {
                Manazer.this.oldTick = (newTick / Manazer.TICK_LENGTH) * Manazer.TICK_LENGTH;
                //Manazer.this.posliSpravu("tik");
            }
        }
    }
    
    private class ManazerMysi extends MouseAdapter {
        public void mouseClicked(MouseEvent event) {
            if (event.getButton() == MouseEvent.BUTTON1) {
                Manazer.this.posliSpravu("posunVpravo", event.getX(), event.getY());
            }
        }
    }
    
    private void posliSpravu(String selektor, Object adresat) {
        
        try {
            Method sprava = adresat.getClass().getMethod(selektor);
            sprava.invoke(adresat);
        } catch (SecurityException e) {
            this.doNothing();
        } catch (NoSuchMethodException e) {
            this.doNothing();
        } catch (IllegalArgumentException e) {
            this.doNothing();
        } catch (IllegalAccessException e) {
            this.doNothing();
        } catch (InvocationTargetException e) {
            this.doNothing();
        }
        
    }
    
    private void posliSpravu(String selektor, int prvyParameter, int druhyParameter) {
        for (Object adresat : this.spravovaneObjekty) {
            try {
                Method sprava = adresat.getClass().getMethod(selektor, Integer.TYPE, Integer.TYPE);
                sprava.invoke(adresat, prvyParameter, druhyParameter);
            } catch (SecurityException e) {
                this.doNothing();
            } catch (NoSuchMethodException e) {
                this.doNothing();
            } catch (IllegalArgumentException e) {
                this.doNothing();
            } catch (IllegalAccessException e) {
                this.doNothing();
            } catch (InvocationTargetException e) {
                this.doNothing();
            }
        }
    }
    
    private void doNothing() {
        
    }
    
    /**
     * Vytvori novy manazer, ktory nespravuje zatial ziadne objekty.
     */
    public Manazer(Hrac prvyHrac, Hrac druhyHrac) {
        this.spravovaneObjekty = new ArrayList<Object>();
        Platno.dajPlatno().addKeyListener(new ManazerKlaves());
        Platno.dajPlatno().addTimerListener(new ManazerCasovaca());
        Platno.dajPlatno().addMouseListener(new ManazerMysi());
        this.hraci[0] = prvyHrac;
        this.hraci[1] = druhyHrac;

    }
    
    /**
     * Manazer bude spravovat dany objekt.
     * 
     * tuto triedu som upravil tak, aby spravovala objekty, ktore su pridane v atribute hraci a v atribute kocka triedy Hra
     * 
     */
    public void spravujObjekt() {
        this.spravovaneObjekty.add(this.hraci[0]);
        this.spravovaneObjekty.add(this.hraci[1]);
    }
}
