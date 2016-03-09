package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends Comando {
	String nomeAttrezzo;

	@Override
	public String esegui(Partita partita) {
		Borsa borsa=partita.getGiocatore().getBorsa();
		String messaggio;

		if(borsa.hasAttrezzo(this.nomeAttrezzo)){
			AbstractPersonaggio personaggio=partita.getStanzaCorrente().getPersonaggio();
			if(personaggio==null)
				messaggio="Non c'è nessuno a cui regalare il "+this.nomeAttrezzo;
			else{
				 messaggio=personaggio.riceviRegalo(borsa.removeAttrezzo(nomeAttrezzo), partita);
			}
		}
		else
			messaggio="Non hai l'attrezzo che vuoi regalare";
		return(messaggio);
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;

	}

}
