/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Sovelluslogiikka.Laivanupotus;
import Sovelluslogiikka.Laiva;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vpiilola
 */
public class LaivanupotusTest {

    Laivanupotus uusiPeli;
    Laiva Risteilija;
    Laiva Sukellusvene;

    public LaivanupotusTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        uusiPeli = new Laivanupotus();
        uusiPeli.valmisteleAlusta();
        Risteilija = new Laiva(3);
        Sukellusvene = new Laiva(1);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void OletusAlustaOikeanKorkuinen() {
        assertEquals(uusiPeli.getKorkeus(), 10);
    }

    /**
     * Testataan oletus alustan korkeus*
     */
    @Test
    public void OletusAlustaOikeanLevyinen() {
        assertEquals(uusiPeli.getLeveys(), 10);
    }

    /**
     * Testataan oletus alustan leveys*
     */

    @Test
    public void AmpumaKerratAlussa() {
        assertEquals(0, uusiPeli.ampumaKerrat);
    }

    /*Tarkistaa, että alussa ei ole ammuttu*/
    @Test
    public void ValmisteleAlustaAsettaaLaivattomiaRuutuja() {
        uusiPeli.valmisteleAlusta();
        boolean eiLaivaa = true;

        for (int i = 0; i < uusiPeli.getKorkeus(); i++) {
            for (int j = 0; j < uusiPeli.getLeveys(); j++) {

                if (uusiPeli.onkoLaivaa(i, j)) {
                    eiLaivaa = false;
                    break;
                }
            }
        }
        assertEquals(eiLaivaa, true);
    }

    /**
     * Tarkistaa, että alusta luodaan oikein ja ruudut ovat tyhjiä
     */
    @Test
    public void OnkoLaudallaToimiiKunOllaanLaudalla() {
        assertEquals(uusiPeli.onkoLaudalla(2, 4), true);
    }

    /*testaa onkoLaudalla -metodia, että pysytään laudalla */
    @Test
    public void OnkoLaudallaToimiiKunEiOllaLaudalla() {
        assertEquals(uusiPeli.onkoLaudalla(11, 4), false);
    }

    /*testaa onkoLaudalla -metodia, ja varmistaa että on oikein
     kun ei pysytälaudalla */
    @Test
    public void onkoLaivaaToimiiKunRuudussaOnLaiva() {
        uusiPeli.alusta[2][2].asetaLaiva(Sukellusvene);
        assertEquals(true, uusiPeli.onkoLaivaa(2, 2));
    }

    /* Tarkistetaan löytyykö asetettu laiva oikeasta ruudusta */
    @Test
    public void onkoLaivaaToimiiKunRuudussaEiOleLaivaa() {
        assertEquals(false, uusiPeli.onkoLaivaa(1, 1));
    }

    /*Sama tarkistus kun ei ole laivaa */
    @Test
    public void laivaLoytyyRuudustaOikeassavaiheessa() {
        boolean vastaus = uusiPeli.onkoLaivaa(1, 1);
        assertEquals(false, vastaus);

        uusiPeli.sijoitaLaiva(Risteilija, 1, 1);
        vastaus = uusiPeli.onkoLaivaa(1, 1);
        assertTrue(vastaus);
    }

    /*Tarkistetaan, että laiva löytyy oikeasta ruudusta oikeaan aikaan */
    @Test
    public void laivaSopiiLaudalle() {
        boolean vastaus = uusiPeli.sopiikoLaiva(1, 1, 0, Risteilija);
        assertTrue(vastaus);
    }

    /*tarkastetaan, että laivan sijoittaminen onnistuu laudalle */
    @Test
    public void laivaaEiVoiSyöttääUlkopuolelle() {
        boolean vastaus = uusiPeli.sopiikoLaiva(11, 2, 0, Sukellusvene);
        assertFalse(vastaus);
    }

    /*Tarkistetaan, että laivaa ei voi alunperin syöttää ulos laudalta */
    @Test
    public void laivaaEiVoiAsettaaOsinUlos() {
        boolean vastaus = uusiPeli.sopiikoLaiva(8, 8, 1, Risteilija);
        assertFalse(vastaus);
    }

    /*tarkistetaan, ettei liian isoa laivaa voi asettaa reunalle s.e.
     * se menisi ulos pelilaudalta. */
    @Test
    public void EiVoiAmpuaLiianSuureenRuuttuun() {
        uusiPeli.Ammu(11, 0);
        assertEquals(uusiPeli.ampumaKerrat, 0);
    }

    @Test
    public void EiVoiAmpuaLiianPieneenRuutuun() {
        uusiPeli.Ammu(-1, -2);
        assertEquals(uusiPeli.ampumaKerrat, 0);
    }

    /*Tarkistetaan, että ohi laudan ampuminen ei edistä peliä*/
    @Test
    public void AmpuminenToimiiTyhjaanRuutuun() {
        uusiPeli.Ammu(2, 2);
        assertTrue(uusiPeli.alusta[2][2].getAmmuttu());

        assertEquals(uusiPeli.ampumaKerrat, 1);
    }

    @Test
    public void AmpuminenOsuuLaivaan() {
        uusiPeli.sijoitaLaiva(Risteilija, 1, 1);
        uusiPeli.Ammu(1, 1);
        assertTrue(uusiPeli.alusta[1][1].ammuttu);

        assertEquals(1, uusiPeli.ampumaKerrat);
    }

    @Test
    public void AmmuttuunRuutuunEiVoiAmpua() {
        uusiPeli.Ammu(1, 1);
        uusiPeli.Ammu(1, 1);

        assertEquals(uusiPeli.ampumaKerrat, 1);
    }

    @Test
    public void AmmuMetodiPealauttaaNollaKunEiOsu() {
        int vastaus = uusiPeli.Ammu(1, 1);
        assertEquals(0, vastaus);
    }

    @Test
    public void AmmuMetodiPalauttaaYksiKunOsutaan() {
        uusiPeli.sijoitaLaiva(Risteilija, 1, 1);
        int vastaus = uusiPeli.Ammu(1, 1);
        assertEquals(1, vastaus);
    }

    @Test
    public void ammuMetodiUpottaaPienenLaivan() {
        uusiPeli.sijoitaLaiva(Sukellusvene, 1, 1);
        int vastaus = uusiPeli.Ammu(1, 1);
        assertEquals(2, vastaus);
    }

    @Test
    public void ammuMetodiUpottaaUseassaRuudussaOlevanLaivan() {
        uusiPeli.sijoitaLaiva(Risteilija, 1, 1);
        uusiPeli.sijoitaLaiva(Risteilija, 1, 2);
        uusiPeli.sijoitaLaiva(Risteilija, 1, 3);

        uusiPeli.Ammu(1, 1);
        uusiPeli.Ammu(1, 2);
        int vastaus = uusiPeli.Ammu(1, 3);
        assertEquals(2, vastaus);
    }

    @Test
    public void peliaOnJaljellaKunLaivojaOnJaljella() {
        uusiPeli.sijoitaLaivaSatunnaiseen(Risteilija);
        boolean vastaus = uusiPeli.onkoPeliaJaljella();
        assertTrue(vastaus);
    }

    @Test
    public void peliaEiOleJaljellaKunLaivojaEiOle() {
        boolean vastaus = uusiPeli.onkoPeliaJaljella();
        assertFalse(vastaus);
    }
    
    @Test
    public void TietokoneenLaivastoMuodostuuOikein(){
        uusiPeli.tietokoneenLaivasto();
        assertEquals(6, uusiPeli.laivojaJaljella);
    }

}
