package it.uniroma3.diadia.giocatore;


import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Giocatore-Un giocatore nel gioco diadia
 * Un giocatore è uno studente universitario che si muove in diadia
 * e gestisce il numero di spostamenti(punteggio) nell'università attraverso il numero di CFU.
 * Ha inoltre una borsa per riporre oggetti
 *@author AndreaIlgrande MattiaIodice
 *@see Borsa
 *@version 1.0
 */
public class Giocatore {
	private static int CFU_INIZIALI = 20;
	private int Cfu;
	private Borsa borsa;
	public Giocatore(){
		this.Cfu=CFU_INIZIALI;
		this.borsa=new Borsa();
		
	}
	public int getCfu(){
		return this.Cfu;
	}
	public void setCfu(int Cfu){
		this.Cfu=Cfu;
	}
	public boolean getAttrezzo(Attrezzo attrezzo){
		return this.borsa.addAttrezzo(attrezzo);
	}
	  public Borsa getBorsa(){
		  return this.borsa;
	  }
}
