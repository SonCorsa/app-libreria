import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import ComponentiRotondi.RoundedButton;

public class Home extends JPanel{

    //attributi
    private JButton aggiungiRead,profileButton,aggiungiReading,aggiungiToRead; 
    private ArrayList<JButton> libriButtonsRead,libriButtonsReading,libriButtonsToRead; 
    private final JLabel home,reading,read,toRead; 
    private final JPanel p1,p2,readPanel,readingPanel,toReadPanel;
    private ImageIcon icon;
    private File fileicon;
    private ArrayList<JPanel> readList,readingList,toReadList;
    private Font PoppinsBlack;
    
    
    public Home(){

        setLayout(new BorderLayout());


        //creazione del font personalizzato
        try {
            PoppinsBlack =Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Poppins-Black.ttf")).deriveFont(50f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Poppins-Black.ttf")));
        }
        catch ( IOException | FontFormatException e ) {
        }      
        
        
        //istanzia dei JButton
        profileButton = new JButton();
        aggiungiRead = new RoundedButton("+",20,20);
        aggiungiReading= new RoundedButton("+",20,20);
        aggiungiToRead = new RoundedButton("+",20,20);
        
        //istanza dei JLabel
        home = new JLabel("Welcome");
        read= new JLabel("Read");
        reading = new JLabel("Reading");
        toRead= new JLabel("To Read");

        //cambio del font
        home.setFont(PoppinsBlack);
        read.setFont(PoppinsBlack.deriveFont(30f));
        reading.setFont(PoppinsBlack.deriveFont(30f));
        toRead.setFont(PoppinsBlack.deriveFont(30f));
        
        
        //istanza dei JPanel
        p1 = new JPanel(new BorderLayout());
        p2=new JPanel(new GridLayout(6,0));
        readPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        readingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        toReadPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        
        //Ordinamento degli elementi da destra a sinistra all'interno dei JPanel 
        readPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        readingPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        toReadPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        //istanza degli ArrayList
        libriButtonsRead = new ArrayList<JButton>();
        libriButtonsReading = new ArrayList<JButton>();
        libriButtonsToRead = new ArrayList<JButton>();
        readList=new ArrayList<JPanel>();
        readingList=new ArrayList<JPanel>();
        toReadList= new ArrayList<JPanel>();
        
        //settaggio immagine profilo di default
        fileicon = new File("Images/user.png");             //creazione oggetto di tipo file che prende un'immagine .png
        icon = new ImageIcon(fileicon.getAbsolutePath());         //creazione oggetto ImageIcon 
        profileButton.setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 75, 5)));    //settaggio parametri di dimensione dell'icon
        profileButton.setOpaque(false);
        profileButton.setBorderPainted(false);
        profileButton.setContentAreaFilled(false);
        
        //aggiunta dei panel
        p1.add(profileButton,BorderLayout.EAST);
        p1.add(home,BorderLayout.WEST);
        
        //aggiunta dei button degli ArrayList ai JPanel
        for(JButton b : libriButtonsRead){
            readPanel.add(b);
        }

        for(JButton b : libriButtonsReading){
            readingPanel.add(b);
        }

        for(JButton b : libriButtonsToRead){
            toReadPanel.add(b);
        }
        
        //aggiunta dei JPanel ai JPanel principali
        readingPanel.add(aggiungiReading);
        p2.add(reading);
        p2.add(readingPanel);
        
        readPanel.add(aggiungiRead);
        p2.add(read);
        p2.add(readPanel);
        
        toReadPanel.add(aggiungiToRead);
        p2.add(toRead);
        p2.add(toReadPanel);
        
        
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
    }
    
    public void InstaziaLibri(){

        readPanel.removeAll();              //svuota il pannello dei bottoni read
        for(JButton b : libriButtonsRead){
            readPanel.add(b);               //aggiunta dei singoli JButton al pannello read
        }
        readPanel.add(aggiungiRead);        //aggiunta del pulsante "+" per la creazione di un nuovo libro
        

        readingPanel.removeAll();           //svuota pannello reading
        for(JButton b : libriButtonsReading){
            readingPanel.add(b);            //aggiunta dei singoli JButton al pannello reading
        }
        readingPanel.add(aggiungiReading);  //aggiunta del pulsante "+" per la creazione di un nuovo libro
        

        toReadPanel.removeAll();            //svuota il pannello toRead
        for(JButton b : libriButtonsToRead){
            toReadPanel.add(b);             //aggiunta dei singoli JButton al pannello toRead
        }
        toReadPanel.add(aggiungiToRead);    //aggiunta del pulsante "+" per la creazione di un nuovo libro
    }


    //get dei JButton
    public ArrayList<JButton> getLibriButtonsRead() {
        return libriButtonsRead;
    }
    
    public ArrayList<JButton> getLibriButtonsReading() {
        return libriButtonsReading;
    }
    
    public ArrayList<JButton> getLibriButtonsToRead() {
        return libriButtonsToRead;
    }
    
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


    //get dei JPanel
    public JPanel getP1() {
        return p1;
    }

    public JPanel getP2() {
        return p2;
    }

    public JPanel getReadPanel() {
        return readPanel;
    }

    public JPanel getReadingPanel() {
        return readingPanel;
    }

    public JPanel getToReadPanel() {
        return toReadPanel;
    }
    
}
