import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import ComponentiRotondi.RoundedButton;

public class Home extends JPanel{

    private JButton aggiungiRead,profileButton,aggiungiReading,aggiungiToRead; 
    private JButton[] libriButtons;
    private final JLabel home,reading,read,toRead; 
    private final JPanel p1,p2,readPanel,readingPanel,toReadPanel,aggiungiPanel;
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
        
        
        
        //istanzio i JButton
        profileButton = new JButton();
        aggiungiRead = new RoundedButton("+",20,20);
        aggiungiReading= new RoundedButton("+",20,20);
        aggiungiToRead = new RoundedButton("+",20,20);



        //istanzio i JLabel
        home = new JLabel("Welcome");
        home.setFont(PoppinsBlack);
        read= new JLabel("Read");
        read.setFont(PoppinsBlack.deriveFont(30f));
        reading = new JLabel("Reading");
        reading.setFont(PoppinsBlack.deriveFont(30f));
        toRead= new JLabel("To Read");
        toRead.setFont(PoppinsBlack.deriveFont(30f));

        
        //istanzio i JPanel
        p1 = new JPanel(new BorderLayout());
        p2=new JPanel(new GridLayout(6,0));
        aggiungiPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); //!!da mettere in Aggiungi
        readPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        readingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        toReadPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        

        //addPage=new Aggiungi();  //!!da gestire con controller

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


    /*ToDo:
     * Creare interfaccia per l'aggiunta di un libro;
     * Implementare la possibilità di aggiungere i dati di un libro(inclusa una foto);
     * Migliorare l'interfaccia grafica principale per renderla molto più userfriendly;
     */
    
}
