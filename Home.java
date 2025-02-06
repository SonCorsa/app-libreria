import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class Home extends  JFrame{
    //ciao roberto mi manchi mentre stai spiegando alla lavagna.
    //ricordati di NON toccare nessuno degli altri file,ho mi fotti il lavoro.
    //ho già creato la branch, lavorato sopra, fatto il merge ed eliminato la branch perciò qualsiasi cosa fai lavora SOLO su questo file.
    //i test li facciamo quando facciamo il merge
    //muah :3

    private JButton profileButton; 
    private JLabel home,reading,read,toRead; 
    private JPanel p1,p2;
    private ArrayList<JPanel> readList,readingList,toReadList;
    private ImageIcon icon;
    
    public Home(String titolo){
        super(titolo);
        setLayout(new BorderLayout());
        
        profileButton = new JButton();
        home = new JLabel("    home");
        read= new JLabel("Read");
        reading = new JLabel("Reading");
        toRead= new JLabel("To Read");
        p1 = new JPanel(new BorderLayout());
        p2=new JPanel(new GridLayout(6,0));
        readList=new ArrayList<JPanel>();
        readingList=new ArrayList<JPanel>();
        toReadList= new ArrayList<JPanel>();
        

        p1.add(profileButton,BorderLayout.EAST);
        p1.add(home,BorderLayout.WEST);
        p2.add(reading);
        p2.add(read);
        p2.add(toRead);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        
       
        profileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                icon = new ImageIcon(file.getAbsolutePath());
                profileButton.setIcon(new ImageIcon(icon.getImage().getScaledInstance(50, 70, 5)));
            }
        });

        profileButton.setIcon(icon);

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
