package com.proyecto.rmi.db;
import java.sql.*;
  
public class ConnectionDB { 
	
   private static String bd = "libreriarmi";
   private static String login = "root";
   private static String password = "admin";
   private static String url = "jdbc:mysql://localhost/"+bd;
 
   private Connection connection = null;
  
   public ConnectionDB() {
      try{ 
         Class.forName("com.mysql.jdbc.Driver"); 
         connection = DriverManager.getConnection(url,login,password);
 
         if (connection!=null){
            System.out.println("Conexión a base de datos "+bd+" OK\n");
         }
      }
      catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
   }
   
   public Connection getConnection(){
      return connection;
   }
 
   public void desconectar(){
      connection = null;
   }
}