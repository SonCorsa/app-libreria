import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import ComponentiRotondi.RoundedButton;

public class Home extends JPanel{

    private JButton aggiungiRead,profileButton,aggiungiReading,aggiungiToRead; 
    private ArrayList<JButton> libriButtonsRead,libriButtonsReading,libriButtonsToRead; //ArrayList di JButton che contengono i libri letti, in lettura e da leggere
    private final JLabel home,reading,read,toRead; 
    private final JPanel p1,p2,readPanel,readingPanel,toReadPanel;
    private ImageIcon icon;
    private File fileicon;
    private ArrayList<JPanel> readList,readingList,toReadList;
    private Font PoppinsBlack;
    

    public Home(){
        setLayout(new BorderLayout());
        //FONT
        try {
            PoppinsBlack =Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Poppins-Black.ttf")).deriveFont(50f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Poppins-Black.ttf")));
        }
         catch ( IOException | FontFormatException e ) {
        }      
        
        
        //istanzio i JButton
        profileButton = new JButton();
        aggiungiRead = new RoundedButton("+",20,20);
        aggiungiReading= new RoundedButton("+",20,20);
        aggiungiToRead = new RoundedButton("+",20,20);
        
        
        
        
        //istanzio i JLabel
        home = new JLabel("Welcome");
        read= new JLabel("Read");
        reading = new JLabel("Reading");
        toRead= new JLabel("To Read");
        //cambio i font
        home.setFont(PoppinsBlack);
        read.setFont(PoppinsBlack.deriveFont(30f));
        reading.setFont(PoppinsBlack.deriveFont(30f));
        toRead.setFont(PoppinsBlack.deriveFont(30f));
        
        
        //istanzio i JPanel
        p1 = new JPanel(new BorderLayout());
        p2=new JPanel(new GridLayout(6,0));
        readPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        readingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        toReadPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        
        //Ordino gli elementi da destra a sinistra all'interno dei JPanel 
        readPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        readingPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        toReadPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        //istanzio ArrayList
        libriButtonsRead = new ArrayList<JButton>();
        libriButtonsReading = new ArrayList<JButton>();
        libriButtonsToRead = new ArrayList<JButton>();
        readList=new ArrayList<JPanel>();
        readingList=new ArrayList<JPanel>();
        toReadList= new ArrayList<JPanel>();
        
        //IMMAGINE PROFILO
        fileicon = new File("Images/user.png");
        icon = new ImageIcon(fileicon.getAbsolutePath());
        profileButton.setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 75, 5)));
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
        p2.add(reading);
        readingPanel.add(aggiungiReading);
        p2.add(readingPanel);
        
        p2.add(read);
        readPanel.add(aggiungiRead);
        p2.add(readPanel);
        
        p2.add(toRead);
        toReadPanel.add(aggiungiToRead);
        p2.add(toReadPanel);
        
        
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
    }
    
    public void InstaziaLibri(){
        readPanel.removeAll();
        for(JButton b : libriButtonsRead){
            readPanel.add(b);
        }
        readPanel.add(aggiungiRead);

        readingPanel.removeAll();
        for(JButton b : libriButtonsReading){
            readingPanel.add(b);
        }
        readingPanel.add(aggiungiReading);

        toReadPanel.removeAll();
        for(JButton b : libriButtonsToRead){
            toReadPanel.add(b);
        }
        toReadPanel.add(aggiungiToRead);
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

    public void JbuttonsRead(Libri l){

    }

    //*ToDo:
    
    
}
