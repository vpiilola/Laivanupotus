/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Laivanupotus.käyttöliittymä.Aloitunakyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import Sovelluslogiikka.Pelaaja;

import Kayttoliittyma.Käyttöliittymä;
import Sovelluslogiikka.Pelaaja;
import javax.swing.JTextField;
/**
 *
 * @author vpiilola
 */
public class NimenKuuntelija implements ActionListener {
    private Käyttöliittymä kayttoliittyma;
    private JTextField nimiKentta;
    private Pelaaja pelaaja;
    
    
    public NimenKuuntelija(Käyttöliittymä käyttöliittymä){
        this.kayttoliittyma=käyttöliittymä;
                
    }
    
    public void tuoKoponentit(JTextField nimiKentta){
        this.nimiKentta=nimiKentta;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String nimi = nimiKentta.getText();
        this.pelaaja.setNimi(nimi);
    }
    
}

