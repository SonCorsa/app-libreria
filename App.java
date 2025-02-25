
public class App{
    public static void main(String args[]){
        Libreria libri= new Libreria();
        JFramePrincipale finestra = new JFramePrincipale();
        Model model = new Model(finestra,finestra.getAddPage(),finestra.getHome(),libri);
       
        Controller controller = new Controller(finestra,finestra.getAddPage(),finestra.getHome(),libri);
        controller.ActionListener();
        finestra.setVisible(true);

    }
}