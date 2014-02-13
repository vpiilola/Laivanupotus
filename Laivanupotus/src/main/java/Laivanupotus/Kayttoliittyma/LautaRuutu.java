/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Laivanupotus.Kayttoliittyma;

import javax.swing.JButton;

/**
 *
 * @author Vesku
 */
public class LautaRuutu extends JButton {

    int rivi;
    int sarake;

    public LautaRuutu(String teksti, int x, int y) {
        super(teksti);
        rivi = x;
        sarake = y;

    }

    public int getRivi() {
        return rivi;
    }

    public int getSarake() {
        return sarake;
    }
}
