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

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getPagine() {
        return pagine;
    }

    public void setPagine(int pagine) {
        this.pagine = pagine;
    }

    public int[] getDataI() {
        return dataI;
    }

    public void setDataI(int[] dataI) {
        this.dataI = dataI;
    }

    public int[] getDataF() {
        return dataF;
    }

    public void setDataF(int[] dataF) {
        this.dataF = dataF;
    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    
    
}
