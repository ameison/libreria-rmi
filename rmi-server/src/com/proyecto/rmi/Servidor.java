  
package com.proyecto.rmi;

import java.rmi.*;  
  
public class Servidor{
	
	/**Para ejecutar el proyecto:
     * 0.- Matar proceso: fuser -n tcp -k 1099
     * 1.- Generar el stub ubicado en la carpeta de proyecto (bin) donde estan los .class para los servicios remotos:  
            -> rmic com.proyecto.rmi.LibrosService
     * 2.- Poner en la variable de entorno CLASSPATH el directorio en el que está nuestra clase ObjetoRemoto y class de Mysql
            -> CLASSPATH=/home/abcdroid/workspace-rmi/rmi-server/bin
            
	 * 3.- Iniciar el servidor desde la ruta de paquete de clases (/home/abcdroid/workspace-rmi/rmi-server/bin/):
            -> rmiregistry 
       4.- Agregar al cliente los stubs !! 
            
	 */
     
    public Servidor() {
    	
    	System.out.println("Se ha iniciado el Servidor Rmi");
    	
        try {
        	System.setProperty("java.rmi.server.codebase", "file://home/abcdroid/workspace-rmi/rmi-server/bin/");
        	  
            LibrosInterface libroService = new LibrosService(); 
            Naming.rebind ("//localhost/libroService", libroService); 
			
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Servidor();
    }
}
