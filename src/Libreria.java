import java.io.Serializable;
import java.util.ArrayList;

public class Libreria implements Serializable {

    //Lista dei libri
    protected ArrayList<Libri> libri;

    public Libreria(){
        libri=new ArrayList<Libri>();
    }

    //metodo per aggiungere un libro alla lista se non è già presente
    public boolean aggiungiLibro(Libri l){
        boolean presente=false;
        for(Libri li:libri){
            if(li.equals(libri)){
                presente=true;
            }
        }
        if(presente){
            return true;
        }else{
            libri.add(l);
            return false;
        }
    }
    
    //metodo per eliminare un libro dalla lista se è presente
    public boolean eliminaLibro(Libri l){
        boolean presente=false;
        for(Libri li:libri){
            if(li.equals(libri)){
                presente=true;
            }
        }
        if(presente){
            libri.remove(l);
            return true;
        }else{
            return false;
        }
    }

    //get della lista
    public ArrayList<Libri> getLibri() {
        return libri;
    }
    
}
