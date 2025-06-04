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
    private final static int scorrimento = 7; // numero di libri da visualizzare per volta
    private int indReading, indToRead, indRead; // Indici per lo scorrimento delle liste



    public Model(JFramePrincipale finestra,Libreria libri){
        this.finestra=finestra;
        this.addPage=finestra.getAddPage();
        this.home=finestra.getHome();
        this.libroGUI = finestra.getLibroGUI();
        this.libreria=libri;
        fileChooser = new JFileChooser();
        indReading = 1; //inizializzo y a 1
        indToRead = 1; //inizializzo y a 1
        indRead = 1; //inizializzo y a 1
    }

    public void cambiaPagina(){ 
        if(finestra.isHome()){  //controllo dello stato della finestra
            //aggiornamento degli stati
            finestra.setHome(false);  
            finestra.setAddPage(true);
            finestra.setIsLibroGUI(false);
            finestra.getCardLayout().show(finestra.getPannelli(), "addPage");
        }else if (finestra.isAddPage()){ //controllo dello stato della finestra
            //aggiornamento degli stati
            finestra.setHome(true);
            finestra.setAddPage(false);
            finestra.setIsLibroGUI(false);
            finestra.getCardLayout().show(finestra.getPannelli(), "home");
        }else if(finestra.isLibroGUI()){
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
        String trama = addPage.getTrama().getText();
        int npag = Integer.parseInt(addPage.getNpag().getText());

        // Svuoto le textfield
        addPage.getNome().setText("");
        addPage.getAutore().setText("");
        addPage.getGenere().setText("");
        addPage.getNpag().setText("");
        addPage.getTrama().setText(""); 

        // Istanzio il libro e aggiungo alla libreria
        Libri l = new Libri(autore, nome, Genere, npag, immagineLibro);
        l.setTrama(trama);
        if(x == 1){
            l.setRead(true);
        }else if(x == 2){
            l.setReading(true);
        }else if(x== 3){
            l.setToRead(true);
        }
        // Aggiungo il libro alla libreria
        libreria.aggiungiLibro(l);


        // Resetto l'immagine di copertina
        addPage.setImmagineCopertina();

        // Salvataggio su file sovrascrivendo il file esistente
        File file = new File("Files/Libri.txt");
        try (FileOutputStream fos = new FileOutputStream(file, false);
        ObjectOutputStream scrivi = new ObjectOutputStream(fos)) {
            scrivi.writeObject(libreria);//scrivo l'oggetto libro
            scrivi.flush(); //svuoto il buffer
            scrivi.close(); //chiudo lo stream
        }catch(Exception e){
            e.printStackTrace();
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
        if(file.exists() && file.length()>0){
            ObjectInputStream leggi = new ObjectInputStream(new FileInputStream(file));
            try{
                libreria = (Libreria) leggi.readObject(); //leggo l'oggetto libro
                
                leggi.close();
            }catch(EOFException e){ //eccezione di fine file
                System.out.println("File vuoto, nessun libro da leggere.");
            }
        }
        
        //aggiorno i bottoni della home
        home.getLibriButtonsRead().clear(); //svuoto i bottoni letti\
        home.getLibriButtonsReading().clear(); //svuoto i bottoni letti
        home.getLibriButtonsToRead().clear(); //svuoto i bottoni letti
        for(Libri l1 :libreria.getLibri()){  //per ogni libro della libreria
            if(l1.isRead() && home.getLibriButtonsRead().size() < 7 ){  //se il libro è letto
                //creo un bottone e lo aggiungo alla lista dei bottoni letti
                JButton b = new JButton();
                ImageIcon im = new ImageIcon((l1.getImmagine().getScaledInstance(70, 90, 5)));
                b.setIcon(im);
                l1.setButton(b);
                //e lo aggiungo alla home
                home.getLibriButtonsRead().add(b);
            }else if(l1.isReading() && home.getLibriButtonsReading().size() < 7){ //se il libro è in lettura
                JButton b = new JButton();
                ImageIcon im = new ImageIcon((l1.getImmagine().getScaledInstance(70, 90, 5)));
                b.setIcon(im);
                l1.setButton(b);
                //e lo aggiungo alla home
                home.getLibriButtonsReading().add(b);
            }else if(l1.isToRead() && home.getLibriButtonsToRead().size() < 7){ //se il libro è da leggere

                JButton b = new JButton();
                ImageIcon im = new ImageIcon((l1.getImmagine().getScaledInstance(70, 90, 5)));
                b.setIcon(im);
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
    

    public void eliminaLibro(Libri l){
        if(l.isRead()){
            home.getLibriButtonsRead().remove(l.getButton());
        }else if(l.isReading()){
            home.getLibriButtonsReading().remove(l.getButton());
        }else if(l.isToRead()){
            home.getLibriButtonsToRead().remove(l.getButton());
        }
        libreria.eliminaLibro(l);
        File file = new File("Files/Libri.txt");
        try (FileOutputStream fos = new FileOutputStream(file, false);
        ObjectOutputStream scrivi = new ObjectOutputStream(fos)) {
            scrivi.writeObject(libreria);//Riscrivo l'oggetto libreria
            scrivi.flush(); //svuoto il buffer
            scrivi.close(); 
        }catch(Exception e){
            e.printStackTrace();
        }
        home.InstaziaLibri();
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
    
    public void salvaLibro(Libri l,LibroGUI li) throws IOException{
        l.setAutore(li.getAutore().getText());
        l.setNome(li.getNome().getText());
        l.setGenere(li.getGenere().getText());
        l.setTrama(li.getTrama().getText());
        int z =Integer.parseInt(li.getNpag().getText());
        l.setPagine(z);
        File file = new File("Files/Libri.txt");
        try (FileOutputStream fos = new FileOutputStream(file, false);
        ObjectOutputStream scrivi = new ObjectOutputStream(fos)) {
            scrivi.writeObject(libreria);//scrivo l'oggetto libro
            scrivi.flush(); //svuoto il buffer
            scrivi.close(); //chiudo lo stream
        }
    }

    public Libreria getLibreria(){
        return libreria;
    }
    public void setLibreria(Libreria libreria){
        this.libreria=libreria;
    }


    public void scorrimentoReading(){
        home.getLibriButtonsReading().clear();
        int x = 0;
        for(Libri l : libreria.getLibri()){
            if(x< scorrimento*indReading){
                x++;
            }else if(l.isReading() && home.getLibriButtonsReading().size() < scorrimento){
                try{
                    JButton b = new JButton();
                    ImageIcon im = new ImageIcon((l.getImmagine().getScaledInstance(70, 90, 5)));
                    b.setIcon(im);
                    l.setButton(b);
                    home.getLibriButtonsReading().add(b);
                    home.InstaziaLibri();
                    home.aggiungiScorrimentoInvReading();
                }catch(Exception e){
                    e.printStackTrace(); 
                }
            }
        }
        if(home.getLibriButtonsReading().size() < scorrimento*indReading){
            home.getScorriButtonReading().setEnabled(false);
        }
        indReading++;
    }

    public void scorrimentoInvReading(){
        home.getLibriButtonsReading().clear();
        int x = scorrimento * (indReading-1);
        for(Libri l : libreria.getLibri()){  
            if(l.isReading() && x < scorrimento*indReading){
                try{
                    JButton b = new JButton();
                    ImageIcon im = new ImageIcon((l.getImmagine().getScaledInstance(70, 90, 5)));
                    b.setIcon(im);
                    l.setButton(b);
                    home.getLibriButtonsReading().add(b);
                    home.InstaziaLibri();
                    x++;
                }catch(Exception e){
                    e.printStackTrace(); 
                }
            }
        }
        if(x >= 7) {
            home.rimuoviScorrimentoInvReading();
            home.getScorriButtonReading().setEnabled(true);
        }
        indReading--;
    }

    public void scorrimentoToRead(){
        home.getLibriButtonsToRead().clear();
        int x = 0;
        for(Libri l : libreria.getLibri()){
            if(x< scorrimento*indToRead){
                x++;
            }else if(l.isToRead() && home.getLibriButtonsToRead().size() < scorrimento){
                try{
                    JButton b = new JButton();
                    ImageIcon im = new ImageIcon((l.getImmagine().getScaledInstance(70, 90, 5)));
                    b.setIcon(im);
                    l.setButton(b);
                    home.getLibriButtonsToRead().add(b);
                    home.InstaziaLibri();
                    home.aggiungiScorrimentoInvToRead();
                }catch(Exception e){
                    e.printStackTrace(); 
                }
            }
        }
        if(home.getLibriButtonsToRead().size() < scorrimento*indToRead){
            home.getScorriButtonToRead().setEnabled(false);
        }
        indToRead++;
    }

    public void scorrimentoInvToRead(){
        home.getLibriButtonsToRead().clear();
        int x = scorrimento * (indToRead-1);
        for(Libri l : libreria.getLibri()){  
            if(l.isToRead() && x < scorrimento*indToRead){
                try{
                    JButton b = new JButton();
                    ImageIcon im = new ImageIcon((l.getImmagine().getScaledInstance(70, 90, 5)));
                    b.setIcon(im);
                    l.setButton(b);
                    home.getLibriButtonsToRead().add(b);
                    home.InstaziaLibri();
                    x++;
                }catch(Exception e){
                    e.printStackTrace(); 
                }
            }
        }
        if(x >= 7) {
            home.rimuoviScorrimentoInvToRead();
            home.getScorriButtonToRead().setEnabled(true);
        }
        indToRead--;
    }

    public void scorrimentoRead(){
        home.getLibriButtonsRead().clear();
        int x = 0;
        for(Libri l : libreria.getLibri()){
            if(x< scorrimento*indRead){
                x++;
            }else if(l.isRead() && home.getLibriButtonsRead().size() < scorrimento){
                try{
                    JButton b = new JButton();
                    ImageIcon im = new ImageIcon((l.getImmagine().getScaledInstance(70, 90, 5)));
                    b.setIcon(im);
                    l.setButton(b);
                    home.getLibriButtonsRead().add(b);
                    home.InstaziaLibri();
                    home.aggiungiScorrimentoInvRead();
                }catch(Exception e){
                    e.printStackTrace(); 
                }
            }
        }
        if(home.getLibriButtonsRead().size() < scorrimento*indRead){
            home.getScorriButtonRead().setEnabled(false);
        }
        indRead++;
    }

    public void scorrimentoInvRead(){
        home.getLibriButtonsRead().clear();
        int x = scorrimento * (indRead-1);
        for(Libri l : libreria.getLibri()){  
            if(l.isRead() && x < scorrimento*indRead){
                try{
                    JButton b = new JButton();
                    ImageIcon im = new ImageIcon((l.getImmagine().getScaledInstance(70, 90, 5)));
                    b.setIcon(im);
                    l.setButton(b);
                    home.getLibriButtonsRead().add(b);
                    home.InstaziaLibri();
                    x++;
                }catch(Exception e){
                    e.printStackTrace(); 
                }
            }
        }
        if(x >= 7) {
            home.rimuoviScorrimentoInvRead();
            home.getScorriButtonRead().setEnabled(true);
        }
        indRead--;
    }
}   
