/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

/**
 *
 * @author vpiilola
 */
public class Laiva {

    private int koko = 0;
    /**
     * Laivan koko - montako ruutua laiva kuluttaa*
     */

    private int osumat;

    /**
     * Montako kertaa laivaan on osuttu jos on yhtäsuurin kuin koko laiva
     * tuhoutuu *
     */

    public Laiva(int koko) {
        this.koko = koko;
        osumat = 0;
    }

    /**
     * luo laiva-olion, jonka kooksi asetaan syötetty luku, tässä vaiheessa
     * laiva on ehjä *
     */
    public int getKoko() {
        return koko;
    }

    /**
     * Palauttaa laivan koon - erityisesti myöhempiä metodeja varten (?) *
     */
    public int getOsumat() {
        return osumat;
    }

    /**
     * Vastaavasti palauttaa osumat*
     */
    public boolean onkoUponnut() {
        return getOsumat() == koko;
    }

    public void osumaLaivaan() {
        osumat++;
    }

}
