public class Model {
    private Aggiungi addPage;
    private Home home;
    private Libreria libreria;


    public Model(Aggiungi addPage, Home home){
        this.addPage=addPage;
        this.home=home;
    }

    public void cambiaPagina(){
        if(home.isVisible()){
            home.setVisible(false);
            addPage.setVisible(true);
        }else{
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
    
    
}
