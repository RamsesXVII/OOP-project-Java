package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa extends Comando {
	private String nomeAttrezzo;
	
	@Override
	public String esegui(Partita partita) {
		StringBuilder messaggio=new StringBuilder();
		
   	 if(this.nomeAttrezzo==null)
		 messaggio.append("Quale attrezzo vuoi posare?");
	 else{
		 Borsa borsa=partita.getGiocatore().getBorsa();
		 Stanza stanzacorrente=partita.getStanzaCorrente();
		 
		 if(borsa.hasAttrezzo(this.nomeAttrezzo)){
				 Attrezzo attrezzo_daposare=borsa.removeAttrezzo(this.nomeAttrezzo);
				 stanzacorrente.addAttrezzo(attrezzo_daposare);
				 messaggio.append("Attrezzo posato correttamente");
				 
				 ComandoMostraContenutoBorsa mostra= new ComandoMostraContenutoBorsa();//TODO
				 mostra.esegui(partita);	
		 
		 }
		 else messaggio.append("Attrezzo non presente in borsa\n "+borsa.toString());
	 }
	 return messaggio.toString();

 }
	

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;

	}

}
