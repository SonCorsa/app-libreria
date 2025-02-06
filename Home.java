import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;

public class Home extends JFrame{
    //ciao roberto mi manchi mentre stai spiegando alla lavagna.
    //ricordati di NON toccare nessuno degli altri file,ho mi fotti il lavoro.
    //ho già creato la branch, lavorato sopra, fatto il merge ed eliminato la branch perciò qualsiasi cosa fai lavora SOLO su questo file.
    //i test li facciamo quando facciamo il merge
    //muah :3
    
    private JButton profileButton; 
    private JTextPane tp; 
    private JPanel panel;
    
    public Home(String titolo){
        super(titolo);
        setLayout(new BorderLayout());
        
        profileButton = new JButton("pulsante del profilo");
        tp=new JTextPane();
        panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        panel.add(profileButton);
        add(panel,BorderLayout.NORTH);

        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
