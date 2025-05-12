import java.awt.CardLayout;
import java.awt.Toolkit;
import javax.swing.*;


public class JFramePrincipale extends JFrame {
    private CardLayout cardLayout;
    private Model model;
    private JPanel pannelli;
    private boolean isHome;
    private boolean isAddPage;
    private boolean isLibroGUI;
    private Home home;
    private Aggiungi addPage;
    private LibroGUI libroGUI;
    
    public JFramePrincipale(Libreria libri){
        cardLayout = new CardLayout();
        pannelli = new JPanel(cardLayout);

        
        //Instazio i pannelli Home & Aggiungi
    
        home = new Home();
        addPage = new Aggiungi(this);
        //Instazio i valori booleani
        isHome = true;
        isAddPage = false;
        
        //Aggiungo i Pannelli al CardLayout
        pannelli.add(home, "home");
        pannelli.add(addPage, "addPage");
        //pannelli.add(libroGUI, "libroGUI");
        cardLayout.show(pannelli,"home");
        add(pannelli);
        
        //Operazioni finali
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
    public Home getHome() {
        return home;
    }

    public Aggiungi getAddPage() {
        return addPage;
    }
    
    public LibroGUI getLibroGUI(){
        return libroGUI;
    }
    public boolean isHome() {
        return isHome;
    }

    public void setHome(boolean isHome) {
        this.isHome = isHome;
    }

    public boolean isAddPage() {
        return isAddPage;
    }

    public void setAddPage(boolean isAddPage) {
        this.isAddPage = isAddPage;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }
    public void setShow(String panel){
        cardLayout.show(pannelli, panel);
    }
    public JPanel getPannelli() {
        return pannelli;
    }

    public void setLibroGUI(LibroGUI libro){
        this.libroGUI = libro;
    }
    
    public void setIsLibroGUI(boolean isLibroGUI) {
        this.isLibroGUI = isLibroGUI;
    }
    public boolean isLibroGUI() {
        return isLibroGUI;
    }
}
