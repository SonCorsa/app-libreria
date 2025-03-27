import java.io.*;
import javax.swing.*;

public class Model {
    private JFramePrincipale finestra;
    private Aggiungi addPage;
    private Home home;
    private Libreria libreria;
    private JFileChooser fileChooser;
    private File immagineLibro;


    public Model(JFramePrincipale finestra,Libreria libri){
        this.finestra=finestra;
        this.addPage=finestra.getAddPage();
        this.home=finestra.getHome();
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

    public void aggiungiLibro() throws IOException{
        //lettura dalle textfield
        String nome= addPage.getNome().getText();
        String autore= addPage.getAutore().getText();
        String Genere=addPage.getGenere().getText();
        int npag = Integer.parseInt(addPage.getNpag().getText());

        //svuoto le textfield
        addPage.getNome().setText(" ");
        addPage.getAutore().setText(" ");
        addPage.getGenere().setText(" ");
        addPage.getNpag().setText(" ");

        //istanzio il libro e aggiungo alla libreria
        Libri l= new Libri(autore, nome, Genere, npag,immagineLibro);
        this.libreria.aggiungiLibro(l);
        
        //resetto l'immmagine di copertina
        addPage.setImmagineCopertina();
        
        //salvataggio su file
        File file = new File("Files/Libri.txt");
        ObjectOutputStream scrivi = new ObjectOutputStream(new FileOutputStream(file));
        scrivi.writeObject(l);
        scrivi.flush();
        scrivi.close();
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
