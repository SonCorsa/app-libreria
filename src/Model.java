import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.*;

public class Model {
    private JFramePrincipale finestra;
    private Aggiungi addPage;
    private Home home;
    private LibroGUI libroGUI;
    private Libreria libreria,libreriaRead,libreriaReading,libreriaToRead;
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
        libreriaRead = new Libreria();
        libreriaReading = new Libreria();
        libreriaToRead = new Libreria();
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

    public void aggiungiLibro() throws IOException {
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

        // Istanzio il libro e aggiungo alla libreria
        Libri l = new Libri(autore, nome, Genere, npag, immagineLibro);
        if(addPage.getSelectedCheckbox()== 1){
            l.setRead(true);
            libreriaRead.aggiungiLibro(l);
        }else if(addPage.getSelectedCheckbox()== 2){
            l.setReading(true);
            libreriaReading.aggiungiLibro(l);
        }else if(addPage.getSelectedCheckbox()== 3){
            l.setToRead(true);
            libreriaToRead.aggiungiLibro(l);
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
        try (FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream scrivi = new ObjectOutputStream(fos)) {
                scrivi.writeObject(libreria);//scrivo l'oggetto libro
                scrivi.flush(); //svuoto il buffer
                scrivi.close(); //chiudo lo stream
        }
    }

 
    public void leggiLibro()throws IOException, ClassNotFoundException{
        File file = new File("Files/Libri.txt");
        ObjectInputStream leggi = new ObjectInputStream(new FileInputStream(file));
        Libreria l =(Libreria) leggi.readObject();
        libreria = l;
        leggi.close();
        //aggiorno i bottoni della home
        for(Libri l1 :libreria.getLibri()){
            //home.getLibriButtons()[i].setIcon(new ImageIcon());;
            if(l1.isRead()){
                JButton b = new JButton();
                b.setIcon(new ImageIcon(l1.getImmagine().getScaledInstance(100, 150, 5)));
                home.getLibriButtonsRead().add(b);
            }else if(l1.isReading()){
                JButton b = new JButton();
                b.setIcon(new ImageIcon(l1.getImmagine().getScaledInstance(100, 150, 5)));
                home.getLibriButtonsReading().add(b);
            }else if(l1.isToRead()){
                JButton b = new JButton();
                b.setIcon(new ImageIcon(l1.getImmagine().getScaledInstance(100, 150, 5)));
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

    public void SetImmagineCopertina(){
        addPage.setImmagineCopertina();
    }
}
