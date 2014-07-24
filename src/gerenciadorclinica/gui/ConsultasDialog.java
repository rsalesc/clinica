package gerenciadorclinica.gui;

import gerenciadorclinica.App;
import gerenciadorclinica.clinica.Consulta;
import gerenciadorclinica.clinica.Paciente;
import gerenciadorclinica.gui.components.ConsultaTableModel;
import gerenciadorclinica.gui.components.PacienteTableModel;

import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ConsultasDialog extends JDialog {
	private JTable table;
	private Paciente paciente;

	
	public static void showDialog(Window owner) {
		showDialog(owner, null);
	}
	
	public static void showDialog(Window owner, Paciente p) {
		try {
			ConsultasDialog dialog = new ConsultasDialog(owner, p);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultasDialog(Window owner, Paciente p) {
		super(owner);
		setTitle("Gerenciamento de Consultas");
		this.paciente = p;
		if(paciente != null) setTitle("Consultas do paciente " + paciente.getNome());
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 535, 338);
		getContentPane().setLayout(null);
		
		JButton btnDesmarcarSelecionada = new JButton("Desmarcar Selecionada");
		btnDesmarcarSelecionada.setBounds(376, 11, 143, 23);
		getContentPane().add(btnDesmarcarSelecionada);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		scrollPane.setBounds(10, 51, 509, 249);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setIntercellSpacing(new Dimension(8, 1));
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("D\u00EA um duplo clique para editar.");
		label.setBounds(10, 15, 163, 14);
		getContentPane().add(label);
		
		Window self = this;
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					JTable t = (JTable)e.getSource();
					Consulta c = ((ConsultaTableModel)t.getModel()).getRow(t.getSelectedRow());
					AddConsultaDialog.showDialog(self, c);
					try {
						atualizarConsultas();
					} catch (Exception e1) {
						App.showMsgBox(self, e1.getMessage());
					}
				}
			}
		});
		
		
		try{
			atualizarConsultas();
		}catch(Exception e){
			App.showMsgBox(this, e.getMessage());
		}
		
	}
	
	public void atualizarConsultas() throws Exception{
		ArrayList<Consulta> consultas = this.paciente == null ? Consulta.listar(App.db) : Consulta.listar(App.db, "pacienteId = " + this.paciente.getID());
		ConsultaTableModel model = new ConsultaTableModel(consultas);
		table.setModel(model);
	}
}
