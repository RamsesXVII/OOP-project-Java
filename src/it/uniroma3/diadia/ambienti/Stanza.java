package it.uniroma3.diadia.ambienti;


import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;


/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * @author Paolo Merialdo (a partire da un'idea di Michael Kolling e David J. Barnes)
 * @see Attrezzo
 * @version 0.1
*/

public class Stanza{
	private String nome;
    private Set<Attrezzo> attrezzi;
    private HashMap<String, Stanza> stanzeAdiacenti;
    private AbstractPersonaggio personaggio;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.stanzeAdiacenti = new HashMap<String,Stanza>();
        this.attrezzi = new HashSet<Attrezzo>();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        this.stanzeAdiacenti.put(direzione, stanza);
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
        return this.stanzeAdiacenti.get(direzione);
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Attrezzo[] getAttrezzi() {
    	return (Attrezzo[]) this.attrezzi.toArray();
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
       return this.attrezzi.add(attrezzo);
    }
    
    public void setPersonaggio(AbstractPersonaggio personaggio){
    	this.personaggio=personaggio;
    }
    
    public AbstractPersonaggio getPersonaggio(){
    	return this.personaggio;
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    @Override
    public String toString() {
    	Set<String>direzioni=this.stanzeAdiacenti.keySet();
    	String s = new String();
    	s += this.nome;
    	s += "\nUscite: ";
    	for (String direzione : direzioni)
    			s += " " + direzione;
    	s += "\nAttrezzi nella stanza: ";
    	for (Attrezzo attrezzo : this.attrezzi) {
    		if(attrezzo!=null) //l'errore era nel tentativo di accesso a casella vuota
    		s += attrezzo.toString()+" ";
    	}
    	if(this.getPersonaggio()!=null){
    		s+=" \n è presente il personaggio"+this.getPersonaggio().getNome();
    	}
    	return s;
    }
    

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {//TODO importantissimo
		Attrezzo a=new Attrezzo(nomeAttrezzo,-1);
		return this.attrezzi.contains(a);
	}

	/**
     * Restituisce il riferimento all'attrezzo nomeAttrezzo 
     * se quest'ultimo è presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Iterator<Attrezzo>iteratore= this.attrezzi.iterator();
		Attrezzo b=new Attrezzo(nomeAttrezzo,-1);
		Attrezzo a;
		while(iteratore.hasNext()){
			a=iteratore.next();
			if(a.equals(b))
				return a;
		}
		return null;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */

	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.remove(attrezzo);
	}
	
	/**
	 * Cerca nell'array degli attrezzi della stanza un attrezzo con il nome nomeAttrezzo
	 * e restituisce la sua posizione nell'array 
	 * @param nomeAttrezzo
	 * @return int della posizione dell'oggetto nell'array attrezzi

	//IMPORTANTE
	  private int returnPosition(String nomeAttrezzo){
		 LinkedList<Attrezzo>lista=new LinkedList<Attrezzo>();
		 lista.addAll(this.attrezzi);
		 return lista.indexOf(nomeAttrezzo);
	  }	 */
	  
	public Collection<Stanza> getStanzeAdiacenti(){
		return this.stanzeAdiacenti.values();
	}
	
	public int getNumeroAttrezzi(){
		return this.attrezzi.size();
	}
	@Override
	public int hashCode(){
		return this.toString().hashCode();
	}
	
	@Override
	public boolean equals(Object o){
		Stanza nuova=(Stanza) o;
		return this.toString().equals(nuova.toString());
	}
}