package com.proyecto.rmi.db;
 
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
  
public class LibrosDao implements Serializable{
	  
	private static final long serialVersionUID = 1L; 
	private Statement stmt = null;
	private ResultSet rs = null;
	private ConnectionDB conn = null; 
	
	public List<Libro> listarProductos(){
		
		conn = new ConnectionDB();
		List<Libro> lstLibros = new ArrayList<Libro>();
		
		try {
		    stmt = conn.getConnection().createStatement();
		    rs = stmt.executeQuery("SELECT * FROM Libros");
		    
		    while (rs.next()){
		    	Libro libro = new Libro();
		    	libro.setId(rs.getInt("id"));
		    	libro.setNombre(rs.getString("nombre")); 
		    	lstLibros.add(libro);
		    }
		    
		  
		}
		catch (SQLException ex){ 
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		finally { 

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;		        
		    }
		    conn.desconectar();
		}
		
		return lstLibros;
	}
	
	public List<LibroDisponible> consultarStock(int libroId){
		
		conn = new ConnectionDB();
		List<LibroDisponible> lstLibros = new ArrayList<LibroDisponible>();
		
		try {
		    stmt = conn.getConnection().createStatement();
		    rs = stmt.executeQuery("SELECT * FROM LibrosDisponibles where libro_id="+libroId);
		    
		    while (rs.next()){
		    	LibroDisponible libro = new LibroDisponible();
		    	libro.setId(rs.getInt("id"));
		    	libro.setIsbn(rs.getString("isbn"));
		    	libro.setFechaRegistro(rs.getDate("fecha_registro"));
		    	lstLibros.add(libro);
		    }
		    
		  
		}
		catch (SQLException ex){ 
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		finally { 

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;		        
		    }
		    conn.desconectar();
		}
		
		return lstLibros;
	}

}
