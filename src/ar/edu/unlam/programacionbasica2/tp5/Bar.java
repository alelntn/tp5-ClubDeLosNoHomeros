package ar.edu.unlam.programacionbasica2.tp5;

import java.util.TreeSet;

public class Bar {
	
	private boolean estado;
	TreeSet<Cliente> lista;
		
	public Bar (){
		this.setEstado(false);
		lista = new TreeSet<Cliente>() ;
	}

	public void abrirBar(){
		if(lista.isEmpty()){
			this.setEstado(true);
		}	
	}
	
	public void admitirCliente(Cliente nuevo){
		if (estado == true)
		lista.add(nuevo);		
	}		
		
	public void imprimirClientes(TreeSet<Cliente> lista){		
		for (Cliente cli : lista){
			System.out.println(cli.getNombre()+ " " + cli.getEdad());
		}
	}
	
	public TreeSet<Cliente> ordenarPorEdad(TreeSet<Cliente> lista){
		
		PorEdadComparador compar = new PorEdadComparador();
		TreeSet<Cliente> nuevaLista = new TreeSet<Cliente>(compar);
		
		nuevaLista.addAll(lista);		
		//imprimirClientes(nuevaLista);
		return nuevaLista;					
	}
	
	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}	
}
