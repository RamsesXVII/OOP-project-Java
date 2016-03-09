package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {
private Stanza atrio,aula,campus;
private Attrezzo portaombrelli,lavagna,computer,libro,tavolo,ps4,automobile,quadro,divano,webcam,cappello;
	@Before
	public void setUp() throws Exception {
		/*Creo camere*/
		this.atrio=new Stanza("atrio");
		this.campus=new Stanza("campus");
		this.aula=new Stanza("aula");
		/*Creo oggetti*/
		this.portaombrelli=new Attrezzo("portaombrelli",2);
		this.lavagna=new Attrezzo("lavagna",20);
		this.computer=new Attrezzo("Computer",4);
		this.libro=new Attrezzo("libro",2);
		this.tavolo=new Attrezzo("tavolo",1);
		this.ps4=new Attrezzo("ps4",3);
		this.automobile=new Attrezzo("automobile",200);
		this.quadro=new Attrezzo("quadro",2);
		this.divano=new Attrezzo("divano",40);
		this.webcam=new Attrezzo("webcam",1);
		this.cappello=new Attrezzo("cappello",1);
		/*Imposto direzioni*/
		this.atrio.impostaStanzaAdiacente("sud", campus);
		this.campus.impostaStanzaAdiacente("nord",atrio);
		this.atrio.impostaStanzaAdiacente("est",aula);
		this.aula.impostaStanzaAdiacente("ovest",atrio);
		/*Aggiungo attrezzo*/
		this.atrio.addAttrezzo(this.portaombrelli);
		this.campus.addAttrezzo(this.computer);
		this.aula.addAttrezzo(this.lavagna);	

		
	}

	@Test
	public void testGetStanzaAdiacente() {
		assertEquals("Le stanze non corrispondono",campus,this.atrio.getStanzaAdiacente("sud"));
		assertEquals("Le stanze non corrispondono",atrio,this.campus.getStanzaAdiacente("nord"));
		assertEquals("Le stanze non corrispondono",null,this.campus.getStanzaAdiacente("ndord"));
		assertEquals("Le stanze non corrispondono",aula,this.atrio.getStanzaAdiacente("est"));
		assertEquals("Le stanze non corrispondono",atrio,this.aula.getStanzaAdiacente("ovest"));
}

	@Test
	public void testGetNome() {
		assertEquals("il nome della stanza aula non corrisponde","aula",this.aula.getNome());
		assertEquals("il nome della stanza campus non corrisponde","campus",this.campus.getNome());
		assertEquals("il nome della stanza atrio non corrisponde","atrio",this.atrio.getNome());

	}

	
	@Test
	public void testHasAttrezzo(){
		assertEquals("Attrezzo non presente",true,this.aula.hasAttrezzo("lavagna"));
		assertEquals("Attrezzo non presente",false,this.campus.hasAttrezzo("lavagna"));

		
	}
	@Test
	public void testaddAttrezzo(){
		assertEquals(true,this.aula.removeAttrezzo(lavagna));
		assertFalse(this.aula.hasAttrezzo("lavagna"));

		assertEquals(true,this.aula.addAttrezzo(this.lavagna));
		assertTrue(this.aula.hasAttrezzo("lavagna"));
		
		assertEquals("ERRORE:l'attrezzo viene aggiunto anche se giˆ presente",false,this.campus.addAttrezzo(this.computer));
		assertEquals(true,this.atrio.addAttrezzo(this.computer));
		assertEquals(true,this.atrio.addAttrezzo(this.lavagna));
		assertEquals(true,this.atrio.addAttrezzo(this.libro));
		assertEquals(true,this.atrio.addAttrezzo(this.tavolo));
		assertEquals(true,this.atrio.addAttrezzo(this.ps4));
		assertEquals(true,this.atrio.addAttrezzo(this.automobile));
		assertEquals(true,this.atrio.addAttrezzo(this.quadro));
		assertEquals(true,this.atrio.addAttrezzo(this.divano));
		assertEquals("divano",this.atrio.getAttrezzo("divano").getNome());
		assertEquals(true,this.atrio.addAttrezzo(this.webcam));
		assertEquals(true,this.atrio.addAttrezzo(this.cappello));
		assertEquals(true,this.atrio.removeAttrezzo(portaombrelli));
		assertEquals(false,this.atrio.removeAttrezzo(portaombrelli));
		assertEquals(true,this.atrio.removeAttrezzo(tavolo));
		assertEquals(false,this.atrio.removeAttrezzo(tavolo));
		assertEquals(true,this.atrio.removeAttrezzo(lavagna));
		assertEquals(true,this.atrio.addAttrezzo(this.lavagna));
		assertEquals(true,this.atrio.addAttrezzo(this.tavolo));
		assertEquals(true,this.atrio.addAttrezzo(this.portaombrelli));
		assertEquals(false,this.atrio.addAttrezzo(this.portaombrelli));

		assertEquals("NON C'E OVERFLOW",false,this.atrio.addAttrezzo(this.cappello));

	}
	@Test
	public void testremoveAttrezzo(){
		assertEquals(true,this.atrio.removeAttrezzo(portaombrelli));
		assertEquals(false,this.atrio.removeAttrezzo(portaombrelli));
		assertEquals(false,this.campus.removeAttrezzo(portaombrelli));

	}

}


