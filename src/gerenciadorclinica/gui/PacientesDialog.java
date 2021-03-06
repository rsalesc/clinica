package gerenciadorclinica.gui;

import gerenciadorclinica.App;
import gerenciadorclinica.clinica.Paciente;
import gerenciadorclinica.gui.components.PacienteTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

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
		
		Window self = this;
		
		JButton btnRemoverSelecionado = new JButton("Remover Selecionado");
		btnRemoverSelecionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					removeSelecionado();
					atualizarPacientes();
				} catch (Exception e1) {
					App.showMsgBox(self, e1.getMessage());
				}
			}
		});
		btnRemoverSelecionado.setBounds(431, 45, 149, 23);
		getContentPane().add(btnRemoverSelecionado);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAddPaciente();
				try {
					atualizarPacientes();
				} catch (SQLException e1) {
					App.showMsgBox(self, e1.getMessage());
				}
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 570, 290);
		getContentPane().add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					JTable t = (JTable)e.getSource();
					Paciente p = ((PacienteTableModel)t.getModel()).getRow(t.getSelectedRow());
					AddPacienteDialog.showDialog(self, p);
					try {
						atualizarPacientes();
					} catch (SQLException e1) {
						App.showMsgBox(self, e1.getMessage());
					}
				}
			}
		});
		table.setIntercellSpacing(new Dimension(8, 1));
		table.setRowHeight(25);
		table.setBackground(Color.WHITE);
		table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(10, 79, 570, 290);
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("D\u00EA um duplo clique para editar.");
		label.setBounds(10, 49, 163, 14);
		getContentPane().add(label);
		
		JButton btnListarConsultas = new JButton("Listar Consultas");
		btnListarConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() >= 0){
					Paciente p = ((PacienteTableModel)table.getModel()).getRow(table.getSelectedRow());
					ConsultasDialog.showDialog(self, p);
				}
			}
		});
		btnListarConsultas.setBounds(310, 45, 111, 23);
		getContentPane().add(btnListarConsultas);
		
		JButton btnListarExames = new JButton("Listar Exames");
		btnListarExames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() >= 0){
					Paciente p = ((PacienteTableModel)table.getModel()).getRow(table.getSelectedRow());
					ExamesDialog.showDialog(self, p);
				}
			}
		});
		btnListarExames.setBounds(189, 45, 111, 23);
		getContentPane().add(btnListarExames);
		
		try{
			atualizarPacientes();
		}catch(Exception e){
			App.showMsgBox(this, e.getMessage());
		}
	}
	
	public void showAddConsulta(){
		if(table.getSelectedRow() >= 0){
			Paciente p = ((PacienteTableModel)table.getModel()).getRow(table.getSelectedRow());
			AddConsultaDialog.showDialog(this, p);	
		}
	}
	
	public void showAddExame(){
		if(table.getSelectedRow() >= 0){
			Paciente p = ((PacienteTableModel)table.getModel()).getRow(table.getSelectedRow());
			AddExamesDialog.showDialog(this, p);
		}
	}
	
	public void showAddPaciente(){
		AddPacienteDialog.showDialog(this, null);
	}
	
	public void atualizarPacientes() throws SQLException{
		PacienteTableModel model = new PacienteTableModel(Paciente.listar(App.db));
		table.setModel(model);
	}
	
	public void removeSelecionado() throws Exception{
		if(table.getSelectedRow() >= 0){
			if(App.showConfirm(this)){
				PacienteTableModel model = (PacienteTableModel)table.getModel();
				Paciente p = model.getRow(table.getSelectedRow());
				p.remover(App.db);
			}
		}
	}
}
