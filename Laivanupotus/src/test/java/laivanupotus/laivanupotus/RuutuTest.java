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
public class RuutuTest {
    
    public RuutuTest() {
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
    public void RuudussaEiLaivaa(){
        Ruutu ruutu = new Ruutu();
        assertEquals(ruutu.laiva, null);
        
    }
    
    
    @Test
    public void RuudussaLaiva(){
        Ruutu ruutu = new Ruutu();
        Laiva laiva = new Laiva(2);
        ruutu.asetaLaiva(laiva);
        assertEquals(ruutu.getLaiva(),laiva);
    }
    
    @Test
    public void RuutuunEiAmmuttu(){
        Ruutu ruutu = new Ruutu();
        assertEquals(ruutu.ammuttu, false);
    }
}
