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

    
    public Libri(String autore, String nome, String genere, int pagine) {
        this.autore = autore;
        this.nome = nome;
        this.genere = genere;
        this.pagine = pagine;
        dataI = new int[3];
        dataF = new int[3];
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
    public String toString(){
        return String.format("%s %s %s %d",autore,nome, genere,pagine);
    }

    public boolean equals(Libri l){
        if(this.toString().equals(l.toString()) && dataI == l.getDataI() && dataF == l.getDataF()){
            return true;
        }else{
            return false;
        }
    }
    
    
}
