package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

import org.junit.Before;
import org.junit.Test;

public class ComandoVaiTest {
	private Partita partita;
	private Stanza corrente,successiva;

	@Before
	public void setUp() throws Exception {
		this.partita=new Partita();
		this.corrente=new Stanza("laboratorio");
		this.successiva=new Stanza("mensa");
		this.corrente.impostaStanzaAdiacente("nord",this.successiva);
	}

	@Test
	public void test() {
		
		Stanza attesa= this.partita.getStanzaCorrente().getStanzaAdiacente("sud");
		ComandoVai comando=new ComandoVai();
		comando.setParametro("sud");
		comando.esegui(partita);
		assertEquals(attesa,this.partita.getStanzaCorrente());
	}

}
