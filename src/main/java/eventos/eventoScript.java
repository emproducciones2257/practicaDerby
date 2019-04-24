package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mvcCRUDDerby.*;
import vista.vistaTabla;

public class eventoScript implements ActionListener {
	
	 public eventoScript(vistaTabla vista) {
		// TODO Auto-generated constructor stub
		 
		 v=vista;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		crudBase script = new crudBase(v);
		
		script.ejecutarScript();

	}
	vistaTabla v;
}
