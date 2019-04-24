package mvcCRUDDerby;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import datos.modeloDatos;
import inicio.inicio;
import vista.vistaTabla;

public class crudBase extends inicio{
	
	public crudBase (vistaTabla v) {
		
		vista=v;
	
	}
	
	public void crearBase () {
		
				// en db creo la instruccion para crear la base, 
		
				String db = "jdbc:derby:"+ getProyecto() +";create=true";
				
				// creo una conexion en esta ruta especifica, en este caso en la carpeta del proyecto
				
				conesion = new conexion(db);
				
				objConnection = conesion.getConexion();
				
				// codigo para crear una tabla en la base
				
				String tabla = "CREATE TABLE Usuarios (ID INT PRIMARY KEY, NOMBRE VARCHAR (50), APELLIDOS VARCHAR (50), COLOR VARCHAR (50))";
				
				try {
					
					pre = objConnection.prepareStatement(tabla);
					
					pre.execute();
					
					objConnection.close();
						
					}catch (Exception e) {
						// TODO: handle exception
						System.out.println("Error al crear la base de datos");
						e.printStackTrace();
					}
	}
	
	
	
	public void cargarRegistro(modeloDatos d) {
		// TODO Auto-generated method stub
		//System.out.println("La ruta es: " + ruta);
		
		conesion = new conexion(getDb());
		
		objConnection = conesion.getConexion();
		
		try {
			
			pre=objConnection.prepareStatement(cargaRegistro);
			
			pre.setInt(1, d.getId());
			
			pre.setString(2, d.getNombre());
			
			pre.setString(3, d.getApellido());
			
			pre.setString(4, d.getColor());
			
			pre.execute();
			
			objConnection.close();
			
			System.out.println("Registro Cargado Correctamente");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("Registro No Cargado Correctamente");
		}
		
		leerRegistro();
		
	}
	
	public void leerRegistro() {
		// TODO Auto-generated method stub
		
		conesion = new conexion(getDb());
		
		objConnection=conesion.getConexion();
		
		try {
			
			pre= objConnection.prepareStatement(sqlLeer);
			
			rs= pre.executeQuery();
			
			/*while (rs.next()) {
				
				System.out.println(rs.getString("APELLIDOS"));

				Object filaTemporal []  = {rs.getInt("ID"),rs.getString("APELLIDOS"),rs.getString("NOMBRE"),rs.getString("COLOR")};

				filas.add(filaTemporal);
				

			}*/
			
			vista.propiedadTabla(rs);
			
			rs.close();
			
			objConnection.close();
			
			
			
		} catch (SQLException e) {
			
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ejecutarScript() {
		// TODO Auto-generated method stub
		
		conesion = new conexion(getDb());
		
		objConnection = conesion.getConexion();
		
		String var ="";
		
		try {
			
			
			FileReader archivoEntrada = new FileReader(new File("src/mvcCRUDDerby/scriptSQL.sql"));
			
			BufferedReader lecturaScript = new BufferedReader(archivoEntrada);
			
			while (lecturaScript.ready()) {
				
				var = lecturaScript.readLine();
				
				pre=objConnection.prepareStatement(var);
				
				pre.execute();
				
				System.out.println("Registro Cargado Correctamente");

			}
			objConnection.close();
			
		}catch (Exception e) {
			e.getMessage();
			
			System.out.println("no se encontro el archivo");

		}
		
		
		
		leerRegistro();
	}

	
	private String cargaRegistro ="INSERT INTO Usuarios (ID, NOMBRE, APELLIDOS, COLOR) VALUES (?,?,?,?)";
	
	private String sqlLeer = "SELECT * FROM Usuarios ORDER BY ID";
	
	private Connection objConnection;
	
	private conexion conesion;
	
	private vistaTabla vista;
	
	private PreparedStatement pre;
	
	private ResultSet rs;
	
	private ArrayList<Object []> filas;	
}
