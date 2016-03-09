package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LabirintoTest {
	private Labirinto labirinto;
	private Labirinto labirinto1;
	private Stanza stanzavincente;
	private Stanza stanzacorrente;
	private Stanza stanzavincente1;
	private Stanza stanzacorrente1;
	@Before
	public void setUp() throws Exception {
		this.labirinto=new Labirinto();
		this.labirinto1=new Labirinto();
		this.stanzacorrente=this.labirinto.getStanzaCorrente();
		this.stanzavincente=this.labirinto.getStanzaVincente();
		this.stanzacorrente1=this.labirinto1.getStanzaCorrente();
		this.stanzavincente1=this.labirinto1.getStanzaVincente();
		
	}

	@Test
	public void testGetStanzaCorrente() {
		assertEquals(this.stanzacorrente,this.labirinto.getStanzaCorrente());
		assertEquals(this.stanzacorrente1,this.labirinto1.getStanzaCorrente());
		
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals(this.stanzavincente1,this.labirinto1.getStanzaVincente());
		assertEquals(this.stanzavincente,this.labirinto.getStanzaVincente());
	}

}
