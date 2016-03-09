package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaBloccataTest {
	StanzaBloccata stanza;
	private Attrezzo chiave;
	Stanza stanzaAdiacente;

	@Before
	public void setUp() throws Exception {
		this.stanza= new StanzaBloccata("libreria","sud","chiave");
		this.chiave=new Attrezzo("chiave",2);
		this.stanzaAdiacente=new Stanza("uscita");
		this.stanza.impostaStanzaAdiacente("sud",this.stanzaAdiacente);
	}

	@Test
	public void test() {
		assertEquals(this.stanza,this.stanza.getStanzaAdiacente("sud"));
		this.stanza.addAttrezzo(this.chiave);
		assertEquals(this.stanzaAdiacente,this.stanza.getStanzaAdiacente("sud"));
	}

}
