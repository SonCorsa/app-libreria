import java.awt.*;
import javax.swing.*;

public class Home extends  JFrame{
    //ciao roberto mi manchi mentre stai spiegando alla lavagna.
    //ricordati di NON toccare nessuno degli altri file,ho mi fotti il lavoro.
    //ho già creato la branch, lavorato sopra, fatto il merge ed eliminato la branch perciò qualsiasi cosa fai lavora SOLO su questo file.
    //i test li facciamo quando facciamo il merge
    //muah :3

    private JButton profileButton; 
    private JLabel home,reading,read,toRead; 
    private JPanel p1,p2,p3,p4,p5;
    
    public Home(String titolo){
        super(titolo);
        setLayout(new BorderLayout());
        
        profileButton = new JButton("profilo");
        home = new JLabel("    home");
        read= new JLabel("Read");
        reading = new JLabel("Reading");
        toRead= new JLabel("To Read");
        p1 = new JPanel(new BorderLayout());
        p5=new JPanel(new GridLayout(3,0));

        p1.add(profileButton,BorderLayout.EAST);
        p1.add(home,BorderLayout.WEST);
        p5.add(reading);
        p5.add(read);
        p5.add(toRead);
        add(p1,BorderLayout.NORTH);
        add(p5,BorderLayout.WEST);
        

        setSize(600,1000);
    
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*ToDo:
     * sistemare il BoxLayout
     * mettere le altre 3 righe
     * inserire l'immagine nel JButton
     * impostare il JButton come un cerchio
     * creare il Listener
     * 
     */
    
}
