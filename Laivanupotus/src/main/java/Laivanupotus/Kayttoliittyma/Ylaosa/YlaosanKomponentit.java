/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Laivanupotus.Kayttoliittyma.Ylaosa;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.GridLayout;

import Laivanupotus.Kayttoliittyma.Käyttöliittymä;
import Sovelluslogiikka.Pelaaja;
import Sovelluslogiikka.Laivanupotus;
/**
 *
 * @author vpiilola
 */
public class YlaosanKomponentit extends JPanel {
    
    private Käyttöliittymä liittyma;
    private Laivanupotus peli;
    
    public YlaosanKomponentit(Käyttöliittymä kayttoliittyma){
        this.liittyma=kayttoliittyma;
        this.setLayout(new GridLayout(2,1));
    }
    
    public void luoKomponentit(){
        JLabel nimi = new JLabel("Nimi: " + this.liittyma.getPelaaja().getNimi());
        JLabel ampumaKerrat = new JLabel("Ampumakerrat: " + this.liittyma.getAmpumaKerrat());
        
        this.add(nimi);
        this.add(ampumaKerrat);
        
    }
    
}
