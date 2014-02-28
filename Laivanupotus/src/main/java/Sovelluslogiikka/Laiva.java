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

    /**
     * Luo laiva-olion, jonka kooksi asetetaan syötetty luku.
     * @param koko 
     */
    public Laiva(int koko) {
        this.koko = koko;
        osumat = 0;
    }


    /**
     * Palauttaa laivan koon.
     * @return 
     */
    public int getKoko() {
        return koko;
    }

 /**
  * Palauttaa laivaan tullee osumat. 
  * @return 
  */
    public int getOsumat() {
        return osumat;
    }

   
    /**
     * Kertoo onko laiva uponnut.
     * @return 
     */
    public boolean onkoUponnut() {
        return getOsumat() == koko;
    }

    
    /**
     * Kasvattaa laivan usumia.
     */
    public void osumaLaivaan() {
        osumat++;
    }

}
