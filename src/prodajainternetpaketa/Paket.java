/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodajainternetpaketa;

/**
 *
 * @author jusuf
 */
public class Paket {
    public String brzina;
    public String protok;
    public String trajanjeUgovora;
    public String IDprodaje;
    public String imeKorisnika;
    public String prezimeKorisnika;
    public String adresaKorisnika;
    
    public Paket (String brzina, String protok, String trajanjeUgovora, String IDprodaje, String ime, String prezime, String adresa){
        this.brzina = brzina;
        this.protok = protok;
        this.trajanjeUgovora = trajanjeUgovora;
        this.IDprodaje = IDprodaje;
        this.imeKorisnika = ime;
        this.prezimeKorisnika = prezime;
        this.adresaKorisnika = adresa;
    }
    
    @Override
    public String toString() {
        String paket = "\nID: " + this.IDprodaje + 
                "\nIme i prezime korisnika: " + this.imeKorisnika + " " + this.prezimeKorisnika + 
                "\nAdresa korisnika: " + this.adresaKorisnika + 
                "\nBrzina protoka: " + this.brzina + 
                "\nProtok: " + this.protok + 
                "\nTrajanje ugovora: " + this.trajanjeUgovora;
        return paket;
    }
    
    public void setIDprodaje(String id) {
        this.IDprodaje = id;
    }
    public String getIDprodaje() {
        return this.IDprodaje;
    }
    
    public void setImeKorisnika(String ime) {
        this.imeKorisnika = ime;
    }
    public String getImeKorisnika() {
        return this.imeKorisnika;
    }
    
    public void setPrezimeKorisnika(String prezime) {
        this.prezimeKorisnika = prezime;
    }
    public String getPrezimeKorisnika() {
        return this.prezimeKorisnika;
    }
    
    public void setAdresaKorisnika(String adresa) {
        this.adresaKorisnika = adresa;
    }
    public String getAdresaKorisnika() {
        return this.adresaKorisnika;
    }
    
    public void setBrzina(String brzina) {
        this.brzina = brzina;
    }
    public String getBrzina() {
        return this.brzina;
    }
    
    public void setProtok(String protok) {
        this.protok = protok;
    }
    public String getProtok() {
        return this.protok;
    }
    
    public void setTrajanjeUgovora(String trajanje) {
        this.trajanjeUgovora = trajanje;
    }
    public String getTrajanjeUgovora() {
        return this.trajanjeUgovora;
    }
}
