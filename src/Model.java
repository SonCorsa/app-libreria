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
    }

    public void cambiaPagina(){ 
        System.out.println(finestra.isHome());
        System.out.println(finestra.isAddPage());
        System.out.println(finestra.isLibroGUI());
        if(finestra.isHome()){  //controllo dello stato della finestra
            //aggiornamento degli stati
            System.out.println("Cambia pagina home -> addPage");
            finestra.setHome(false);  
            finestra.setAddPage(true);
            finestra.setIsLibroGUI(false);
            finestra.getCardLayout().show(finestra.getPannelli(), "addPage");
        }else if (finestra.isAddPage()){ //controllo dello stato della finestra
            //aggiornamento degli stati
            System.out.println("Cambia pagina addPage -> home");
            finestra.setHome(true);
            finestra.setAddPage(false);
            finestra.setIsLibroGUI(false);
            finestra.getCardLayout().show(finestra.getPannelli(), "home");
        }else if(finestra.isLibroGUI()){
            System.out.println("Cambia pagina libro -> home");
            finestra.setIsLibroGUI(false);
            finestra.setHome(true);
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

     public void modificaLibro(int x) throws IOException {
        // Lettura dalle textfield
        String nome = LibroGUI.getNome().getText();
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

    public LibroGUI apriLibro(Libri l){
        LibroGUI li = new LibroGUI(finestra,l);
        finestra.setLibroGUI(li);
        finestra.getCardLayout().addLayoutComponent(li,"libro");
        finestra.getPannelli().add(li,"libroGUI");
        finestra.getCardLayout().show(finestra.getPannelli(),"libro");
        finestra.setIsLibroGUI(true);
        finestra.setHome(false);
        finestra.setAddPage(false);
        finestra.setLibroGUI(li);
        return li;
    }
 
    public void leggiLibro()throws IOException, ClassNotFoundException{  //Lettura della libreria da file
        File file = new File("Files/Libri.txt");
        ObjectInputStream leggi = new ObjectInputStream(new FileInputStream(file));
        while(true){
            try{
                libreria = (Libreria) leggi.readObject(); //leggo l'oggetto libro
            }catch(EOFException e){ //eccezione di fine file
                break;
            }
        }
        leggi.close();
        //aggiorno i bottoni della home
        home.getLibriButtonsRead().clear(); //svuoto i bottoni letti\
        home.getLibriButtonsReading().clear(); //svuoto i bottoni letti
        home.getLibriButtonsToRead().clear(); //svuoto i bottoni letti
        int x =0;
        for(Libri l1 :libreria.getLibri()){  //per ogni libro della libreria
            if(l1.isRead() && home.getLibriButtonsRead().size() < 5){  //se il libro è letto
                //creo un bottone e lo aggiungo alla lista dei bottoni letti
                JButton b = new JButton();
                ImageIcon im = new ImageIcon((l1.getImmagine().getScaledInstance(100, 150, 5)));
                b.setIcon(im);
                x++;
                l1.setButton(b);
                //e lo aggiungo alla home
                home.getLibriButtonsRead().add(b);
            }else if(l1.isReading() && home.getLibriButtonsReading().size() < 7){ //se il libro è in lettura

                JButton b = new JButton();
                ImageIcon im = new ImageIcon((l1.getImmagine().getScaledInstance(100, 150, 5)));
                b.setIcon(im);
                x++;
                l1.setButton(b);
                //e lo aggiungo alla home
                home.getLibriButtonsReading().add(b);
            }else if(l1.isToRead() && home.getLibriButtonsToRead().size() < 7){ //se il libro è da leggere

                JButton b = new JButton();
                ImageIcon im = new ImageIcon((l1.getImmagine().getScaledInstance(100, 150, 5)));
                im.setDescription(String.valueOf(x));
                b.setIcon(im);
                x++;
                l1.setButton(b);
                //e lo aggiungo alla home
                home.getLibriButtonsToRead().add(b);
            }
            try (FileOutputStream fos = new FileOutputStream(file, false);
            ObjectOutputStream scrivi = new ObjectOutputStream(fos)) {
                scrivi.writeObject(libreria);//scrivo l'oggetto libro
                scrivi.flush(); //svuoto il buffer
                scrivi.close(); //chiudo lo stream
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
    
    public Libreria getLibreria(){
        return libreria;
    }
    public void setLibreria(Libreria libreria){
        this.libreria=libreria;
    }

    public void salvaLibro(Libri l,LibroGUI li){
        System.out.println(l.getNome());
        l.setAutore(li.getAutore().getText());
        l.setNome(li.getNome().getText());
        l.setGenere(li.getGenere().getText());
        int z =Integer.parseInt(li.getNpag().getText());
        l.setPagine(z);
    }
}
