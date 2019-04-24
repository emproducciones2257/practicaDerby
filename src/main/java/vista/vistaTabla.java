package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import eventos.eventoCargar;
import eventos.eventoScript;
import inicio.inicio;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;

public class vistaTabla extends JFrame {
	
	
	//----------------------CAMPOS DE CLASE---------------------------------------------------
	
	
	private JPanel contentPane;
	JTable table = new JTable();
	private JTextField textID;
	private JTextField textApellido;
	private JTextField textNombre;
	private JTextField textColor;
	
//----------------------GETER SETER----------------------------------------------------

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public int getTextID() {
		
		return Integer.parseInt(textID.getText());
	}

	public void setTextID(JTextField textID) {
		this.textID = textID;
	}

	public String getTextApellido() {
		
		return textApellido.getText();
	}

	public void setTextApellido(JTextField textApellido) {
		this.textApellido = textApellido;
	}

	public String getTextNombre() {
		
		return textNombre.getText();
	}

	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	public String getTextColor() {
		
		return textColor.getText();
	}

	public void setTextColor(JTextField textColor) {
		this.textColor = textColor;
	}
	

	//----------------------METODOS----------------------------------------------------	
	public vistaTabla(String ruta) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 11, 574, 245);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblID = new JLabel("Id");
		lblID.setBounds(47, 287, 46, 14);
		contentPane.add(lblID);
		
		textID = new JTextField();
		textID.setBounds(96, 284, 86, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(339, 287, 46, 14);
		contentPane.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setBounds(411, 284, 86, 20);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(47, 325, 46, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(96, 322, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(339, 339, 46, 14);
		contentPane.add(lblColor);
		
		textColor = new JTextField();
		textColor.setBounds(411, 336, 86, 20);
		contentPane.add(textColor);
		textColor.setColumns(10);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new eventoCargar(this));
		btnCargar.setBounds(93, 390, 89, 23);
		contentPane.add(btnCargar);
		
		JButton btnNewButton = new JButton("New button");
		
		btnNewButton.addActionListener(new eventoScript(this));
		btnNewButton.setBounds(296, 390, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	public void propiedadTabla (ResultSet rs) {
		
		String columnas [] = {"ID", "Apellido", "Nombre", "Color"};
		
		DefaultTableModel modeloTabla = new DefaultTableModel(null,columnas);
		
		table.setModel(modeloTabla);
		try {
			while (rs.next()) {

				Object filaTemporal []  = {rs.getInt("ID"),rs.getString("APELLIDOS"),rs.getString("NOMBRE"),rs.getString("COLOR")};

				modeloTabla.addRow(filaTemporal);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
