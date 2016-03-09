package it.uniroma3.diadia.giocatore;

import java.util.Comparator;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class OrdinatorePerNome implements Comparator<Attrezzo> {

	@Override
	public int compare(Attrezzo attrezzo1, Attrezzo attrezzo2) {
		return attrezzo1.getNome().compareTo(attrezzo2.getNome());
	}

}
