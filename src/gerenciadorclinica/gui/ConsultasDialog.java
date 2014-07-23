package gerenciadorclinica.gui;

import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class ConsultasDialog extends JDialog {
	private JTable table;


	public static void showDialog(Window owner) {
		try {
			ConsultasDialog dialog = new ConsultasDialog(owner);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultasDialog(Window owner) {
		super(owner);
		setTitle("Gerenciamento de Consultas");
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 535, 338);
		getContentPane().setLayout(null);
		
		JButton btnDesmarcarSelecionada = new JButton("Desmarcar Selecionada");
		btnDesmarcarSelecionada.setBounds(376, 11, 143, 23);
		getContentPane().add(btnDesmarcarSelecionada);
		
		table = new JTable();
		table.setBounds(10, 45, 509, 254);
		getContentPane().add(table);

	}

}
