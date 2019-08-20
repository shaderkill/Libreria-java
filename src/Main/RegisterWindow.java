package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class RegisterWindow extends JFrame {

	private JPanel contentPane;
	private JTextField InputUser;
	private JTextField InputName;
	private JPasswordField InputPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterWindow frame = new RegisterWindow();
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
	public RegisterWindow() {
		JFrame popframe = new JFrame("JOptionPane showMessageDialog");
		
		setTitle("Registrar usuario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 444, 272);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblRegistroDeUsuario = new JLabel("Registro de usuario");
		lblRegistroDeUsuario.setBounds(33, 5, 375, 34);
		lblRegistroDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeUsuario.setForeground(Color.WHITE);
		lblRegistroDeUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		panel.add(lblRegistroDeUsuario);
		
		InputUser = new JTextField();
		InputUser.setColumns(10);
		InputUser.setBounds(154, 71, 264, 20);
		panel.add(InputUser);
		
		JLabel label = new JLabel("Usuario");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label.setBounds(33, 67, 107, 22);
		panel.add(label);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.TRAILING);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblContrasea.setBounds(10, 111, 130, 22);
		panel.add(lblContrasea);
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo");
		lblNombreCompleto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombreCompleto.setForeground(Color.WHITE);
		lblNombreCompleto.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNombreCompleto.setBounds(10, 157, 130, 22);
		panel.add(lblNombreCompleto);
		
		InputName = new JTextField();
		InputName.setColumns(10);
		InputName.setBounds(154, 161, 264, 20);
		panel.add(InputName);
		
		JLabel ErrorUser = new JLabel("");
		ErrorUser.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		ErrorUser.setForeground(Color.RED);
		ErrorUser.setBounds(154, 90, 264, 14);
		panel.add(ErrorUser);
		
		JLabel ErrorPass = new JLabel("");
		ErrorPass.setForeground(Color.RED);
		ErrorPass.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		ErrorPass.setBounds(154, 136, 264, 14);
		panel.add(ErrorPass);
		
		JLabel ErrorName = new JLabel("");
		ErrorName.setForeground(Color.RED);
		ErrorName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		ErrorName.setBounds(154, 181, 264, 14);
		panel.add(ErrorName);
		
		JButton btnNewButton = new JButton("Crear usuario");
		btnNewButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				
				if(InputUser.getText().isEmpty()) {
					ErrorUser.setText("El campo 'usuario' no puede estar vació.");
					return;
				}
				if(InputPass.getText().isEmpty()) {
					ErrorPass.setText("El campo 'contraseña' no puede estar vació.");
					return;
				}
				if(InputName.getText().isEmpty()) {
					ErrorName.setText("El campo 'Nombre completo' no puede estar vació.");
					return;
				}
				 String user = InputUser.getText();
				 String pass = InputPass.getText();
				 String name = InputName.getText();
				
				 
				 if(!Main.menu.userExist(user)) {
					Boolean right = Main.menu.registerUser(user, pass, name);
					if(right) {
						dispose();
						Main.LoginWindow.main(null);
					}
				 } else {
					 JOptionPane.showMessageDialog(popframe,"Usuario ya ingresado.",
		                        "Inicio de sesión",
		                        JOptionPane.ERROR_MESSAGE);
				 }
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnNewButton.setBounds(122, 225, 203, 23);
		panel.add(btnNewButton);
		
		InputPass = new JPasswordField();
		InputPass.setBounds(154, 115, 264, 20);
		panel.add(InputPass);
		
		
	}
}
