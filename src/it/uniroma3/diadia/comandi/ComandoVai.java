package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends Comando {
	
	private String direzione;
	
	/*public ComandoVai(String direzione){
		this.direzione=direzione;
	}*/ // TODO con direzione non funge
	
	@Override
	public String esegui(Partita partita) {
		StringBuilder messaggio=new StringBuilder();
		
		Stanza stanzaCorrente = partita.getStanzaCorrente(); 
		Stanza prossimaStanza = null;
		if (direzione==null) {
			messaggio.append("Dove vuoi andare? Devi specificare una direzione");
			return messaggio.toString();
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione); 
		
		if (prossimaStanza==null) {
			messaggio.append("Direzione inesistente");
			return messaggio.toString(); }
		
		partita.setStanzaCorrente(prossimaStanza);
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		messaggio.append(partita.getStanzaCorrente().getDescrizione());
		return messaggio.toString();

	}
	@Override
	public void setParametro(String parametro) { 
		this.direzione = parametro;
	}
}
