package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi extends Comando {
	private Partita partita;
	private String nomeAttrezzo;
    /**
     * Permette di prendere un oggetto presente nella stanza
     * in cui si trova il giocatore se quest'ultimo può aggiungerlo nella borsa
     * @param nomeAttrezzo
     */
	@Override
	public String esegui(Partita partita) {
		this.partita=partita;
		StringBuilder messaggio=new StringBuilder();
		
		if(this.nomeAttrezzo==null)
			messaggio.append("Che attrezzo vuoi prendere?");
		
		else{
			Stanza stanzacorrente=partita.getStanzaCorrente();
			Attrezzo attrezzo=stanzacorrente.getAttrezzo(this.nomeAttrezzo);
			
			if (attrezzo==null)
				messaggio.append("Attrezzo inesistente");
			
			else {
				if(attrezzoAggiunto(attrezzo)){
					partita.getStanzaCorrente().removeAttrezzo(attrezzo);
					messaggio.append("L'attrezzo "+this.nomeAttrezzo+" è stato preso correttamente");
				}
				
				else
					messaggio.append("Non c'è spazio nella borsa, attrezzo non aggiunto");
			}
		}
		return messaggio.toString();
	}


	
  /** Metodo di supporto a prendi che aggiunge un oggetto nella borsa se c'è
    * abbastanza spazio
    * @param attrezzo
    * @return true se è stato aggiunto correttamente l'ogetto, false se non c'è abbastanza spazio
    */
	private boolean attrezzoAggiunto(Attrezzo attrezzo){
		boolean esito=false;
		Borsa borsa=this.partita.getGiocatore().getBorsa();
		if(borsa.addAttrezzo(attrezzo));
		esito=true;
		return esito;
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;

	}
	
}
