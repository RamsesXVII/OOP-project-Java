package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{
	private static final String MESSAGGIO_DONO = "Sono contenta che mi hai salutato, ti trasferir˜ in un posto speciale";
	private static final String MESSAGGIO_SCUSE = "Sei maleducato, ABRAKADABRA, nella stanza con meno attrezzi finirai";

	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}
	
	

	@Override
	public String agisci(Partita partita) {
		String messaggio;
		if(super.haSalutato()){
			messaggio=MESSAGGIO_DONO;
			System.out.println(partita.getStanzaCorrente().getDescrizione());
			partita.setStanzaCorrente(this.getStanzaTrasfetimento(partita,true));
		}
		else{
			messaggio=MESSAGGIO_SCUSE;
			partita.setStanzaCorrente(this.getStanzaTrasfetimento(partita, false));
		}
		return messaggio;
	}
	
	private Stanza getStanzaTrasfetimento(Partita partita, boolean haSalutato){
		Stanza stanzaCorrente=partita.getStanzaCorrente();
		Stanza stanzaTrasferimento=stanzaCorrente;
		
		if(haSalutato)
		for(Stanza stanza:stanzaCorrente.getStanzeAdiacenti()){
			if(stanza.getNumeroAttrezzi()>stanzaTrasferimento.getNumeroAttrezzi())
				stanzaTrasferimento=stanza;
				
		}
		else
			for(Stanza stanza:stanzaCorrente.getStanzeAdiacenti()){
				if(stanza.getNumeroAttrezzi()<stanzaTrasferimento.getNumeroAttrezzi())
					stanzaTrasferimento=stanza;
					
			}
		return stanzaTrasferimento;
	}



	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return ("BUAHAHAHAHHAHAHAHAHHA");
	}

}
