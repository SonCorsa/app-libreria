import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class Home extends JFrame{
    //ciao roberto mi manchi mentre stai spiegando alla lavagna.
    //ricordati di NON toccare nessuno degli altri file,ho mi fotti il lavoro.
    //ho già creato la branch, lavorato sopra, fatto il merge ed eliminato la branch perciò qualsiasi cosa fai lavora SOLO su questo file.
    //i test li facciamo quando facciamo il merge
    //muah :3
    
    
    private JButton profileButton,aggiungiRead,aggiungiReading,aggiungiToRead,indietro; 
    private final JLabel home,reading,read,toRead; 
    private final JPanel p1,p2,readPanel,readingPanel,toReadPanel,aggiungiPanel;
    private ImageIcon icon;
    private final Aggiungi addPage;
    private File fileicon;
    private ArrayList<JPanel> readList,readingList,toReadList;

    public Home(String titolo){
        //istanzio il frame
        super(titolo);
        
        //istanzio i JButton
        profileButton = new JButton();
        aggiungiRead = new JButton("+");
        aggiungiReading= new JButton("+");
        aggiungiToRead = new JButton("+");
        indietro=new JButton("indietro"); 
        
        //istanzio i JLabel
        home = new JLabel("    home");
        read= new JLabel("Read");
        reading = new JLabel("Reading");
        toRead= new JLabel("To Read");
        
        
        //istanzio i JPanel
        p1 = new JPanel(new BorderLayout());
        p2=new JPanel(new GridLayout(6,0));
        aggiungiPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); //!!da mettere in Aggiungi
        readPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        readingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        toReadPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        
        //istanzio Aggiungi
        addPage=new Aggiungi("aggiungi un libro");  //!!da gestire con controller

        //IMMAGINE PROFILO
        fileicon = new File("app-libreria/user.png");
        icon = new ImageIcon(fileicon.getAbsolutePath());
        profileButton.setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 75, 5)));
                profileButton.setOpaque(false);
        profileButton.setBorderPainted(false);
        profileButton.setContentAreaFilled(false);


        //istanzio ArrayList
        readList=new ArrayList<JPanel>();
        readingList=new ArrayList<JPanel>();
        toReadList= new ArrayList<JPanel>();

        //aggiunta dei panel
        p1.add(profileButton,BorderLayout.EAST);
        p1.add(home,BorderLayout.WEST);
        
        aggiungiPanel.add(indietro);
        addPage.add(aggiungiPanel);
        
        p2.add(reading);
        readingPanel.add(aggiungiReading);
        for(JPanel l:readingList){
            readingPanel.add(l);
        }
        p2.add(readingPanel);

        p2.add(read);
        readPanel.add(aggiungiRead);
        for(JPanel l:readList){
            readPanel.add(l);
        }
        p2.add(readPanel);
        
        p2.add(toRead);
        toReadPanel.add(aggiungiToRead);
        for(JPanel l:toReadList){
            toReadPanel.add(l);
        }
        p2.add(toReadPanel);

        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);

        //operazioni finali
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //get dei JButton

    public JButton getProfileButton() {
        return profileButton;
    }

    public JButton getAggiungiRead() {
        return aggiungiRead;
    }

    public JButton getAggiungiReading() {
        return aggiungiReading;
    }

    public JButton getAggiungiToRead() {
        return aggiungiToRead;
    }

    public JButton getIndietro() {
        return indietro;
    }

    /*ToDo:
     * Creare interfaccia per l'aggiunta di un libro;
     * Implementare la possibilità di aggiungere i dati di un libro(inclusa una foto);
     * Migliorare l'interfaccia grafica principale per renderla molto più userfriendly;
     */
    
}
