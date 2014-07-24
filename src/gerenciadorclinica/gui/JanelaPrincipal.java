package gerenciadorclinica.gui;

import gerenciadorclinica.App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel authLbl;

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		setTitle("Gerenciador de Cl\u00EDnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 200);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 0, 0, 0));
		
		authLbl = new JLabel("Aguardando autentica\u00E7\u00E3o...");
		authLbl.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(authLbl);
		
		JButton btnPacientes = new JButton("Pacientes");
		btnPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPacientes();
			}
		});
		contentPane.add(btnPacientes);
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showConsultas();
			}
		});
		contentPane.add(btnConsultas);
		
		JButton btnExames = new JButton("Exames");
		btnExames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showExames();
			}
		});
		contentPane.add(btnExames);
	}

	public void showPacientes(){
		PacientesDialog.showDialog(this);
	}
	
	public void showConsultas(){
		ConsultasDialog.showDialog(this);
	}
	
	public void showExames(){
		ExamesDialog.showDialog(this);
	}
	
	public void atualizaUsuario(){
		if(App.usuario != null) authLbl.setText("Bem-vindo, " + App.usuario.getNome() + ".");
	}
}
