package it.uniroma3.diadia.attrezzi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class AttrezzoTest {
	private Attrezzo attrezzo;
	private Attrezzo attrezzo1;

	@Before
	public void setUp() throws Exception {
		this.attrezzo=new Attrezzo("Spada",15);
		this.attrezzo1=new Attrezzo("Osso",2);
	}

	@Test
	public void testGetNome() {
		assertEquals("Il nome è sbagliato","Spada",this.attrezzo.getNome());
		assertEquals("Il nome è sbagliato","Osso",this.attrezzo1.getNome());

	}

	@Test
	public void testGetPeso() {
		assertEquals("Il peso è sbagliato",15,this.attrezzo.getPeso());
		assertEquals("Il peso è sbagliato",2,this.attrezzo1.getPeso());

	}



}
