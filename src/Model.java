import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.*;

public class Model {
    private JFramePrincipale finestra;
    private Aggiungi addPage;
    private Home home;
    private LibroGUI libroGUI;
    private Libreria libreria;
    private JFileChooser fileChooser;
    private File immagineLibro;


    public Model(JFramePrincipale finestra,Libreria libri){
        this.finestra=finestra;
        this.addPage=finestra.getAddPage();
        this.home=finestra.getHome();
        this.libroGUI = finestra.getLibroGUI();
        this.libreria=libri;
        fileChooser = new JFileChooser();
        libreria=new Libreria();
    }

    public void cambiaPagina(){ 
        if(finestra.isHome()){  //controllo dello stato della finestra
            //aggiornamento degli stati
            finestra.setHome(false);  
            finestra.setAddPage(true);
            finestra.getCardLayout().show(finestra.getPannelli(), "addPage");
        }else if (finestra.isAddPage()){ //controllo dello stato della finestra
            //aggiornamento degli stati
            finestra.setHome(true);
            finestra.setAddPage(false);
            finestra.getCardLayout().show(finestra.getPannelli(), "home");
        }
       
    }

    public void aggiungiLibro(int x) throws IOException {
        // Lettura dalle textfield
        String nome = addPage.getNome().getText();
        String autore = addPage.getAutore().getText();
        String Genere = addPage.getGenere().getText();
        int npag = Integer.parseInt(addPage.getNpag().getText());

        // Svuoto le textfield
        addPage.getNome().setText("");
        addPage.getAutore().setText("");
        addPage.getGenere().setText("");
        addPage.getNpag().setText("");

        //?DA CAMBIARE

        // Istanzio il libro e aggiungo alla libreria
        Libri l = new Libri(autore, nome, Genere, npag, immagineLibro);
        if(x == 1){
            l.setRead(true);
        }else if(x == 2){
            l.setReading(true);
        }else if(x== 3){
            l.setToRead(true);
        }
        // Resetto le checkbox
        addPage.getRead().setSelected(false);
        addPage.getReading().setSelected(false);
        addPage.getToRead().setSelected(false);
        libreria.aggiungiLibro(l);

        // Resetto l'immagine di copertina
        addPage.setImmagineCopertina();

        // Salvataggio su file in modalità append
        File file = new File("Files/Libri.txt");
        try (FileOutputStream fos = new FileOutputStream(file, false);
        ObjectOutputStream scrivi = new ObjectOutputStream(fos)) {
            scrivi.writeObject(libreria);//scrivo l'oggetto libro
            scrivi.flush(); //svuoto il buffer
            scrivi.close(); //chiudo lo stream
        }
    }

    public void apriLibro(JButton b){
        for(Libri l: libreria.getLibri()){
            try{
                if(){
                    LibroGUI li = new LibroGUI(finestra,l);
                    finestra.setLibroGUI(li);
                }
            } catch (Exception e){
                System.out.println("errore nel confronto");
            }
        }
    }
 
    public void leggiLibro()throws IOException, ClassNotFoundException{  //Lettura della libreria da file
        File file = new File("Files/Libri.txt");
        ObjectInputStream leggi = new ObjectInputStream(new FileInputStream(file));
        Libreria l =(Libreria) leggi.readObject();
        leggi.close();
        System.out.println("Libro letto: "+libreria.getLibri().size());
        libreria.getLibri().clear(); //svuoto la libreria
        libreria.getLibri().addAll(l.getLibri()); //aggiungo i libri letti alla libreria
        System.out.println("Libro letto: "+libreria.getLibri().size());
        //aggiorno i bottoni della home
        home.getLibriButtonsRead().clear(); //svuoto i bottoni letti\
        home.getLibriButtonsReading().clear(); //svuoto i bottoni letti
        home.getLibriButtonsToRead().clear(); //svuoto i bottoni letti
        int x =0;
        for(Libri l1 :libreria.getLibri()){  //per ogni libro della libreria
            if(l1.isRead()){  //se il libro è letto
                System.out.println("Libro letto: "+l1.getNome());

                //creo un bottone e lo aggiungo alla lista dei bottoni letti
                JButton b = new JButton();
                ImageIcon im = new ImageIcon((l1.getImmagine().getScaledInstance(100, 150, 5)));
                im.setDescription(String.valueOf(x));
                b.setIcon(im);
                x++;
                l1.setButton(b);
                //e lo aggiungo alla home
                home.getLibriButtonsRead().add(b);
            }else if(l1.isReading()){ //se il libro è in lettura

                JButton b = new JButton();
                ImageIcon im = new ImageIcon((l1.getImmagine().getScaledInstance(100, 150, 5)));
                im.setDescription(String.valueOf(x));
                b.setIcon(im);
                x++;
                l1.setButton(b);
                 //e lo aggiungo alla home
                home.getLibriButtonsReading().add(b);
            }else if(l1.isToRead()){ //se il libro è da leggere

                JButton b = new JButton();
                ImageIcon im = new ImageIcon((l1.getImmagine().getScaledInstance(100, 150, 5)));
                im.setDescription(String.valueOf(x));
                b.setIcon(im);
                x++;
                l1.setButton(b);
                //e lo aggiungo alla home
                home.getLibriButtonsToRead().add(b);
            }
        }
        home.InstaziaLibri(); 
    }
    

    public int getN(){
        return libreria.getLibri().size();
    }


    public void eliminaLibro(Libri l){
        libreria.eliminaLibro(l);
    }

    public void cambiaImmagineProfilo(){
        ImageIcon x = new ImageIcon();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(home.getProfileButton());
        if (result == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            x = new ImageIcon(file.getAbsolutePath());
            home.getProfileButton().setIcon(new ImageIcon(x.getImage().getScaledInstance(75, 75, 5)));
        }
    }

    public void cambiaImmagineCopertina(){
        ImageIcon x = new ImageIcon();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(addPage.getCopertina());
        if (result == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            x = new ImageIcon(file.getAbsolutePath());
            immagineLibro = new File(file.getAbsolutePath());
            addPage.getCopertina().setIcon(new ImageIcon(x.getImage().getScaledInstance(255, 330, 5)));
        }
    }
}
