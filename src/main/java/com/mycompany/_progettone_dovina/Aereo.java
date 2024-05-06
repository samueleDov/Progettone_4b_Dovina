/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._progettone_dovina;

/**
 *
 * @author Studente
 */
public class Aereo {
    private final int N_MAX_POSTI=20; 
    private Prenotazione[] elencoPrenotazioni; 
    

    public Prenotazione[] getElencoPrenotazioni() {
        return elencoPrenotazioni;
    }

    public void setElencoPrenotazioni(Prenotazione[] elencoPrenotazioni) {
        this.elencoPrenotazioni = elencoPrenotazioni;
    }

    public Aereo(Prenotazione[] elencoPrenotazioni) {
        this.elencoPrenotazioni = elencoPrenotazioni;
    }

    @Override
    public String toString() {
        return "Aereo{" + "N_MAX_POSTI=" + N_MAX_POSTI + ", elencoPrenotazioni=" + elencoPrenotazioni + '}';
    }
    
}
