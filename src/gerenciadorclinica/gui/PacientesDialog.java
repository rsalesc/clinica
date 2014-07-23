package gerenciadorclinica.gui;

import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JTable;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PacientesDialog extends JDialog {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void showDialog(Window owner){
		try {
			PacientesDialog dialog = new PacientesDialog(owner);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PacientesDialog(Window owner) {
		super(owner);
		setTitle("Gerenciamento de Pacientes");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 596, 408);
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 79, 570, 290);
		getContentPane().add(table);
		
		JButton btnEditarSelecionado = new JButton("Editar Selecionado");
		btnEditarSelecionado.setBounds(451, 45, 129, 23);
		getContentPane().add(btnEditarSelecionado);
		
		JButton btnRemoverSelecionado = new JButton("Remover Selecionado");
		btnRemoverSelecionado.setBounds(292, 45, 149, 23);
		getContentPane().add(btnRemoverSelecionado);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAddPaciente();
			}
		});
		btnCadastrar.setBounds(491, 11, 89, 23);
		getContentPane().add(btnCadastrar);
		
		JButton btnMarcarConsulta = new JButton("Marcar Consulta");
		btnMarcarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAddConsulta();
			}
		});
		btnMarcarConsulta.setBounds(370, 11, 111, 23);
		getContentPane().add(btnMarcarConsulta);
		
		JButton btnSolicitarExame = new JButton("Solicitar Exame");
		btnSolicitarExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAddExame();
			}
		});
		btnSolicitarExame.setBounds(243, 11, 117, 23);
		getContentPane().add(btnSolicitarExame);

	}
	
	public void showAddConsulta(){
		AddConsultaDialog.showDialog(this);
	}
	
	public void showAddExame(){
		AddExamesDialog.showDialog(this);
	}
	
	public void showAddPaciente(){
		AddPacienteDialog.showDialog(this);
	}
}
