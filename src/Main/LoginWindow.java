package Main;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class LoginWindow {

	private JFrame frmInicioDeSesin;
	private JTextField InputUser;
	private JPasswordField InputPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frmInicioDeSesin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInicioDeSesin = new JFrame();
		frmInicioDeSesin.setTitle("Inicio de sesi\u00F3n");
		//frmInicioDeSesin.setOpacity(0.0f);
		frmInicioDeSesin.setResizable(false);
		frmInicioDeSesin.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frmInicioDeSesin.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		sl_panel.putConstraint(SpringLayout.WEST, lblBienvenido, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblBienvenido, -26, SpringLayout.EAST, panel);
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		panel.add(lblBienvenido);
		
		JLabel lblUsuario = new JLabel("Usuario");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblBienvenido, -17, SpringLayout.NORTH, lblUsuario);
		sl_panel.putConstraint(SpringLayout.NORTH, lblUsuario, 78, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblUsuario, 30, SpringLayout.WEST, panel);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		sl_panel.putConstraint(SpringLayout.NORTH, lblContrasea, 39, SpringLayout.SOUTH, lblUsuario);
		sl_panel.putConstraint(SpringLayout.WEST, lblContrasea, 0, SpringLayout.WEST, lblUsuario);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel.add(lblContrasea);
		
		InputUser = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, InputUser, 21, SpringLayout.SOUTH, lblBienvenido);
		sl_panel.putConstraint(SpringLayout.EAST, InputUser, 0, SpringLayout.EAST, lblBienvenido);
		sl_panel.putConstraint(SpringLayout.WEST, InputUser, 56, SpringLayout.EAST, lblUsuario);
		panel.add(InputUser);
		InputUser.setColumns(10);
		
		JButton btnNewButton = new JButton("Ingresar");
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 190, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -38, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -181, SpringLayout.EAST, panel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = InputUser.getText();
				String pass = InputPass.getText();
				
				menu.loginUser(user, pass);
			}
		});
		panel.add(btnNewButton);
		
		JLabel lblusuarioNuevoRegistrate = new JLabel("\u00BFUsuario nuevo?, registrate pulsando aqui.");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblusuarioNuevoRegistrate, -89, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 23, SpringLayout.SOUTH, lblusuarioNuevoRegistrate);
		sl_panel.putConstraint(SpringLayout.EAST, lblusuarioNuevoRegistrate, -102, SpringLayout.EAST, panel);
		lblusuarioNuevoRegistrate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmInicioDeSesin.dispose();
				RegisterWindow.main(null);
				
			}
		});
		lblusuarioNuevoRegistrate.setForeground(SystemColor.textHighlight);
		lblusuarioNuevoRegistrate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel.add(lblusuarioNuevoRegistrate);
		
		InputPass = new JPasswordField();
		sl_panel.putConstraint(SpringLayout.NORTH, InputPass, 4, SpringLayout.NORTH, lblContrasea);
		sl_panel.putConstraint(SpringLayout.WEST, InputPass, 0, SpringLayout.WEST, InputUser);
		sl_panel.putConstraint(SpringLayout.EAST, InputPass, 0, SpringLayout.EAST, lblBienvenido);
		panel.add(InputPass);
		frmInicioDeSesin.setBackground(SystemColor.window);
		frmInicioDeSesin.setBounds(100, 100, 482, 320);
		frmInicioDeSesin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
