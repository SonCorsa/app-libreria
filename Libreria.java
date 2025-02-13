import java.util.ArrayList;

public class Libreria {
    protected ArrayList<Libri> libri;

    public Libreria(){
        libri=new ArrayList<Libri>();
    }

    public boolean aggiungiLibro(String nome,String autore,String genere,int npag){
        Libri l=new Libri(nome,autore,genere,npag);
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
    

    
}
