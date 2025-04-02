import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import ComponentiRotondi.RoundedButton;

public class Home extends JPanel{

    private JButton aggiungiRead,profileButton,aggiungiReading,aggiungiToRead; 
    private ArrayList<JButton> libriButtons;
    private final JLabel home,reading,read,toRead; 
    private final JPanel p1,p2,readPanel,readingPanel,toReadPanel;
    private ImageIcon icon;
    //private final Aggiungi addPage;
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
        
        //array di JButtons
        
        //istanzio i JButton
        profileButton = new JButton();
        aggiungiRead = new RoundedButton("+",20,20);
        aggiungiReading= new RoundedButton("+",20,20);
        aggiungiToRead = new RoundedButton("+",20,20);
        libriButtons = new ArrayList<JButton>();
        
        
        
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
        
        //Instanzio l'array di bottoni per la lettura da file
                
        //IMMAGINE PROFILO
        fileicon = new File("Images/user.png");
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
        
        //addPage.add(aggiungiPanel);

        for(JButton b : libriButtons){
            toReadPanel.add(b);
        }


        
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
    }
    
    public void InstaziaLibri(){
        toReadPanel.removeAll();
        for(JButton b : libriButtons){
            toReadPanel.add(b);
        }
        toReadPanel.add(aggiungiToRead);
    }
    //get dei JButton
    public ArrayList<JButton> getLibriButtons() {
        return libriButtons;
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


    //*ToDo:
    //*Implementare l'interfaccia che permetta di leggere i dati del libro;
    
    
}
