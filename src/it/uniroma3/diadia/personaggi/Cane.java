package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	private static final String presentazione="BAU BAU BAU BAU GRRRRRR";
	
	
	public Cane(String nome,String presentazione){
		super(nome,presentazione);
	}
	
	
	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-2);
		return Cane.presentazione+ " Il cane ti ha morso, hai perso 2 CFu";
	}


	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String messaggio;
		if(attrezzo.getNome().equals("osso")){
			Attrezzo collare=new Attrezzo("collare",2);
			messaggio=new String("GNAM GNAMM");
			partita.getStanzaCorrente().addAttrezzo(collare);
			
		}
		else{
			messaggio=new String("BLEAH");
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
		}
		return messaggio;
	}
	

}
