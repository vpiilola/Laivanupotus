package Laivanupotus.Kayttoliittyma;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Sovelluslogiikka.Laivanupotus;
import Laivanupotus.käyttöliittymä.Aloitunakyma.AloitusNakyma;
import Laivanupotus.Kayttoliittyma.Ylaosa.YlaosanKomponentit;
import Sovelluslogiikka.Pelaaja;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
//import jawa.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Vesku
 */
public class Käyttöliittymä implements Runnable {

    private JFrame frame;
    private JFrame frame2;
    Laivanupotus peli;
    private AloitusNakyma aloitus;
    private YlaosanKomponentit ylaosa;
    private JPanel alusta;
    private GridLayout layout;
    private AmmunKuuntelija tahtain;

    public Käyttöliittymä(Laivanupotus laivapeli) {
        this.peli = laivapeli;
    }
    
    public int getLaivojaJaljella(){
        return peli.getLaivojaJaljella();
    }
    
    public Pelaaja getPelaaja(){
        return peli.getPelaaja();
    }
    
    public int getAmpumaKerrat(){
        return peli.getAmpumaKerrat();
    }
  

    @Override
    public void run() {
        
        this.frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(300, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoAloitusNakyma();


        frame.pack();
        frame.setVisible(true);
        
        

//        luoKomponentit(frame.getContentPane());
//        frame.pack();
//        frame.setVisible(true);
    }

    /*
     * Luo toistaiseksi vain tekstikomponentit käyttöliittymälle
     */
    public void luoAloitusNakyma(){
        this.aloitus = new AloitusNakyma(this);
        aloitus.luo();
        frame.getContentPane().add(aloitus, BorderLayout.NORTH);
    }
    

    
    public void AloitaPeli(){
        frame.setVisible(false);
        
        this.frame2 = new JFrame("Laivanupotus");
        frame2.setPreferredSize(new Dimension(700, 700));
        
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
               
        
        
        luoKomponentit(frame2.getContentPane());
        
        this.ylaosa = new YlaosanKomponentit(this);
        ylaosa.luoKomponentit();
        frame2.getContentPane().add(ylaosa,BorderLayout.NORTH);
        
        
        frame2.pack();
        frame2.setVisible(true);
        
    }

    public void luoKomponentit(Container container) {
               

        container.add(luoRuudukko(), BorderLayout.SOUTH);
    }

    /*
     * Luo käyttöliittymään peliruudukon, josta näkyy aluksi
     * ruudut joihin mihinkään ei ole ammuttu
     */
    public JPanel luoRuudukko() {
        this.layout = new GridLayout(peli.getKorkeus(), peli.getLeveys());
        alusta = new JPanel(this.layout);
        this.peli.valmisteleAlusta();
        this.peli.tietokoneenLaivasto();
        
        for (int i = 0; i < peli.getKorkeus(); i++) {
            for (int j = 0; j < peli.getLeveys(); j++) {
                LautaRuutu ruutu = new LautaRuutu("0", i, j);
                tahtain = new AmmunKuuntelija(this,i,j, ruutu);
                ruutu.addActionListener(tahtain);
                alusta.add(ruutu);
            }

        }
        
        return alusta;
    }
    
    public void PaivitaYlaosa(){          
        ylaosa.paivitaYlaPaneeli();        
        this.frame2.getContentPane().add(ylaosa, BorderLayout.NORTH);
        this.frame2.pack();
        this.frame2.setVisible(true);
    }
    
    public JPanel getAlusta(){
        return this.alusta;
    }

    public JFrame getFrame() {
        return this.frame2;
    }

}
