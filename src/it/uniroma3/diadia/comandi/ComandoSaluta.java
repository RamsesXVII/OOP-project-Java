package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends Comando {

	@Override
	public String esegui(Partita partita) {
		StringBuilder messaggio=new StringBuilder();
		AbstractPersonaggio personaggio=partita.getStanzaCorrente().getPersonaggio();
		
		if(personaggio!=null)
			messaggio.append(personaggio.saluta());
		else
			messaggio.append("Non c'è nessuno in questa stanza");
		
		return messaggio.toString();

	}

}
