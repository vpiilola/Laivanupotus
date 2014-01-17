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
    public void LuodaanOikeanKokoinenLaiva(){
        Laiva laiva = new Laiva(2);
        int koko = laiva.getKoko();
        assertEquals(2, koko);
    }
    /** Testataan onnistuiko oikean kokoisen laivan luominen, samalla toimiiko 
     * getteri oikein **/
}
