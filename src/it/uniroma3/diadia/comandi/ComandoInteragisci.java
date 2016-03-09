package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends Comando{
	private String messaggio;

	@Override
	public String esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio(); 
		StringBuilder messaggio=new StringBuilder();
		
		if(personaggio!=null)
			messaggio.append(personaggio.agisci(partita)); 
		
		else
			messaggio.append("Non c'è nessuno in questa stanza");
		
		return messaggio.toString();
	}
	
	public String getMessaggio() {
	       return this.messaggio;
	}
}
