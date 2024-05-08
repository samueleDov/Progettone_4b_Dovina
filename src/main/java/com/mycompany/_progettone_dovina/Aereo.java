/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._progettone_dovina;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import eccezioni.EccezioneRipianoNonValido;
import eccezioni.FileException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Studente
 */
public class Aereo implements Serializable
{
    private final int N_MAX_POSTI=20; 
    private Prenotazione[] elencoPrenotazioni; 

    public Aereo(Prenotazione[] elencoPrenotazioni) {
        this.elencoPrenotazioni = elencoPrenotazioni;
    }
  
    
    public Prenotazione[] getElencoPrenotazioni() {
        return elencoPrenotazioni;
    }

    public void setElencoPrenotazioni(Prenotazione[] elencoPrenotazioni) {
        this.elencoPrenotazioni = elencoPrenotazioni;
    }

     public void esportaLibriCSV(String nomeFile) throws IOException, FileException
    {
        Libro lib;
        String libroCSV;
        TextFile f1;
        
        //Prima cancello i libri presenti nel file
        f1=new TextFile(nomeFile, 'W');
        f1.close();
        
        //Poi apro il file i append per aggiungere, uno alla volta, il libri dello scaffale
        f1=new TextFile(nomeFile, 'W',true); //Apro il file in scrittura in append
        for(int i=0;i<getNumRipiani();i++)
        {
            try 
            {
                for(int j=0;j<getNumMaxLibri(i);j++) 
                {
                    try
                    {
                        lib=getLibro(i, j);
                        libroCSV=i+";"+j+";"+lib.getTitolo()+";"+lib.getAutore()+";"+lib.getNumeropagine();
                        f1.toFile(libroCSV);
                    }
                    catch (EccezionePosizioneNonValida | EccezioneRipianoNonValido | EccezionePosizioneVuota ex)
                    { 
                        //In tutti questi casi l'applicazione non fa nulla
                    }
                }
            } 
            catch (EccezioneRipianoNonValido ex) 
            {
                //L'applicazione noin fa nulla. Questa eccezione non si vrrifica mai se il ciclo for è costruito correttamente.
            }
        }
       f1.close();
    }
    
    // 
    /**
     * Legge i libri presenti in un file di testo CSV e li aggiunge allo scaffale,
     * Se il ripiano o la posizione del libro non è valida,il  libro letto dal file non viene caricato
     * Se il ripiano/posizione del libro è già occupato, il libro letto dal file non viene caricato.
     * @param nomeFile pathname del file CSV da cui importare i volumi
     * @throws IOException Se non è possibile accedere al file
     */
    public void importaPostiCSV(String nomeFile) throws IOException
    {
        TextFile a1=new TextFile(nomeFile, 'R'); //Apro il file in lettura
        String PrenotazioneLetta;
        String[] PrenotazioneLettaSplit;
        String nome,eta;
        int ripiano, posizione;
        boolean prenotazione;
        Prenotazione pre = null;
        
        try 
        {
            //ciclo di lettura da file
            PrenotazioneLetta=a1.fromFile();  
            while(PrenotazioneLetta!=null)
            {     
               
                try 
                {
                    PrenotazioneLettaSplit=PrenotazioneLetta.split(";");
                    ripiano=Integer.parseInt(PrenotazioneLettaSplit[0]);
                    posizione=Integer.parseInt(PrenotazioneLettaSplit[1]);
                    nome=PrenotazioneLettaSplit[2];
                    eta=PrenotazioneLettaSplit[3];
                    pre=new Prenotazione(nome,eta,prenotazione);
                    setElencoPrenotazioni(pre, ripiano, posizione);
                } 
                catch (EccezionePosizioneOccupata | EccezionePosizioneNonValida |EccezioneRipianoNonValido | NumberFormatException ex) 
                {
                   //Il libro letto da file viene ignorato in tutti questi casi
                }  
                
                libroLetto=f1.fromFile();   //Leggo il libro successivo
            }
        } 
        catch (FileException ex) 
        {
           //Esce dal ciclo quando il file è terminato oppure è stato apreto in scrittura anzichè in lettura
        }
        f1.close();
    }
    
    /**
     * Salva l'oggetto scaffale this (e tutti gli oggetti in esso contenuti) su un file binario
     * @param nomeFile Nome del file
     * @throws FileNotFoundException Se il file non viene trovato in fase di chiusura
     * @throws IOException Se non è possibile accedere al file
     */
    public void salvaAereo(String nomeFile) throws FileNotFoundException, IOException
    {
        
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream output=new ObjectOutputStream(f1);
        output.writeObject(this);
        output.flush();
        output.close();
    }
    
    /**
     * Restituisce un oggetto scaffale (e tutti gli oggetti in esso contenuti)
     * precedentemente memeorizzato in un file binario
     * 
     * @param nomeFile Pathname del file binario
     * @return
     * @throws FileNotFoundException Se il file non viene trovato in fase di chiusura
     * @throws IOException      Se non è possibile accedere al file
     * @throws ClassNotFoundException Se la struttura dati memorizzata nel file non corrisponde allo scaffale
     */
    public static Scaffale caricaAereo(String nomeFile) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream f1=new FileInputStream(nomeFile);
        ObjectInputStream input=new ObjectInputStream(f1);
        Aereo s;    
        s=(Aereo)input.readObject();
        input.close();
        return s;
    }
    @Override
    public String toString() {
        return "Aereo{" + "N_MAX_POSTI=" + N_MAX_POSTI + ", elencoPrenotazioni=" + elencoPrenotazioni + '}';
    }
    
}
