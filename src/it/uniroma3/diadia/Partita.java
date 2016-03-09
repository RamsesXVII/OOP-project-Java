package it.uniroma3.diadia;


import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco e gestisce le informazioni relative alla partita
 *
 * @author  Paolo Merialdo, Valter Crescenzi (da un'idea di Michael Kolling and David J. Barnes)
 * @see Stanza
 * @version 0.1
 */

public class Partita {
    public static String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa","borsa","cfu","regala","interagisci","saluta"};
    
	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	private Giocatore giocatore;
	public Partita(){
		this.giocatore=new Giocatore();
		this.labirinto=new Labirinto();
		this.finita = false;
		this.stanzaCorrente=this.labirinto.getStanzaCorrente();
		this.stanzaVincente=this.labirinto.getStanzaVincente();
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public Giocatore getGiocatore(){
		return this.giocatore;
	}

	public boolean giocatoreIsVivo() {
		return this.giocatore.getCfu()!=0;
	}

}
