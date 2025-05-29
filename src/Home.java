import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import ComponentiRotondi.RoundedButton;

public class Home extends JPanel{

    //attributi
    private JButton aggiungiRead,profileButton,aggiungiReading,aggiungiToRead;
    private JButton scorriButtonRead , scorriButtonReading, scorriButtonToRead; //questi pulsanti servono per scorrere i libri nella home
    private JButton scorriInvRead, scorriInvReading , scorriInvToRead;  
    private ArrayList<JButton> libriButtonsRead,libriButtonsReading,libriButtonsToRead; 
    private final JLabel home,reading,read,toRead; 
    private final JPanel p1,p2,readPanel,readingPanel,toReadPanel;
    private ImageIcon icon;
    private File fileicon;
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

        scorriButtonToRead = new RoundedButton(">", 20, 20);
        scorriButtonReading = new RoundedButton(">", 20, 20);
        scorriButtonRead = new RoundedButton(">", 20, 20);

        scorriInvToRead = new RoundedButton("<", 20, 20);
        scorriInvReading = new RoundedButton("<", 20, 20);
        scorriInvRead = new RoundedButton("<", 20, 20);

        
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

        readPanel.removeAll();
        readPanel.add(scorriButtonRead);
        scorriButtonRead.setVisible(false);
        if(libriButtonsRead.size() > 6){
            scorriButtonRead.setVisible(true);
        }
        for(JButton b : libriButtonsRead){
            readPanel.add(b);               
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
        }
        readPanel.add(aggiungiRead);        

        readingPanel.removeAll();  
        readingPanel.add(scorriButtonReading);
        scorriButtonReading.setVisible(false);
        if(libriButtonsReading.size() > 6){
            scorriButtonReading.setVisible(true);
        }   
        for(JButton b : libriButtonsReading){
            readingPanel.add(b);            
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
        }
        readingPanel.add(aggiungiReading);  
        

        toReadPanel.removeAll();
        toReadPanel.add(scorriButtonToRead);
        scorriButtonToRead.setVisible(false);
        if(libriButtonsToRead.size() > 6){
            scorriButtonToRead.setVisible(true);
        }
        for(JButton b : libriButtonsToRead){
            toReadPanel.add(b);             
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
        }
        toReadPanel.add(aggiungiToRead);    
    }

    
    public void aggiungiScorrimentoInvReading(){
        readingPanel.remove(aggiungiReading);
        System.out.println("Aggiungo il pulsante di scorrimento inverso per la sezione Reading");
        readingPanel.add(scorriInvReading);
    }

    public void aggiungiScorrimentoInvRead(){
        readPanel.remove(aggiungiRead);
        System.out.println("Aggiungo il pulsante di scorrimento inverso per la sezione Read");
        readPanel.add(scorriInvRead);
    }

    public void aggiungiScorrimentoInvToRead(){
        toReadPanel.remove(aggiungiToRead);
        System.out.println("Aggiungo il pulsante di scorrimento inverso per la sezione To Read");
        toReadPanel.add(scorriInvToRead);
    }

    public void rimuoviScorrimentoInvReading(){
        readingPanel.remove(scorriInvReading);
        System.out.println("Rimuovo il pulsante di scorrimento inverso per la sezione Reading");
        readingPanel.add(aggiungiReading);
    }

    public void rimuoviScorrimentoInvRead(){
        readPanel.remove(scorriInvRead);
        System.out.println("Rimuovo il pulsante di scorrimento inverso per la sezione Read");
        readPanel.add(aggiungiRead);
    }

    public void rimuoviScorrimentoInvToRead(){
        toReadPanel.remove(scorriInvToRead);
        System.out.println("Rimuovo il pulsante di scorrimento inverso per la sezione To Read");
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

        public JButton getScorriButtonRead() {
        return scorriButtonRead;
    }

    public JButton getScorriButtonReading() {
        return scorriButtonReading;
    }

    public JButton getScorriButtonToRead() {
        return scorriButtonToRead;
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

    public JButton getScorriInvReading() {
        return scorriInvReading;
    }

    public JButton getScorriInvRead() {
        return scorriInvRead;
    }
    public JButton getScorriInvToRead() {
        return scorriInvToRead;
    }
}
