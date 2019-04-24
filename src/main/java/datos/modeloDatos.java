package datos;

public class modeloDatos {
	
	private int id;
	
	private String Nombre;
	
	private String Apellido;
	
	private String Color;
	
	

	@Override
	public String toString() {
		return "modeloDatos [id=" + id + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Color=" + Color + "]";
	}

	public modeloDatos(int id, String nombre, String apellido, String color) {
		super();
		this.id = id;
		Nombre = nombre;
		Apellido = apellido;
		Color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}
}
