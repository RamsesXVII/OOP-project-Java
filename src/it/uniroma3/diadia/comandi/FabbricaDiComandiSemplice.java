package it.uniroma3.diadia.comandi;

import java.util.Scanner;
/**
 * Classe che costruisce un comando in base alla stringa digitata, lo scanner
 *  spezza il messaggio in due parole è una parola formata da nome+parametro e in base
 *  al tipo di istruzione crea un' istanza della relativa classe. Tale classe ha la propria 
 *  implementazione dell'interface Comando permettendo quindi a DiaDia di gestire soltanto il 
 *  supertipo comando 
 *   
 * @author mattiaiodice
 *
 */
public class FabbricaDiComandiSemplice implements FabbricaDiComandi {
	
	@Override
	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione); 
		
		String nomeComando = null;
		String parametro = null;
		
		Comando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();// seconda parola: eventuale parametro
		
		if (nomeComando == null)
			comando = new ComandoNonValido();
		else if (nomeComando.equals("vai"))      //TODO non bisogna passare un parametro ?
			comando = new ComandoVai(); 
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi(); 
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa();
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto();
		else if(nomeComando.equals("interagisci"))
			comando=new ComandoInteragisci();
		else if(nomeComando.equals("saluta"))
			comando=new ComandoSaluta();
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if (nomeComando.equals("borsa"))
			comando = new ComandoMostraContenutoBorsa();
		else if (nomeComando.equals("cfu"))
			comando = new ComandoMostraCFU();
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda();
		else if (nomeComando.equals("regala"))
			comando = new ComandoRegala();
		else comando = new ComandoNonValido();
		
		comando.setParametro(parametro);
		
		return comando;
}
}