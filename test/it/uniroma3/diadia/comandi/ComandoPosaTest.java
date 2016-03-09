package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.giocatore.Borsa;

import org.junit.Before;
import org.junit.Test;

public class ComandoPosaTest {
	private Partita partita;
	private Attrezzo portaombrelli,lavagna,computer,libro,tavolo,ps4,automobile,quadro,divano,presa;


	@Before
	public void setUp() throws Exception {
		this.partita=new Partita();
		
		this.portaombrelli=new Attrezzo("portaombrelli",1);
		this.lavagna=new Attrezzo("lavagna",1);
		this.computer=new Attrezzo("Computer",1);
		this.libro=new Attrezzo("libro",1);
		this.tavolo=new Attrezzo("tavolo",1);
		this.ps4=new Attrezzo("ps4",1);
		this.automobile=new Attrezzo("automobile",1);
		this.quadro=new Attrezzo("quadro",1);
		this.divano=new Attrezzo("divano",1);
		this.presa=new Attrezzo("presa",1);
	}

	@Test
	public void test() {
		Borsa borsa=this.partita.getGiocatore().getBorsa();
		
		borsa.addAttrezzo(this.automobile);
		borsa.addAttrezzo(this.computer);
		borsa.addAttrezzo(this.divano);
		borsa.addAttrezzo(this.lavagna);
		borsa.addAttrezzo(this.libro);
		borsa.addAttrezzo(this.portaombrelli);
		borsa.addAttrezzo(this.ps4);
		borsa.addAttrezzo(this.quadro);
		borsa.addAttrezzo(this.tavolo);
		borsa.addAttrezzo(this.presa);

		
		ComandoPosa comando=new ComandoPosa();
		
		comando.setParametro("portaombrelli");
		comando.esegui(this.partita);
		comando.setParametro("lavagna");
		comando.esegui(this.partita);
		comando.setParametro("Computer");
		comando.esegui(this.partita);
		comando.setParametro("libro");
		comando.esegui(this.partita);
		comando.setParametro("tavolo");
		comando.esegui(this.partita);
		comando.setParametro("ps4");
		comando.esegui(this.partita);
		comando.setParametro("automobile");
		comando.esegui(this.partita);
		comando.setParametro("quadro");
		comando.esegui(this.partita);
		comando.setParametro("divano");
		comando.esegui(this.partita);
		comando.setParametro("presa");
		comando.esegui(this.partita);
		
		assertEquals(true,this.partita.getStanzaCorrente().hasAttrezzo(this.portaombrelli.getNome()));
		assertEquals(true,this.partita.getStanzaCorrente().hasAttrezzo(this.lavagna.getNome()));
		assertEquals(true,this.partita.getStanzaCorrente().hasAttrezzo(this.computer.getNome()));
		assertEquals(true,this.partita.getStanzaCorrente().hasAttrezzo(this.libro.getNome()));
		assertEquals(true,this.partita.getStanzaCorrente().hasAttrezzo(this.tavolo.getNome()));
		assertEquals(true,this.partita.getStanzaCorrente().hasAttrezzo(this.ps4.getNome()));
		assertEquals(true,this.partita.getStanzaCorrente().hasAttrezzo(this.automobile.getNome()));
		assertEquals(true,this.partita.getStanzaCorrente().hasAttrezzo(this.quadro.getNome()));
		assertEquals(true,this.partita.getStanzaCorrente().hasAttrezzo(this.divano.getNome()));
		assertEquals(true,this.partita.getStanzaCorrente().hasAttrezzo(this.presa.getNome()));
		
		assertEquals(false,borsa.hasAttrezzo("presa"));

	}

}
