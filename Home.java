import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class Home extends  JFrame implements ActionListener{
    //ciao roberto mi manchi mentre stai spiegando alla lavagna.
    //ricordati di NON toccare nessuno degli altri file,ho mi fotti il lavoro.
    //ho già creato la branch, lavorato sopra, fatto il merge ed eliminato la branch perciò qualsiasi cosa fai lavora SOLO su questo file.
    //i test li facciamo quando facciamo il merge
    //muah :3

    private JButton profileButton,aggiungiRead,indietro; 
    private JLabel home,reading,read,toRead; 
    private JPanel p1,p2,readPanel,readingPanel,toReadPanel,aggiungiPanel;
    private ArrayList<JPanel> readList,readingList,toReadList;
    private ImageIcon icon;
    private Aggiungi addPage;
    
    public Home(String titolo){
        super(titolo);
        setLayout(new BorderLayout());
        
        //istanzio JButton
        profileButton = new JButton();
        aggiungiRead = new JButton("+");
        indietro=new JButton("indietro");

        //istanzio JLabel
        home = new JLabel("    home");
        read= new JLabel("Read");
        reading = new JLabel("Reading");
        toRead= new JLabel("To Read");
        p1 = new JPanel(new BorderLayout());
        p2=new JPanel(new GridLayout(6,0));

        //istanzio JPanel
        aggiungiPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        readPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        readingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        toReadPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        
        //istanzio ArrayList
        readList=new ArrayList<JPanel>();
        readingList=new ArrayList<JPanel>();
        toReadList= new ArrayList<JPanel>();

        //istanzio Aggiungi
        addPage=new Aggiungi("aggiungi un libro");

        //aggiunta dei Listener
        aggiungiRead.addActionListener(this);
        indietro.addActionListener(this);

        //aggiunta ai pannelli
        p1.add(profileButton,BorderLayout.EAST);
        p1.add(home,BorderLayout.WEST);
        p2.add(reading);
        aggiungiPanel.add(indietro);
        addPage.add(aggiungiPanel);
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
        for(JPanel l:toReadList){
            toReadPanel.add(l);
        }
        p2.add(toReadPanel);

        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        
       //Listener per l'aggiunta delle immagini
        profileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                icon = new ImageIcon(file.getAbsolutePath());
                profileButton.setIcon(new ImageIcon(icon.getImage().getScaledInstance(50, 70, 5)));
                profileButton.setOpaque(false);
                profileButton.setBorderPainted(false);
                profileButton.setContentAreaFilled(false);
            }
        });
        profileButton.setIcon(icon);

        //operazioni finali
        setSize(600,1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==aggiungiRead){
            addPage.setVisible(true);
            this.setVisible(false);
        }else if(e.getSource()== indietro){
            this.setVisible(true);
            addPage.setVisible(false);
        }
    }

    /*ToDo:
     * creare il pulsante per visualizzare la lista
     * creare i pulsanti per aggiungere i libri alla lista 
     * creatre file txt per salvare il path dell'immagine profilo  
     * impostare il JButton come un cerchio
     * creare il Listener
     * 
     */
    
}
