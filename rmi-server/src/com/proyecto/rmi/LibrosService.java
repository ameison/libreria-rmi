/*
 * ObjetoRemoto.java
 *
 * Created on 27 de abril de 2004, 21:18
 */

package com.proyecto.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import com.proyecto.rmi.db.Libro;
import com.proyecto.rmi.db.LibroDisponible;
import com.proyecto.rmi.db.LibrosDao;
 
public class LibrosService extends UnicastRemoteObject implements LibrosInterface{

	private static final long serialVersionUID = 1L;
	
	public LibrosService () throws RemoteException{
        super();
    }

	@Override
	public List<Libro> listarLibros() throws RemoteException { 
		LibrosDao dao = new LibrosDao();
		List<Libro> lstLibros = dao.listarProductos();
		return lstLibros;
	}
   
	@Override
	public List<LibroDisponible> consultarStock(Integer libroId) throws RemoteException { 
		LibrosDao dao = new LibrosDao();
		List<LibroDisponible> lstLibros = dao.consultarStock(libroId);
		return lstLibros;
	}

	public static void main(String[] args) throws RemoteException {
		LibrosService s = new LibrosService();
		List<LibroDisponible> l = s.consultarStock(1);
		for (LibroDisponible libroDisponible : l) {
			System.out.println(libroDisponible.getId());
			System.out.println(libroDisponible.getIsbn());
			System.out.println(libroDisponible.getFechaRegistro());
		}
		
	}
    
}
