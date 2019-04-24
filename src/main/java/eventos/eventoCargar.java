package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import datos.modeloDatos;
import inicio.inicio;
import mvcCRUDDerby.crudBase;
import vista.vistaTabla;

public class eventoCargar extends inicio implements ActionListener  {
	
	public eventoCargar(vistaTabla v) {
		super();
		this.v = v;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		modelo = new modeloDatos(v.getTextID(), v.getTextNombre(), v.getTextApellido(), v.getTextColor());
		
		System.out.println(modelo.toString());
		
		crudBase crud = new crudBase(v);
		
		crud.cargarRegistro(modelo);
		
	}
	
	vistaTabla v;
	
	modeloDatos modelo;

}