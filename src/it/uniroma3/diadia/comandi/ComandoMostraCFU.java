package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoMostraCFU extends Comando {

	@Override
	public String esegui(Partita partita) {
		return (""+partita.getGiocatore().getCfu());

	}


}
