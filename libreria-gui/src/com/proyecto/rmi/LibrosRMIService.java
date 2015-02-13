package com.proyecto.rmi;

import java.rmi.*; 
import java.util.List;

import com.proyecto.rmi.db.Libro;
import com.proyecto.rmi.db.LibroDisponible;

public class LibrosRMIService { 
	
	public LibrosRMIService() {};
	
	public List<Libro> getLibrosEnVenta() {
		System.out.println("Se inicio el cliente Rmi");
		List<Libro> lstLibros = null;
		try {  
			LibrosInterface libroService = (LibrosInterface) Naming.lookup("//localhost/libroService");
			lstLibros = libroService.listarLibros();			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lstLibros ;
	} 
	
	public List<LibroDisponible> consultarStock(int libroId) {
		System.out.println("Se realizo consulta de libros");
		List<LibroDisponible> lstLibros = null;
		try {  
			LibrosInterface libroService = (LibrosInterface) Naming.lookup("//localhost/libroService");
			lstLibros = libroService.consultarStock(libroId);			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lstLibros ;
	} 
	
}
