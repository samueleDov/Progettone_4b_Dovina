/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._progettone_dovina;

import console_input.ConsoleInput;
import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import eccezioni.EccezioneRipianoNonValido;
import eccezioni.FileException;
import java.io.IOException;
import menu.Menu;

/**
 *
 * @author Studente
 */
public class App {

    public static void main(String[] args) 
    {
        //Gestione con Menu
        Aereo a1=new Aereo();
        int sceltaMenu;
       // Scanner tastiera=new Scanner(System.in);
        ConsoleInput tastiera=new ConsoleInput();
        //Pathname file in cui verranno esportati i posti in formato CSV
        String nomeFileCSV="prenotazioni.csv";
         //Pathname file in cui verranno esportati le preno in formato CSV
        String nomeFileBIN="prenotazioni.bin";
        
        //Caricamento iniziale dello scaffale dal file binario
        try 
        {     
            a1=Aereo.caricaAereo(nomeFileBIN);
            System.out.println("Caricamento dati iniziali avvenuto correttamente");
        } 
        catch (IOException ex ) 
        {
            System.out.println("File vuoto o non presente. Dati scaffale non caricati.");
        } 
        catch (ClassNotFoundException ex) 
        {
            System.out.println("File vuoto o non presente. Dati scaffale non caricati.");
        }
        
        
        
        String vociMenu[]=new String[11];
        {
            vociMenu[0]="Esci";
            vociMenu[1]="Visualizza posti presenti nell' aereo";
            vociMenu[2]="Aggiungi prenotazione";
            vociMenu[3]="Elimina prenotazione (posizione)";
            vociMenu[4]="Cerca prenotazione (posizione)";
            vociMenu[5]="Esporta tutte le prenotazioni in formato CSV";
            vociMenu[6]="Importa tutte le prenotazioni da un file CSV";
            vociMenu[7]="Salva prenotazione su file";
            vociMenu[8]="Importa prenotazione da file"; 
            
        //Istanzio il menu
        Menu menu=new Menu(vociMenu); 
        
        switch (sceltaMenu) 
            {
                case 0:
                    System.out.println("Arrivederci.");
                    return;
                case 1:
                    System.out.println(s1.toString());
                    break;
                case 2: // aggiungi volume
                    libro=new Libro();
                    do
                    {
                        inputOk=true;
                        try 
                        {
                            System.out.println("\nRipiano [0..4]--> ");
                            ripiano=tastiera.readInt();
                        } 
                        catch (IOException ex) 
                        {
                            System.out.println("Errore nell'inserimento del dato di input. Inserire di nuovo");
                            inputOk=false;
                        }    
                        catch (NumberFormatException ex) 
                        {
                            System.out.println("Input non conforme. Inserire di nuovo");
                            inputOk=false;
                        }
                        
                    }while(!inputOk);
                    
                    do
                    {
                        try 
                        {
                            inputOk=true;
                            System.out.println("\nPosizione [0..14]--> ");
                            posizione=tastiera.readInt();
                        } 
                        catch (IOException ex) 
                        {
                            System.out.println("Errore nell'inserimento del dato di input. Inserire di nuovo");
                            inputOk=false;
                        } 
                        catch (NumberFormatException ex) 
                        {
                            System.out.println("Input non conforme. Inserire di nuovo");
                            inputOk=false;
                        }
                        
                    }while(!inputOk);
                    
                    //Per le stringhe non creo il ciclo di reinserimento dell'input
                    //poichè non può verificarsi un input non conforme
                    try 
                    {
                        System.out.println("\nTitolo--> ");
                        libro.setTitolo(tastiera.readString());
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Errore nell'inserimento del dato di input. Inserire di nuovo");
                    } 

                    //Per le stringhe non creo il ciclo di reinserimento dell'input
                    //poichè non può verificarsi un input non conforme
                    try 
                    {
                        System.out.println("\nAutore--> ");
                        libro.setAutore(tastiera.readString());
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Errore nell'inserimento del dato di input. Inserire di nuovo");
                    } 
                    
                    do
                    {
                        try 
                        {
                            inputOk=true;
                            System.out.println("\nNumero pagine--> ");
                            libro.setNumeroPagine(tastiera.readInt());
                        } 
                        catch (IOException ex) 
                        {
                            System.out.println("Errore nell'inserimento del dato di input. Inserire di nuovo");
                            inputOk=false;
                        } 
                        catch (NumberFormatException ex) 
                        {
                            System.out.println("Input non conforme. Inserire di nuovo");
                            inputOk=false;
                        }
                        
                    }while(!inputOk);

                    try 
                    {
                        s1.setLibro(libro, ripiano, posizione);
                        System.out.println("Inserimento avvenuto correttamente");
                    } 
                    catch (EccezionePosizioneOccupata ex) 
                    {
                        System.out.println("Posizione non vuota");
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                         System.out.println("Posizione non valida");
                    } 
                    catch (EccezioneRipianoNonValido ex) 
                    {
                        System.out.println("Ripiano non valido");
                    } 
                    break;


                case 3: //elimina volume
                    do
                    {
                        inputOk=true;
                        try 
                        {
                            System.out.println("\nRipiano [0..4]--> ");
                            ripiano=tastiera.readInt();
                        } 
                        catch (IOException ex) 
                        {
                            System.out.println("Errore nell'inserimento del dato di input. Inserire di nuovo");
                            inputOk=false;
                        }    
                        catch (NumberFormatException ex) 
                        {
                            System.out.println("Input non conforme. Inserire di nuovo");
                            inputOk=false;
                        }
                        
                    }while(!inputOk);
                    
                    do
                    {
                        try 
                        {
                            inputOk=true;
                            System.out.println("\nPosizione [0..14]--> ");
                            posizione=tastiera.readInt();
                        } 
                        catch (IOException ex) 
                        {
                            System.out.println("Errore nell'inserimento del dato di input. Inserire di nuovo");
                            inputOk=false;
                        } 
                        catch (NumberFormatException ex) 
                        {
                            System.out.println("Input non conforme. Inserire di nuovo");
                            inputOk=false;
                        }
                        
                    }while(!inputOk);
                                             
                    try 
                    {
                        s1.rimuoviLibro(ripiano, posizione);
                        System.out.println("Rimozione avvenuta correttamente"); 
                    } 
                    catch (EccezioneRipianoNonValido ex) 
                    {
                       System.out.println("Ripiano non valido");
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                        System.out.println("Posizione non valida");
                    } 
                    catch (EccezionePosizioneVuota ex)
                    {
                        System.out.println("Posizione gia' vuota");
                    }
                    break;

                case 4:  //cerca volume
                    do
                    {
                        inputOk=true;
                        try 
                        {
                            System.out.println("\nRipiano [0..4]--> ");
                            ripiano=tastiera.readInt();
                        } 
                        catch (IOException ex) 
                        {
                            System.out.println("Errore nell'inserimento del dato di input. Inserire di nuovo");
                            inputOk=false;
                        }    
                        catch (NumberFormatException ex) 
                        {
                            System.out.println("Input non conforme. Inserire di nuovo");
                            inputOk=false;
                        }
                        
                    }while(!inputOk);
                    
                    do
                    {
                        try 
                        {
                            inputOk=true;
                            System.out.println("\nPosizione [0..14]--> ");
                            posizione=tastiera.readInt();
                        } 
                        catch (IOException ex) 
                        {
                            System.out.println("Errore nell'inserimento del dato di input. Inserire di nuovo");
                            inputOk=false;
                        } 
                        catch (NumberFormatException ex) 
                        {
                            System.out.println("Input non conforme. Inserire di nuovo");
                            inputOk=false;
                        }
                        
                    }while(!inputOk);
                    
                    try 
                    {
                        libro=s1.getLibro(ripiano, posizione);
                        System.out.println("Libro richiesto:\n"+libro.toString());
                    } 
                    catch (EccezioneRipianoNonValido ex) 
                    {
                         System.out.println("Ripiano non valido");
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                        System.out.println("Posizione non valida");
                    } 
                    catch (EccezionePosizioneVuota ex) 
                    {
                        System.out.println("Nessun volume presente in questo ripiano-posizione");
                    }
                    break;

                case 5:
                    try 
                    {
                       // System.out.println("Premi invio per continuare...");
                       // tastiera.readString();
                        System.out.println("\nAutore--> ");
                        autore=tastiera.readString();
                        elencoTitoliAutore=s1.elencoTitoliAutore(autore); 
                    } 
                    catch (EccezioneRipianoNonValido ex) 
                    {
                         System.out.println("Ripiano non valido");
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                        System.out.println("Posizione non valida");
                    } 
                    catch (IOException ex) 
                    { 
                         System.out.println("Errore nell'inserimento del dato di input. Inserire di nuovo");
                         inputOk=false;
                    }
                    
                    if (elencoTitoliAutore==null)
                        System.out.println("Nessun titolo presente dell'autore "+autore);
                    else
                    {
                        for(int i=0;i<elencoTitoliAutore.length;i++)
                        {
                            System.out.println(elencoTitoliAutore[i]);
                        }
                    }
                    break;


                case 6:
                    Libro[] elencoLibriOrdinato = null;
                    try 
                    {
                        elencoLibriOrdinato=s1.elencoOrdinatoLibriPresenti();
                    } 
                    catch (EccezioneRipianoNonValido ex) 
                    {
                         System.out.println("Ripiano non valido");
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                        System.out.println("Posizione non valida");
                    } 
                    for(int i=0;i<elencoLibriOrdinato.length;i++)
                    {
                        System.out.println(elencoLibriOrdinato[i].toString());
                    }
                    break;
                
                case 7:
                
                    try 
                    {
                        s1.esportaLibriCSV(nomeFileCSV);
                        System.out.println("Esportazione avvenuta correttamente");
                    }  
                    catch (IOException ex) 
                    {
                        System.out.println("Errore! Impossibile accedere al file. I libri non sono stati esportati!");
                    } 
                    catch (FileException ex) 
                    {
                        System.out.println(ex.toString());
                    }
                    break;
                case 8:
                    try 
                    {
                        s1.importaLibriCSV(nomeFileCSV);
                        System.out.println("Importazione avvenuta con successo.");
                    } 
                   /* catch (NumberFormatException e)
                    {
                        System.out.println("Errore! Il formato del file CSV non è corretto.");
                    }*/
                    catch (IOException ex) 
                    {
                        System.out.println("Errore! impossibile accedere ai file. I libri non sono stati importati!");
                    }
                    break;
               
                case 9:
                    try 
                    {
                        s1.salvaScaffale(nomeFileBIN);
                         System.out.println("Salvataggio dati avvenuto correttamente");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile accedere al file. Savataggio non avvenuto");
                    }
                    break;
                    
                case 10:
                    //Caricamento scaffale da file binario
                    try 
                    {     
                        s1=Scaffale.caricaScaffale(nomeFileBIN);
                        System.out.println("Caricamento dati avvenuto correttamente");
                    } 
                    catch (IOException ex ) 
                    {
                        System.out.println("File corrotto o non presente. Dati scaffale non caricati.");
                    } 
                    catch (ClassNotFoundException ex) 
                    {
                        System.out.println("File vuoto o non presente. Dati scaffale non caricati.");
                    }
            }
            
        }while(true);
     
    
        } 
    } 
                }
