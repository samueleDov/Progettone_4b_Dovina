/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._progettone_dovina;

/**
 *
 * @author Studente
 */
public class Prenotazione {
    private String nome; 
    private String eta; 
    private boolean prenotato;

    public Prenotazione(String nome, String eta) {
        this.nome = nome;
        this.eta = eta; 
        this.prenotato = false; // Inizialmente la prenotazione è vuota
    } 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }
    public void prenotaPrenotazione() {
        if (!prenotato) { // Controlla se la prenotazione è già stata fatta
            prenotato = true; // Segna la prenotazione come effettuata
            System.out.println("Prenotazione effettuata per " + nome);
        } else {
            System.out.println("Prenotazione già effettuata per " + nome);
        }
    }

    public void confermaPrenotazione() {
        if (prenotato) { // Controlla se la prenotazione è stata effettuata
            System.out.println("Prenotazione confermata per " + nome + ". Ecco il tuo attestato.");
            System.out.println("Nome: " + nome);
            System.out.println("Età: " + eta);
        } else {
            System.out.println("Non ci sono prenotazioni da confermare per " + nome);
        }
    }
    @Override
    public String toString() {
        return "Prenotazione{" + "nome=" + nome + ", eta=" + eta + '}';
    }
    
    
}
