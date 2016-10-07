package CapaGrafica;
import CapaEntidades.*;
import CapaNegocio.*;
import utils.*;
import org.apache.logging.log4j.Level;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class AdministrarPersonaje extends JFrame {
	private ControladorPersonajes ctrl;

	private JPanel contentPane;
	private JTextField txtBoxidPersonaje;
	private JTextField txtBoxNombre;
	private JTextField txtBoxVida;
	private JTextField txtBoxPuntosTotales;
	private JTextField txtBoxDefensa;
	private JTextField txtBoxEnergia;
	private JTextField txtBoxEvasion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrarPersonaje frame = new AdministrarPersonaje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdministrarPersonaje() {
		
		ctrl=new ControladorPersonajes();
		JOptionPane.showMessageDialog(null, "Se le daran 200pts asignelos entre vida,energia,defensa y evasion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLabel lblIdpersonaje = new JLabel("idPersonaje:");
		lblIdpersonaje.setVisible(true);
		txtBoxidPersonaje = new JTextField();
		txtBoxidPersonaje.setColumns(10);
		txtBoxidPersonaje.setVisible(true);
		JLabel lblNombrePer = new JLabel("Nombre: ");
		txtBoxNombre = new JTextField();
		txtBoxNombre.setColumns(10);
		JLabel lblVida = new JLabel("Vida:");
		txtBoxVida = new JTextField();
		txtBoxVida.setColumns(10);
		JLabel label = new JLabel("");
		JLabel lblPuntosTotales = new JLabel("Puntos Totales:");
		txtBoxPuntosTotales = new JTextField();
		txtBoxPuntosTotales.setColumns(10);
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					altaPersonaje();
				} catch (ApplicationException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		JLabel lblPersonaje = new JLabel("PERSONAJE:");
		lblPersonaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblDefensa = new JLabel("Defensa:");
		
		txtBoxDefensa = new JTextField();
		txtBoxDefensa.setColumns(10);
		
		JLabel lblEnergia = new JLabel("Energia:");
		
		txtBoxEnergia = new JTextField();
		txtBoxEnergia.setColumns(10);
		
		JLabel lblEvasion = new JLabel("Evasion:");
		
		txtBoxEvasion = new JTextField();
		txtBoxEvasion.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNombrePer)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtBoxNombre, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblIdpersonaje)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtBoxidPersonaje, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
								.addComponent(label))
							.addGap(249))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPersonaje)
							.addContainerGap(342, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblVida)
								.addComponent(lblEnergia))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtBoxDefensa, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
								.addComponent(txtBoxEvasion, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
								.addComponent(txtBoxEnergia, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
								.addComponent(txtBoxVida, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
							.addGap(249))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDefensa)
							.addContainerGap(370, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblEvasion)
							.addContainerGap(373, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnGuardar)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPuntosTotales)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtBoxPuntosTotales, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(273, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPersonaje)
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdpersonaje)
						.addComponent(txtBoxidPersonaje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombrePer)
						.addComponent(txtBoxNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVida)
						.addComponent(txtBoxVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnergia)
						.addComponent(txtBoxEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDefensa)
						.addComponent(txtBoxDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblEvasion)
							.addComponent(txtBoxEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPuntosTotales)
						.addComponent(txtBoxPuntosTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnGuardar)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

  protected void altaPersonaje() throws ApplicationException
  {  Personaje p=MapearDeFormulario();
     if(p.validarPuntos())
	    { ctrl.agregarPer(p);
	     JOptionPane.showMessageDialog(null, "Personaje Agregado con exito");
         limpiarCampos();}
     else{
    	 JOptionPane.showMessageDialog(null, "Los puntos asginados entre vida,energía,defensa,evasión deben sumar 200pts o menos");
         }
  }

  protected  Personaje MapearDeFormulario()
  {         Personaje p = new Personaje();
			try{ 
			    p.setIdPersonaje(Integer.parseInt(txtBoxidPersonaje.getText())); 
				p.setNombrePer(txtBoxNombre.getText());
			    p.setVida(Float.parseFloat(txtBoxVida.getText()));
			    p.setEnergia(Float.parseFloat(txtBoxEnergia.getText()));
			    p.setDefensa(Float.parseFloat(txtBoxDefensa.getText()));
			    p.setEvasion(Float.parseFloat(txtBoxEvasion.getText()));
			    p.setPuntosTotales(Float.parseFloat(txtBoxPuntosTotales.getText()));
			    
			    }
			catch(Exception e )
			{ 
				JOptionPane.showMessageDialog(null, " DATOS INGRESADOS INCORRECTAMENTE");
			}
			return p;
  }
  
  protected void MapearAFormulario(Personaje p)
  {      txtBoxidPersonaje.setText(String.valueOf(p.getIdPersonaje()));
         txtBoxNombre.setText(p.getNombrePer());
         txtBoxVida.setText(String.valueOf(p.getVida()));
         txtBoxEnergia.setText(String.valueOf(p.getEnergia()));
         txtBoxDefensa.setText(String.valueOf(p.getDefensa()));
         txtBoxEvasion.setText(String.valueOf(p.getEvasion()));
         txtBoxPuntosTotales.setText(String.valueOf(p.getPuntosTotales()));
  }
  
  protected void limpiarCampos()
  {   
	  txtBoxidPersonaje.setText("");
	  txtBoxNombre.setText("");
	  txtBoxVida.setText("");
	  txtBoxEnergia.setText("");
	  txtBoxDefensa.setText("");
	  txtBoxEvasion.setText("");
	  txtBoxPuntosTotales.setText("");
  }
  
  
}

