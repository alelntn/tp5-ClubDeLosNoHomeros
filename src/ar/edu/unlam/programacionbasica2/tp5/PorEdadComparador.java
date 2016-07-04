package ar.edu.unlam.programacionbasica2.tp5;

import java.util.Comparator;

public class PorEdadComparador implements Comparator <Cliente>{
	
	@Override
	public int compare (Cliente unCliente, Cliente otroCliente){
		
		return unCliente.getEdad().compareTo(otroCliente.getEdad());
	}

}
