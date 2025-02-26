import java.io.*;
import javax.swing.*;

public class Model {
    private JFramePrincipale finestra;
    private Aggiungi addPage;
    private Home home;
    private Libreria libreria;
    private JFileChooser fileChooser;
    private String path;


    public Model(JFramePrincipale finestra,Libreria libri){
        this.finestra=finestra;
        this.addPage=finestra.getAddPage();
        this.home=finestra.getHome();
        this.libreria=libri;
        fileChooser = new JFileChooser();
        libreria=new Libreria();
    }

    public void cambiaPagina(){
        if(finestra.isHome()){
            finestra.setHome(false);
            finestra.setAddPage(true);
            finestra.getCardLayout().show(finestra.getPannelli(), "addPage");
        }else if (finestra.isAddPage()){
            finestra.setHome(true);
            finestra.setAddPage(false);
            finestra.getCardLayout().show(finestra.getPannelli(), "home");
        }
       
    }

    public void aggiungiLibro(){
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

        //istanzio il libro
        Libri l= new Libri(autore, nome, Genere, npag);

        //salvo il path dell'immagine
        l.setPath(this.path);

        //resetto l'immmagine di copertina
        this.libreria.aggiungiLibro(l);

        //aggiungo il libro alla libreria
        addPage.setImmagineCopertina();

        //salvataggio su file
        try{
            File file = new File(String.format("File/%s.txt",nome));
            FileWriter fw= new FileWriter(file);
            file.createNewFile();
            fw.write(String.format("%s&%s&%s&%d&%s",nome,autore,Genere,npag,path));
            fw.flush();
            fw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
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
            path= file.getAbsolutePath();
            addPage.getCopertina().setIcon(new ImageIcon(x.getImage().getScaledInstance(255, 330, 5)));
        }
    }

    public void SetImmagineCopertina(){
        File fileicon = new File("app-libreria/Aggiungi.png");
        ImageIcon icon = new ImageIcon(fileicon.getAbsolutePath());
        addPage.getCopertina().setIcon(new ImageIcon(icon.getImage().getScaledInstance(285, 370, 5)));
        addPage.getCopertina().setOpaque(false);
        addPage.getCopertina().setBorderPainted(false);
        addPage.getCopertina().setContentAreaFilled(false);
    }
}
