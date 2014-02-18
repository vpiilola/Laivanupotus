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
    private JLabel ampumaKerrat;
    private JLabel laivojaJaljella;
    private JLabel nimi;
    
    public YlaosanKomponentit(Käyttöliittymä kayttoliittyma){
        this.liittyma=kayttoliittyma;
        this.setLayout(new GridLayout(3,1));
    }
    
    public void luoKomponentit(){
        this.nimi = new JLabel("Nimi: " + this.liittyma.getPelaaja().getNimi());
        this.ampumaKerrat = new JLabel("Ampumakerrat: " + this.liittyma.getAmpumaKerrat());
        this.laivojaJaljella = new JLabel("Laivoja jäljellä: " + this.liittyma.getLaivojaJaljella());
        
        this.add(nimi);
        this.add(ampumaKerrat);
        this.add(laivojaJaljella);
        
    }
    
    public void paivitaYlaPaneeli(){
        this.removeAll();
        this.add(nimi);
        this.ampumaKerrat = new JLabel("Ampumakerrat: " + this.liittyma.getAmpumaKerrat());
        this.laivojaJaljella = new JLabel("Laivoja jäljellä: " + this.liittyma.getLaivojaJaljella());
        
        this.add(nimi);
        this.add(ampumaKerrat);
        this.add(laivojaJaljella);
        
    }
    
}
