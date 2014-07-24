package gerenciadorclinica.gui;

import gerenciadorclinica.App;
import gerenciadorclinica.clinica.Exame;
import gerenciadorclinica.clinica.Paciente;
import gerenciadorclinica.gui.components.ExameTableModel;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

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
		Window self = this;
		setTitle("Gerenciamento de Exames");
		this.paciente = p;
		if(this.paciente != null) setTitle("Exames do paciente " + p.getNome());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setBounds(100, 100, 511, 346);
		getContentPane().setLayout(null);
		
		JButton btnVincularArquivo = new JButton("Vincular Arquivo");
		btnVincularArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					vinculaArquivo((Dialog)self);
				} catch (IOException e1) {
					App.showMsgBox(self, e1.getMessage());
				}
			}
		});
		btnVincularArquivo.setBounds(386, 11, 109, 23);
		getContentPane().add(btnVincularArquivo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 485, 229);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setIntercellSpacing(new Dimension(8, 1));
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		JLabel lblDUmDuplo = new JLabel("D\u00EA um duplo clique para editar.");
		lblDUmDuplo.setBounds(10, 15, 163, 14);
		getContentPane().add(lblDUmDuplo);
		
		JButton btnRemove = new JButton("Remover Selecionado");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					removeSelecionado();
					atualizarExames();
				} catch (Exception e) {
					App.showMsgBox(self, e.getMessage());
				}
			}
		});
		btnRemove.setBounds(241, 11, 135, 23);
		getContentPane().add(btnRemove);
		
		JButton btnVerArquivosVinculados = new JButton("Ver Arquivos Vinculados");
		btnVerArquivosVinculados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					showArquivosVinculados();
				} catch (IOException e1) {
					App.showMsgBox(self, e1.getMessage());
				}
			}
		});
		btnVerArquivosVinculados.setBounds(332, 45, 163, 23);
		getContentPane().add(btnVerArquivosVinculados);
		
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
	
	public void vinculaArquivo(Dialog d) throws IOException{
		if(table.getSelectedRow() >= 0){
			ExameTableModel model = (ExameTableModel)table.getModel();
			Exame ex = model.getRow(table.getSelectedRow());
			ex.vincularArquivo(d);
		}
	}
	
	public void showArquivosVinculados() throws IOException{
		if(table.getSelectedRow() >= 0){
			ExameTableModel model = (ExameTableModel)table.getModel();
			Exame ex = model.getRow(table.getSelectedRow());
			ex.verArquivosVinculados();
		}
	}
	
	public void removeSelecionado() throws Exception{
		if(table.getSelectedRow() >= 0){
			if(App.showConfirm(this)){
				ExameTableModel model = (ExameTableModel)table.getModel();
				Exame ex = model.getRow(table.getSelectedRow());
				ex.remover(App.db);
			}
		}
	}
}
