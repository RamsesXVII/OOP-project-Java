package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaMagicaTest {
	private StanzaMagica stanza;
	private Attrezzo borsa;
	private Attrezzo chiave;

	@Before
	public void setUp() throws Exception {
		
		this.stanza=new StanzaMagica("Matrix",1);
		
		/*creo attrezzi*/
		this.chiave=new Attrezzo("chiave",2);
		this.borsa=new Attrezzo("borsa",2);
	}
	@Test
	public void testAddAttrezzo() {
		
		this.stanza.addAttrezzo(this.borsa);	
		this.stanza.addAttrezzo(this.chiave);	
		
		assertEquals("borsa",this.stanza.getAttrezzo("borsa").getNome());
		assertEquals(2,this.stanza.getAttrezzo("borsa").getPeso());

		assertEquals("evaihc",this.stanza.getAttrezzo("evaihc").getNome());
		assertEquals(4,this.stanza.getAttrezzo("evaihc").getPeso());
	}
}
