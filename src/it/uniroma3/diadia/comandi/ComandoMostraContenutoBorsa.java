package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoMostraContenutoBorsa extends Comando {

	@Override
	public String esegui(Partita partita) {
		String infoBorsa=partita.getGiocatore().getBorsa().toString();
		return infoBorsa;
	}


}
