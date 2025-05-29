import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Libri implements Serializable {
    //attributi
    protected String autore;
    protected String nome;
    protected String genere;
    protected int pagine;
    protected int[] dataI;
    protected int[] dataF;
    protected String trama;
    protected byte[] immagine;
    private boolean read,reading,toRead;
    private static final long serialVersionUID = 1L; //numero seriale per la lettura
    private JButton button;  //riferimento al pulsante associato  
    //aggiungere attributo per il la recensione

    
    public Libri(String autore, String nome, String genere, int pagine,File immagine) throws IOException {
        this.autore = autore;
        this.nome = nome;
        this.genere = genere;
        this.pagine = pagine;
        this.immagine = Files.readAllBytes(immagine.toPath());
        dataI = new int[3];
        dataF = new int[3];
        trama = "";
        read = false;
        reading = false;
        toRead = false;
    }
        
    //get degli attributi
    public JButton getButton(){
        return button;
    }
    public String getAutore() {
        return autore;
    }

    public String getNome() {
        return nome;
    }

    public String getGenere() {
        return genere;
    }
    
    public int getPagine() {
        return pagine;
    }

    public int[] getDataI() {
        return dataI;
    }

    public int[] getDataF() {
        return dataF;
    }
    

    public String getTrama() {
        return trama;
    }

    public void setButton(JButton b){
        this.button = b;
    }

    public int getNpagine() {
        return pagine;
    }

    public BufferedImage getImmagine()throws IOException{
        ByteArrayInputStream im = new ByteArrayInputStream(immagine);
        return ImageIO.read(im);
    }


    //set degli attributi
    public void setAutore(String autore) {
        this.autore = autore;
        System.out.println(autore+"<--Autore dentro setAutore");
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
    public void setPagine(int pagine) {
        this.pagine = pagine;
    }

    public void setDataI(int[] dataI) {
        this.dataI = dataI;
    }

    public void setDataF(int[] dataF) {
        this.dataF = dataF;
    }

    public void setRead(boolean n){
        read=n;
    }
    
    public void setReading(boolean n){
        reading=n;
    }

    public void setToRead(boolean n){
        toRead=n;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public void setNpagine(int npagine) {
        this.pagine = npagine;
    }

    
    public boolean isRead() {
        return read;
    }
    public boolean isReading() {
        return reading;
    }
    public boolean isToRead() {
        return toRead;
    }

    //metodo per la stampa di un libro
    public String toString(){
        return String.format("%s %s %s %d",autore,nome, genere,pagine);
    }

    //metodo per il confronto tra libri
    public boolean equals(Libri l){
        if(this.toString().equals(l.toString())){
            return true;
        }else{
            return false;
        }
    }
}