package laivanupotus.laivanupotus;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Laivanupotus laivapeli = new Laivanupotus();
        Käyttöliittymä liittyma = new Käyttöliittymä(laivapeli);
        
        liittyma.run();
        
        
    }
}
