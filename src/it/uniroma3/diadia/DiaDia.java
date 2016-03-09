package it.uniroma3.diadia;


import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;
import it.uniroma3.diadia.comandi.FabbricaDiComandiSemplice;


/**
 *  Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 *  Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 *  Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes) *
 * @version 0.1
 */

public class DiaDia {
	private Partita partita;
	private InterfacciaUtente interfaccia;

    public DiaDia() {
    	this.partita = new Partita();
    	this.interfaccia=new InterfacciaUtenteConsole();
    	
    }

	public void gioca() {
		String istruzione; 
		this.interfaccia.mostraMessaggio(Labirinto.MESSAGGIO_BENVENUTO);

		do		
			istruzione = this.interfaccia.prendiIstruzione();
		while (!processaIstruzione(istruzione));
	}   
    

	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire=null;
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva();
			comandoDaEseguire = factory.costruisciComando(istruzione); 
			this.interfaccia.mostraMessaggio(comandoDaEseguire.esegui(this.partita)); //il supertipo comando eseguirˆ il metodo secondo
		                                          	//l'implementazione  del sottotipo corrente
		if (this.partita.vinta())
			this.interfaccia.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			this.interfaccia.mostraMessaggio("Hai esaurito i CFU, hai perso!");
		return 
				this.partita.isFinita();
	}


	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();


	}
	 

}