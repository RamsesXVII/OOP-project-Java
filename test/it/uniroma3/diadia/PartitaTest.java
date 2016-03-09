package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;

import org.junit.Before;
import org.junit.Test;

public class PartitaTest {
	private Partita partita_vincente;
	private Partita partita_persa;
	private Stanza stanza;

	@Before
	public void setUp() throws Exception {
		/*inizializzo due partite*/
		this.partita_vincente=new Partita();
		this.partita_persa=new Partita();
		/*imposto un valore di CFU per cui la partita è persa*/
		this.partita_persa.getGiocatore().setCfu(0);
		/*imposto come stanza corrente la stanza vincente*/
		this.partita_vincente.setStanzaCorrente(this.partita_vincente.getStanzaVincente());
		this.stanza=this.partita_vincente.getStanzaVincente();
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("La stanza vincente non è corretta",this.stanza,this.partita_vincente.getStanzaVincente());

	}

	@Test
	public void testVinta() {
		assertEquals(true,this.partita_vincente.vinta());
		assertEquals(false,this.partita_persa.vinta());

	}

	@Test
	public void testIsFinita() {
		assertEquals(true,this.partita_persa.isFinita());
		assertEquals(true,this.partita_vincente.isFinita());
	}

	@Test
	public void testGetCfu() {
		assertEquals(0,this.partita_persa.getGiocatore().getCfu());
		assertEquals(20,this.partita_vincente.getGiocatore().getCfu());		
	}

}
