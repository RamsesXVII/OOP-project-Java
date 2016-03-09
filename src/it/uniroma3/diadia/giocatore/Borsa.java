package it.uniroma3.diadia.giocatore;


import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/** 
 * Classe Borsa: un oggetto dello studente in cui esso può
 *  raccogliere e riporre gli attrezzi presenti nel gioco di ruolo. Ha un limite massimo
 *  di peso trasportabile.
 *@author mattiaiodice andreailgrande
 *@see Attrezzo
 *@version 1.0
 */

public class Borsa {
  public final static int DEFAULT_PESO_MAX_BORSA = 10;
  private Map<String,Attrezzo> attrezzi;
  private int pesoMax;
  private int numeroAttrezzi;
  /**
   * Costruttore che inizializza l'oggetto borsa senza parametri
   * chiamando il costruttore Borsa(int)
   */
  public Borsa() {
  this(DEFAULT_PESO_MAX_BORSA);
  }
  /**
   * Costruttore che inizializza l'oggetto borsa
   * @param pesoMax meso massimo della borsa
   */
  public Borsa(int pesoMax) {
     this.pesoMax = pesoMax;
     this.attrezzi = new HashMap<String,Attrezzo>(); 
  }
  /**
   * Aggiunge un attrezzo nella borsa se il peso complessivo e il numero degli oggetti 
   *  è inferiore a 10.
   * @param attrezzo
   * @return true se è stato possibile aggiungere l'attrezzo, false altrimenti
   */
  public boolean addAttrezzo(Attrezzo attrezzo) {
	if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
		   return false;
	this.attrezzi.put(attrezzo.getNome(),attrezzo);
	this.numeroAttrezzi++;
	return true;
  }
  /**
   * metodo che restituisce il peso massimo della borsa
   * @return int peso massimo
   */
  public int getPesoMax() {
     return pesoMax;
  }
  /**
   * metodo che restituisce il numero di attrezzi presenti nella borsa
   */
  public int getNumeroAttrezzi(){
	  return this.numeroAttrezzi;
  }
  /**
   * Dato un nome di un attrezzo restituisce il riferimento Attrezzo se quel nome è
   * relativo ad un attrezzo presente nella borsa
   * @param nomeAttrezzo
   * @return riferimento all'Attrezzo corrispondente alla stringa inserita
   */
  public Attrezzo getAttrezzo(String nomeAttrezzo) {
     return this.attrezzi.get(nomeAttrezzo);
  }
  /**
   * Metodo che restituisce il peso attuale della borsa, ovvero la somma dei pesi
   * degli attrezzi in essa
   * @return int perso della borsa
   */
  public int getPeso() {
	  int peso=0;
	 List<Attrezzo>lista=new LinkedList<Attrezzo>(this.attrezzi.values());
	 for(Attrezzo a:lista){
		  peso+=a.getPeso();
	  }
	 return peso;
  }
  /**
   * metodo che verifica se una borsa è vuota
   * @return true se non ci sono oggetti, false altrimenti
   */
  public boolean isEmpty() {
	  return this.attrezzi.isEmpty();
  }
  /**
   * Verifica se è presente un attrezzo in una borsa
   * @param nomeAttrezzo nome dell'attrezzo
   * @return true se presente false altrimenti
   */
  public boolean hasAttrezzo(String nomeAttrezzo) {
	  return this.getAttrezzo(nomeAttrezzo)!=null;
  }
  /**
   * Rimuove un attrezzo dalla borsa se presente e lo restituisce.
   * Se effettua la rimozione riordina anche l'array
   *  per non avere posizioni con riferimenti nulli
   *  che impedirebbero il corretto funzionamento di addAttrezzo
   * @param nomeAttrezzo
   * @return riferimento all'attrezzo rimosso se presente nella borsa, null altrimenti
   */

  public Attrezzo removeAttrezzo(String nomeAttrezzo) {
	  Attrezzo a=this.attrezzi.remove(nomeAttrezzo);
	  if(a!=null)
		 this.numeroAttrezzi--;
	  return a;
	 
  }
  /**
   * Restituisce una mappa che associa ad un intero con un insieme(comunque non vuoro di attrezzi
   * ): tutti gli attrezzi nell'insieme hanno lo stesso peso ed è pari all'intero che figura
   * come chiave della mappa
   */
  public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPeso(){
	  Map<Integer,Set<Attrezzo>> mappa=new TreeMap<Integer,Set<Attrezzo>>();
	  
	  List<Attrezzo>lista=new LinkedList<Attrezzo>();
	  lista.addAll(this.getContenutoOrdinatoPerPeso());
	  
	  for(Attrezzo attrezzo:lista){
		  int pesoAttrezzo=attrezzo.getPeso();
		  	if(mappa.containsKey(pesoAttrezzo)){
		  		mappa.get(pesoAttrezzo).add(attrezzo);			  
		  	}
		  	else{
		  		Set <Attrezzo>listaAttrezzi=new HashSet<Attrezzo>();
		  		listaAttrezzi.add(attrezzo);
		  		mappa.put(pesoAttrezzo, listaAttrezzi);
			}
	  }
	  	return mappa;	  
  }
  public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPes1o() {
      Collection<Attrezzo> attrezzi = this.getAttrezzi();
      Map<Integer, Set<Attrezzo>> raggruppamento = new HashMap<Integer, Set<Attrezzo>>();
     
      Iterator<Attrezzo> it = attrezzi.iterator();
      while (it.hasNext()) {
              Attrezzo attrezzo = it.next();
              Set<Attrezzo> setAttrezzi;
              int peso = attrezzo.getPeso();
             
              if (raggruppamento.containsKey(peso)) {
                      setAttrezzi = raggruppamento.get(peso);
              } else {
                      setAttrezzi = new HashSet<Attrezzo>();
              }
             
              setAttrezzi.add(attrezzo);
              raggruppamento.put(peso, setAttrezzi);
      }
     
      return raggruppamento;
}
/**
 * restituisce una lista contente gli attrezzi ordinati per peso
 * @return List<Attrezzo>
 */
  public List<Attrezzo> getContenutoOrdinatoPerPeso() {
	  List<Attrezzo>lista=new LinkedList<Attrezzo>();
	  lista.addAll(this.attrezzi.values());
	  Collections.sort(lista);
	  return lista;	}
  /**
   * Restituisce una lista contenente gli attrezzi ordinati per noem	  
   */
  public List<Attrezzo> getContenutoOrdinatoPerNome(){
	  List<Attrezzo>lista=new LinkedList<Attrezzo>();
	  
	  lista.addAll(this.attrezzi.values());
	  OrdinatorePerNome ordinatore=new OrdinatorePerNome();
	  Collections.sort(lista, ordinatore);
	  return lista;
	  
  }
 public Collection<Attrezzo> getAttrezzi(){
	 return this.attrezzi.values();
 }
  /**
   * Stampa il contenuto della borsa a schermo
   */
  @Override
  public String toString() {
	  StringBuilder s = new StringBuilder();
	  List<Attrezzo>attrezzi=new LinkedList<Attrezzo>(this.attrezzi.values());
	  Collections.sort(attrezzi);
		if (!this.isEmpty()) {
     	  s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
	      for (Attrezzo a:attrezzi)
	      s.append(a.toString()+" ");
	  }
	  else
	      s.append("Borsa vuota");
	  return s.toString();
  }



  

}