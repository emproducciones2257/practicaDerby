package mvcCRUDDerby;

import java.sql.*;

public class conexion {
	
	public conexion (String ruta) {
		
		rutaLocal = ruta;
	}
	
	public Connection getConexion () {

		try {
                        
                    
			// cargo el driver de la base de datos 
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			
			conexion = DriverManager.getConnection(rutaLocal);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("Fallo al crear la conexion");
		}

		return conexion;
	}
	
	private String rutaLocal;
	
	private Connection conexion = null;

}

