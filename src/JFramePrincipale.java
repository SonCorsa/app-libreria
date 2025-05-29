import java.awt.CardLayout;
import javax.swing.*;


public class JFramePrincipale extends JFrame {
    //attributi
    private CardLayout cardLayout;
    private JPanel pannelli;
    private boolean isHome;
    private boolean isAddPage;
    private boolean isLibroGUI;
    private Home home;
    private Aggiungi addPage;
    private LibroGUI libroGUI;
    
    public JFramePrincipale(Libreria libri){

        //settaggio del layout
        cardLayout = new CardLayout();
        pannelli = new JPanel(cardLayout);

        
        //Instaza dei pannelli Home & Aggiungi
        home = new Home();
        addPage = new Aggiungi(this);
        libroGUI= new LibroGUI(this, null);
        //Instazio i valori booleani
        isHome = true;
        isAddPage = false;
        
        //Aggiunta dei pannelli al CardLayout
        pannelli.add(home, "home");
        pannelli.add(addPage, "addPage");
        pannelli.add(libroGUI,"libroGUI");
        cardLayout.show(pannelli,"home");
        add(pannelli);
        
        //Operazioni finali
        setSize(1080,607);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //get dei pannelli
    public Home getHome() {
        return home;
    }

    public Aggiungi getAddPage() {
        return addPage;
    }
    
    public LibroGUI getLibroGUI(){
        return libroGUI;
    }

    //cotrollo dello stato dei pannelli
    public boolean isHome() {
        return isHome;
    }

    public void setHome(boolean isHome) {
        this.isHome = isHome;
    }

    public boolean isAddPage() {
        return isAddPage;
    }

    public boolean isLibroGUI() {
        return isLibroGUI;
    }

    //settaggio dello stato dei pannelli
    public void setAddPage(boolean isAddPage) {
        this.isAddPage = isAddPage;
    }

    public void setIsLibroGUI(boolean isLibroGUI) {
        this.isLibroGUI = isLibroGUI;
    }

    //getter del CardLayout
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    //settaggio della View 
    public void setShow(String panel){
        cardLayout.show(pannelli, panel);
    }

    //get del JPanel
    public JPanel getPannelli() {
        return pannelli;
    }

    //settaggio del LibroGUI
    public void setLibroGUI(LibroGUI libro){
        this.libroGUI = libro;
    }
    
}
