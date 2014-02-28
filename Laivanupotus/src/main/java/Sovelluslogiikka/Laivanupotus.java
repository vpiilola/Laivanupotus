/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Sovelluslogiikka.Pelaaja;
import Sovelluslogiikka.Laiva;
import Sovelluslogiikka.Ruutu;

/**
 *
 * @author vpiilola
 */
import java.util.Random;

public class Laivanupotus {

    /**
     * Pelaaja*
     */
    private Pelaaja pelaaja;

    /**
     * Pelilaudan korkeus*
     */
    int korkeus;

    /*Pelilaudan leveys**/
    int leveys;


    /*Montako kertaa pelin aikana on ammuttu**/
    int ampumaKerrat = 0;

    /*Kertoo montako laivaa pelissä on vielä jäljellä**/
    int laivojaJaljella;

    /**
     * Ruutu-olioista koostuva pelialusta.
     */
    public Ruutu[][] alusta;

    /**
     * Luo luokalle ilmentymän. Oletusarvoinen pelilauta 10x10 lauta, jossa ei
     * ole vielä laivoja.
     */
    public Laivanupotus() {
        korkeus = 10;
        leveys = 10;
        this.pelaaja = new Pelaaja();
        this.laivojaJaljella = 0;
        alusta = new Ruutu[korkeus][leveys];
    }

    /**
     * Palauttaa montako kertaa pelaaja on ampunut.
     *
     * @return
     */
    public int getAmpumaKerrat() {
        return ampumaKerrat;
    }

    /**
     * Palauttaa ampumattomien laivojen määrän.
     *
     * @return
     */
    public int getLaivojaJaljella() {
        return this.laivojaJaljella;
    }

    /**
     * Alustaa pelilaudan peliä varten tyhjillä ruutu - olioilla.
     */
    public void valmisteleAlusta() {

        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                alusta[i][j] = new Ruutu();
            }
        }
    }

    /**
     * Palauttaa pelilaudan korkeuden.
     *
     * @return
     */
    public int getKorkeus() {
        return korkeus;
    }

    /**
     * Palauttaa pelilaudan leveyden.
     *
     * @return
     */
    public int getLeveys() {
        return leveys;
    }

    /**
     * Palauttaa pelaajan
     *
     * @return
     */
    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    /**
     * Tarkistaa onko annettu piste pelilaudalla.
     *
     * @param x
     * @param y
     * @return
     */
    public boolean onkoLaudalla(int x, int y) {
        if (x < 0 || y < 0 || x >= korkeus || y >= leveys) {
            return false;
        }

        return true;
    }

    /**
     * Tarkistaa onko annetussa ruudussa jo laivaa.
     *
     * @param x
     * @param y
     * @return
     */
    public boolean onkoLaivaa(int x, int y) {
        return alusta[x][y].getLaiva() != null;
    }

    /**
     * Tarkistetaan sopiiko ehdotettu laiva pelilaudalle
     *
     * @param x käyttäjän antama rivi, johon laivaa sijoitetaan
     * @param y käyttäjän antama sarake
     * @param suunta 0 tai 1 (0 vaakasuoraan, 1 pystysuoraan)
     * @param laiva sijoitettava laiva-olio *
     */
    public boolean sopiikoLaiva(int x, int y, int suunta, Laiva laiva) {
        int laivaaJaljella = laiva.getKoko();

        boolean sopiiko = false;

        while (laivaaJaljella > 0) {
            if (onkoLaudalla(x, y) && !onkoLaivaa(x, y)) {
                sopiiko = true;
                laivaaJaljella--;
                if (suunta == 0) {
                    x++;
                } else if (suunta == 1) {
                    y++;
                }
            } else {
                sopiiko = false;
                break;
            }
        }

        return sopiiko == true;
    }

    /**
     * Sijoittaa annetun laivan-olion annettuun ruutuun.
     *
     * @param laiva
     * @param x
     * @param y
     */
    public void sijoitaLaiva(Laiva laiva, int x, int y) {
        alusta[x][y].asetaLaiva(laiva);
    }

    /**
     *
     * Sijoitetaan laiva satunnaisesta ruudusta lähtien satunnaiseen suuntaan
     *
     * @param laiva Käyttäjän antama laiva, jota sijoitetaan
     */
    public void sijoitaLaivaSatunnaiseen(Laiva laiva) {
        Random arpoja = new Random();
        int rivi;
        int sarake;
        int suunta;

        do {
            rivi = arpoja.nextInt(korkeus);
            sarake = arpoja.nextInt(leveys);
            suunta = arpoja.nextInt(2);
        } while (!sopiikoLaiva(rivi, sarake, suunta, laiva));

        int laivaaJaljella = laiva.getKoko();

        while (laivaaJaljella > 0) {
            sijoitaLaiva(laiva, rivi, sarake);
            laivaaJaljella--;
            if (suunta == 0) {
                rivi++;
            } else {
                sarake++;
            }

        }
        laivojaJaljella++;
    }

    /**
     * Tarkistaa onko ehdotettuun ruutuun jo ammuttu
     *
     * @param x
     * @param y
     * @return boolean
     */
    public boolean onkoAmmuttu(int x, int y) {
        return alusta[x][y].getAmmuttu();
    }

    /**
     * Suorittaa ampumisen käyttäjän antamaan koordinaattiin, palauttaa
     * numeroarvon riippuen mitä tapahtui.
     *
     * @param x käyttäjän antama rivi, johon ammutaan
     * @param y käyttjän antama sarake
     * @return -1 jos ruutuun ei voi ampua, 0-2 sen mukaan oliko laivaa tai
     * upposiko osuttu laiva
     */
    public int Ammu(int x, int y) {

        if (onkoLaudalla(x, y) == false || onkoAmmuttu(x, y)) {
            return -1;
        } else {
            alusta[x][y].setAmmuttu();
            ampumaKerrat++;

            if (onkoLaivaa(x, y) == true) {
                alusta[x][y].getLaiva().osumaLaivaan();
                if (alusta[x][y].getLaiva().onkoUponnut()) {
                    laivojaJaljella--;
                    return 2;
                }
                return 1;
            }
            return 0;
        }
    }

    /**
     * Tarkistaa jatkuuko peli vielä - peli päättyy kun arvo on false eli
     * laivojen lkm = 0
     *
     * @return True jos pelissä on vielä laivoja
     */
    public boolean onkoPeliaJaljella() {
        return laivojaJaljella > 0;
    }

    /**
     * Luo koko tietokoneen laivaston kerralla.
     */
    public void tietokoneenLaivasto() {
        Laiva lentotukialus = new Laiva(5);
        Laiva taistelulaiva = new Laiva(4);
        Laiva Risteilija1 = new Laiva(3);
        Laiva Risteilija2 = new Laiva(3);
        Laiva havittaja = new Laiva(2);
        Laiva sukellusvene = new Laiva(1);

        sijoitaLaivaSatunnaiseen(lentotukialus);
        sijoitaLaivaSatunnaiseen(taistelulaiva);
        sijoitaLaivaSatunnaiseen(Risteilija1);
        sijoitaLaivaSatunnaiseen(Risteilija2);
        sijoitaLaivaSatunnaiseen(havittaja);
        sijoitaLaivaSatunnaiseen(sukellusvene);

    }

}
