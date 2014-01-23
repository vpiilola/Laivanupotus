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
public class Laivanupotus {
    
    Pelaaja pelaaja =new Pelaaja();
    
    /**Pelaaja**/
    
    int korkeus;
    /**Pelilaudan korkeus**/
    
    int leveys;
    /*Pelilaudan leveys**/
    
    int ampumaKerrat =0;
      
    /**Montako kertaa pelin aikana on ammuttu**/
    
    int laivojaJaljella;
    
    /**Kertoo montako laivaa pelissä on vielä jäljellä**/
    
    public Ruutu[][] alusta;
    
    /**Luodaan pelialusta, joka koostuu Ruutu -olioista**/
    
    
    
    public Laivanupotus(){
        korkeus = 10;
        leveys = 10;
        this.laivojaJaljella=0;
        alusta=new Ruutu[korkeus][leveys];
    }
    
    public int getAmpumaKerrat(){
        return ampumaKerrat;
    }
    
    /**Palauttaa ampumisten määrät**/
    
    public void valmisteleAlusta(){
        
        for (int i=0; i< korkeus; i++){
            for (int j=0; j<leveys; j++){
                alusta[i][j]= new Ruutu();
            }
        }
    }
    
    /**Alustaa pelilaudan peliä varten tyhjillä ruutu - olioilla**/
    
    public int getKorkeus(){
        return korkeus;
    }
    
    /**Getteri korkeudelle, jos myöhemmin sallitaan muuttaa laudan kokoa**/
    
    public int getLeveys(){
        return leveys;
    }
    
    /**Getteri korkeudelle, jos myöhemmin sallitaan muuttaa laudan kokoa**/
    
    public Pelaaja getPelaaja(){
        return pelaaja;
    }
    
    /**Palauttaa pelaajan**/
    
    public boolean onkoLaudalla(int x, int y){
        if (x<0 || y<0 || x>=korkeus || y>=leveys){
            return false;
        }
        
        return true;
    }
    
    /**Tarkastaa onko annettu piste pelialustalla*/
    
        public boolean onkoLaivaa(int x, int y) {
            return alusta[x][y].getLaiva() != null;
    }
        
    /**Tarkistetaan onko annetussa ruudussa jo laivaa*/
    
        
        
    public boolean sopiikoLaiva(int x, int y, int suunta, Laiva laiva){
        int laivaaJaljella = laiva.getKoko();
        
        boolean sopiiko = false;
        
        while (laivaaJaljella >0){
            if(onkoLaudalla(x,y) && !onkoLaivaa(x,y)){
                sopiiko =true;
                laivaaJaljella--;
                if (suunta ==0){
                    x++;
                }
                else if (suunta ==1){
                    y++;
                }
            }
            else{
                sopiiko =false;
                break;
            }
        }
        
        return sopiiko == true;
    }
    
    /**Tarkistetaan sopiiko ehdotettu laiva pelilaudalle
      * @param x        käyttäjän antama rivi, johon laivaa sijoitetaan
      * @param y        käyttäjän antama sarake
      * @param suunta   0 tai 1 (0 vaakasuoraan, 1 pystysuoraan)
      * @param laiva    sijoitettava laiva-olio
      * **/
    
    public void sijoitaLaiva(Laiva laiva, int x, int y){
        alusta[x][y].asetaLaiva(laiva);
    }
    
    /**Sijoittaan laivan pelilaudalle kohtaan (x,y), 
     * Pisteen sopivuus tarkastetaan muualla
     */
    
    
    public void Ammu(int x, int y){
        
        if (onkoLaudalla(x,y)==false || alusta[x][y].ammuttu==true){
            System.out.println("Tarksita koordinaatit!");
        }
        else{
            alusta[x][y].setAmmuttu();
            ampumaKerrat++;
            
            if (onkoLaivaa(x,y) == true){
                alusta[x][y].getLaiva().osumaLaivaan();
        }               
        }
    }
    
    
}
