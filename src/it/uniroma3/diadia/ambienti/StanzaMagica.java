package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/** Una stanza magica, esattamente come la stanza ordinaria, 
 *  ha una descrizione, una collezione di uscite, una collezione di attrezzi,
 *   dopo N volte che da tale stanza viene posato (aggiunto)
 *   un qualsiasi attrezzo dal giocatore, la stanza inizierà a
 *  comportarsi magicamente
 * 
 * @author mattiaiodice
 *
 */

public class StanzaMagica extends Stanza {
	
	private int contatoreAttrezziPosati;
	final static private int SOGLIA_DEFAULT = 3;
	private int sogliaMagica;
	
	public StanzaMagica(String nome){
		this(nome,StanzaMagica.SOGLIA_DEFAULT);
	}
	
	public StanzaMagica(String nome, int soglia){
		super(nome);
		this.contatoreAttrezziPosati=0;
		this.sogliaMagica=soglia;
	}

	
	
	/**
	 *  quando la stanza si comporta magicamente, ogni volta che posiamo un attrezzo,
	 *  la stanza "inverte" il nome dell'attrezzo e ne raddoppia il peso. 
	 *  Ad esempio: se posiamo (togliamo dalla borsa e aggiungiamo alla stanza)
	 *   l'attrezzo con nome "chiave" e peso 2, la stanza memorizza un attrezzo con nome "evaihc"
	 *    e peso 4
	 *    @param Attrezzo, l'attrezzo il cui nome verrà invertito
	 *    @return Attrezzo con nome invertito e il peso raddoppiato
	 */

	public boolean addAttrezzo(Attrezzo attrezzo) { 
		this.contatoreAttrezziPosati++;
			if (this.contatoreAttrezziPosati > this.sogliaMagica)
				attrezzo = this.modificaAttrezzo(attrezzo); 
		return super.addAttrezzo(attrezzo);
	}
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) { 
		
		 StringBuilder nomeInvertito; 
		 int pesoDoppio = attrezzo.getPeso()*2; 
		 nomeInvertito = new StringBuilder(attrezzo.getNome()); 
		 nomeInvertito = nomeInvertito.reverse(); 
		 attrezzo = new Attrezzo(nomeInvertito.toString(),pesoDoppio); 

		 return attrezzo; 
		 }
	public int getContatoreAttrezziAggiunti(){
		return this.contatoreAttrezziPosati;
	}
}

