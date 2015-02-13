package com.proyecto.gui;
   
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.awt.image.BufferedImage;
import java.io.File; 
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.proyecto.rmi.LibrosRMIService;
import com.proyecto.rmi.db.Libro;

public class Dashboard extends JFrame implements ActionListener {
	
	// **** Swing -> http://www.javamex.com/tutorials/swing/components.shtml 
	
	//Rmi: basico
	//http://chuwiki.chuidiang.org/index.php?title=Conceptos_b%C3%A1sicos_de_rmi
	//http://www.chuidiang.com/java/rmi/rmi.php
	//http://profesores.elo.utfsm.cl/~agv/elo330/2s05/projects/CesarVasquez/sitio_web/ejemplo.html
	//http://www.codejava.net/java-se/swing/jlist-custom-renderer-example
	private static final long serialVersionUID = 1L;
	private static final String IMG_PATH = "src/lib-background.jpg";
	
	private JPanel panelMenu, panelLista; 
	private JButton botonRecargar;
	private JButton botonConsultarStock;
	private JList<Libro> listaNombres;
	private DefaultListModel<Libro> modelo;
	private JScrollPane scrollLista; 
	private Dashboard dashboard; 
	private LibrosRMIService libroService = new LibrosRMIService();
	
	public Dashboard() { 
		iniciarComponentes(); 
		setTitle(":: Sistema de Venta de Libros ::"); 
		setSize(600, 300); 
		setLocationRelativeTo(null);
	}

	public void setVentanaPrincipal(Dashboard dashboard) {
		this.dashboard = dashboard;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void iniciarComponentes() { 
		getContentPane().setLayout(null);
		modelo = new DefaultListModel();
		
		panelMenu = new JPanel();
		panelMenu.setBounds(10, 10, 400, 40);
		panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.X_AXIS)); 
		panelLista = new JPanel();
		panelLista.setBounds(10, 50, 500, 200);
		panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.X_AXIS)); 
 
		listaNombres = new JList();  
		listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION ); 
		cargarLista(libroService.getLibrosEnVenta());
		scrollLista = new JScrollPane(); 
		scrollLista.setViewportView(listaNombres);

		botonRecargar = new JButton();
		botonRecargar.setText("Recargar");
		botonRecargar.setBounds(100, 80, 80, 23);
		botonRecargar.addActionListener(this);
		
		botonConsultarStock = new JButton();
		botonConsultarStock.setText("Consultar Stock");
		botonConsultarStock.setBounds(100, 80, 80, 23);
		botonConsultarStock.addActionListener(this); 
		
		 
		JLabel labelImg = new JLabel();
		try{
			BufferedImage img = ImageIO.read(new File(IMG_PATH));
	        ImageIcon icon = new ImageIcon(img);
			labelImg = new JLabel(icon);
			labelImg.setBounds(80, 20, 180, 23);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		getContentPane().add(panelMenu);
		getContentPane().add(panelLista);
		
		panelMenu.add(botonRecargar);
		panelMenu.add(botonConsultarStock);
		panelLista.add(scrollLista);
		panelLista.add(labelImg); 
	} 
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == botonConsultarStock) {  
			Libro libro = listaNombres.getSelectedValue();  
			if(libro!=null){
				Dialogo miVentanaConfirmacion = new Dialogo(dashboard, true, libro);
				miVentanaConfirmacion.setVisible(true);
			}
			
		}else if(evento.getSource() == botonRecargar) { 
			cargarLista(libroService.getLibrosEnVenta());
		} 
		 
	}
	 
	private void cargarLista(List<Libro> lista) {
		modelo.clear();
		for (Libro libro : lista) {
			modelo.addElement(libro); 
		}
		listaNombres.setModel(modelo);
	}
}

