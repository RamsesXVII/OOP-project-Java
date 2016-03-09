package it.uniroma3.diadia;
import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.OrdinatorePerNome;


public class BorsaTest {
	private List<Attrezzo>lista;
	private  Borsa eastpak;
	private  Borsa nike;
	private  Attrezzo astuccio;
	private  Attrezzo lavagna;
	private  Attrezzo penna=new Attrezzo("penna",1);

	public void setUp() throws Exception {
		this.nike=new Borsa();
		this.eastpak=new Borsa();
		
		this.astuccio=new Attrezzo("astuccio",2);
		this.lavagna=new Attrezzo("Lavagna",25);
		
		this.eastpak.addAttrezzo(astuccio);
		this.nike.addAttrezzo(astuccio);
		this.eastpak.addAttrezzo(penna);
	}

	public void testAddAttrezzo() {
		assertFalse(this.eastpak.hasAttrezzo("lavagna"));
		assertFalse(this.eastpak.addAttrezzo(this.lavagna));
		
		assertEquals(true,this.eastpak.addAttrezzo(this.astuccio));
		assertEquals(false,this.nike.addAttrezzo(lavagna));
		assertEquals(this.astuccio,this.nike.removeAttrezzo("astuccio"));
		assertEquals(null,this.nike.removeAttrezzo("lavagna"));
		assertEquals(null,this.nike.removeAttrezzo("maglia"));
		assertEquals(null,this.nike.removeAttrezzo("astuccio"));
		assertEquals(true,this.nike.addAttrezzo(astuccio));
		assertEquals(true,this.nike.addAttrezzo(astuccio));
		assertEquals(true,this.nike.addAttrezzo(astuccio));
		assertEquals(true,this.nike.addAttrezzo(astuccio));
		assertEquals(true,this.nike.addAttrezzo(astuccio));
		assertEquals(true,this.nike.addAttrezzo(astuccio));
		assertEquals(true,this.nike.addAttrezzo(astuccio));
		assertEquals(true,this.nike.addAttrezzo(astuccio));
		assertEquals(true,this.nike.addAttrezzo(astuccio));
		assertEquals(true,this.nike.addAttrezzo(astuccio));
		assertEquals(true,this.nike.addAttrezzo(astuccio));


	}

	@Test
	public void testGetPesoMax() {
		assertEquals(10,this.nike.getPesoMax());
		assertEquals(10,this.eastpak.getPesoMax());

	}

	@Test
	public void testGetAttrezzo() {
		assertEquals(this.penna,this.eastpak.getAttrezzo("penna"));
		assertEquals(null,this.nike.getAttrezzo("cellulare"));
		
	}

	@Test
	public void testGetPeso() {
		assertEquals(2,this.nike.getPeso());
		assertEquals(3,this.eastpak.getPeso());

	}

	@Test
	public void testIsEmpty() {
		assertEquals(/*ci sono oggetti nello zaino*/false,this.eastpak.isEmpty());
		assertEquals(/*ci sono oggetti nello zaino*/false,this.nike.isEmpty());
		
		this.eastpak.removeAttrezzo("penna");
		this.eastpak.removeAttrezzo("astuccio");
		assertEquals(true,this.eastpak.isEmpty());


	}

	@Test
	public void testHasAttrezzo() {
		assertEquals(true,this.eastpak.hasAttrezzo("astuccio"));
		assertEquals(true,this.eastpak.hasAttrezzo("penna"));
		assertEquals(false,this.eastpak.hasAttrezzo("computer"));


	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso(){
		assertEquals(2,this.eastpak.getNumeroAttrezzi());
		Attrezzo birra=new Attrezzo("birra",3);
		this.eastpak.addAttrezzo(birra);
		
		this.lista=new LinkedList<Attrezzo>();
		this.lista.addAll(this.eastpak.getContenutoOrdinatoPerPeso());
		
		assertEquals(3, this.lista.size());
		assertEquals(birra,Collections.max(lista));
		this.lista.add(new Attrezzo("masso",15));
		assertEquals(new Attrezzo("masso",32),Collections.max(lista));
		this.lista.add(new Attrezzo("aaaaa",32));
		assertEquals(new Attrezzo("aaaaa",32),Collections.max(lista));


	}
	@Test
	public void testGetContenutoOrdinatoPerNome(){
		Attrezzo birra=new Attrezzo("birra",3);
		this.eastpak.addAttrezzo(birra);
		this.lista=new LinkedList<Attrezzo>();
		this.lista.addAll(this.eastpak.getContenutoOrdinatoPerNome());
		
		assertTrue(this.lista.contains(this.astuccio));
		assertTrue(this.lista.contains(birra));
		assertTrue(this.lista.contains(this.penna));
		
		assertEquals(0,this.lista.indexOf(this.astuccio));
		assertEquals(1,this.lista.indexOf(birra));
		assertEquals(2,this.lista.indexOf(this.penna));

		Attrezzo abaco=new Attrezzo("abaco",1);
		this.lista.add(abaco);
		assertEquals(3,this.lista.indexOf(abaco));
		Collections.sort(this.lista, new OrdinatorePerNome());
		assertEquals(0,this.lista.indexOf(abaco));
		assertEquals(1,this.lista.indexOf(this.astuccio));
		assertEquals(2,this.lista.indexOf(birra));
		assertEquals(3,this.lista.indexOf(this.penna));
	}
	@Test
	public void testGetContenutoRaggruppatoPeso(){
		
		Attrezzo birra=new Attrezzo("birra",3);
		this.eastpak.addAttrezzo(birra);
		
		Attrezzo abaco=new Attrezzo("abaco",1);
		this.eastpak.addAttrezzo(abaco);
		
		Attrezzo cellulare=new Attrezzo("cellulare",1);
		this.eastpak.addAttrezzo(cellulare);
		
		Attrezzo cuffie=new Attrezzo("cuffie",1);
		this.eastpak.addAttrezzo(cuffie);
		
		  Map<Integer,Set<Attrezzo>> mappa=new TreeMap<Integer,Set<Attrezzo>>();
		  mappa.putAll(this.eastpak.getContenutoRaggruppatoPeso());
		  
		  assertTrue(mappa.containsKey(1));
		  assertTrue(mappa.containsKey(3));
		  assertTrue(mappa.containsKey(2));
		  assertFalse(mappa.containsKey(0));

		  Set<Attrezzo>listaAttrezzi=new HashSet<Attrezzo>();
		  listaAttrezzi.addAll(mappa.get(1));
		  
		  assertTrue(listaAttrezzi.size()==4);
		  assertTrue(listaAttrezzi.contains(abaco));
		  assertTrue(listaAttrezzi.contains(cellulare));
		  assertTrue(listaAttrezzi.contains(cuffie));
		  assertTrue(listaAttrezzi.contains(this.penna));
		  assertFalse(listaAttrezzi.contains(birra));
		  
		  listaAttrezzi.clear();
		  listaAttrezzi.addAll(mappa.get(3));
		  assertTrue(listaAttrezzi.size()==1);
		  assertTrue(listaAttrezzi.contains(birra));
		  
		  listaAttrezzi.clear();
		  listaAttrezzi.addAll(mappa.get(2));
		  assertTrue(listaAttrezzi.size()==1);
		  assertTrue(listaAttrezzi.contains(this.astuccio));

		  

		  




		
		
	}


}
