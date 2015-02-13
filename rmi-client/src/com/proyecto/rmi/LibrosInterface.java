package com.proyecto.rmi;

import java.rmi.*;
import java.util.List;

import com.proyecto.rmi.db.Libro;

public interface LibrosInterface extends Remote {
	
    public List<Libro> listarLibros () throws RemoteException; 
}
