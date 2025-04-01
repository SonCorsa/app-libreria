
public class App{
    public static void main(String args[]){
        Libreria libri= new Libreria();
        JFramePrincipale finestra = new JFramePrincipale(libri);
        Model model = new Model(finestra,libri);
        try{
            Controller controller = new Controller(finestra,libri);
        }catch(Exception e ){
            e.printStackTrace();
        }
        finestra.setVisible(true);

    }
}