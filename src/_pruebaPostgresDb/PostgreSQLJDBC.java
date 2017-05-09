package _pruebaPostgresDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PostgreSQLJDBC {
	
	public static void main(String args[]) {
		Connection c = null;
		Statement stmt = null;
		String sql = null;
		
		try {
		     Class.forName("org.postgresql.Driver");
		     c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/dbPrueba", "postgres", "admin");
		     System.out.println("Opened database c, schema length:" + c.getSchema().length());
		 
		     stmt = c.createStatement();
		     
		     /**
		      * Creacion tabla prueba
		      * 
		      */
		     sql = new String("CREATE TABLE prueba " +
		    		 "(codigo INT PRIMARY KEY     NOT NULL," +
		    		 " descripcion           CHAR(50)     NOT NULL, " +
	    		 	 " numero         REAL)");
		     stmt.executeUpdate(sql);
		     
		     /**
		      * insert sobre tabla de prueba	
		      */
		     sql = new String("INSERT INTO prueba (codigo, descripcion, numero) VALUES (100, 'insert por sist', 100.1)"); 
		     stmt.executeUpdate(sql);
		     
		     stmt.close();
		     c.close();
		     
		  } catch (Exception e) {
		     e.printStackTrace();
		     System.err.println(e.getClass().getName()+": "+e.getMessage());
		     System.exit(0);
		  } finally {
			  System.out.println("Closed database successfully");
		  }
   }
	
}

