/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

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
public class LaivaTest {

    public LaivaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
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
    public void LuodaanOikeanKokoinenLaiva() {
        Laiva laiva = new Laiva(2);
        int koko = laiva.getKoko();
        assertEquals(2, koko);
    }

    /**
     * Testataan onnistuiko oikean kokoisen laivan luominen, samalla toimiiko
     * getteri oikein *
     */
    @Test
    public void OsumaKasvattaaOsumienMaaraa() {
        Laiva laiva = new Laiva(3);
        laiva.osumaLaivaan();
        assertEquals(1, laiva.getOsumat());
    }

    /**
     * Testataan kasvattaako osuma oikeasti osumien määrää*
     */
    @Test
    public void EhjaLaivaEiOleUponnut() {
        Laiva laiva = new Laiva(2);
        assertEquals(laiva.onkoUponnut(), false);
    }

    /**
     * Testataan ettei ehja laiva uppoa*
     */
    @Test
    public void LaivaUppoaa() {
        Laiva laiva = new Laiva(2);
        laiva.osumaLaivaan();
        laiva.osumaLaivaan();
        assertEquals(laiva.onkoUponnut(), true);
    }

    /**
     * Testataan, että laiva uppoaa kun siihen osutaan tarpeaksi usein*
     */
}
