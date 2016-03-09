package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends Comando {

	@Override
	public String esegui(Partita partita) {
		return("Comando sconosciuto");

	}

	
}
