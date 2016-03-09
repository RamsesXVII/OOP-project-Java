package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends Comando {

	@Override
	public String esegui(Partita partita) {
		partita.setFinita();
		return("Grazie di aver giocato!");

	}


}
