package com.proyecto.gui;
  
import java.awt.GridBagConstraints;
import java.util.Date;
import java.util.List;  

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener; 
import javax.swing.table.TableModel;

import com.proyecto.rmi.LibrosRMIService;
import com.proyecto.rmi.db.Libro;
import com.proyecto.rmi.db.LibroDisponible;

public class Dialogo extends JDialog {
	 
	private static final long serialVersionUID = 1L; 
	private JLabel labelTotalLibros;
	private JLabel labelNombreLibro;
	private JPanel panelMenu; 
	private LibrosRMIService libroService = new LibrosRMIService();
	List<LibroDisponible> lstLibrosStock ;
	
	public Dialogo(Dashboard miVentanaPrincipal, boolean modal, Libro libro) { 
		
		super(miVentanaPrincipal, modal);
		setTitle(":: Consulta de Stock ");
		
		panelMenu = new JPanel();
		panelMenu.setBounds(10, 10, 400, 40);
		panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS)); 
		getContentPane().add(panelMenu);
		 
		labelNombreLibro = new JLabel();
		labelNombreLibro.setBounds(10, 10, 180, 23);
		labelNombreLibro.setText("Libro buscado: "+libro.getNombre());
	
		//_____________ Tabla ____________
        GridBagConstraints restricciones = new GridBagConstraints(); 
        restricciones.gridx = 0;
        restricciones.gridy = 0;
        restricciones.gridwidth = GridBagConstraints.REMAINDER;
        restricciones.fill = GridBagConstraints.BOTH;
        restricciones.weightx = 1.0;
        restricciones.weighty = 1.0;
		
		lstLibrosStock = libroService.consultarStock(libro.getId()); 
		MiModelo modelo = new MiModelo();
	    JScrollPane scroll = new JScrollPane();
		JTable tabla = new JTable(modelo);
		scroll.setViewportView(tabla);
        scroll.setColumnHeaderView (tabla.getTableHeader()); 
		  
        labelTotalLibros = new JLabel();
		labelTotalLibros.setText(lstLibrosStock.size()+" libros encontrados");
		 
		panelMenu.add(labelNombreLibro);
		panelMenu.add(scroll, restricciones);
		panelMenu.add(labelTotalLibros);
		
		setSize(350, 150); 
		setLocationRelativeTo(null);
	}
	
	class MiModelo implements TableModel{

		@Override
		public void addTableModelListener(TableModelListener arg0) { }

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public Class getColumnClass(int columnIndex) { 
	        switch (columnIndex){
	            case 0:
	                // La columna cero contiene el Id
	                // un Int
	                return Integer.class;
	            case 1:
	                // La columna uno contiene el Isbn
	                // un String
	                return String.class;
	            case 2:
	                // La columna dos contine la fecha
	                // Date
	                return Date.class;
	            default:
	                // Devuelve una clase Object por defecto.
	                return Object.class;
	        }
	    }

		@Override
		public int getColumnCount() { return 3; }

		@Override
		public String getColumnName(int columnIndex){
	        switch (columnIndex){
	            case 0:
	                return "Id";
	            case 1:
	                return "ISBN";
	            case 2:
	                return "F.Registro";
	            default:
	                return null;
	        }
	    }
		@Override
		public int getRowCount() { return lstLibrosStock.size(); }
		
		@Override
		public boolean isCellEditable(int arg0, int arg1) { return false; }

		@Override
		public void removeTableModelListener(TableModelListener arg0) { }

		@Override
		public Object getValueAt(int fila, int columna) {
			LibroDisponible l= (LibroDisponible )lstLibrosStock.get(fila);	
			 
			switch (columna) { 
	           case 0:                                                      
	               return l.getId(); 
	           case 1:                                                       
	        	   return l.getIsbn(); 
	           case 2:                                                       
	        	   return l.getFechaRegistro(); 
			}
			return null;
		}
 
		@Override
		public void setValueAt (Object dato, int fila, int columna) {
 
			System.out.println(">>> "+lstLibrosStock.get(fila).getIsbn());
			LibroDisponible l= (LibroDisponible )lstLibrosStock.get(fila);	      
			switch (columna) { 
	           case 0:                                                      
	               l.setId((Integer)dato);
	               break; 
	           case 1:    
	        	   l.setIsbn((String)dato);
	               break; 
	           case 2:             
	        	   l.setFechaRegistro((Date)dato);
	               break;
	        }


	        // Aquí hay que avisar a los sucriptores del cambio. 
	        // Ver unpoco más abajo cómo.
	    }


	}
	 
}