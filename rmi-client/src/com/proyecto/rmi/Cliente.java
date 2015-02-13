package com.proyecto.rmi;

import java.rmi.*; 
import java.util.List;

import com.proyecto.rmi.db.Libro;

public class Cliente { 
	
	public Cliente() {
		System.out.println("Se inicio el cliente Rmi");
		try { 
			InterfaceRemota objetoRemoto = (InterfaceRemota) Naming.lookup("//localhost/ObjetoRemoto");
			System.out.print("2 + 3 = ");
			System.out.println(objetoRemoto.suma(2, 3));
			
			LibrosInterface libroService = (LibrosInterface) Naming.lookup("//localhost/libroService");
			List<Libro> lst = libroService.listarLibros();
			
			for (Libro libro : lst) {
				System.out.println("Wuuuu "+libro.getNombre());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
}
