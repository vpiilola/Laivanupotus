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
public class Pelaaja {
    
    String nimi;
    
    /**Pelaajalla täytyy olla nimi**/
    
    public Pelaaja(String nimi){
        this.nimi=nimi;
    }
    
    /**Luodaan pelaaja-olio**/
    
//    public void setNimi(String nimi){
//        this.nimi=nimi;
//    }
    
    public String getNimi(){
        return nimi;
    }
    /** Palauttaa pelaajan nimen**/
}
