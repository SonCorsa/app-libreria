
public class App{
    public static void main(String args[]){
        Libreria libri= new Libreria();
        JFramePrincipale finestra = new JFramePrincipale(libri);

        Model model = new Model(finestra,libri);
        Controller controller = new Controller(finestra,model.getLibreria(),model);
        try{
            controller.Setup();
            controller.setLibreria(model.getLibreria());
        }catch(Exception e ){
            e.printStackTrace();
        }
        finestra.setVisible(true);

    }
}