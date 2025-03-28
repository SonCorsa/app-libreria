import java.util.ArrayList;

public class Libreria {
    protected ArrayList<Libri> libri;

    public Libreria(){
        libri=new ArrayList<Libri>();
    }

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

    public ArrayList<Libri> getLibri() {
        return libri;
    }
    
}
