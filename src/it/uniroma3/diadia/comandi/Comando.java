package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public abstract class Comando {
	public abstract String esegui(Partita partita);
	public void setParametro(String parametro) {    }
}
