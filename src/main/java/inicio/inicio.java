package inicio;

import java.io.File;

import mvcCRUDDerby.crudBase;
import vista.vistaTabla;

public class inicio {
	
	private static String proyecto;
	
	private static String db;
	
	public static String getProyecto() {
		return proyecto;
	}

	public static String getDb() {
		return db;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		vistaTabla vista = new vistaTabla(getDb());
		
		vista.setVisible(true);
		
		// esta instruccion me almacena el separador, osea barra en windows
		
		String barra = File.separator;
		
		// localizo donde tengo la carpeta del proyecto
		
		proyecto = System.getProperty("user.dir")+barra+"registro";
		
		db = "jdbc:derby:"+ proyecto;
		
		//con esta instruccion almaceno, si existe, esa ruta en file
		File url = new File(proyecto);

		if (url.exists()) {
			
			crudBase crud = new crudBase(vista);
			
			crud.leerRegistro();

		}else {
			
			crudBase crud = new crudBase(vista);
			
			crud.crearBase();
			
			System.out.println("Base de datos creada correctamente");

		}

	}
}
