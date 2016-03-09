package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

import org.junit.Before;
import org.junit.Test;

public class ComandoPrendiTest {
	private Partita partita;
	private Borsa borsa;
	private ComandoPrendi comando;
	private Attrezzo portaombrelli,lavagna,computer,libro,tavolo,ps4,automobile,quadro,divano,astuccio;

	@Before
	public void setUp() throws Exception {
		this.partita=new Partita();
		this.comando=new ComandoPrendi();
		/*creo attrezzi*/
		this.portaombrelli=new Attrezzo("portaombrelli",1);
		this.lavagna=new Attrezzo("lavagna",1);
		this.computer=new Attrezzo("Computer",1);
		this.libro=new Attrezzo("libro",1);
		this.tavolo=new Attrezzo("tavolo",1);
		this.ps4=new Attrezzo("ps4",1);
		this.automobile=new Attrezzo("automobile",1);
		this.quadro=new Attrezzo("quadro",1);
		this.divano=new Attrezzo("divano",1);
		this.astuccio=new Attrezzo("astuccio",1);
		
		Stanza stanza=this.partita.getStanzaCorrente();
		/*aggiungo gli attrezzi nella stanza*/
		stanza.addAttrezzo(this.automobile);
		stanza.addAttrezzo(this.computer);
		stanza.addAttrezzo(this.divano);
		stanza.addAttrezzo(this.lavagna);
		stanza.addAttrezzo(this.libro);
		stanza.addAttrezzo(this.portaombrelli);
		stanza.addAttrezzo(this.ps4);
		stanza.addAttrezzo(this.quadro);
		stanza.addAttrezzo(this.tavolo);
		stanza.addAttrezzo(this.astuccio);
		
		
	}

	@Test
	public void test() {
		this.borsa=this.partita.getGiocatore().getBorsa();
		
		this.comando.setParametro("portaombrelli");
		this.comando.esegui(this.partita);
		
		assertEquals(true,this.borsa.hasAttrezzo("portaombrelli"));
		
		this.comando.setParametro("lavagna");
		this.comando.esegui(this.partita);
		assertEquals(true,this.borsa.hasAttrezzo("lavagna"));

		this.comando.setParametro("Computer");
		this.comando.esegui(this.partita);
		assertEquals(true,this.borsa.hasAttrezzo("Computer"));

		this.comando.setParametro("libro");
		this.comando.esegui(this.partita);
		assertEquals(true,this.borsa.hasAttrezzo("libro"));

		this.comando.setParametro("tavolo");
		this.comando.esegui(this.partita);
		assertEquals(true,this.borsa.hasAttrezzo("tavolo"));

		this.comando.setParametro("ps4");
		this.comando.esegui(this.partita);
		assertEquals(true,this.borsa.hasAttrezzo("ps4"));

		this.comando.setParametro("automobile");
		this.comando.esegui(this.partita);
		assertEquals(true,this.borsa.hasAttrezzo("automobile"));

		this.comando.setParametro("quadro");
		this.comando.esegui(this.partita);
		assertEquals(true,this.borsa.hasAttrezzo("quadro"));
		
		this.comando.setParametro("astuccio");
		this.comando.esegui(this.partita);
		assertEquals(true,this.borsa.hasAttrezzo("astuccio"));

		this.comando.setParametro("divano");
		this.comando.esegui(this.partita);
		assertEquals(true,this.borsa.hasAttrezzo("divano"));


		
		assertEquals(10,this.borsa.getPeso());

		
		

	}

}
