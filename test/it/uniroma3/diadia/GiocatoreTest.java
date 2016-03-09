package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {
	private Giocatore player;
	private Giocatore giocatore;
	@Before
	public void setUp() throws Exception {
		Attrezzo spada=new Attrezzo("Spada",15);
		this.giocatore=new Giocatore();
		this.player=new Giocatore();
		this.player.setCfu(12);
		this.giocatore.setCfu(0);
		this.giocatore.getBorsa().addAttrezzo(spada);
	}

	@Test
	public void testGetCfu() {
		assertEquals(0,this.giocatore.getCfu());
		assertEquals(12,this.player.getCfu());

	}


}
