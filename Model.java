import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class Model {
    private Aggiungi addPage;
    private Home home;
    private Libreria libreria;


    public Model(Aggiungi addPage, Home home){
        this.addPage=addPage;
        this.home=home;
        libreria=new Libreria();
    }

    public void cambiaPagina(){
        if(home.isVisible()){
            home.setVisible(false);
            addPage.setVisible(true);
        }else if(addPage.isVisible()){
            addPage.setVisible(false);
            home.setVisible(true);
        }
    }

    public void aggiungiLibro(String nome,String autore,String genere,int npag){
        libreria.aggiungiLibro(nome,autore,genere,npag);
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
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(addPage.getCopertina());
        if (result == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            x = new ImageIcon(file.getAbsolutePath());
            addPage.getCopertina().setIcon(new ImageIcon(x.getImage().getScaledInstance(285, 390, 5)));
        }
    }
}
