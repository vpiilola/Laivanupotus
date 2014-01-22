/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laivanupotus.laivanupotus;

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
    public void OletusAlustaOikeanKorkuinen(){
        assertEquals(uusiPeli.getKorkeus(),10);
    }
    
    /**Testataan oletus alustan korkeus**/
    
    @Test
    public void OletusAlustaOikeanLevyinen(){
        assertEquals(uusiPeli.getLeveys(),10);
    }
    /**Testataan oletus alustan leveys**/
    
    @Test
    public void AmpumaKerratAlussa(){
        assertEquals(0,uusiPeli.ampumaKerrat);
    }
    
    /*Tarkistaa, että alussa ei ole ammuttu*/
    
    @Test
    public void ValmisteleAlustaAsettaaLaivattomiaRuutuja(){
        uusiPeli.valmisteleAlusta();
        boolean eiLaivaa = true;
        
        for (int i=0; i<uusiPeli.getKorkeus();i++){
            for (int j=0; j<uusiPeli.getLeveys(); j++){
                
                if (uusiPeli.onkoLaivaa(i, j)){
                    eiLaivaa =false;                           
                    break;
                }
            }
        }
        assertEquals(eiLaivaa,true);
    }
    
    
    /**Tarkistaa, että alusta luodaan oikein ja ruudut ovat tyhjiä */
    
    @Test
    public void OnkoLaudallaToimiiKunOllaanLaudalla(){
        assertEquals(uusiPeli.onkoLaudalla(2, 4),true);
    }
    
    /*testaa onkoLaudalla -metodia, että pysytään laudalla */
    
    @Test
    public void OnkoLaudallaToimiiKunEiOllaLaudalla(){
        assertEquals(uusiPeli.onkoLaudalla(11, 4),false);
    }
    
    /*testaa onkoLaudalla -metodia, ja varmistaa että on oikein
     kun ei pysytälaudalla */

    @Test
    public void onkoLaivaaToimiiKunRuudussaOnLaiva(){
        uusiPeli.alusta[2][2].asetaLaiva(Sukellusvene);
        assertEquals(true, uusiPeli.onkoLaivaa(2, 2));
    }
    
    /* Tarkistetaan löytyykö asetettu laiva oikeasta ruudusta */
    
    
    @Test
    public void onkoLaivaaToimiiKunRuudussaEiOleLaivaa(){
        assertEquals(false, uusiPeli.onkoLaivaa(1, 1));
    }
    
    /*Sama tarkistus kun ei ole laivaa */
    
    @Test
    public void laivaLoytyyRuudustaOikeassavaiheessa(){
        boolean vastaus = uusiPeli.onkoLaivaa(1, 1);
        assertEquals(false, vastaus);
        
        uusiPeli.sijoitaLaiva(Risteilija, 1, 1);
        vastaus = uusiPeli.onkoLaivaa(1, 1);
        assertTrue(vastaus);
    }
    
   /*Tarkistetaan, että laiva löytyy oikeasta ruudusta oikeaan aikaan */
    
    @Test
    public void laivaSopiiLaudalle(){
         boolean vastaus = uusiPeli.sopiikoLaiva(1, 1, 0, Risteilija);
         assertTrue(vastaus);
    }
    
    /*tarkastetaan, että laivan sijoittaminen onnistuu laudalle */
    
    @Test
    public void laivaaEiVoiSyöttääUlkopuolelle(){
        boolean vastaus = uusiPeli.sopiikoLaiva(11, 2, 0, Sukellusvene);
        assertFalse(vastaus);
    }
    
    /*Tarkistetaan, että laivaa ei voi alunperin syöttää ulos laudalta */
    
    @Test
    public void laivaaEiVoiAsettaaOsinUlos(){
        boolean vastaus = uusiPeli.sopiikoLaiva(8, 8, 1, Risteilija);
        assertFalse(vastaus);
    }
    
    /*tarkistetaan, ettei liian isoa laivaa voi asettaa reunalle s.e.
     * se menisi ulos pelilaudalta. */
    
    
}
