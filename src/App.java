
public class App{
    public static void main(String args[]){
        Libreria libri= new Libreria();
        JFramePrincipale finestra = new JFramePrincipale(libri);

        Model model = new Model(finestra,libri);
        Controller controller = new Controller(finestra,libri);
        System.out.println("diopo "+model.getLibreria().getLibri().size());
        //controller.setLibreria(model.getLibreria());
        try{
            controller.Setup();
        }catch(Exception e ){
            e.printStackTrace();
        }
        finestra.setVisible(true);

    }
}