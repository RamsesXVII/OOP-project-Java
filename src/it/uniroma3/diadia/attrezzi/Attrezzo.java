package it.uniroma3.diadia.attrezzi;


import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Una semplice classe che modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze
 * del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  Paolo Merialdo
 * @see Stanza
 * @version 0.1
 *
 */
public class Attrezzo implements Comparable<Attrezzo> {
   private String nome;
   private int peso;

  /**
   * Crea un attrezzo
   * @param nome il nome che identifica l'attrezzo
   * @param peso il peso dell'attrezzo
   */
   public Attrezzo(String nome, int peso) {
      this.peso = peso;
      this.nome = nome;
   }
   public void setNome(String nome){
	   this.nome=nome;
   }
   public void setPeso(int peso){
	   this.peso=peso;
   }
  /**
   * Restituisce il nome identificatore dell'attrezzo
   * @return il nome identificatore dell'attrezzo
   */
   public String getNome() {
      return this.nome;
   }

  /**
   * Restituisce il peso dell'attrezzo
   * @return il peso dell'attrezzo
   */
   public int getPeso() {
      return this.peso;
   }

   /**
	* Restituisce una rappresentazione stringa di questo attrezzo
	* @return la rappresentazione stringa
	*/
   @Override
   public String toString() {
		  return this.getNome();
	   }
   @Override
   public boolean equals(Object o){
	   Attrezzo that=(Attrezzo)o;
	   return that.getNome().equals(this.getNome());
   }
   @Override
   public int hashCode(){
	   return this.nome.hashCode();
   }
   /**
    * <0 se oggetto corrente  minore di that
    */
   @Override
   public int compareTo(Attrezzo that) {
	if(this.peso==that.getPeso())
		return this.getNome().compareTo(that.getNome());
	else
		return this.getPeso()-that.getPeso();
	
}

   

}