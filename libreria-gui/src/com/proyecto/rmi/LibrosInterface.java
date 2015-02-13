package com.proyecto.rmi;

import java.rmi.*;
import java.util.List;

import com.proyecto.rmi.db.Libro;
import com.proyecto.rmi.db.LibroDisponible;

public interface LibrosInterface extends Remote {
	
    public List<Libro> listarLibros () throws RemoteException; 
    public List<LibroDisponible> consultarStock(Integer libroId) throws RemoteException;
}
