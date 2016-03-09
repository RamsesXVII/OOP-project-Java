package it.uniroma3.diadia.ambienti;


import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

/**
 * Classe Labirinto: ha lo scopo di definire la planimetria di diadia
 *  e di impostare la stanza vincente
 *@author AndreaIlGrandre MattiaIodice
 *@see Stanza
 *@version 1.0
 */

public class Labirinto {
    public static final String MESSAGGIO_BENVENUTO = 
		"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
		"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
		"I locali sono popolati da strani personaggi, " +
		"alcuni amici, altri... chissa!\n"+
		"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
		"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
		"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
		"Per conoscere le istruzioni usa il comando 'aiuto'.";
    private static String pathLabirinto="/Users/mattiaiodice/Documents/workspace/POO_HOMEWORK3/src/it/uniroma3/diadia/ambienti/CaricatoreLabirinto.txt";
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private CaricatoreLabirinto caricatore;
	public Labirinto(){
		this(pathLabirinto);
	}
	public Labirinto(String nomeFile) { 
				this.caricatore =	new CaricatoreLabirinto(nomeFile);
			    caricatore.carica();
				this.stanzaCorrente = caricatore.getStanzaIniziale();
			    this.stanzaVincente = caricatore.getStanzaVincente();
			    }
	
	
    public Stanza getStanzaCorrente() {
        return this.stanzaCorrente;
    }

    public Stanza getStanzaVincente() {
        return this.stanzaVincente;
    }
    
}
