public class Libri {
    protected String autore;
    protected String nome;
    protected String genere;
    protected int pagine;
    protected int[] dataI;
    protected int[] dataF;
    protected String trama;
    //attributo per gli stati
    //attributo per il punteggio(recensione)
    public Libri(String autore, String nome, String genere, int pagine, int[] dataI, int[] dataF, String trama) {
        this.autore = autore;
        this.nome = nome;
        this.genere = genere;
        this.pagine = pagine;
        this.dataI = dataI;
        this.dataF = dataF;
        this.trama = trama;
    }

    
    
}
