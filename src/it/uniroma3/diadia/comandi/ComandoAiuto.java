package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends Comando {

	@Override
	public String esegui(Partita partita) {
		StringBuilder messaggio=new StringBuilder();
		for(int i=0; i< Partita.elencoComandi.length; i++) 
			messaggio.append((Partita.elencoComandi[i]+" "));
		return messaggio.toString();
	}



}
