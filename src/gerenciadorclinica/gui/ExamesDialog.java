package gerenciadorclinica.gui;

import gerenciadorclinica.App;
import gerenciadorclinica.clinica.Consulta;
import gerenciadorclinica.clinica.Exame;
import gerenciadorclinica.clinica.Paciente;
import gerenciadorclinica.gui.components.ConsultaTableModel;
import gerenciadorclinica.gui.components.ExameTableModel;

import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ExamesDialog extends JDialog {
	private JTable table;
	private Paciente paciente;

	/**
	 * Launch the application.
	 */
	public static void showDialog(Window owner) {
		showDialog(owner, null);
	}
	
	public static void showDialog(Window owner, Paciente p) {
		try {
			ExamesDialog dialog = new ExamesDialog(owner, p);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ExamesDialog(Window owner, Paciente p) {
		super(owner);
		setTitle("Gerenciamento de Exames");
		this.paciente = p;
		if(this.paciente != null) setTitle("Exames do paciente " + p.getNome());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setBounds(100, 100, 511, 346);
		getContentPane().setLayout(null);
		
		JButton btnVincularArquivo = new JButton("Vincular Arquivo");
		btnVincularArquivo.setBounds(386, 11, 109, 23);
		getContentPane().add(btnVincularArquivo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 485, 256);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setIntercellSpacing(new Dimension(8, 1));
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		JLabel lblDUmDuplo = new JLabel("D\u00EA um duplo clique para editar.");
		lblDUmDuplo.setBounds(10, 15, 163, 14);
		getContentPane().add(lblDUmDuplo);
		
		Window self = this;
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					JTable t = (JTable)e.getSource();
					Exame ex = ((ExameTableModel)t.getModel()).getRow(t.getSelectedRow());
					AddExamesDialog.showDialog(self, ex);
					try {
						atualizarExames();
					} catch (Exception e1) {
						App.showMsgBox(self, e1.getMessage());
					}
				}
			}
		});
		
		try{
			atualizarExames();
		}catch(Exception e){
			App.showMsgBox(this, e.getMessage());
		}
	}
	
	public void atualizarExames() throws Exception{
		ArrayList<Exame> exames = this.paciente == null ? Exame.listar(App.db) : Exame.listar(App.db, "pacienteId = " + this.paciente.getID());
		ExameTableModel model = new ExameTableModel(exames);
		table.setModel(model);
	}
}
