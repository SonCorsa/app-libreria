import java.awt.image.BufferedImage;
import java.io.*;
import java.io.Serializable;
import java.nio.file.Files;
import javax.imageio.ImageIO;

public class Libri implements Serializable {
    protected String autore;
    protected String nome;
    protected String genere;
    protected int pagine;
    protected int[] dataI;
    protected int[] dataF;
    protected String trama;
    protected byte[] immagine;
    //attributo per gli stati
    //attributo per il punteggio(recensione)

    
    public Libri(String autore, String nome, String genere, int pagine,File immagine) throws IOException {
        this.autore = autore;
        this.nome = nome;
        this.genere = genere;
        this.pagine = pagine;
        this.immagine = Files.readAllBytes(immagine.toPath());
        dataI = new int[3];
        dataF = new int[3];
        trama = "";
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
        if(this.toString().equals(l.toString())){
            return true;
        }else{
            return false;
        }
    }

    public BufferedImage getImmagine()throws IOException{
        ByteArrayInputStream im = new ByteArrayInputStream(immagine);
        return ImageIO.read(im);
    }

    public void salvaCopertinaLibro(String path)throws IOException{
        Files.write(new File(path).toPath(),immagine);   
    }
}
