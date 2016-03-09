package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {
	private String nome;
	private String presentazione;
	private boolean haSalutato;
	
	public AbstractPersonaggio(String nome,String presentazione){
		this.nome=nome;
		this.presentazione=presentazione;
		this.haSalutato=false;
	}

	public String getNome(){
		return this.nome;
	}
	
	public boolean haSalutato(){
		return this.haSalutato;
	}
	
	public String getPresentazione(){
		return this.presentazione;
	}
	
	public String saluta(){
		StringBuilder saluto=new StringBuilder();
		saluto.append("Ciao io sono "+this.getNome()+". ");
		if(this.haSalutato())
			return saluto.append("Ci siamo giˆ presentati").toString();
		else{
			this.haSalutato=true;
			return saluto.append(this.getPresentazione()).toString();}
	}
	
	abstract public String agisci(Partita partita);
	public abstract String riceviRegalo(Attrezzo attrezzo, Partita partita);
	
	@Override
	public String toString(){
		return this.getNome();
	}
}
