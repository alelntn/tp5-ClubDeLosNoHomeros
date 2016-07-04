package ar.edu.unlam.programacionbasica2.tp5;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class ClubDeLosNoHomerosTest {

	@Test
	public void testQueElBarAbraSinClientes(){
		
		Bar miBar = new Bar();
				
		Assert.assertFalse(miBar.getEstado());		
		miBar.abrirBar();		
		Assert.assertTrue(miBar.getEstado());		
	}
	
	@Test
	public void testQueNoSeAdmitanClientesDeIgualNombre(){
		
		Bar miBar = new Bar();
		miBar.abrirBar();
		
		Cliente Cliente1 = new Cliente("Pablo",33);
		Cliente Cliente2 = new Cliente("Jose",25);
		Cliente Cliente3 = new Cliente("Pablo",20);
		Cliente Cliente4 = new Cliente("Jose",30);
		miBar.admitirCliente(Cliente1);
		miBar.admitirCliente(Cliente2);
		miBar.admitirCliente(Cliente3);
		miBar.admitirCliente(Cliente4);
		
		//System.out.println(miBar.lista);
		Assert.assertEquals(2, miBar.lista.size());		
	}
	
	@Test
	public void testQueLosClientesEstenOrdenadosAlfabeticamente(){
		
		Bar miBar = new Bar();
		miBar.abrirBar();
				
		Cliente Cliente1 = new Cliente("Pablo",33);
		Cliente Cliente2 = new Cliente("Jose",25);
		Cliente Cliente3 = new Cliente("Diego",20);		
		miBar.admitirCliente(Cliente1);
		miBar.admitirCliente(Cliente2);
		miBar.admitirCliente(Cliente3);
		
		//System.out.println(miBar.lista);		
		assertEquals("Diego",miBar.lista.first().getNombre());
     }
	
	@Test
	public void testQueLosClientesEstenOrdenadosPorEdad(){
		
		Bar miBar = new Bar();	
		miBar.abrirBar();
		
		Cliente Cliente1 = new Cliente("Diego",40);
		Cliente Cliente2 = new Cliente("Jose",55);
		Cliente Cliente3 = new Cliente("Pablo",33);		
		miBar.admitirCliente(Cliente1);
		miBar.admitirCliente(Cliente2);
		miBar.admitirCliente(Cliente3);		
				
		miBar.lista = miBar.ordenarPorEdad(miBar.lista);
		
		//System.out.println(miBar.lista);				
		Assert.assertEquals(33,miBar.lista.first().getEdad(), 0.01);				
	}
		
	@Test
	public void testQueComparaClientes(){
	
		Bar miBar = new Bar();	
		miBar.abrirBar();
		
		Cliente Cliente1 = new Cliente("Pablo",55);  //en bar
		Cliente Cliente2 = new Cliente("Pablo",35);  //no está en bar
		Cliente Cliente3 = new Cliente("Pablo",50);	 //no está en bar
		miBar.admitirCliente(Cliente1);
		miBar.admitirCliente(Cliente2);
				
		Assert.assertFalse(Cliente1.equals(Cliente2));
		Assert.assertFalse(Cliente2.equals(Cliente3));
	}	
}
