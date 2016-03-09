package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaBuiaTest {
	private StanzaBuia stanza; 
	private Attrezzo lanterna,torcia;
	private StanzaBuia stanzino;
	private Stanza stanza1;
	@Before
	public void setUp() throws Exception {
		this.stanza=new StanzaBuia("stanza","lanterna");
		this.lanterna=new Attrezzo("lanterna",2);
		this.stanzino=new StanzaBuia("stanzino","torcia");
		this.torcia=new Attrezzo("torcia",4);
		this.stanza1=new Stanza("stanzino");
		
	}

	@Test
	public void test() {
		assertEquals(stanza.toString(),stanzino.toString());
		stanza.addAttrezzo(lanterna);
		stanzino.addAttrezzo(this.torcia);
		stanza.addAttrezzo(lanterna);
		this.stanza1.addAttrezzo(this.torcia);
		assertEquals(stanza1.toString(),stanzino.toString());
	}

}
