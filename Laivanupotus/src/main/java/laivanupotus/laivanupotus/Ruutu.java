/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.laivanupotus;

/**
 *
 * @author vpiilola
 */
public class Ruutu {

    Laiva laiva;

    /**
     * Ruudussa voi olla laiva*
     */
    boolean ammuttu;

    /**
     * kertoo onko ruutuun jo ammuttu*
     */

    public Ruutu() {
        this.ammuttu = false;
        this.laiva = null;
    }

    //**Luo ruutu-olion, jossa ei ole laivaa eikä siihen ole ammuttu**/
    public void asetaLaiva(Laiva laiva) {
        this.laiva = laiva;
    }

    /**
     * Asettaa ruutuun laivan*
     */
    public Laiva getLaiva() {
        return laiva;
    }

    //**Palauttaa ruudussa olevan laivan, jos laivaa ei ole palauttaa arvon null**/
    public boolean getAmmuttu() {
        return ammuttu;
    }

    /**
     * Kertoo onko ruutuun jo ammuttu - onko turha getteri(??)*
     */
    public void setAmmuttu() {
        ammuttu = true;
    }

    /**
     * Muuttaa ruudun ammutuksi, jos siihen ammutaan*
     */
}
